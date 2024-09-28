import java.util.Scanner;
public class simpleCalcuOperations {
   
   public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        System.out.println("\tThis is a Simple Calculator\n");
        System.out.println("==================================================\n");
        
        System.out.println("\tPlease choose operation:\n");
        System.out.println("\tPress 1 for Addition");
        System.out.println("\tPress 2 for Subraction");
        System.out.println("\tPress 3 for Multiplicaton");
        System.out.println("\tPress 4 for Division");
        System.out.println("\tPress 5 for Remainder\n");
        System.out.println("==================================================\n");
      
            System.out.print("\nEnter your choice: ");
            int choice = scanf.nextInt();
      
      //conditional statement/s
            if (choice == 1){
                   System.out.print("\nEnter first integer: ");
                   int firstNumber = scanf.nextInt();
                   System.out.print("Enter second integer: ");
                   int secondNumber = scanf.nextInt();
                   System.out.println("\nThe sum of " + firstNumber + " and " + secondNumber + " is " + (firstNumber + secondNumber));
                }
            else if(choice == 2){
                   System.out.print("\nEnter first integer: ");
                   int firstNumber = scanf.nextInt();
                   System.out.print("Enter second integer: ");
                   int secondNumber = scanf.nextInt();
                   System.out.println("\nThe difference of " + firstNumber + " and " + secondNumber + " is " + (firstNumber - secondNumber));
                }
            else if (choice == 3){
                   System.out.print("\nEnter first integer: ");
                   int firstNumber = scanf.nextInt();
                   System.out.print("Enter second integer: ");
                   int secondNumber = scanf.nextInt();
                   System.out.println("\nThe product of " + firstNumber + " and " + secondNumber + " is " + (firstNumber * secondNumber));
                }
            else if (choice == 4){
                   System.out.print("\nEnter first integer: ");
                   int firstNumber = scanf.nextInt();
                   System.out.print("Enter second integer: ");
                   int secondNumber = scanf.nextInt();
                      if (firstNumber == 0 && secondNumber == 0){
                         System.out.println("\nIndeterminate quotient.");
                      }
                         else if (secondNumber == 0){
                         System.out.println("\nUndefined quotient.");
                      }
                         
                      else{
                         System.out.println("\nThe quotient of " + firstNumber + " and " + secondNumber + " is " + ((double)firstNumber / secondNumber));
                      }
                }
             else if (choice == 5){
                   System.out.print("\nEnter first integer: ");
                   int firstNumber = scanf.nextInt();
                   System.out.print("Enter second integer: ");
                   int secondNumber = scanf.nextInt();
                   System.out.println("\nThe remainder of " + firstNumber + " and " + secondNumber + " is " + (firstNumber % secondNumber));
                }
             else 
                   System.out.println("\nInvalid command! Please only consider 1-5 as an input.");
            }
}
