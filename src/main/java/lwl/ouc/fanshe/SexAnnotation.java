package lwl.ouc.fanshe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // RetentionPolicy有三个值 Class表示写入JVM但是不能读 RunTime表示写入JVM也能读 SOURCE表示不写如JVM
@Target(ElementType.METHOD) // 用来指定该注解修饰对象 Method表示只能修饰方法 Type类、接口（包括注释类型）或枚举声明 等等 详情见Target
public @interface SexAnnotation {
    public enum SEX {
        MALE, FEMAL, ALL
    };
    SEX s() default SEX.MALE;
}
