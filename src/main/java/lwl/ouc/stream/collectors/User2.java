package lwl.ouc.stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author wlli
 * @date 2021/04/16
 */
@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class User2 {

    private Long id;
    private String username;
    private Integer type;

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 奇偶数分组：奇数分一组，偶数分一组
        // groupingBy(Function<? super T, ? extends K> classifier) 参数是Function类型，Function返回值可以是要分组的条件，也可以是要分组的字段
        // 返回的结果是Map，其中key的数据类型为Function体中计算类型，value是List<T>类型，为分组的结果
        Map<Boolean, List<Integer>> result = list.stream().collect(Collectors.groupingBy(item -> item % 2 == 0));
        // {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}
        System.out.println(result);

        // partitioningBy 用于分成两组的情况
        Map<Boolean, List<Integer>> twoPartiton =
            list.stream().collect(Collectors.partitioningBy(item -> item % 2 == 0));
        System.out.println(twoPartiton);

        User2 user = new User2(1L, "zhangsan", 1);
        User2 user2 = new User2(2L, "lisi", 2);
        User2 user3 = new User2(3L, "wangwu", 3);
        User2 user4 = new User2(4L, "fengliu", 1);
        List<User2> users = Arrays.asList(user, user2, user3, user4);
        // 根据某个字段进行分组
        Map<Integer, List<User2>> userGroup = users.stream().collect(Collectors.groupingBy(item -> item.type));

        /**
         * key 为要分组的字段 value 分组的结果 { 1=[User{id=1, username='zhangsan', type=1}, User{id=4, username='fengliu',
         * type=1}], 2=[User{id=2, username='lisi', type=2}], 3=[User{id=3, username='wangwu', type=3}] }
         */
        System.out.println(userGroup);
    }
}