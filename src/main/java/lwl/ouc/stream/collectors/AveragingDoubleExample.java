package lwl.ouc.stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AveragingDoubleExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // [2,4,6,8] 20/4 = 5.0
        Double result = list.stream().collect(Collectors.averagingLong(d -> d * 2));
        System.out.println(result);

        // [1,4,9,16]30/4 = 7.5
        Double result5 = list.stream().collect(Collectors.averagingLong(d -> d * d));
        System.out.println(result5);

        // [2,4,6,8] 20/4 = 5.0  5.0 * 5.0 = 25
        Double result4 =
            list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v -> v * 2), s -> s + s));
        System.out.println(result4);
        
        String str= Stream.of("a", "b", "c").collect(Collectors.collectingAndThen(Collectors.joining(":"), x -> x + "d"));
        System.out.println(str);
    }
}