package gr.hua.dit.tax.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "authorities")
public class Authorities{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // @Column(name = "username")
    // private String username;

    @Column(name = "authority")
    @NotBlank
    private String authority;

    //Susxethsh me ton pinaka users
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Authorities() {

    }

    public Authorities(String authority) {
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}