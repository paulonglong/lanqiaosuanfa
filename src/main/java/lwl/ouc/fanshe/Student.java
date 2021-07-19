package lwl.ouc.fanshe;

import java.io.Serializable;

import lwl.ouc.fanshe.SexAnnotation.SEX;

public class Student implements Serializable {

    private static final long serialVersionUID = -4031445132979288101L;

    private String name;
    private int age;

    // ---------------构造方法-------------------
    @SuppressWarnings("unused")
    private Student(char name) {
        this.name = String.valueOf(name);
        System.out.println("姓名：" + name);
    }

    protected Student(String name) {
        System.out.println("私有的构造方法   年龄：" + age);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("姓名：" + name + "|年龄：" + age);// 这的执行效率有问题，以后解决。
    }

    public Student(int age) {
        System.out.println("私有的构造方法   年龄：" + age);
    }

    public Student() {
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    Student(Boolean b) {
        System.out.println("(默认)的构造方法 b = " + b);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    // **************成员方法***************//
    public void show() {
        System.out.println("调用了：公有的，无参数方法show()!!!!!!!");
    }

    public void show1(String s) {
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }

    protected void show2() {
        System.out.println("调用了：受保护的，无参的show2()");
    }

    void show3() {
        System.out.println("调用了：默认的，无参的show3()");
    }

    @Deprecated
    @SexAnnotation(s = SEX.FEMAL)
    private String show4(int age) {
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

}
