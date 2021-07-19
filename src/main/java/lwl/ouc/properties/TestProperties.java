 package lwl.ouc.properties;

 import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

 /**
  * @author wlli
  * @date 2021/06/30
  */
public class TestProperties {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        props.load(TestProperties.class.getResourceAsStream("/setting.properties"));

        String filepath = props.getProperty("last_open_file");
        System.out.println(filepath);
        String interval = props.getProperty("auto_save_interval", "120");
        System.out.println(interval);

        props.setProperty("url", "http://www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        props.store(new FileWriter("D:\\setting.properties"), "这是写入的properties注释");

    }
}
