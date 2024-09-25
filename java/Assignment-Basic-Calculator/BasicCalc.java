// @iAmK1ruu (Change the variable names and prompts tytyy)
import java.util.Scanner;
public class BasicCalc {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int operation = 0;
        float a = 0, b = 0, output = 0;
        System.out.println("Choose the operation\n1. Addition\n2. Subtraction\n3. Multiplication \n4. Division \n5. Modulo");
        operation = myScanner.nextInt();
        System.out.println("Enter the first operand: ");
        a = myScanner.nextFloat();
        System.out.println("Enter the second operand: ");
        b = myScanner.nextFloat();
        
        if (operation < 1 || operation > 5) {
            System.out.println("Invalid operator!\nChoose between only 1-5");
        }
        
        if(operation == 1) {
            output = a + b;
            System.out.println("The sum of " + a + " and " + b + " is " + output);
        }
        if(operation == 2) {
            output = a - b;
            System.out.println("The difference of " + a + " and " + b + " is " + output);
        }
        if(operation == 3) {
            output = a * b;
             System.out.println("The product of " + a + " and " + b + " is " + output);
        }
        if(operation == 4) {
            output = a / b;
             System.out.println("The quotient of " + a + " and " + b + " is " + output);
        }
        if(operation == 5) {
            output = a % b;
             System.out.println("The remainder of " + a + " and " + b + " is " + output);
        }
        
        
    }
}
