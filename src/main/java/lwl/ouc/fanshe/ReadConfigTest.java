package lwl.ouc.fanshe;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReadConfigTest {
    private static String cp = "/lwl/ouc/fanshe/pro.txt"; 
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws Exception {
        //通过反射获取Class对象
        Class stuClass = Class.forName(getValue("className"));//"cn.fanshe.Student"
        //2获取show()方法
        Method m = stuClass.getMethod(getValue("methodName"));//show
        //3.调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());
    }
    
    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException{
        Properties pro = new Properties();//获取配置文件的对象
        String aString = ReadConfigTest.class.getResource(cp).getFile();
        FileReader in = new FileReader(new File(aString));//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }
}
