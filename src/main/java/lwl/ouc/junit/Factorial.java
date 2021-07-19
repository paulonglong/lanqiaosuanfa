package lwl.ouc.junit;

/**
 * @author wlli
 * @date 2021/07/19
 */
public class Factorial {
    public long fact(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n > 20) {
            throw new IllegalArgumentException("too big");
        }
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}