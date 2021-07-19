 package lwl.ouc.lanqiao.class03;

 /**
 * @author wlli
 * @date 2021/06/02
 */
public class QuickSort2 {
    public static void main(String[] args) {
        // int[] A = {2, 3, 7, 1, 4, 5, 9, 7, 8, 6};
        int[] A = {6, 5, 3, 9, 1, 7, 8, 2, 4, 0};
        print(A);
        quickSort2(A, 0, A.length - 1);
        System.out.println();
        print(A);
    }

    /**
     * @param a
     */
    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * 
     * @param A
     * @param p
     * @param r
     */
    public static void quickSort2(int[] A, int p, int r) {
        if (p < r) {
            int q = partition2(A, p, r);
            quickSort2(A, p, q - 1);
            quickSort2(A, q + 1, r);
        }
    }

    /**
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int partition2(int[] a, int p, int r) {
        int pivot = a[p];
        int left = p + 1;
        int right = r;
        while (left <= right) {
            // 从左往右找到第一个大于pivot的元素
            while(left <= right && a[left] <= pivot) left++;
            // 从右往左找到第一个小于pivot的元素
            while(left <= right && a[right] > pivot) right--;
            //交换 left和right索引上的元素
            if (left < right) {
                swap(a, left, right);
            }
        }
        // 交换p和right索引上的元素
        swap(a, p, right);

        return right;
    }

    /**
     * @param a
     * @param left
     * @param right
     */
    private static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}
