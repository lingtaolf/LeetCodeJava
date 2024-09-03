package No3_maxLengthString;

/**
 * @Description TODO
 * @Author tao.ling
 * @Date 2024/4/28
 **/
public class Main {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        int res = 0;
        int begin = 0;
        int subLen = 1;

        while(subLen < s.length() - begin) {
            String subStr = s.substring(begin, begin+subLen);

            if (begin + subLen < s.length() && subStr.contains(String.valueOf(s.charAt(begin + subLen)))) {
                res = res > subLen ? res : subLen;
                begin = begin + 1;
                subLen = 1;
            }
            else
                ++subLen;
        }

        res = res > subLen ? res : subLen;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
