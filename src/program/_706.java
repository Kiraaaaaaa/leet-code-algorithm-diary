package program;

import java.util.Arrays;

public class _706 {
    public static void main(String[] args) {
        MyHashMap set = new MyHashMap();
        set.put(1, 1);
        set.remove(1);
        System.out.println(set.get(1));
    }
    static class MyHashMap {
        int[] map;
        public MyHashMap() {
            map = new int[1000001];
            Arrays.fill(map, -1);
        }

        public void put(int key, int value) {
            map[key] = value;
        }

        public int get(int key) {
            return map[key];
        }

        public void remove(int key) {
            map[key] = -1;
        }
    }
}
