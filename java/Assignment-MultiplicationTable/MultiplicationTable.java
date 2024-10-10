import java.util.Scanner;

public class MultiplicationTable {

public static void main (String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter Rows: ");
        int rows = userInput.nextInt();
        System.out.print("Enter Columns: ");
        int columns = userInput.nextInt();
        
        userInput.close();

        System.out.println(rows + "x" + columns + "Multiplication Table");
        
            for(int i = 1;i <= rows;i++){
                    for(int j = 1;j <= columns;j++){
                    System.out.print(i * j + "\t");
                     }
                    System.out.println();
            }
    }
}