import java.util.Scanner;
public class Tri {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the number of columns");
        int cols = myScanner.nextInt();
        int rows = cols;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("\t");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
        myScanner.close();
    }
}
