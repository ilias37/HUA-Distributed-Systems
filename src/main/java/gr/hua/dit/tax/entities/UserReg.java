package gr.hua.dit.tax.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "userreg")
public class UserReg {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username", unique = true)
    @NotBlank(message = "Please enter your username")
    private String username;

    @Column(name = "firstName")
    @NotBlank(message = "Please enter your first name")
    @Size(max = 30, message = "Name should not be greater than 30 characters")
    private String firstName;   

    @Column(name = "lastName")
    @NotBlank(message = "Please enter your last name")
    @Size(max = 30, message = "Name should not be greater than 30 characters")
    private String lastName;

    @Column(name = "email", unique = true)
    @NotBlank(message = "Please enter an email")
    @Email(message = "Please enter a valid email")
    @Size(max = 50, message = "Email should not be greater than 50 characters")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Please enter your password")
    @Size(max = 100, message = "Password should not be greater than 100 characters")
    private String password;

    public UserReg() {
 
    }

    public UserReg(String username, String firstName, String lastName, String email, String password) {     
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        // this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

}