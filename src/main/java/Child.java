import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wlli
 * @date 2021/04/20
 */
public class Child {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int avg = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        int max = 0;
        while (true) {
            list.add(scan.nextInt());
            if (++max == n) {
                break;
            }
        }

        int r = 0;
        for (int i = 0; i < n; i++) {
            r += jis(list, avg);
            list.remove(0);
        }
        System.out.println(r);
        scan.close();
    }

    private static int jis(List<Integer> list, int avg) {
        int sum = 0;
        int r = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if (sum / (i + 1) >= avg) {
                r++;
            }
        }
        return r;
    }
}
