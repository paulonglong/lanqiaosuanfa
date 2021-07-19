package lwl.ouc.zip;
import lombok.Data;

@Data
public class TtcOrderAttachment {
    private Integer id;
    private Integer orderId;
    private String attachName;
    private String attachSize;
    private String attachUrl;
    private Integer userId;
}

