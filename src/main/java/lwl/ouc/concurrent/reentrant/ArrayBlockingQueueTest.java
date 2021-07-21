package lwl.ouc.concurrent.reentrant;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author wlli
 * @date 2021/07/21
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(20);
        Thread c1 = new Thread(() -> {
            try {
                String aaa = null;
                while (true) {
                    Thread.sleep(500);
                    aaa = abq.take();
                    System.out.println(Thread.currentThread().getName() + "消费了一个" + aaa);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "生产者停工了，没有可消费的内容了");
                return;
            }
        });
        c1.setName("C1");
        c1.start();
        Thread c2 = new Thread(() -> {
            try {
                String aaa = null;
                while (true) {
                    Thread.sleep(500);
                    aaa = abq.take();
                    System.out.println(Thread.currentThread().getName() + "消费了一个" + aaa);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "生产者停工了，没有可消费的内容了");
                return;
            }
        });
        c2.start();
        c2.setName("C2");

        Thread p = new Thread(() -> {
            int i = 1;
            while (true) {
                try {
                    if (i > 50) {
                        break;
                    }
                    System.out.println("我生产了一个" + i);
                    abq.put(i++ + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        p.start();
        p.join();
        try {
            Thread.sleep(10000);
            c1.interrupt();
            c2.interrupt();
        } catch (Exception e) {
        }
    }
}
