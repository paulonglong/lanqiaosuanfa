package lwl.ouc.stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author wlli
 * @date 2021/04/16
 */
public class TestCollectors {
    @Test
    public void testToCollection() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // [10, 20, 30]
        List<Integer> collect = list.stream().map(i -> i * 10).collect(Collectors.toList());

        // [20, 10, 30]
        Set<Integer> collect1 = list.stream().map(i -> i * 10).collect(Collectors.toSet());

        // {key1=value:10, key2=value:20, key3=value:30}
        Map<String, String> collect2 = list.stream().map(i -> i * 10)
            .collect(Collectors.toMap(key -> "key" + key / 10, value -> "value:" + value));
        collect2.forEach((key, value) -> System.out.println(key + "=" + value));

        // [1, 3, 4]
        TreeSet<Integer> collect3 = Stream.of(1, 3, 4).collect(Collectors.toCollection(TreeSet::new));
    }
}
