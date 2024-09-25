// @iAmK1ruu
import java.util.Scanner;
public class TheKiruuWay {
    public static void main (String[] args){
        Scanner myScanner = new Scanner(System.in);
        // ARRAYYY
        String[] operationResult= {"sum", "difference", "product", "quotient", "remainder"};
        // Considering that we are making a CLI-based program.
        System.out.println("Choose the operation\n1. Addition\n2. Subtraction\n3. Multiplication \n4. Division \n5. Modulo");
        int operation = myScanner.nextInt();
        if ((operation > 5 || operation < 1)) {
            System.out.println("Invalid operation!");
            main(args);
        } else {
        // Getting the input for 2 operands
        System.out.print("Enter the first operand: ");
        float x = myScanner.nextFloat();
        System.out.print("Enter the second operand: ");
        float y = myScanner.nextFloat();
        // Calculate the result by invoking the calculate function
        float total = calculate(x, y, operation);
        myScanner.close();
        System.out.println("The " + operationResult[operation - 1] + " of " + x + " and " + y + " is " + total);
        }
    
    public static float calculate(float firstOperand, float secondOperand, int operation) {
        return switch (operation) {
            case 1 -> firstOperand + secondOperand;
            case 2 -> firstOperand - secondOperand;
            case 3 -> firstOperand * secondOperand;
            case 4 -> firstOperand / secondOperand;
            case 5 -> firstOperand % secondOperand;
            default -> -1;
        };
    }
}
