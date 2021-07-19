package lwl.ouc.lanqiao;

public class WeiYunSuan {
    public static void main(String[] args) {
        int a = 25;
        // 判断某个数数奇数还是偶数，即判断该数的二进制形式的第1位上是0还是1
        System.out.println(a + "是" + ((a & 1) == 0 ? "偶数" : "奇数"));

        // 判断某个数a，二进制形式时的第n位上是0还是1
        // 右移a（n-1）位，再和1进行与操作
        int n = 5;
        System.out.println(a + "的第" + n + "位是" + (((a >> (n - 1)) & 1) == 0 ? "0" : "1"));

        // 左移0（n-1）位，再和a进行与操作
        System.out.println(a + "的第" + n + "位是" + ((a & (1 << (n - 1))) == 0 ? "0" : "1"));
        
        // 通过亦或交换两个整数
        int b = 52;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        // 右移>> 和 无符号右移>>> 求一个整数绝对值
        int c = -199;
        System.out.println(c + "的绝对值是" + ((c ^ (c >> 31)) + (c >>> 31)));

    }
}
