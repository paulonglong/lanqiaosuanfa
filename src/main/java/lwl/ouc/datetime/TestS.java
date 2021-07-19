package lwl.ouc.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wlli
 * @date 2021/07/15
 */
public class TestS {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("YYYY年MM月dd日").format(new Date()));
    }
}
