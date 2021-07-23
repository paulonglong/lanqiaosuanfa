package lwl.ouc.mail;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * @author wlli
 * @date 2021/07/23
 */
public class JavaMailTest {
    public static void main(String[] args) throws Exception {
        // 服务器地址:
        String smtp = "smtp.163.com";
        // 登录用户名:
        String username = "lwlouc@163.com";
        // 登录口令:
        String password = "qwert1234!";
        // 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "465"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.ssl.enable", true);
        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // 设置debug模式便于调试:
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        // 设置发送方地址:
        message.setFrom(new InternetAddress("lwlouc@163.com"));
        // 设置接收方地址:
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("yqxu@wisedu.com"));
        // 设置邮件主题:
        message.setSubject("Hello", "UTF-8");

        Multipart multipart = new MimeMultipart();
        // 添加text:
        BodyPart textpart = new MimeBodyPart();
        textpart.setContent("Hi yqxu...", "text/html;charset=utf-8");
        multipart.addBodyPart(textpart);

        BodyPart textpart2 = new MimeBodyPart();
        textpart2.setContent("<h1>Hello</h1><p><img src=\"cid:img01\"></p>", "text/html;charset=utf-8");
        multipart.addBodyPart(textpart2);

        // 添加image:
        BodyPart imagepart = new MimeBodyPart();
        imagepart.setFileName("nzb.png");
        imagepart.setDataHandler(new DataHandler(new ByteArrayDataSource(
            new FileInputStream(new File("C:\\Users\\wlli\\Downloads\\l.png")), "image/png")));
        imagepart.setHeader("Content-ID", "<img01>");
        multipart.addBodyPart(imagepart);
        // 设置邮件内容为multipart:
        message.setContent(multipart);
        // 发送:
        Transport.send(message);
    }
}
