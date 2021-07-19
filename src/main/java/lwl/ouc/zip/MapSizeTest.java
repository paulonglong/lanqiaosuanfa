 package lwl.ouc.zip;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author wlli
 * @date 2021/07/06
 */
public class MapSizeTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(2);
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        for (Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
}
