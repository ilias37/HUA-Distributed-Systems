package gr.hua.dit.tax.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "pub_contracts")
public class PublishedContracts{
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address", unique = true)
    @NotBlank(message = "Please enter the property's address")
    @Size(max = 30, message = "Addres should not be greater than 30 characters")
    private String address;

    @Column(name = "tax")
    @NotNull(message = "Please enter the tax")
    @Digits(integer = 9, fraction = 2, message = "Tax should not be greater than 9 digits")
    private int tax;

    @Column(name = "buyerid")
    @NotNull(message = "Please enter the buyer's id")
    @Digits(integer = 9, fraction = 0, message = "Id should not be greater than 9 digits")
    private int buyerId;

    
    @Column(name = "sellerid")
    @NotNull(message = "Please enter the buyer's id")
    @Digits(integer = 9, fraction = 0, message = "Id should not be greater than 9 digits")
    private int sellerId;

    @Column(name = "notaryid")
    @NotNull(message = "Please enter the buyer's id")
    @Digits(integer = 9, fraction = 0, message = "Id should not be greater than 9 digits")
    private int notaryId;

    public PublishedContracts() {

    }

    public PublishedContracts(String address, int tax, int buyerId, int sellerId, int notaryId) {
        this.address = address;
        this.tax = tax;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.notaryId = notaryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

     public int getNotaryId() {
        return notaryId;
    }

    public void setNotaryId(int notaryId) {
        this.notaryId = notaryId;
    }

    @Override
    public String toString() {
        return "Contract:\n" +
               "Address" + address + "\n" +
               "Tax: " + tax + "\n " +
               "BuyerId" + buyerId + "\n" +
               "SellerId: " + sellerId + "\n" +
               "NotaryId: " + notaryId;
    }

}