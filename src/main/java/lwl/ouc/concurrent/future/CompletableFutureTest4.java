package lwl.ouc.concurrent.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author wlli
 * @date 2021/07/22
 */
public class CompletableFutureTest4 {
    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture.allOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = CompletableFuture.supplyAsync(() -> {
            return fetchPrice(cfQueryFromSina.join(), "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = CompletableFuture.supplyAsync(() -> {
            return fetchPrice(cfQueryFrom163.join(), "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture.allOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        System.out.println("price: " + cfFetchFromSina.join());
        System.out.println("price: " + cfFetchFrom163.join());

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long)(Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long)(Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
