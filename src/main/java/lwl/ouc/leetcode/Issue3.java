package lwl.ouc.leetcode;

import java.util.HashSet;

public class Issue3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String str) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> cset = new HashSet<Character>();
        while (right < str.length()) {
            System.out.println(right);
            if (!cset.contains(str.charAt(right))) {
                cset.add(str.charAt(right++));
                res = Math.max(res, cset.size());
            } else {
                cset.remove(str.charAt(left++));
            }
        }
        return res;
    }
}
