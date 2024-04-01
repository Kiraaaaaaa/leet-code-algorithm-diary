package program;

public class _2129 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.capitalizeTitle_1("capiTalIze tHe titLe");
        System.out.println(res);
    }
    public static class Solution {
        // 方法1.使用String拼接
        public String capitalizeTitle(String title) {
            String[] arr = title.split(" ");
            String res = new String();
            for (String s : arr) {
                for (int i = 0; i < s.length(); i++) {
                    if(s.length() > 2 && i == 0){ //首字母大写
                        res += Character.toUpperCase(s.charAt(i));
                    }else{ //其他字母小写
                        res += Character.toLowerCase(s.charAt(i));
                    }
                }
                res += " ";
            }
            return res.substring(0, res.length() - 1); //去掉末尾的空格
        }
        // 方法2.使用StringBuilder
        public String capitalizeTitle_1(String title) {
            String[] arr = title.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                s = s.toLowerCase(); //全部转小写
                if(s.length() > 2){
                    sb.append(Character.toUpperCase(s.charAt(0))); //添加首字母大写
                    sb.append(s.substring(1, s.length())); //添加其他字母
                }else{
                    sb.append(s); //添加其他字母
                }
                sb.append(" ");
            }
            return sb.deleteCharAt(sb.length()-1).toString();
        }
    }
}
