import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Kiruu {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("[MULTIPLICATION TABLE]\nEnter the columns: ");
        int cols = myScanner.nextInt();
        System.out.println("Enter the rows: ");
        int rows = myScanner.nextInt();
        myScanner.close();
        System.out.printf("[%d x %d TABLE]\n", cols, rows);
        for (int i = 1; i <= cols; i++) {
            for (int j = 1; j <= rows; j++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print(i * j + "\t"); // Relocated the sysout so if the thread has been interrupted the animation will only fail, not the whole printing process.
            }
            System.out.println();
        }
    }
}
