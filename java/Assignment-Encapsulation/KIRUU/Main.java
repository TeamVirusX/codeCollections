public class Main {
    public static void main(String[] args) {
        SystemUser raven = new SystemUser("testpassword123");
        LoginService svc = new LoginService(); // CREATED AN INSTANCE OF LOGINSERVICE CLASS SINCE THE MAIN METHOD IS STATIC.
        System.out.println(svc.login(raven));
    }
}
