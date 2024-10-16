// Using binet's formula instead of recursion and array-type implementation
import java.lang.Math;
import java.util.Scanner;
public class Fibonaccify {
    public double Fibonacci(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5);
    }
    public static void main(String[] args) {
        Fibonaccify fib = new Fibonaccify();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Fibonaccify Me!\nEnter a number to get the Fibonacci sequence of up to nth term:");
        int n = myScanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            System.out.println((int)fib.Fibonacci(i));
        }
    }
}
