package lwl.ouc.concurrent.future;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author wlli
 * @date 2021/07/22
 */
public class CompletableFutureTest5 {
    public static void main(String[] args) throws Exception {
        CompletableFuture<List<String>> painting = CompletableFuture.supplyAsync(() -> {
            // 第一个任务获取美术课需要带的东西，返回一个list
            List<String> stuff = new ArrayList<>();
            stuff.add("画笔");
            stuff.add("颜料");
            return stuff;
        });
        CompletableFuture<List<String>> handWork = CompletableFuture.supplyAsync(() -> {
            // 第二个任务获取劳技课需要带的东西，返回一个list
            List<String> stuff = new ArrayList<>();
            stuff.add("剪刀");
            stuff.add("折纸");
            return stuff;
        });
        CompletableFuture<List<String>> total = painting
            // 传入handWork列表，然后得到两个CompletableFuture的参数Stuff1和2
            .thenCombine(handWork, (stuff1, stuff2) -> {
                // 合并成新的list
                List<String> totalStuff =
                    Stream.of(stuff1, stuff2).flatMap(Collection::stream).collect(Collectors.toList());
                return totalStuff;
            });

        for (String string : total.join()) {
            System.out.println(string);
        }
    }
}
