package lwl.ouc.concurrent;

/**
 * @author wlli
 * @date 2021/07/20
 */
public class Consumer extends Thread {
    TaskQueue task;

    public Consumer(TaskQueue task) {
        this.task = task;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String s = task.get();
                System.out.println(Thread.currentThread().getName() + " execute task: " + s);
            } catch (InterruptedException e) {
                System.out.println("fuck you");
                return;
            }
        }
    }
}
