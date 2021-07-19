package lwl.ouc.lanqiao;

import java.util.Scanner;

/**
 * @author wlli
 * @date 2021/05/13
 */
public class BynarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[] origin = {1, 2, 3, 4, 11, 12, 13, 14, 55, 56, 67, 78, 90, 111, 222, 333, 444, 555, 666, 777, 888, 999};
        int start = 0;
        int end = origin.length - 1;
        System.out.println(dosearch(origin, target, start, end));
    }

    private static int dosearch(int[] origin, int target, int start, int end) {
        if (target < origin[start] || target > origin[end] || start >= end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        // start end通过mid赋值的时候+1 -1是target不存在于数组时，递归退出的关键
        if (target == origin[mid]) {
            return mid;
        } else if (target > origin[mid]) {
            return dosearch(origin, target, mid + 1, end);
        } else {
            return dosearch(origin, target, start, mid - 1);
        }
    }
}
