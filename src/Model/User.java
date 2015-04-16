package Model;

/**
 * Created by henrik on 16/04/15.
 */
public class User {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String userName;

    public User(String name, String surname, String email, String password, String userName) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.userName = userName;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
