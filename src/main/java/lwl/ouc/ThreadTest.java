package lwl.ouc;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Li Wenlong
 * @since 2021/4/19
 */
public class ThreadTest extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("1111111111");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    static int[] ad = new int[5];

    public static void main(String[] args) {
        new ThreadTest().start();
        System.out.println("2222222222");
        // System.out.println(ThreadTest.start());
        // IntStream.of(20,30).forEach(item -> System.out.println(item));
    }
}
