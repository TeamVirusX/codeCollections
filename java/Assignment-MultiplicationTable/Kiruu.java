/*
 * Ocampo, Raven Neil L. | II BSCS - A
 * This program creates a multiplication table using nested loops.
 */
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("[MULTIPLICATION TABLE]\nEnter the columns: ");
        int cols = myScanner.nextInt();
        System.out.println("Enter the rows: ");
        int rows = myScanner.nextInt();
        myScanner.close();
        System.out.print("\t");
        for (int i = 1; i <= cols; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < cols; i++) {
            System.out.print("--------"); 
        }
        System.out.println(); 
        for (int j = 1; j <= rows; j++) {
            System.out.print(j + " |"); 
            for (int i = 1; i <= cols; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print("\t" + (i * j));
            }
            System.out.println();
        }
    }
}
