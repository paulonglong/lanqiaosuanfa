package lwl.ouc.lanqiao;

public class RandomBetween {
    public static void main(String[] args) {
        int a = 3, b = 5;
        double r = a + Math.random() * (b - a);
        System.out.println(r);
        int ri = (int)(a + Math.random() * (b - a));
        System.out.println(ri);
    }
}
