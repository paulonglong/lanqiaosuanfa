package lwl.ouc.stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
    @Test
    public void forEach() {
        // 你不鸟我,我也不鸟你
        List<String> list = Arrays.asList("you", "don't", "bird", "me", ",", "I", "don't", "bird", "you");

        // 方式一：JDK1.8之前的循环方式
        for (String item : list) {
            System.out.println(item);
        }

        // 方式二：使用Stream的forEach方法
        // void forEach(Consumer<? super T> action)
        list.stream().forEach(item -> System.out.println(item));

        // 方式三：方式二的简化方式
        // 由于方法引用也属于函数式接口，所以方式二Lambda表达式也可以使用方法引用来代替
        // 此种方式就是方式一、方式二的简写形式
        list.stream().forEach(System.out::println);

        list.stream().forEach(i -> {
            System.out.println(i);
            System.out.println(i);
        });
    }

    @Test
    public void flatMap() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);

        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        List<List<Integer>> collect = Stream.of(a, b).collect(Collectors.toList());
        // [[1, 2, 3], [4, 5, 6]]
        System.out.println(collect);

        // 将多个集合中的元素合并成一个集合
        List<Integer> mergeList = Stream.of(a, b).flatMap(list -> list.stream()).collect(Collectors.toList());
        // [1, 2, 3, 4, 5, 6]
        System.out.println(mergeList);

        // 通过Builder模式来构建
        Stream<Object> stream = Stream.builder().add("hello").add("hi").add("byebye").build();
        stream.forEach(System.out::println);
    }

    @Test
    public void sort() {
        List<String> list = Arrays.asList("ca", "ed", "aa", "de", "bc");
        // Stream<T> sorted(Comparator<? super T> comparator);
        // int compare(T o1, T o2);
        list.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println);
    }

    @Test
    public void distinct() {
        // 知之为知之,不知为不知
        Stream<String> stream = Stream.of("know", "is", "know", "noknow", "is", "noknow");
        stream.distinct().forEach(System.out::println); // know is noknow
    }

    @Test
    public void count() {
        Stream<String> stream = Stream.of("know", "is", "know", "noknow", "is", "noknow");
        long count = stream.distinct().count();
        System.out.println(count);
    }

    @Test
    public void min() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        // Optional<T> min(Comparator<? super T> comparator);
        Optional<String> optional = list.stream().min((a, b) -> a.compareTo(b));
        String value = optional.get();
        System.out.println(value);
    }

    @Test
    public void skip() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        // Stream<T> skip(long n)
        list.stream().skip(2).forEach(System.out::println); // c、d、e
    }

    @Test
    public void limit() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        list.stream().skip(2).limit(2).forEach(System.out::println); // c、d
    }

    @Test
    public void collect() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        // Stream -> Collection
        List<String> collect = list.stream().collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

        // Stream -> Object[]
        Object[] objects = list.stream().toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    public void concat() {
        List<String> list = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("c", "d");
        Stream<String> concatStream = Stream.concat(list.stream(), list2.stream());
        concatStream.forEach(System.out::println);
    }

    @Test
    public void match() {
        // 你给我站住
        List<String> list = Arrays.asList("you", "give", "me", "stop");
        // boolean anyMatch(Predicate<? super T> predicate);
        // parallelStream可以并行计算，速度比stream更快
        boolean result = list.parallelStream().anyMatch(item -> item.equals("me"));
        System.out.println(result);
    }

    /**
     * anyMatch伪代码 如果集合中有一个元素满足条件就返回true
     * 
     * @return
     */
    public boolean anyMatch() {
        List<String> list = Arrays.asList("you", "give", "me", "stop");
        for (String item : list) {
            if (item.equals("me")) {
                return true;
            }
        }

        return false;
    }

    /**
     * 归纳
     */
    @Test
    public void reduce() {
        Stream<String> stream = Stream.of("you", "give", "me", "stop");
        // Optional<T> reduce(BinaryOperator<T> accumulator);
        Optional<String> optional = stream.reduce((before, after) -> before + "," + after);
        optional.ifPresent(System.out::println); // you,give,me,stop
    }

    @Test
    public void findFirst() {
        Stream<String> stream = Stream.of("you", "give", "me", "stop");
        String value = stream.findFirst().get();
        System.out.println(value);
    }

    @Test
    public void findAny() {
        Stream<String> stream = Stream.of("you", "give", "me", "stop");
        String value2 = stream.findAny().get();
        System.out.println(value2);
    }
}
