package dao;

import entities.Persona;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // SAVE

    public void save(Persona newPersona) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newPersona);
        transaction.commit();
        System.out.println("La Persona " + newPersona + "è stato aggiungo al DB");
    }

    public Persona getById(UUID id) {
        Persona fromDB = this.entityManager.find(Persona.class, id);
        if (fromDB == null) throw new NotFoundException("Persona non trovata");
        System.out.println("PERSONA RICHIESTA" + fromDB);
        return fromDB;

    }

    public void delete(UUID id) {
        Persona fromDB = this.getById(id);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.remove(fromDB);
        transaction.commit();
        System.out.println("La Persona " + fromDB + "è stato rimosso dal DB");
    }
}
