package dao;

import entities.Partecipazione;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // SAVE

    public void save(Partecipazione newPartecipazione) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newPartecipazione);
        transaction.commit();
        System.out.println("La Partecipazione " + newPartecipazione + "è stato aggiungo al DB");
    }

    public Partecipazione getById(UUID id) {
        Partecipazione fromDB = this.entityManager.find(Partecipazione.class, id);
        if (fromDB == null) throw new NotFoundException(" Partecipazione non trovata");
        System.out.println("PARTECIPAZIONE RICHIESTA" + fromDB);
        return fromDB;

    }

    public void delete(UUID id) {
        Partecipazione fromDB = this.getById(id);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.remove(fromDB);
        transaction.commit();
        System.out.println("La Partecipazione " + fromDB + "è stato rimosso dal DB");


    }
}
