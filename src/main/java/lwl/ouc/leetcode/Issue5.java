package lwl.ouc.leetcode;

public class Issue5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babaad"));
    }

    public static String longestPalindrome(String s) {
        // len 字符串的长度
        int len = s.length();
        
        // cslen 新字符数组长度
        int cslen = 2 * len + 3;
        
        // cs 新字符数组，并添加头尾和间隔符
        char[] cs = new char[cslen];
        cs[0] = '$';
        cs[1] = '#';
        cs[cslen - 1] = '.';
        for (int i = 2, j = 0; i < cslen - 1; ++i, ++j) {
            cs[i] = s.charAt(j);
            cs[++i] = '#';
        }

        // 最大范围（位置+位置上的对称半径）对应的位置
        int index = 0;
        
        // 最大范围（位置+位置上的对称半径）对应的位置上的对称半径
        int rangeOnIndex = 0;
        
        // 最长回文对应的位置
        int maxIndex = 0;
        
        // 最长回文对应的位置上的对称半径
        int rangeOnMaxIndex = 0;
        
        // 各个位置对称半径的数组，且初始值都是0，即所有位置的对称半径都初始为0
        int[] p = new int[cslen];

        for (int i = 1; i < cslen - 1; ++i) {
            // 当前位置i小于最大范围内，所以i位置上的对称半径，需要初始化为“最大范围位置左边位置上的对称半径”，“最大范围-当前位置”两者中的最小值
            if (i < index + rangeOnIndex) {
                p[i] = Math.min(p[2 * index - i], index + rangeOnIndex - i);
            }
            // System.out.println(i + " " + idx + " " + range + " " + p[i]);

            // 以当前位置i为中心，向左右两边扩展，判断是否相等，如果相等，则当前位置上的对称半径+1，继续循环；不等则退出循环
            while (cs[i - p[i]] == cs[i + p[i]]) {
                ++p[i];
            }

            // 发现有更大的半径，则赋值给最长的回文串对应的位置和位置上的半径
            // 这里是“小于”逻辑，即如果出现多个相同对称半径的回文字串，只会记录第一个。
            // 如果想记录最后一个，则改成“小于等于”
            if (rangeOnMaxIndex < p[i]) {
                maxIndex = i;
                rangeOnMaxIndex = p[i];
            }

            // 发现更大的范围是，更新最大范围对应的位置和位置上的对称半径
            if (i + p[i] > index + rangeOnIndex) {
                index = i;
                rangeOnIndex = p[i];
            }
        }

        // 循环拼接找到的最大回文字串
        StringBuilder sb = new StringBuilder();
        for (int i = maxIndex - rangeOnMaxIndex + 1; i < maxIndex + rangeOnMaxIndex; ++i) {
            if (cs[i] != '#')
                sb.append(cs[i]);
        }

        return sb.toString();
    }
}
