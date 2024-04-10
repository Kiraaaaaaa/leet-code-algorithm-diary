package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _1600 {
    public static void main(String[] args) {
        ThroneInheritance so = new ThroneInheritance("king");
    }
    static class ThroneInheritance {
        String kingName; //记录国王名字
        HashMap<String, ArrayList<String>> map = new HashMap<>(); //记录父子关系
        HashSet<String> deathSet = new HashSet<>(); //记录死亡人
        public ThroneInheritance(String kingName) {
            this.kingName = kingName;
            map.put(kingName, new ArrayList<>());
        }
        public void birth(String parentName, String childName) {
            map.get(parentName).add(childName);
            map.put(childName, new ArrayList<>());
        }
        public void death(String name) {
            deathSet.add(name);
        }
        public List<String> getInheritanceOrder() {
            ArrayList<String> res = new ArrayList<>();
            dfs(res, kingName);
            return res;
        }
        private void dfs(ArrayList<String> res, String node) {
            if(!deathSet.contains(node)) res.add(node); //如果该人没死，则加入结果集
            for (String name : map.get(node)) dfs(res, name); //遍历该人的孩子
        }
    }
}
