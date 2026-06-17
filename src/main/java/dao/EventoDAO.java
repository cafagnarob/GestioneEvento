package dao;


import entities.Evento;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // SAVE

    public void save(Evento newEvento) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newEvento);
        transaction.commit();
        System.out.println("L' evento " + newEvento + "è stato aggiungo al DB");
    }

    public Evento getById(UUID id) {
        Evento fromDB = this.entityManager.find(Evento.class, id);
        if (fromDB == null) throw new NotFoundException(" evento non trovato");
        System.out.println("EVENTO RICHIESTO" + fromDB);
        return fromDB;

    }

    public void delete(UUID id) {
        Evento fromDB = this.getById(id);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.remove(fromDB);
        transaction.commit();
        System.out.println("L' evento " + fromDB + "è stato rimosso dal DB");


    }


}
