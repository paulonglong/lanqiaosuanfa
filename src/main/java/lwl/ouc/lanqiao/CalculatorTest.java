 package lwl.ouc.lanqiao;

 import java.util.Scanner;

 /**
  * @author wlli
  * @date 2021/05/12
  */
public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        String operator = scanner.next();
        double b = scanner.nextDouble();

        double result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                result = Double.NaN;
                break;
        }

        System.out.printf("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
