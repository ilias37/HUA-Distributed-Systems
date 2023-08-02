package gr.hua.dit.tax.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "actors")
public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "username", unique = true)
    @NotBlank(message = "Please enter your username")
    private String username;

    @Column(name = "firstName")
    @NotBlank(message = "Please enter the first name")
    @Size(max = 30, message = "Name should not be greater than 30 characters")
    private String firstName;

    @Column(name = "lastName")
    @NotBlank(message = "Please enter the last name")
    @Size(max = 30, message = "Name should not be greater than 30 characters")
    private String lastName;

    @Column(name = "email", unique = true)
    @NotBlank(message = "Please enter an email")
    @Email(message = "Please enter a valid email")
    @Size(max = 50, message = "Email should not be greater than 50 characters")
    private String email;

    // //Susxethsh me ton pinaka users
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "userid")
    // private Users user;

    // public Users getUser() {
    //     return user;
    // }

    // public void setUser(Users user) {
    //     this.user = user;
    // }

    public Actor() {
 
    }

    public Actor(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    @Override
    public String toString() {
        return "Actor:\n" +
               "Userame: " + username + "\n" +
               "FirstName: " + firstName + "\n" +
               "LastName: " + lastName + "\n" +
               "Email: " + email;
    }
    
}