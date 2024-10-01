import java.util.Scanner;

public class Angzky_OOP_A1 {
    public static void main(String[] args){

        Scanner intscan = new Scanner (System.in);
        float num1, num2;
        float result = 0;
        int operation;



        // Display menu for operations
        System.out.println("Choose some operation:");
        System.out.println("1. Addition  (+)");
        System.out.println("2. Subtraction  (-)");
        System.out.println("3. Multiplacation  (*)");
        System.out.println("4. Division (/) ");
        System.out.println("5. Mudolo (%)\n" );
        System.out.println("The operator you choose:" );

        operation = intscan.nextInt(); // Read user input for operation
        
        
         // Prompt for first number
         System.out.println("Enter the first number: ");
         num1 = intscan.nextFloat();

         // Promp for second number
         System.out.println("Enter the second number:");
         num2 = intscan.nextFloat();

         // Using if else statements to perform the selected operation

         if (operation == 1) {
            result = num1 + num2; // Addition
            System.out.println("The Sum of two number is: " + result);
        }
        else if (operation == 2) {
            result = num1 - num2; // Subtraction
            System.out.println("The Difference of two number is: " + result);
        }
        else if (operation == 3) {
            result = num1 * num2; // Multiplication
            System.out.println("The Product of two number is: " + result);
        }
        else if (operation == 4) {
            if (num2 != 0) // Check to prevent division by zero
                result = num1 / num2; // Division
                System.out.println( "The Quotient of two number is " + result);  

            } else {
                System.out.println("Error: Division by zero is not allowed.");
            } 
            if (operation == 5) {
                 if (num2 != 0) { // Check to prevent modulo by zero
                    result = num1 % num2; // Modulo
                    System.out.println("The Remainder of two number is: " + result);
                } else {
                    System.out.println("Error: Modulo by zero is not allowed.");
                }
            } 
         intscan.close(); // Close the scanner
    }
}
