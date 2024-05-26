package program;

import java.util.ArrayDeque;

public class _2283 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minNumberOfHours(1, 1, new int[]{1,1,1,1}, new int[]{1,1,1,50});
        System.out.println(res);
    }
    public static class Solution {
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
            int n = energy.length;
            int energySum = 0;
            int expSum = 0;
            for (int i = 0; i < n; i++) {
                if(initialEnergy < energy[i]){
                    energySum += energy[i] - initialEnergy + 1;
                    initialEnergy = 1;
                }else if(initialEnergy == energy[i]){
                    energySum++;
                    initialEnergy = 1;
                }else{
                    initialEnergy -= energy[i];
                }
                if(initialExperience < experience[i]){
                    int exp = experience[i] - initialExperience + 1;
                    expSum += exp;
                    initialExperience += exp;
                }else if(initialExperience == experience[i]){
                    expSum++;
                    initialExperience += experience[i] + 1;
                }else{
                    initialExperience += experience[i];
                }
            }
            return energySum + expSum;
        }
    }
}
