import java.util.Scanner;
import java.util.concurrent.TimeUnit;
 public class OOP_a2 { 
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("MULTIPLICATION TABLE\nEnter a number of Rows =>: ");
        int rows = userInput.nextInt();
        System.out.print("Enter a number of columns =>: ");
        int columns = userInput.nextInt();
        userInput.close();

        System.out.println("[" + columns + " x " + rows + " TABLE]");

        for(int i = 1;i <= rows;i++) {
            for(int j = 1;j <= columns;j++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(500000); 
                } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                }
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
 }
