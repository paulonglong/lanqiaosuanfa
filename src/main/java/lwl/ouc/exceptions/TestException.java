package lwl.ouc.exceptions;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author wlli
 * @date 2021/06/24
 */
public class TestException {
    final Log log = LogFactory.getLog(this.getClass());
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(TestException.class.getName());
        logger.info("Start process...");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            logger.severe(e.getMessage());
            // TODO: 使用logger.severe()打印异常
        }
        logger.info("Process end.");

    }

    /**
     * @return
     */
    private static String test() {
        try {
            String a = "111";
            int b = 1 / 0;
            return a;
        } catch (Exception e) {
            return "exception is " + e.getMessage();
        } finally {
        }
    }
}
