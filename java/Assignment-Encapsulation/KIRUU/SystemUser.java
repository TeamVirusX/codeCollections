// ONLY CREATED A PASSWORD VARIABLE SINCE THE IDENTIFIER IS THE USERNAME BY DEFAULT
public class SystemUser {
    private String password;
    public SystemUser(String password) {
        this.password = password; // CONSTRUCTOR METHOD IS USED AS A SETTER METHOD
    }
    public String getPassword() {
        return password;
    }
}
