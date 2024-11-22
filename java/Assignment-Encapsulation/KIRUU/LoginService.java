// THIS IS SIMPLIFIED TO AN EXTENT
import java.util.Scanner;
public class LoginService {
    public boolean login(SystemUser user) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter password:");
            return ((sc.nextLine()).equals(user.getPassword()));
        }
        return false;
    }
}   
