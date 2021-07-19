package lwl.ouc.annotation;

import java.lang.reflect.Field;

/**
 * @author wlli
 * @date 2021/06/28
 */
public class Persion {
    @Range(min = 1, max = 20)
    public String name;

    @Range(max = 10)
    public String city;

    @Range(min = 1, max = 300)
    public int age;

    public static void main(String[] args) throws IllegalArgumentException, ReflectiveOperationException {
        Persion p = new Persion();
        p.name = "1234";
        p.city = "nanjing";
        p.age = 0;
        p.check(p);
    }

    void check(Persion p) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历所有Field:
        for (Field field : p.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(p);
                // 如果值是String:
                if (value instanceof String) {
                    String s = (String)value;
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                } else if (value instanceof Integer) {
                    Integer s = (Integer)value;
                    // 判断值是否满足@Range的min/max:
                    if (s.intValue() < range.min() || s.intValue() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }
}