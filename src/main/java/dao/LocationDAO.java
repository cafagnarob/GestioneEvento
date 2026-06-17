package dao;

import entities.Location;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // SAVE

    public void save(Location newLocation) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newLocation);
        transaction.commit();
        System.out.println("La location " + newLocation + "è stato aggiungo al DB");
    }

    public Location getById(UUID id) {
        Location fromDB = this.entityManager.find(Location.class, id);
        if (fromDB == null) throw new NotFoundException(" Location non trovata");
        System.out.println("LOCATION RICHIESTA" + fromDB);
        return fromDB;

    }

    public void delete(UUID id) {
        Location fromDB = this.getById(id);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.remove(fromDB);
        transaction.commit();
        System.out.println("La Location " + fromDB + "è stato rimosso dal DB");


    }
}
