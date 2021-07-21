 package lwl.ouc.concurrent.readwrite;

 import java.util.Arrays;

 /**
  * @author wlli
  * @date 2021/07/21
  */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t3 = new Thread(() -> {
            c.inc(0);
            c.inc(1);
        });
        t3.start();

        Thread t4 = new Thread(() -> {
            c.inc(0);
            c.inc(1);
        });
        t4.start();

        t3.join();
        t4.join();

        Thread t = new Thread(() -> {
            System.out.println(Arrays.toString(c.get()));
        });
        t.start();

        Thread t2 = new Thread(() -> {
            System.out.println(Arrays.toString(c.get()));
        });
        t2.start();
    }
}
