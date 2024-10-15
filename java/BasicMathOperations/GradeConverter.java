// Uses a unique approach in converting grades instead of loooooong if-else statements

import java.util.Scanner;

public class GradeConverter {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter total grade to convert in Grade Point Equivalence: ");
        System.out.println(convertedGrade(myScanner.nextInt()));
    }

    public static double convertedGrade(int basis) {
        int max_grade = 100;
        if (basis < 75) {
            return 5.0;
        } 
        if (basis >= 75 && basis <= 100) {
            for (double grade = 1.00; grade < 3.0; grade += 0.25) {
                max_grade -= 3;
                if (max_grade <= basis) {
                    return grade;
                }
            }
        }
        System.out.println("Invalid grade input!");
        return -1;
    }
}
