package lwl.ouc.lanqiao.sort;

/**
 * @author wlli
 * @date 2021/05/14
 */
public class ChaRuSort {
    public static void main(String[] args) {
        int[] origin = {78, 90, 56, 67, 111, 222, 1, 2, 3, 333, 444, 4, 11, 12, 13, 14, 55, 555, 666, 777, 888, 999};
        // 外层是从origin里一张张抽牌，从第二张牌开始
        for (int i = 0; i < origin.length; i++) {
            // i代表当前牌，index代表当前牌应该插入的最新的值的位置，初始化为当前位置减1
            int index = i - 1;
            int current = origin[i];
            // 内层是拿着抽到的牌，和indexOfLast之前的所有牌比较，直到数组开头，找到合适的位置插入
            while (index > -1 && current < origin[index]) {
                origin[index + 1] = origin[index];
                index--;
            }
            origin[index + 1] = current;
        }

        for (int i : origin) {
            System.out.printf("%d \t", i);
        }
    }
}
