package examples;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * creator: fenghaidong
 * createdAt: 2020/7/22
 * description:
 **/
public class LongestSubStr {

    public int find(String source, int k) {
        if (null == source || source.length() * k == 0) {
            return 0;
        }
        Map<Character, Integer> mappings = new LinkedHashMap<>();
        int len = source.length();
        //滑动窗口左右指针
        int right = 0;
        int left = 0;

        //最大子串长度
        int maxLen = 1;
        //最大子串的起止索引
        int mL = 0, mR = 0;
        while (right < len) {
            char e = source.charAt(right);
            mappings.put(e, right++);

            //mapping中的字符数量已经达到目标值的 k+1,则一定满足了k个不同字符的要求，右指针保持不变。
            //移动左指针，慢慢找到最大子串，记录在maxLen中
            if (mappings.size() == k + 1) {
                Map.Entry<Character, Integer> leftMost = mappings.entrySet().iterator().next();
                mappings.remove(leftMost.getKey());
                left = leftMost.getValue() + 1;
            }
            int delta = right - left;
            if (delta >= maxLen) {
                maxLen = delta;
                mL = left;
                mR = right;
            }
        }
        System.out.println(source.substring(mL, mR));
        return maxLen;
    }

    public String find2(String source, int k ) {
        if (null == source || source.length() * k == 0) {
            return "";
        }
        Set<Character> occ = new HashSet<>();

        int n = source.length();

        int mL = -1, mR = 0;

        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                occ.remove(source.charAt(i-1));
            }

            while (mL +1 < n && !occ.contains(source.charAt(mL+1))) {
                occ.add(source.charAt(mL+1));
                ++mL;
            }
            mR = Math.max(mR, mL - i +1);
            if (mR == k) {
                break;
            }
        }
        return source.substring((mL+1) - mR, mL+1);
    }

    public static void main(String[] args) {
        String result = new LongestSubStr().find2("abbaaabbcc", 2);
        System.out.println(result);
    }
}
