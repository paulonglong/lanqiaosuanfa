 package lwl.ouc.exceptions;

 /**
 * @author wlli
 * @date 2021/07/05
 */
public class LockTest {
    public static void main(String[] args) {
        int a = 1 / 0;

        try {
            System.out.println("try");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
