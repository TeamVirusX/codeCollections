
import java.util.Scanner;

public class basicCliCalculator {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        double firstOperand, secondOperand, totalValue;
        int operation;
        System.out.println("Choose the desired operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulo");
        operation = myScanner.nextInt();
        System.out.println("Enter the first integer: ");
        firstOperand = myScanner.nextDouble();
        System.out.println("Enter the second integer: ");
        secondOperand = myScanner.nextDouble();
        if (operation == 1) {
            totalValue = firstOperand + secondOperand;
            System.out.println("The sum of " + firstOperand + " and " + secondOperand + " is " + totalValue);
        } else if (operation == 2) {
            totalValue = firstOperand - secondOperand;
            System.out.println("The difference of " + firstOperand + " and " + secondOperand + " is " + totalValue);
        } else if (operation == 3) {
            totalValue = firstOperand * secondOperand;
            System.out.println("The product of " + firstOperand + " and " + secondOperand + " is " + totalValue);
        } else if (operation == 4) {
            if (firstOperand > 0 && secondOperand == 0)
              System.out.println("Undefined quotient!");
            else if (firstOperand == 0 && secondOperand == 0)
              System.out.println("Indefinite quotient!");
            else {
              totalValue = firstOperand / secondOperand;
            System.out.println("The quotient of " + firstOperand + " and " + secondOperand + " is " + totalValue);
            }
        } else if (operation == 5) {
            if (firstOperand > 0 && secondOperand == 0) {
              System.out.println("Undefined remainder!");
            } else {
              totalValue = firstOperand % secondOperand;
          System.out.println("The remainder of " + firstOperand + " and " + secondOperand + " is " + totalValue);
            }
        } else {
          System.out.println("Invalid operation!\nPlease choose only from 1-5.");
        }
    }
}
