 package lwl.ouc.lanqiao.class02;

 /**
 * @author wlli
 * @date 2021/05/21
 */
public class Form004 {
    public static void main(String[] args) {
        int N = 4;
        printHNT(N, "A", "B", "C");
    }

    private static void printHNT(int N, String from, String to, String help) {
        if (1 == N) {
            System.out.println("move " + N + " from " + from + " to " + to);
        } else {
            printHNT(N - 1, from, help, to);
            System.out.println("move " + N + " from " + from + " to " + to);
            printHNT(N - 1, help, to, from);
        }
    }
}
