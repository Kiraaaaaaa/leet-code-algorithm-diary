package program;

public class compress_string_lcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compressString_1("aabcccccaa"));
    }
    public static class Solution{
        //方法1：自写，太辣鸡了，不用看
        public String compressString(String S) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < S.length(); i++) {
                sb.append(S.charAt(i));
                int count = 1; //当前字符的数量
                if(i == S.length()-1){
                    //如果i到了最后一位，还需要个数+1
                    sb.append(count);
                }
                for(int start=i+1; start<S.length(); start++){
                    char c = S.charAt(start); //获取当前字符
                    //如果当前字符与上一个字符不相等，则将当前字符的数量添加到结果字符串中
                    if(S.charAt(start-1) != c){
                        sb.append(count);
                        i = start-1;
                        break;
                    }
                    //注意先后顺序，先判断是否相等再判断是不是最后的字符，直接加上数量，并跳出循环
                    if(start == S.length()-1){
                        sb.append(count+1);
                        i = start;
                        break;
                    }
                    ++count;
                }
            }
            return sb.length() < S.length() ? sb.toString() : S;
        }
        //方法2：双指针
        public String compressString_1(String S){
            int N = S.length();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while(i<N){
                int j = i;
                while(j<N && S.charAt(j) == S.charAt(i)){
                    ++j;
                }
                sb.append(S.charAt(i));
                sb.append(j-i);
                i = j;
            }
            return sb.length()>S.length()?S:sb.toString();
        }
    }
}
