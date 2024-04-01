package program;

import java.util.HashMap;
import java.util.Map;

public class _2671 {
    public static void main(String[] args) {
        FrequencyTracker ft = new FrequencyTracker();
        ft.add(1);
        ft.add(1);
        System.out.println(ft.hasFrequency(2));
    }
    //方法1.使用单个哈希表存储每个数字的次数(超时)
    static class FrequencyTracker {
        HashMap<Integer, Integer> map;
        public FrequencyTracker() {
            map = new HashMap<>();
        }
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        public void deleteOne(int number) {
            if(map.containsKey(number)){
                Integer integer = map.get(number) == 1 ? map.remove(number) : map.put(number, map.getOrDefault(number, 0) - 1);
            }
        }
        public boolean hasFrequency(int frequency) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() == frequency) return true;
            }
            return false;
        }
    }
    //方法2.使用两个哈希表分别存储每个数字的次数和频率个数(通过)
    static class FrequencyTracker_1 {
        HashMap<Integer, Integer> count; //存次数
        HashMap<Integer, Integer> fre; //存频率
        public FrequencyTracker_1() {
            count = new HashMap<>();
            fre = new HashMap<>();
        }
        public void add(int number) {
            Integer times = count.containsKey(number) ? count.get(number) + 1 : 1; //如果该数字存在则获取出现原出现次数+1否则为第一次出现，那么出现次数为1
            count.put(number, times); //更新该数字的出现次数+1
            fre.put(times, fre.getOrDefault(times, 0) + 1); //更新新频率+1
            fre.put(times-1, fre.getOrDefault(times-1, 0) - 1); //更新旧频率-1
        }
        public void deleteOne(int number) {
            if(count.containsKey(number)){ //如果该数字存在才删除该数字和更新频率
                Integer integer = count.get(number) == 1 ? count.remove(number) : count.put(number, count.getOrDefault(number, 0) - 1); //更新该数字的出现次数-1，如果出现原次数为1则直接删除该数字
                Integer times = count.containsKey(number) ? count.get(number) + 1 : 1; //如果该数字在删除一次后出现次数仍然大于0，则获取出现原出现次数，否则原出现次数为1
                fre.put(times, fre.getOrDefault(times, 0) - 1); //更新旧频率-1
                fre.put(times-1, fre.getOrDefault(times-1, 0) + 1); //更新新频率+1
            }
        }
        public boolean hasFrequency(int frequency) {
            return fre.containsKey(frequency) && fre.get(frequency) > 0;
        }
    }
}
