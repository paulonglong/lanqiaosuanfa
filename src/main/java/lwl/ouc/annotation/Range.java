 package lwl.ouc.annotation;

 import java.lang.annotation.ElementType;
 import java.lang.annotation.Retention;
 import java.lang.annotation.RetentionPolicy;
 import java.lang.annotation.Target;

 /**
  * @author wlli
  * @date 2021/06/28
  */
 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.FIELD)
 public @interface Range {
     int min() default 0;

     int max() default 255;
 }
