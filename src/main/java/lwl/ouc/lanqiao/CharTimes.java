 package lwl.ouc.lanqiao;

 /**
 * @author wlli
 * @date 2021/05/13
 */
public class CharTimes {
    public static void main(String[] args) {
        String abc = "fjdsklueiojfjgreiokkfweuipqewrpoufcnmncjkxmuepoiiuytrewqazzxswedcvrrtgbgtyhnmjuiklop";
        int[] times = new int[26];
        char[] origin = abc.toLowerCase().toCharArray();
        for (char c : origin) {
            times[c - 'a']++;
        }
        System.out.println(origin.length);
        int sum = 0;
        for (int i = 0; i < times.length; i++) {
            System.out.println((char)('a' + i) + "出现的次数为" + times[i]);
            sum += times[i];
        }
        System.out.println(sum);
    }
}
