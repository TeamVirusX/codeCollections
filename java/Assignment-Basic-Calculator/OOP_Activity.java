import java.util.Scanner;

// (Name) + (Course & Section);

public class OOP_Activity {
 public static void main (String[] args) {
    int operator;
    int x = 0, y = 0, z = 0;
    String result = "";
    String op = "";
    
    Scanner userInput = new Scanner(System.in);
    System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Modulo.");
    System.out.print("Operator: ");
    operator = userInput.nextInt();

    if((operator < 1) || (operator > 5)){
        System.out.println("Invalid Operator! Please try again between 1-5.");
      }    
    else
    System.out.print("Enter First Integer: ");
    x = userInput.nextInt();
    System.out.print("Enter Second Integer: ");
    y = userInput.nextInt();

    if(operator == 1){
        z = x + y;
        result = "Sum:";
        op = "+";
    }
    if(operator == 2){
        z = x - y;
        result = "Difference:";
        op = "-";
    }
    if(operator == 3){
        z = x * y;
        result = "Product:";
        op = "x";
    }
    if(operator == 4){
        z = x / y;
        result = "Quotient:";
        op = "/";
    }
    if(operator == 5){
        z = x % y;
        result = "Remainder";
        op = "%";
    }
    userInput.close();
    System.out.println(result + " " + x + op + y + " = " + z);
 }

}
