 package lwl.ouc.lanqiao.class01;

 import java.util.Random;

 /**
  * 计算整数的二进制形式中有多少个1
  * 
  * @author wlli
  * @date 2021/05/20
  */
public class Form002 {
    public static void main(String[] args) {
        int n = new Random().nextInt(10);
        int m = n;
        int k = n;
        System.out.println(n);
        System.out.println(Integer.toString(n, 2));
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        System.out.println(count);

        // ================================
        count = 0;
        while (m > 0) {
            // 一个整数减一 再和自身 与操作，则会把之前借位出来的1消掉，循环直到变为0
            m = (m - 1) & m;
            count++;
        }
        System.out.println(count);

        // ================================
        // 判断一个数是不是2的整数次方即 判断该数的二进制数制下是不是只有一个1（1也是因为1=2的0次方）
        // 基于上面的 (m-1)&m的公式，如果该整数只有一个1，那只需要进行一次&操作就变为0了
        System.out.println(((k - 1) & k) == 0 ? k + "是2的整数次方" : k + "不是2的整数次方");

        // 整数的奇 偶 位上的数值互换
        int a = 9;
        int j = a & 0x5555;
        int o = a & 0xaaaa;
        int b = (o >> 1) ^ (j << 1);
        System.out.println(b);

    }
}
