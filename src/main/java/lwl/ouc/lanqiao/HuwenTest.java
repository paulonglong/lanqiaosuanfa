 package lwl.ouc.lanqiao;

 import java.util.Scanner;

 /**
  * @author wlli
  * @date 2021/05/12
  */
public class HuwenTest {
    public static void main(String[] args) {
        print99();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String a = scanner.nextLine();
            if ("-1".equals(a)) {
                break;
            }
            int start = 0;
            int end = a.length() - 1;
            boolean flag = true;
            while (start < end) {
                if (a.charAt(start) != a.charAt(end)) {
                    flag = false;
                    break;
                }
                start++;
                end--;
            }
            System.out.println(flag ? a + " is huiwen" : a + " is not huiwen");
        }
    }

    private static void print99() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d\t", j, i, j * i);
            }
            System.out.println();
        }

    }
}
