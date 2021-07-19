package lwl.ouc.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author wlli
 * @date 2021/07/19
 */
public class Test4 {
    @Test
    public void test001() {
        // { "a", "b", "c" }
        "a b c".split("\\s");
        // { "a", "b", "", "c" }
        "a b  c".split("\\s");
        // { "a", "b", "c" }
        "a, b ;; c".split("[\\,\\;\\s]+");

        // 如果我们想让用户输入一组标签，然后把标签提取出来，因为用户的输入往往是不规范的，这时，
        // 使用合适的正则表达式，就可以消除多个空格、混合,和;这些不规范的输入，直接提取出规范的字符串。
    }

    @Test
    public void test002() {
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
    }

    @Test
    public void test003() {
        // 把不规范的连续空格分隔的句子变成了规范的句子。可见，灵活使用正则表达式可以大大降低代码量。
        String s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog."
    }

    @Test
    public void test004() {
        String s = "Hello, ${name}! You are learning ${lang}!";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Bob");
        map.put("lang", "Java");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            s = s.replaceAll("(\\$\\{" + entry.getKey() + "})", entry.getValue());
        }

        System.out.println(s);
    }
}
