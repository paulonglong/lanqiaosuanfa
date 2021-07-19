package lwl.ouc.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class TestFanShe {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args)
        throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
        IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class stuClass = Class.forName("lwl.ouc.fanshe.Student");

        // 2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = stuClass.getConstructors();
        for (Constructor c : conArray) {
            Parameter[] pms = c.getParameters();
            System.out.println(Arrays.toString(pms));
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = stuClass.getDeclaredConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        System.out.println("*****************获取公有、2个入参的构造方法*******************************");
        Constructor con = stuClass.getConstructor(String.class, int.class);
        // 1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        // 2>、返回的是描述这个无参构造函数的类对象。
        System.out.println("con = " + con);
        // 调用构造方法
        Object obj = con.newInstance("QF", 18);
        Student stu = (Student)obj;
        System.out.println("stu = " + stu);

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con = stuClass.getDeclaredConstructor(char.class);
        System.out.println(con);
        // 调用构造方法
        con.setAccessible(true);// 暴力访问(忽略掉访问修饰符)
        Object obj2 = con.newInstance('Q');
        Student stu2 = (Student)obj2;
        System.out.println("stu2 = " + stu2);

        // ---------------------------------------------------------------------------------------------------------------//
        // ---------------------------------------------------------------------------------------------------------------//

        // 2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass.getFields();
        for (Field f : fieldArray) {
            System.out.println(f);
        }
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fieldArray = stuClass.getDeclaredFields();
        for (Field f : fieldArray) {
            System.out.println(f);
        }
        System.out.println("*************获取私有字段**并调用***********************************");
        Object obj3 = stuClass.getConstructor().newInstance();// 产生Student对象--》Student stu = new Student();
        Field f = stuClass.getDeclaredField("name");
        System.out.println(f);
        f.setAccessible(true);// 暴力反射，解除私有限定
        f.set(obj3, "刘德华");// 为Student对象中的name属性赋值--》stu.name = "刘德华"
        Field f2 = stuClass.getDeclaredField("age");
        System.out.println(f2);
        f2.setAccessible(true);// 暴力反射，解除私有限定
        f2.set(obj3, 58);
        Student stu3 = (Student)obj3;
        System.out.println("stu3 = " + stu3);

        // ---------------------------------------------------------------------------------------------------------------//
        // ---------------------------------------------------------------------------------------------------------------//

        // 2.获取所有公有方法
        System.out.println("***************获取所有的”公有“方法*******************");
        // stuClass.getMethods();还会返回其父类的所有public方法
        Method[] methodArray = stuClass.getMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        // stuClass.getDeclaredMethods();只会返回当前类的所有方法，但不返回其父类的所有方法
        methodArray = stuClass.getDeclaredMethods();
        for (Method m : methodArray) {
            System.out.println(m);
            System.out.println(Arrays.toString(m.getDeclaredAnnotations()));
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Object obj4 = stuClass.getConstructor().newInstance();
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        // 实例化一个Student对象
        m.invoke(obj4, "刘德华");

        System.out.println("***************获取私有的show4()方法******************");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);// 解除私有限定
        Object result = m.invoke(obj4, 20);// 需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);

        // ---------------------------------------------------------------------------------------------------------------//
        // ---------------------------------------------------------------------------------------------------------------//

        System.out.println(Arrays.toString(stuClass.getInterfaces()));
        System.out.println(Arrays.toString(stuClass.getDeclaredAnnotations()));
    }
}
