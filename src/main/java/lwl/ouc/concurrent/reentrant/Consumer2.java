package lwl.ouc.concurrent.reentrant;

/**
 * @author wlli
 * @date 2021/07/20
 */
public class Consumer2 extends Thread {
    TaskQueue2 task;

    public Consumer2(TaskQueue2 task) {
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
