package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Arrays;
import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Address address = new Address("Inndalsveien", 28);
    em.persist(address);
    Customer customer = new Customer("Max Mustermann", Set.of(address));
    em.persist(customer);
    Bank bank = new Bank("Pengebank");
    em.persist(bank);
    Pincode pincode = new Pincode("123", 1);
    em.persist(pincode);
    CreditCard creditCard = new CreditCard(12345, -10000, -5000, pincode, bank, Set.of(customer));
    em.persist(creditCard);
    CreditCard creditCard1 = new CreditCard(123, 2000, 1, pincode, bank, Set.of(customer));
    em.persist(creditCard1);
  }
}
