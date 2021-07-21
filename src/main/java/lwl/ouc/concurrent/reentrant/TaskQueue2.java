package lwl.ouc.concurrent.reentrant;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wlli
 * @date 2021/07/20
 */
public class TaskQueue2 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    Queue<String> queue = new LinkedList<>();

    public void add(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String get() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } catch (InterruptedException e) {
            throw e;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TaskQueue2 task = new TaskQueue2();
        Consumer2 c1 = new Consumer2(task);
        c1.setName("C1");
        c1.start();
        Consumer2 c2 = new Consumer2(task);
        c2.start();
        c2.setName("C2");
        Producer2 p = new Producer2(task);
        p.start();
        p.join();
        c1.interrupt();
        c2.interrupt();
    }
}
