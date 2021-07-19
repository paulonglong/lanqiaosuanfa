 package lwl.ouc.junit;

 import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 /**
  * @author wlli
  * @date 2021/07/19
  */
public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("before");
        this.calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("after");
        this.calculator = null;
    }

    @Test
    public void testAdd() {
        assertEquals(100, this.calculator.add(100));
        assertEquals(150, this.calculator.add(50));
        assertEquals(130, this.calculator.add(-20));
    }

    @Test
    public void testSub() {
        assertEquals(-100, this.calculator.sub(100));
        assertEquals(-150, this.calculator.sub(50));
        assertEquals(-130, this.calculator.sub(-20));
    }
}
