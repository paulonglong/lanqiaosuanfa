 package lwl.ouc.lanqiao;

 import java.util.Scanner;

 /**
  * @author wlli
  * @date 2021/05/12
  */
public class Ten2Sixteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int abc = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.insert(0, single(abc % 16));
            abc = abc / 16;
            if (abc == 0) {
                break;
            }
        }
        System.out.println(sb);
    }

    private static char single(int a) {
        char result;
        if (a > 9) {
            result = (char)('A' + (a - 10));
        } else {
            result = (char)('0' + (a - 0));
        }
        return result;
    }
}
