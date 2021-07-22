package lwl.ouc.concurrent.future.threadlocal;

/**
 * 用户信息上下文
 * 
 * @author wlli
 * @date 2021/07/22
 */
public class UserContext implements AutoCloseable {
    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user) {
        ctx.set(user);
    }

    public static String currentUser() {
        return ctx.get();
    }

    @Override
    public void close() {
        ctx.remove();
    }

    public static void main(String[] args) {
        try (UserContext ctx = new UserContext("Bob")) {
            System.out.println("123");
            doFinal();
        }
    }

    private static void doFinal() {
        String currentUser = UserContext.currentUser();
        System.out.println(currentUser);
    }
}
