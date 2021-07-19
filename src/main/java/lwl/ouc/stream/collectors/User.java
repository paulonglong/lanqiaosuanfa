package lwl.ouc.stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Long id;
    private String username;

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(new User(1L, "mengday"), new User(2L, "mengdee"), new User(3L, "mengdy"));

        // toMap 可用于将List转为Map，便于通过key快速查找到某个value
        Map<Long, User> userIdAndModelMap =
            userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        User user = userIdAndModelMap.get(1L);
        // User(id=1, username=mengday)
        System.out.println(user);

        Map<Long, String> userIdAndUsernameMap =
            userList.stream().collect(Collectors.toMap(User::getId, User::getUsername));
        String username = userIdAndUsernameMap.get(1L);
        // mengday
        System.out.println(username);
    }

    @Test
    public void testJoining() {
        // a,b,c
        List<String> list2 = Arrays.asList("a", "b", "c");
        String result = list2.stream().collect(Collectors.joining(","));

        // Collectors.joining(",")的结果是：a,b,c 然后再将结果 x + "d"操作, 最终返回a,b,cd
        String str =
            Stream.of("a", "b", "c").collect(Collectors.collectingAndThen(Collectors.joining(","), x -> x + "d"));
    }

    @Test
    public void test1() {
        // 求最值 3
        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer maxValue =
            list.stream().collect(Collectors.collectingAndThen(Collectors.maxBy((a, b) -> a - b), Optional::get));

        // 最小值 1
        Integer minValue =
            list.stream().collect(Collectors.collectingAndThen(Collectors.minBy((a, b) -> a - b), Optional::get));

        // 求和 6
        Integer sumValue = list.stream().collect(Collectors.summingInt(item -> item));

        // 平均值 2.0
        Double avg = list.stream().collect(Collectors.averagingDouble(x -> x));
    }

    @Test
    public void test2() {
        // 映射：先对集合中的元素进行映射，然后再对映射的结果使用Collectors操作
        // A,B,C
        Stream.of("a", "b", "c").collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.joining(",")));
    }

    @Test
    public void testReducing() {

        // sum: 是每次累计计算的结果，b是Function的结果
        System.out.println(Stream.of(1, 3, 4).collect(Collectors.reducing(0, x -> x + 1, (sum, b) -> {
            System.out.println(sum + "-" + b);
            return sum + b;
        })));

        // 下面代码是对reducing函数功能实现的描述，用于理解reducing的功能
        int sum = 0;
        List<Integer> list3 = Arrays.asList(1, 3, 4);
        for (Integer item : list3) {
            int b = item + 1;
            System.out.println(sum + "-" + b);
            sum = sum + b;
        }
        System.out.println(sum);

        // 注意reducing可以用于更复杂的累计计算，加减乘除或者更复杂的操作
        // result = 2 * 4 * 5 = 40
        System.out.println(Stream.of(1, 3, 4).collect(Collectors.reducing(1, x -> x + 1, (result, b) -> {
            System.out.println(result + "-" + b);
            return result * b;
        })));
    }
}
