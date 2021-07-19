 package lwl.ouc.thread;

 /**
 * @author wlli
 * @date 2021/06/08
 */
public class Leson001 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main begin");
        Thread t = new Thread(() -> {
            System.out.println("sub1 begin");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sub2 end");
        });
        t.start();
        try {
            t.join();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");

        // -===================================

        Thread t2 = new MyThread();
        t2.start();
        Thread.sleep(1); // 暂停1毫秒
        t2.interrupt(); // 中断t线程
        t2.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}
