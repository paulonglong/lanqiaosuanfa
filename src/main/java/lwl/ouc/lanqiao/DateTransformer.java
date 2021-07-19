package lwl.ouc.lanqiao;

public class DateTransformer {
    public static void main(String[] args) {
        long totalMillis = System.currentTimeMillis();
        
        long totalSeconds = totalMillis / 1000;
        int second = (int)(totalSeconds % 60); 
        int totalMinutes = (int)(totalSeconds / 60);
        int minute = totalMinutes % 60;
        int totalHours = totalMinutes  / 60;
        int hour = totalHours % 24 + 8;
        int totalDays = totalHours / 24;
        int year = totalDays / 365 + 1970;
        
        System.out.println("当前时间为" + hour + ":" + minute + ":" + second + " " + year);
    }
}
