package program;

public class _299 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.getHint("1123", "0111");
        System.out.println(res);
    }
    public static class Solution {
        public String getHint(String secret, String guess) {
            int n = secret.length();
            int[] a = new int[10]; //记录secret中数字出现的次数
            int[] b = new int[10]; //记录guess中数字出现的次数
            int A = 0, B = 0; //A记录相同的数字的个数，B记录剩下的所有数字重新排列后得到的相同个数
            for (int i = 0; i < n; i++) {
                if(secret.charAt(i) == guess.charAt(i)) A++; //记录相同数字的个数A
                a[secret.charAt(i) - '0']++;
                b[guess.charAt(i) - '0']++;
            }
            for (int i = 0; i < 10; i++) if(b[i] > 0 && a[i] > 0) B += b[i] > a[i] ? a[i] : b[i]; //要得到重新排列后的相同个数，只需要找到最小的数字个数相加即可
            return A+"A"+(B - A)+"B"; //注意减去A，因为A已经记录了之前相同数字的个数
        }
    }
}
