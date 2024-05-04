package program;

import java.util.ArrayDeque;
import java.util.HashMap;

public class _900 {
    public static void main(String[] args) {
        RLEIterator_2 RLE = new RLEIterator_2(new int[]{3,8,0,9,2,5});
        System.out.println(RLE.next(2));
        System.out.println(RLE.next(1));
        System.out.println(RLE.next(1));
        System.out.println(RLE.next(2));
    }

    //方法1.【喜提超出内存限制】元素按顺序个数放到队列里，出队列即可
    private static class RLEIterator {
        ArrayDeque<Integer> deque;
        int size;
        public RLEIterator(int[] encoding) {
            deque = new ArrayDeque<>();
            size = encoding.length;
            for (int i = 0; i < size - 1; i += 2) {
                for (int j = 0; j < encoding[i]; j++) {
                    deque.addLast(encoding[i+1]);
                }
            }
        }
        public int next(int n) {
            int res = -1;
            for (int i = 0; i < n && n <= deque.size(); i++) {
                res = deque.pollFirst();
            }
            return res;
        }
    }

    //方法2.官方写法
    private static class RLEIterator_1 {
        int index; //指针，标记当前是第几种数
        int num; //当前index位置已被减去的数
        int len;
        int[] A;
        public RLEIterator_1(int[] encoding) {
            index = 0;
            len = encoding.length;
            this.A = encoding;
        }
        public int next(int n) {
            while (index < len){
                if(num + n > A[index]){ //如果当前所有要减数量大于指针所在的数字个数，则移动指针
                    n -= A[index] - num; //A[index] - num代表该位置还可以删除的数，n减它代表已经删除完该数后还剩多少
                    num = 0;
                    index += 2; //移动到下一个数字
                }else{ //否则在当前数字位可减
                    num += n; //当前数字已减数量+n
                    return A[index+1]; //返回当前数字
                }
            }
            return -1;
        }
    }

    //方法3.自己的思路，写了老久了
    private static class RLEIterator_2 {
        int index; //指针，标记当前是第几种数
        int len; //数组长度
        int[] encoding;
        public RLEIterator_2(int[] encoding) {
            index = 0;
            len = encoding.length;
            this.encoding = encoding;
        }
        public int next(int n) {
            if(index >= len) return -1; //如果当前指针已经到数组末尾了，说明没有数了
            int res = -1; //遍历完数组都凑不到n个就返回默认-1
            if(encoding[index] >= n){ //如果当前数字剩余数量>=需要的数量，则直接减即可
                encoding[index] -= n;
                res = encoding[index+1];
            }else{ //如果当前数字剩余数量<需要的数量，则需要不断去找下一个数字
                while(index <= len - 2){ //只要没超出边界就一直循环，去找达到需要数量的数字
                    n -= encoding[index]; //更新待删除个数
                    index += 2; //去下一个数字
                    if(index <= len - 2 && encoding[index] >= n){ //如果满足了待删除个数
                        encoding[index] -= n; //更新该数字的剩余数量
                        break;
                    }
                }
                if(index <= len - 2){ //只要指针最后没超出边界
                    res = encoding[index+1]; //则该数字是答案
                }
            }
            return res;
        }
    }
}
