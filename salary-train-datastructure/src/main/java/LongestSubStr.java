import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * creator: fenghaidong
 * createdAt: 2020/7/22
 * description:
 **/
public class LongestSubStr {

    public String find(String source, int k ) {
        if (null == source || source.length() * k == 0) {
            return null;
        }
        int len = source.length();
        int left = 0;
        int right = 0 ;
        LinkedHashMap<Character, Integer> mapping = new LinkedHashMap<>(k + 1);

        int maxLen = 1;

        while (right < len) {
            Character character = source.charAt(right);

            if (mapping.containsKey(character)) {
                mapping.remove(character);
            }
            mapping.put(character, right++);

            if (mapping.size() == k+1) {
                Map.Entry<Character, Integer> leftMost = mapping.entrySet().iterator().next();
                mapping.remove(leftMost.getKey());

                left += leftMost.getValue();
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return null;
    }

    public static void main(String[] args) {
        String result = new LongestSubStr().find("abbaaabbcc", 1);
        System.out.println(result);
    }
}
