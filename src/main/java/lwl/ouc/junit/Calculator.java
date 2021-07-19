package lwl.ouc.junit;

/**
 * @author wlli
 * @date 2021/07/19
 */
public class Calculator {
    private long n = 0;

    public long add(long x) {
        n = n + x;
        return n;
    }

    public long sub(long x) {
        n = n - x;
        return n;
    }
}
