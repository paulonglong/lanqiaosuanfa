 package lwl.ouc.lanqiao;

 import java.util.Scanner;

 /**
  * @author wlli
  * @date 2021/05/12
  */
public class Ten2Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int abc = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.insert(0, abc % 2);
            abc = abc / 2;
            if (abc == 0) {
                break;
            }
        }
        System.out.println(sb);

        System.out.println(float2Two());

        print2Num(1, 10);
    }

    private static String float2Two() {
        float a = 0.625f;
        float r = a;
        StringBuilder sb = new StringBuilder("0.");
        while (r != 0) {
            r = r * 2;
            if (r >= 1) {
                sb.append("1");
                r = r - 1;
            } else {
                sb.append("0");
            }
            if (sb.length() > 34) {
                return "Error";
            }
        }
        return sb.toString();
    }

    private static void print2Num(int i, int j) {
        if (i > j) {
            return;
        }
        System.out.println(i);
        print2Num(i + 1, j);
    }
}
