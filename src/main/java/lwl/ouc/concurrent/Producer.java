package lwl.ouc.concurrent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author wlli
 * @date 2021/07/20
 */
public class Producer extends Thread {
    TaskQueue task;

    public Producer(TaskQueue task) {
        this.task = task;
    }

    @Override
    public void run() {
        // 读取文件，放入队列中
        try (BufferedReader br =
            new BufferedReader(new InputStreamReader(new FileInputStream(new File("D://setting.properties"))))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                task.add(line);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
