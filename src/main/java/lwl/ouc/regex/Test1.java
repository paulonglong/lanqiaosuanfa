package lwl.ouc.regex;

import java.util.List;

/**
 * @author wlli
 * @date 2021/07/19
 */
public class Test1 {
    public static void main(String[] args) {
        // 精确匹配
        String re1 = "abc";
        System.out.println("abc".matches(re1));
        System.out.println("Abc".matches(re1));
        System.out.println("abcd".matches(re1));
        System.out.println("======================");
        // 含特殊字符的精确匹配
        String re2 = "a\\&c"; // 对应的正则是a\&c
        System.out.println("a&c".matches(re2));
        System.out.println("a-c".matches(re2));
        System.out.println("a&&c".matches(re2));
        System.out.println("======================");
        // 匹配任意字符
        String re3 = "a.c"; // 对应的正则是a\&c
        System.out.println("a&c".matches(re3));
        System.out.println("a-c".matches(re3));
        System.out.println("ac".matches(re3));
        System.out.println("======================");
        // 匹配数字
        String re4 = "00\\d";
        System.out.println("007".matches(re4));
        System.out.println("00".matches(re4));
        System.out.println("00p".matches(re4));
        System.out.println("======================");
        // 非匹配数字
        String re7 = "00\\D";
        System.out.println("007".matches(re7));
        System.out.println("00".matches(re7));
        System.out.println("00p".matches(re7));
        System.out.println("======================");
        System.out.println("======================");
        System.out.println("======================");
        System.out.println("======================");
        // 匹配一个字母、数字或下划线 \W可以匹配\w不能匹配的字符
        String re5 = "java\\w";
        System.out.println("javac".matches(re5));
        System.out.println("java9".matches(re5));
        System.out.println("java_".matches(re5));
        System.out.println("java&".matches(re5));
        System.out.println("======================");
        // 用\s可以匹配一个空格字符，注意空格字符不但包括空格，还包括tab字符 \S可以匹配\s不能匹配的字符
        String re6 = "a\\sc";
        System.out.println("a c".matches(re6));
        System.out.println("a\tc".matches(re6));
        System.out.println("a   c".matches(re6));
        System.out.println("======================");
        // 修饰符*可以匹配任意个字符，包括0个字符。我们用A\d*

        // 修饰符+可以匹配至少一个字符。我们用A\d+可以匹配：

        // 修饰符?可以匹配0个或一个字符。我们用A\d?可以匹配：

        // 用修饰符{n}就可以。A\d{3}可以精确匹配：用修饰符{n,m} 修饰符{n,}

        String re = "\\d{3,4}-\\d{7,8}";
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }
}
