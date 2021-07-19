package lwl.ouc.fanshe;

import java.lang.reflect.Method;

public class AnnocationTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
        Class<?> clazz = Class.forName("lwl.ouc.fanshe.Student");
        Method method = clazz.getDeclaredMethod("show4", int.class);
        if (method.isAnnotationPresent(SexAnnotation.class)) {
            SexAnnotation sexAnnotation = method.getAnnotation(SexAnnotation.class);
            System.out.println(sexAnnotation.s());
        }
    }
}
