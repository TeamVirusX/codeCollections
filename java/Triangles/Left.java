import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Left {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the number of columns");
        int cols = myScanner.nextInt();
        for (int i = 1; i <= cols; i++) {
            for (int j = 1; j <= i; j++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("*\t");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println();
        }
    }
}