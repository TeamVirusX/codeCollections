import java.util.Scanner;

public class MultiplicationTable {

public static void main (String[] args) {
        //Declaration of the Scanner
        Scanner userInput = new Scanner(System.in);
//User Inputs
        System.out.print("Enter Rows: ");
        int rows = userInput.nextInt();
        System.out.print("Enter Columns: ");
        int columns = userInput.nextInt();
        
//Closing the Scanner to release the unused Memory 
        userInput.close();
        
//Showing the user's input    
        System.out.println(rows + "x" + columns + "Multiplication Table");
        
//Nested loop that is going to print Rows and Columns of the Multiplication Table        
            for(int i = 1;i <= rows;i++){
                    for(int j = 1;j <= columns;j++){
                    System.out.print(i * j + "\t");
                     }
                    System.out.println();
            }
    }
}
