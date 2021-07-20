package lwl.ouc.concurrent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wlli
 * @date 2021/07/20
 */
public class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void add(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }

    public static void main(String[] args) throws InterruptedException {
        TaskQueue task = new TaskQueue();
        Consumer c1 = new Consumer(task);
        c1.setName("C1");
        c1.start();
        Consumer c2 = new Consumer(task);
        c2.start();
        c2.setName("C2");
        Producer p = new Producer(task);
        p.start();
        p.join();
        c1.interrupt();
        c2.interrupt();
    }
}
