package lwl.ouc.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author wlli
 * @date 2021/07/19
 */
public class Test2 {
    @Test
    public void test111() {
        // 此表达式只能匹配 4位长度的字符串，虽然下面的都是以A开头以三个数字结尾的
        String re = "^A\\d{3}$";
        System.out.println("A123".matches(re));
        System.out.println("AB123".matches(re));
        System.out.println("A11123".matches(re));
        // 使用[...]可以匹配范围内的字符，例如，[123456789]可以匹配1~9
        // 匹配大小写不限的十六进制数，比如1A2b3c，我们可以这样写：[0-9a-fA-F]，
        // [...]还有一种排除法，即不包含指定范围的字符。假设我们要匹配任意字符，但不包括数字，可以写[^1-9]{3}：

        // 用|连接的两个正则规则是或规则，例如，AB|CD表示可以匹配AB或CD。

        // 现在我们想要匹配字符串learn java、learn php和learn go怎么办？一个最简单的规则是learn\sjava|learn\sphp|learn\sgo，但是这个规则太复杂了，
        // 可以把公共部分提出来，然后用(...)把子规则括起来表示成learn\\s(java|php|go)。

        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            System.out.println(m.group(0));
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败!");
        }

        // 利用分组匹配，从字符串"23:01:59"提取时、分、秒。
        Pattern p2 = Pattern.compile("([0-1][0-9]|2[0-4]):([0-5][0-9]):([0-5][0-9])");
        Matcher m2 = p2.matcher("23:59:59");
        if (m2.matches()) {
            System.out.println(m2.group(0));
            String g1 = m2.group(1);
            String g2 = m2.group(2);
            String g3 = m2.group(3);
            System.out.println(g1);
            System.out.println(g2);
            System.out.println(g3);
        }
    }
}
