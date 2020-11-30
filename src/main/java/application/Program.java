package application;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

    public static void main(String[] args) {
        Person p1 = new Person(null, "Luiz", "luiz@email.com");
        Person p2 = new Person(null, "Ana", "ana@email.com");
        Person p3 = new Person(null, "Joaquim", "joaquim@email.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa-hibernate");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();

        Person p = em.find(Person.class, 2);

        System.out.println(p);

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
