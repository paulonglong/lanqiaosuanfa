package lwl.ouc.fanshe;

public class ClassloaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader.getClass());
        System.out.println(classLoader.getParent().getClass());
        
        SelfClassLoader selfClassLoader = new SelfClassLoader();
        System.out.println(selfClassLoader.getParent().getClass());
    }
}

class SelfClassLoader extends ClassLoader{

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return this.findClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
    
}