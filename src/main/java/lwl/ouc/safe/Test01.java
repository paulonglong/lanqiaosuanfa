package lwl.ouc.safe;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author wlli
 * @date 2021/07/19
 */
public class Test01 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String encoded = URLEncoder.encode("中  文  !", StandardCharsets.UTF_8);
        System.out.println(encoded);

        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", StandardCharsets.UTF_8);
        System.out.println(decoded);

        byte[] input = new byte[] {(byte)0xe4, (byte)0xb8, (byte)0xad};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);

        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));
        
        // 创建一个MessageDigest实例:
        MessageDigest md2 = MessageDigest.getInstance("SHA-1");
        // 反复调用update输入数据:
        md2.update("Hello".getBytes("UTF-8"));
        md2.update("World".getBytes("UTF-8"));
        byte[] result2 = md2.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result2).toString(16));
    }
}
