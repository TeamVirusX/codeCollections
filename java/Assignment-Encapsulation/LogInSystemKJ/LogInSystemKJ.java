import java.util.Scanner;

class User {
    private  String username;
    private  String password;
    private static int loggedInUsers = 0;
    private boolean isLoggedIn = false;
    // Constructor to initialize username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public boolean login(String inputUsername, String inputPassword) {
        if (inputUsername.equals(this.username) && inputPassword.equals(this.password)) {
            if (!isLoggedIn) {
                isLoggedIn = true;
                loggedInUsers++;
            }
            return true;
        }
        return false;
    }
    public void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            loggedInUsers--;
        }
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    public static int getLoggedInUsers() {
        return loggedInUsers;
    }
    public String getStatus() {
    if (isLoggedIn) {
        return "active";
    } else {
        return "inactive";
    }
}
}
public class LoginSystemKJ {
    public static void main(String[] args) {
        // Predefined users
        User[] users = {
            new User("Rav", "Faker"),
            new User("Ang", "Zeus"),
            new User("Josh", "Boner")
        };
        Scanner scanner = new Scanner(System.in);
         int MAX_ATTEMPTS = 3;
         int MAX_USERS = 3;
        boolean continueUsingSystem = true;
        System.out.println(" ".repeat(21)+" Student Log in");
        while (continueUsingSystem) {
            int attempts = 0;
            // Login attempts loop
            while (attempts < MAX_ATTEMPTS) {
                if (User.getLoggedInUsers() >= MAX_USERS) {
                    System.out.println("You have reached the maximum limit of 3 logged-in users.");
                    break;
                }
                System.out.print("\nUsername: ");
                String inputUsername = scanner.nextLine();
                if(inputUsername.equalsIgnoreCase("exit"))
                {
                    continueUsingSystem = false;
                    break;
                }
                System.out.print("Password: ");
                String inputPassword = scanner.nextLine();
                if(inputUsername.equalsIgnoreCase("exit"))
                {
                    continueUsingSystem = false;
                    break;
                }
                System.out.println();
                boolean loginSuccessful = false;
                for (User user : users) {
                    if (user != null && user.login(inputUsername, inputPassword)) {
                        System.out.println("Logging-in successfully! Welcome, " + user.getUsername() + "!");
                        loginSuccessful = true;
                        break;
                    }
                }
                if (loginSuccessful) {
                    System.out.println("Current logged-in user: " + User.getLoggedInUsers());
                    displayUserStatus(users);
                    break;
                } else {
                    attempts++;
                    if (attempts < MAX_ATTEMPTS) {
                        System.out.println("Incorrect username or password. Remaining attempts: " + (MAX_ATTEMPTS - attempts));
                        System.out.println("_____________________");
                    } else {
                        System.out.println("Exiting system.");
                        continueUsingSystem = false;
                    }
                }
            }
            if (attempts < MAX_ATTEMPTS) {
                System.out.println("\nOption:");
                System.out.println("Enter 'LogOut' to log out.");
                System.out.println("Enter 'LogIn' to add another account.");
                System.out.println("Type 'EXIT' to exit.");
                System.out.print("Enter: ");
                String option = scanner.nextLine();
                switch (option) {
                    case "LogOut":
                        System.out.println("\nSelect the account to log out:");
                        for (int i = 0; i < users.length; i++) {
                            if (users[i].isLoggedIn()) {
                                System.out.println((i + 1) + ". " + users[i].getUsername());
                            }
                        }
                        System.out.print("Enter the number of the account to log out: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); 
                        if (choice > 0 && choice <= users.length && users[choice - 1].isLoggedIn()) {
                            users[choice - 1].logout();
                            System.out.println("You have logged out of " + users[choice - 1].getUsername());
                        } else {
                            System.out.println("Invalid choice.");
                        }
                        System.out.println("Current logged-in users: " + User.getLoggedInUsers());
                        displayUserStatus(users);
                        break;
                    case "LogIn":
                        if (User.getLoggedInUsers() >= MAX_USERS) {
                            System.out.println("You have reached the maximum limit of 3 logged-in users. Please log out a user to log in another.");
                        } else {
                           System.out.println("\n_______________________"); 
                            System.out.println("\nProceed to login another account.");
                        }
                        break;
                    case "Exit":
                        continueUsingSystem = false;
                        break;
                    case "exit":
                        continueUsingSystem = false;
                        break;
                    case "EXIT":
                        continueUsingSystem = false;
                        break;
                    default:
                        System.out.println("Invalid option. Exiting.");
                        continueUsingSystem = false;
                        break;
                }
            }
        }
        System.out.println("System exited.");
    }
    private static void displayUserStatus(User[] users) {
        System.out.println("\nCurrent Update:");
        System.out.println("   User"+" ".repeat(9)+"Status:");
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                System.out.println((i + 1) + ". " + users[i].getUsername() + "  ".repeat(4)+ users[i].getStatus());
            }
        }
        System.out.println("\n_______________________");
    }
}
