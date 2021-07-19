 package lwl.ouc.lanqiao.class02;

 import java.util.Scanner;

 /**
  * @author wlli
  * @date 2021/05/24
  */
public class Form006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = process(n);
        System.out.println(m);
    }

    /**
     * @param n
     * @return
     */
    private static int process(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        return process(n - 1) + process(n - 2) + process(n - 3);
    }
}
