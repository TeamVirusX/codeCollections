import java.util.Random;
import javax.swing.JOptionPane;
public class CARCARCAR {
    Random rand = new Random();
    public int addSpaceThread() {
        return rand.nextInt(2);
    }
    public static void broombroom() throws InterruptedException {
        CARCARCAR x = new CARCARCAR();
        String[] asciiArt = {
            "                  .",
            "    __             |\\",
            " __/__\\___________| \\_",
            "|   ___    |  ,|   ___`-.",
            "|  /   \\   |___/  /   \\  `-.",
            "|_| (O) |________| (O) |____|",
            "   \\___/          \\___/"
        };
        int initialSpacesCar1 = 0;
        int initialSpacesCar2 = 0;
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            for (int i = 0; i < asciiArt.length; i++) {
                System.out.printf("%" + (initialSpacesCar1 + asciiArt[i].length()) + "s%n", asciiArt[i]);
            }
            for (int i = 0; i < asciiArt.length; i++) {
                System.out.printf("%" + (initialSpacesCar2 + asciiArt[i].length()) + "s%n", asciiArt[i]);
            }
            initialSpacesCar1 += x.addSpaceThread();
            initialSpacesCar2 += x.addSpaceThread();
            Thread.sleep(50);
            if (initialSpacesCar1 >= 150) {
                if (initialSpacesCar1 < initialSpacesCar2) {
                    JOptionPane.showMessageDialog(null, "DRIVAAR 2 WINS SAAR");
                } else {
                    JOptionPane.showMessageDialog(null, "DRIVAAR 1 WINS SAAR");
                }
                break;
            }
        }
    }
    public static void main(String[] args) {
        try {
            System.out.println("WE GOING TO RIDE SAAR:");
            broombroom(); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("SAAR WE ARE OUT OF GAS.");
        }
    }
}
