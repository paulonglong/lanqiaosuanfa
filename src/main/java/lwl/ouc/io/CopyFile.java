 package lwl.ouc.io;

 import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

 /**
  * @author wlli
  * @date 2021/07/01
  */
public class CopyFile {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String file = "C:\\Users\\wlli\\Downloads\\pic-todaybing-hd-wbNk5j3R.jpg";
        String fileCopy = "C:\\Users\\wlli\\Downloads\\copy.zip";
        try (InputStream in = new BufferedInputStream(new FileInputStream(file));
            InputStream in2 = new BufferedInputStream(new FileInputStream(file));
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(fileCopy))) {
            out.putNextEntry(new ZipEntry("123/123.jpg"));
            in.transferTo(out);
            out.putNextEntry(new ZipEntry("123/456.jpg"));
            in2.transferTo(out);
        }
    }
}
