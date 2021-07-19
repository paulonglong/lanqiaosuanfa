package lwl.ouc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test3() throws Exception {
        boolean flag = false;
        // 创建异步执行任务:
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> cf = executorService.submit(() -> {
            System.out.println(Thread.currentThread() + " start");
            long beginInSon = System.currentTimeMillis();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if (flag) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread() + " exit,time->" + (System.currentTimeMillis() - beginInSon));
                return 1.2;
            }
        });
        System.out.println("main thread start");
        long beginInMain = +System.currentTimeMillis();
        // 等待子任务执行完成,如果已完成则直接返回结果
        // 如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->" + cf.get());
        System.out.println("main thread exit,time->" + (System.currentTimeMillis() - beginInMain));
    }

    @Test
    public void test2() throws Exception {
        boolean flag = false;
        // 创建异步执行任务，有返回值
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " start");
            long beginInSon = System.currentTimeMillis();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if (flag) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread() + " exit,time->" + (System.currentTimeMillis() - beginInSon));
                return 1.2;
            }
        });
        
        long beginInMain = +System.currentTimeMillis();
        // 等待子任务执行完成,如果已完成则直接返回结果
        // 如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        System.out.println("run result->" + cf.get());
        System.out.println("main thread exit,time->" + (System.currentTimeMillis() - beginInMain));
    }
}
