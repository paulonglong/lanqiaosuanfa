 package lwl.ouc.lanqiao.class02;

/**
  * @author wlli
  * @date 2021/05/25
  */
public class Form007 {
    public static void main(String[] args) {
        int[] a = {1, 9, 2, 5, 7, 3, 4, 6, 8, 0, 11, 15, 17, 17, 10};
        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int maxLength = 0;
        int length = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= a[i - 1]) {
                end = i;
                length = end - start;
                if (maxLength < length) {
                    maxLength = length;
                    maxStart = start;
                    maxEnd = i - 1;
                }
                start = i;
            }
        }
        for (int i = maxStart; i <= maxEnd; i++) {
            System.out.println(a[i]);
        }
    }
}
