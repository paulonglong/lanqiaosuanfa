package lwl.ouc.zip;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author wlli
 * @date 2021/05/07
 */
public class PipeTest {
    public static void main(String[] args) throws IOException {
        // 使用Piped 的输入输出流
        PipedInputStream in = new PipedInputStream();
        final PipedOutputStream out = new PipedOutputStream(in);
        // 启动线程，让数据产生者单独运行
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] bs = new byte[2];
                    for (int i = 0; i <= 100; i++) {
                        bs[0] = (byte)i;
                        bs[1] = (byte)(i + 1);
                        // 测试写入字节数组
                        out.write(bs);
                        out.flush();
                        // 等待0.1秒
                        Thread.sleep(100);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // 数据使用者处理数据
        // 也可以使用线程来进行并行处理
        byte[] bs = new byte[1024];
        int len;
        // 读取数据，并进行处理
        try {
            while ((len = in.read(bs)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.println(bs[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
