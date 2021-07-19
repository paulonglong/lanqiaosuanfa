package lwl.ouc.netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioWebSocket {
    public static void main(String[] args) throws IOException {
        
        ExecutorService executorService = Executors.newCachedThreadPool();

        try (ServerSocket ss = new ServerSocket(6666)) {
            System.out.println("服务器启动了，没有客户端连接，我等着。。。");
            while (true) {
                final Socket socket = ss.accept();
                System.out.println("接收到一个客户端的连接，启动一个线程来处理本次连接传输，如下：");

                executorService.execute(new Runnable() {
                    public void run() {
                        handler(socket);
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handler(Socket socket) {
        System.out.println("线程id=" + Thread.currentThread().getId() + "线程name=" + Thread.currentThread().getName());
        try (InputStream inputStream = socket.getInputStream()) {
            byte[] bytes = new byte[1024];
            while (true) {
                System.out.println("没有输入我继续等着。。。");
                int read = inputStream.read(bytes);
                if (read != 1) {
                    System.out.println(new String(bytes,0, read));
                } else {
                    break;
                }
            }
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        } finally {
            if (null != socket) {
                try {
                    System.out.println("关闭客户端连接");
                    socket.close();
                } catch (IOException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
    }
}
