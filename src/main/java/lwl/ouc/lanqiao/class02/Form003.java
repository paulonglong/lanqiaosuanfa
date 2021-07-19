 package lwl.ouc.lanqiao.class02;

 /**
 * @author wlli
 * @date 2021/05/20
 */
public class Form003 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int r = sum(a, a.length - 1);
        System.out.println(r);
        int x = sum0(a, 0);
        System.out.println(x);

        String c = "abcdefg";
        System.out.println(c);
        String d = reverse(c, c.length() - 1);
        System.out.println(d);

        System.out.println(fbnqAtN(6));
        System.out.println(fbnqAtN(7));
    }

    /**
     * @param a
     * @return
     */
    private static int sum(int[] a, int i) {
        if (i == 0) {
            return a[0];
        }
        int sum = a[i] + sum(a, i - 1);
        return sum;
    }

    /**
     * @param a
     * @return
     */
    private static int sum0(int[] a, int i) {
        if (i == a.length - 1) {
            return a[a.length - 1];
        }
        int sum = a[i] + sum0(a, i + 1);
        return sum;
    }

    private static String reverse(String a, int i) {
        if (i == 0) {
            return a.charAt(i) + "";
        }
        return a.charAt(i) + reverse(a, i - 1);
    }

    private static int fbnqAtN(int n) {
        if (1 == n || 2 == n) {
            return 1;
        }
        return fbnqAtN(n - 1) + fbnqAtN(n - 2);
    }
}
