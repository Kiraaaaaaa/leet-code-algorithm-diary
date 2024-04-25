package program;

import java.util.Arrays;

public class _705 {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.remove(1);
        System.out.println(set.contains(1));
    }
    static class MyHashSet {
        boolean[] set;
        public MyHashSet() {
            set = new boolean[1000001];
        }
        public void add(int key) {
            set[key] = true;
        }

        public void remove(int key) {
            set[key] = false;
        }

        public boolean contains(int key) {
            return set[key];
        }
    }
}
