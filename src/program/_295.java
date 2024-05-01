package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _295 {
    public static void main(String[] args) {
        MedianFinder_2 medianFinder = new MedianFinder_2();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double one = medianFinder.findMedian();
        System.out.println(one);
        medianFinder.addNum(3);
        double second = medianFinder.findMedian();
        System.out.println(second);
    }

    //方法1.每次排序，添加超时
    public static class MedianFinder {
        ArrayList<Integer> list;
        public MedianFinder() {
            list = new ArrayList<>();
        }
        public void addNum(int num) {
            list.add(num);
            Collections.sort(list);
        }
        public double findMedian() {
            return list.size() % 2 == 0 ? (list.get(list.size()/2) + list.get(list.size()/2-1)) / 2.0 : list.get(list.size()/2);
        }
    }
    //方法2.改为堆添加仍然超时
    public static class MedianFinder_1 {
        PriorityQueue<Integer> queue;
        ArrayList<Integer> list;
        public MedianFinder_1() {
            queue = new PriorityQueue<>();
        }
        public void addNum(int num) {
            queue.add(num);
        }
        public double findMedian() {
            list = new ArrayList<>();
            while (!queue.isEmpty()){
                list.add(queue.poll());
            }
            for (Integer num : list) {
                queue.add(num);
            }
            int n = list.size();
            return n % 2 == 0 ? (list.get(n/2) + list.get(n/2-1)) / 2.0 : list.get(n/2);
        }
    }

    //方法3.大小顶堆
    //思路：大顶堆存区间左侧，小顶堆存区间右侧
    //动态维护两区间的个数，保证两区间个数之差最多一个值
    //如果两个区间个数之差为1，则中位数为较长的区间最大值/最小值
    //如果两个区间个数之差为0，则中位数为两个区间的(最大+最小值)/2
    public static class MedianFinder_2 {
        PriorityQueue<Integer> left, right;
        public MedianFinder_2() {
            left = new PriorityQueue<>((a,b)->b-a); //大顶堆存区间左侧
            right = new PriorityQueue<>((a,b)->a-b); //小顶堆存区间右侧
        }
        public void addNum(int num) {
            int lSize = left.size();
            int rSize = right.size();
            if(lSize == rSize){ // 如果两个区间大小一样
                if(rSize == 0 || num <= right.peek()){
                    left.add(num); //如果新加入的数小于等于右侧区间的最小值，则加入左侧区间
                }else{
                    left.add(right.poll()); //否则右区间最小值加入左侧区间，新加入的数加入右侧区间（维持平衡，两区间数字个数之差最多一个值）
                    right.add(num);
                }
            }else{ // 两个区间大小不一样
                if(num >= left.peek()){ // 如果新加入的数大于左侧区间的最大值，则加入右侧区间
                    right.add(num);
                }else{
                    right.add(left.poll()); // 否则左侧区间最大值加入右侧区间，新加入的数加入左侧区间（维持平衡，两区间数字个数之差最多一个值）
                    left.add(num);
                }
            }
        }
        public double findMedian() {
            if(left.size() == right.size()){
                return (left.peek() + right.peek()) / 2.0;
            }else{
                return left.size() > right.size() ? left.peek() : right.peek();
            }
        }
    }
}
