package lwl.ouc.concurrent;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author wlli
 * @date 2021/07/20
 */
public class Test001 {
    @Test
    @Ignore
    public void test001() throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
        });
        System.out.println(Thread.currentThread().getName() + " start");
        t.setName("son thread");
        t.start();
        t.join();
        System.out.println(Thread.currentThread().getName() + " end");
    }

    @Test
    @Ignore
    public void test002() throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        // 暂停1毫秒
        Thread.sleep(1);
        // 中断t线程
        t.interrupt();
        // 等待t线程结束
        t.join();
        System.out.println("end");
    }

    @Test
    public void test003() throws InterruptedException {
        HelloThread3 t3 = new HelloThread3();
        t3.setDaemon(true);
        t3.start();
        HelloThread2 t = new HelloThread2();
        t.start();
        Thread.sleep(1000);
        t.running = false; // 标志位置为false
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
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
                break;
            }
        }
    }
}

class HelloThread2 extends Thread {
    public volatile boolean running = true;

    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}

class HelloThread3 extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (true) {
            n++;
            System.out.println(n + " Daemon !");
        }
    }
}
