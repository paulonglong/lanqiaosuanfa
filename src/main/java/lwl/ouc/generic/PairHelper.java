package lwl.ouc.generic;

import java.util.List;

/**
 * @author wlli
 * @date 2021/06/29
 */
public class PairHelper {
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    int sumOfList(List<? extends Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer n = list.get(i);
            sum = sum + n;
        }
        return sum;
    }

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }
}
