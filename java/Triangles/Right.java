import java.util.Scanner;
public class Right {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the number of columns");
        int cols = myScanner.nextInt();
        for (int i = 1; i <= cols; i++) {
            for (int j = 1; j <= cols; j++) {
                if (j > (cols - i)) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}