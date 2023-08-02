package gr.hua.dit.tax.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username", unique = true)
    @NotBlank
    private String username;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "enabled")
    @NotNull
    private boolean enabled;

    //Susxethsh me ton pinaka authorities, eina eikonikh mono ston kosmo ths java
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Authorities authority;

    public Authorities getAuthority() {
        return authority;
    }

    public void setAuthority(Authorities authority) {
        this.authority = authority;
    }

    // //Susxethsh me ton pinaka actors, eina eikonikh mono ston kosmo ths java
    // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    // private Actor actor;

    // public Actor getActor() {
    //     return actor;
    // }

    // public void setActor(Actor actor) {
    //     this.actor = actor;
    // }

    public Users() {

    }

    public Users(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

     public Users(int id, String username, String password, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
}