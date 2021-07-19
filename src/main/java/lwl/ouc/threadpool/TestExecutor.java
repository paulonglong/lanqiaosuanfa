package lwl.ouc.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutor {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                
            }
        });
        Future<Integer> d = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // TODO Auto-generated method stub
                return null;
            }});
        try {
            d.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
