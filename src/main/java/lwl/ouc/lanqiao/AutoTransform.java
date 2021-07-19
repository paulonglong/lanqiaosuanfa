package lwl.ouc.lanqiao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class AutoTransform {
    public static void main(String[] args) throws UnsupportedEncodingException {
        float a = 1.2f;
        float b = 1.2F;
        System.out.println(a == b);
        float c = 1;
        double d = 1234L;
        double e = 1.2d;
        double f = 1.2D;

        int g = 0X0041;
        System.out.println(g);

        String utf8String =
            "\\xE5\\x85\\x84\\xE5\\xBC\\x9F\\xE9\\x9A\\xBE\\xE5\\xBD\\x93 \\xE6\\x9D\\x9C\\xE6\\xAD\\x8C";
        System.out.println(decodeUTF8Str(utf8String));
    }

    public static String decodeUTF8Str(String xStr) throws UnsupportedEncodingException {
        String b = xStr.replaceAll("\\\\x", "%");
        return URLDecoder.decode(b, "utf-8");
    }
}
