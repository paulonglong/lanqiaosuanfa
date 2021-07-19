package lwl.ouc.lanqiao.sort;

/**
 * @author wlli
 * @date 2021/05/13
 */
/**
 * 冒泡排序是相邻位置比较大小，大的往右边交换，直到天花板位置，再减低天花板高度，从新进行相邻比较
 * 
 * @author wlli
 * @date 2021/05/13
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] origin = {78, 90, 111, 222, 1, 2, 3, 56, 67, 333, 444, 4, 11, 12, 13, 14, 55, 555, 666, 777, 888, 999};
        // 外层是天花板，在降低，内层是从左向右大数往右走
        for (int t = origin.length - 1; t >= 0; t--) {
            for (int i = 0; i <= origin.length - 1; i++) {
                if (origin[i] > origin[i + 1]) {
                    int temp = origin[i];
                    origin[i] = origin[i + 1];
                    origin[i + 1] = temp;
                }
            }
        }
        for (int i : origin) {
            System.out.printf("%d \t", i);
        }
    }
}
