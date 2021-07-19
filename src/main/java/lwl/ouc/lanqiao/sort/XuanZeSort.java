package lwl.ouc.lanqiao.sort;

/**
 * @author wlli
 * @date 2021/05/13
 */
/**
 * 选择排序 是选出最大值，然后将最大值和天花板位置交换，然后再降低天花板，继续找剩下的数里的最大值 最新反之亦然
 * 
 * @author wlli
 * @date 2021/05/13
 */
public class XuanZeSort {
    public static void main(String[] args) {
        int[] origin = {78, 90, 111, 222, 1, 2, 3, 56, 67, 333, 444, 4, 11, 12, 13, 14, 55, 555, 666, 777, 888, 999};
        // 外层是天花板，在降低，内层是找到最大值，以及其位置，将最大值所在的位置交换到天花板最顶端
        for (int t = origin.length - 1; t >= 0; t--) {
            int max = origin[0];
            int indexOfMax = 0;

            for (int i = 0; i <= t; i++) {
                if (origin[i] > max) {
                    max = origin[i];
                    indexOfMax = i;
                }
            }

            int tmp = origin[t];
            origin[t] = max;
            origin[indexOfMax] = tmp;
        }
        for (int i : origin) {
            System.out.printf("%d \t", i);
        }
    }
}
