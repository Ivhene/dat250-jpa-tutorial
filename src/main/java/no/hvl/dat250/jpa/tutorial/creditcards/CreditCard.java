package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private Integer creditLimit;
    private Integer balance;

    @ManyToOne
    @JoinColumn(name = "pincode_id")
    private Pincode pincode;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToMany
    @JoinTable(
            name = "customer_creditcard",
            joinColumns = @JoinColumn(name = "creditcard_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> owners;

    public CreditCard() {}

    public CreditCard(Integer number, Integer creditLimit, Integer balance, Pincode pincode, Bank bank, Set<Customer> owners) {
        this.number = number;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.pincode = pincode;
        this.bank = bank;
        this.owners = owners;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {
        return bank;
    }

    public Collection<Customer> getOwners() {
        return owners;
    }
}
