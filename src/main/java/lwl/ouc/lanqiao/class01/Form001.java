package lwl.ouc.lanqiao.class01;

import java.util.Random;

/**
 * @author wlli
 * @date 2021/05/19
 */
public class Form001 {
    public static void main(String[] args) {
        int N = 1001;
        int[] origin = new int[N];
        for (int i = 0; i < N - 1; i++) {
            origin[i] = i + 1;
        }
        origin[N - 1] = new Random().nextInt(N - 1) + 1;

        for (int i : origin) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 亦或 1到10
        int x1 = 0;
        for (int i = 1; i < N; i++) {
            x1 = x1 ^ i;
        }

        // 1到10的亦或结果，再去亦或数组中的所有值
        for (int i = 0; i < N; i++) {
            x1 = x1 ^ origin[i];
        }
        System.out.println(x1);
        // ================================
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[origin[i]]++;
        }
        for (int i = 1; i < result.length; i++) {
            if (result[i] > 1) {
                System.out.println(i);
            }
        }

        int[] origin2 = {1, 2, 3, 1, 2, 3, 5};
        System.out.println(findLuoDan(origin2));

    }

    /**
     * 寻找数组中，唯一落单的元素
     * 
     * @param origin
     * @return
     */
    private static int findLuoDan(int[] origin) {
        int x1 = 0;
        int N = origin.length;
        for (int i = 0; i < N; i++) {
            x1 = x1 ^ origin[i];
        }
        return x1;
    }
}
