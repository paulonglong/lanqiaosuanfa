 package lwl.ouc.junit;

 import static org.junit.Assert.assertThrows;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

 /**
  * @author wlli
  * @date 2021/07/19
  */
public class FactorialTest {
    Factorial factorial;

    @Before
    public void setUp() {
        if (null == factorial) {
            factorial = new Factorial();
        }
    }

    @After
    public void tearDown() {
        factorial = null;
    }

    @Test
    public void testF() {
        assertThrows(IllegalArgumentException.class, () -> factorial.fact(21));
    }

    @Test
    @Ignore
    public void testDisable() {
        System.out.println("testDisable");
    }
}
