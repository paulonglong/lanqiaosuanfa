 package lwl.ouc.lanqiao.class03;

 /**
 * @author wlli
 * @date 2021/06/02
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] A = {2, 3, 7, 1, 4, 5, 9, 7, 8, 6};
        print(A);
        quickSort(A, 0, A.length - 1);
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
    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    /**
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] a, int p, int r) {
        int pivot = a[p];
        int sp = p + 1;
        int bigger = r;
        while (sp <= bigger) {
            if (a[sp] <= pivot) {
                sp++;
            } else {
                swap(a, sp, bigger);
                bigger--;
            }
        }
        swap(a, p, bigger);
        return bigger;
    }

    /**
     * @param a
     * @param sp
     * @param bigger
     */
    private static void swap(int[] a, int sp, int bigger) {
        int temp = a[sp];
        a[sp] = a[bigger];
        a[bigger] = temp;
    }
}
