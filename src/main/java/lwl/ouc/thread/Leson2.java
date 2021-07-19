package lwl.ouc.thread;

/**
 * @author wlli
 * @date 2021/06/08
 */
public class Leson2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread2();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join();
        System.out.println("end");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted in My");
            hello.interrupt();
        }
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("interrupted in Hello");
                break;
            }
        }
    }
}
