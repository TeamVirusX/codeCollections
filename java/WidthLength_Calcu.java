
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class WidthLength_Calcu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        /*  Declaration of Variables and Initialization  */
        Scanner userInput = new Scanner(System.in);
        float Width = 0;
        float Length = 0;
        float TotalArea = 0;
        String birthdate;

        /*  Prompt to User */
        System.out.print("Please enter Width: ");
        Width = userInput.nextFloat();
        System.out.print("Please Enter Length: ");
        Length = userInput.nextFloat();
        
        /*This is where the Equation happens */
        TotalArea = Length * Width;
        
        /*  Print the calculated output from the Equation */
        //Print of Total area
        System.out.println("Total Area: " + TotalArea);
        
        /*Input the Personal Information from the client */
        //Input name
        System.out.print("Name:");
        String name = userInput.next();
        
        //Input age
        System.out.print("Age: ");
        String age = userInput.next();
        
        //Input Birth date
        System.out.print("Birthdate (MM/DD/YY): ");
        birthdate = userInput.nextLine();
        
        userInput.nextLine();
        
        //Input Sex
        System.out.print("Sex (Male/Female): ");
        String sex = userInput.next();     
        
        //Input of address
        System.out.print("Address: ");
        String address = userInput.next(); 
        
        //Input of Lot Number
        System.out.print("Please Enter Lot No: ");
        int LotNo = userInput.nextInt();
        /*  Output all the Clients info wi */
        
        // Print out all User Inputs
        System.out.println("Current Information");
        System.out.println("Name: " +  name);
        System.out.println("Age: " + age);
        System.out.println("Birthdate: " + birthdate);
        System.out.println("Sex: " + sex);
        System.out.println("Address: " + address);
        System.out.println("Lot No: " + LotNo);
        System.out.println("Width: " + Width);
        System.out.println("Length: " + Length);        
        System.out.println("Total Area: " + TotalArea);
        
        
        /* This is the part of the code where it saves the data you got from the user input */
        try {
        String directory = "C:\\Prog_Lang\\TEST_FILES\\data.dat"; /*  <---- that is the File directory where I put my data.dat file ,
        you can make a folder of yours and you can paste the directory here just like what Raven did. */
        BufferedWriter writer = new BufferedWriter(new FileWriter(directory));
        writer.write("Width: " + String.valueOf(Width));
        writer.newLine();
        writer.write("Length: " + String.valueOf(Length));
        writer.newLine();
        writer.write("Total Area: " + String.valueOf(TotalArea));
        writer.newLine();
        writer.write("Name: " + name);
        writer.newLine();
        writer.write("Age: " + age);
        writer.newLine();
        writer.write("Birthdate: " + birthdate);
        writer.newLine();
        writer.write("Sex: " + sex); //everyday?
        writer.newLine();
        writer.write("Address: " + address);
        writer.newLine();
        writer.write("Lot Number: " + String.valueOf(LotNo));
        writer.close();
    } catch(IOException Failed)
    {
        Failed.printStackTrace();
    }     
    }
    //
}
