 package lwl.ouc.future;

 import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 
 * 
 * @author wlli
 * @date 2021/06/08
 */
 public class CompletableFutureDemo {
     public static void main(String[] args) {
         CompletableFuture.supplyAsync(() -> 1).thenApply(i -> i + 1).thenApply(i -> i * i)
             .whenComplete((r, e) -> System.out.println(r));

         CompletableFuture.supplyAsync(() -> "Hello ").thenApply(s -> s + "World ").thenApply(String::toUpperCase)
             .thenCombine(CompletableFuture.completedFuture("Java"), (s1, s2) -> s1 + s2)
             .thenAccept(System.out::println);

         String[] list = {"a", "b", "c"};
         List<CompletableFuture<String>> reslist = new ArrayList<>();
         Arrays.asList(list).stream().forEach(e -> {
             reslist.add(CompletableFuture.supplyAsync(() -> e).thenApply(String::toUpperCase));
         });
         
         CompletableFuture.allOf(reslist.toArray(new CompletableFuture[reslist.size()])).whenComplete((r,e) -> {
             if (null == e) {
            } else {
                 throw new RuntimeException(e);
            }
         });
         Arrays.asList(list).stream().forEach(System.out::println);
     }
 }