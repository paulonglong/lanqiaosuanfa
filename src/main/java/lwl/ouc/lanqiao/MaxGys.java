 package lwl.ouc.lanqiao;

 import java.util.Scanner;

 /**
  * @author wlli
  * @date 2021/05/13
  */
public class MaxGys {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int big = scanner.nextInt();
        int small = scanner.nextInt();
        // 交换两个整数
        // if (big < small) {
        // int temp = big;
        // big = small;
        // small = temp;
        // }
        if (big < small) {
            big = big ^ small;
            small = big ^ small;
            big = big ^ small;
        }
        System.out.println(big + "和" + small + "的最大公约数是" + max(big, small));
    }

    // 递归调用 时间复杂logn2
    private static int max(int big, int small) {
        System.out.println("big = " + big + " | small = " + small);
        if (big % small == 0) {
            return small;
        } else {
            big = big % small;
            return max(small, big);
        }
    }
}
