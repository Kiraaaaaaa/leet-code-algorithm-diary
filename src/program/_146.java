package program;

import java.util.LinkedHashMap;

public class _146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        int res = 0;
        res = lRUCache.get(1);// 返回1
        System.out.println(res);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        res = lRUCache.get(2);// 返回 -1 (未找到)
        System.out.println(res);
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        res = lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println(res);
        res = lRUCache.get(3);    // 返回 3
        System.out.println(res);
        res = lRUCache.get(4);    // 返回 4
        System.out.println(res);
    }

    /**
     * 双向哈希链表+
     */
    public static class LRUCache{
        int cap = 0;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            //如果get到不存在的key
            if(!cache.containsKey(key)) return -1;
            //否则由于使用改过所以更新该key为最新key
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            // //如果存在该key则更新
            if(cache.containsKey(key)){
                cache.put(key, value);
                makeRecently(key);
                return;
            }else if(cache.size()>=cap){
                //没有该key则查看链表空间是否够用，不够用就删除最老的元素，再更新
                Integer old = cache.keySet().iterator().next();
                cache.remove(old);
            }
            //没有该key则插入该key
            cache.put(key, value);
        }
        //将当前get过或者put更新(已存在)过的key设置为最新key
        private void makeRecently(int key){
            Integer val = cache.get(key);
            //先删除旧的
            cache.remove(key);
            //再重新插入就是最新的了
            cache.put(key, val);
        }
    }
}
