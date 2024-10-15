import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the number of columns");
        int cols = myScanner.nextInt();
        int rows = cols;

        // Upper triangle
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("\t");
            }
            for (int k = 1; k <= i; k++) {  // Print i asterisks
                System.out.print("*\t");
            }
            System.out.println();
        }

        // Lower triangle (one less than the number of rows)
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("\t");
            }
            for (int k = 1; k <= i; k++) {  // Print i asterisks
                System.out.print("*\t");
            }
            System.out.println();
        }

        myScanner.close();
    }
}
