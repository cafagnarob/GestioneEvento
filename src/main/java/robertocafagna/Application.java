package robertocafagna;

import Enum.Sesso;
import Enum.Stato;
import Enum.TipoEvento;
import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import entities.Persona;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneEventopu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);

        //LOCATION
        Location loc1 = new Location("Forum Assago", "Milano");
        Location loc2 = new Location("Palalottomatica", "Roma");
        Location loc3 = new Location("Teatro Massimo", "Palermo");
        Location loc4 = new Location("Arena di Verona", "Verona");


       /* locationDAO.save(loc1);
        locationDAO.save(loc2);
        locationDAO.save(loc3);
        locationDAO.save(loc4);*/

//PERSON
        Persona p1 = new Persona(
                "Mario",
                "Rossi",
                LocalDate.of(1990, 5, 12),
                Sesso.M);

        Persona p2 = new Persona(
                "Giulia",
                "Bianchi",
                LocalDate.of(1995, 8, 20),
                Sesso.F);

        Persona p3 = new Persona(
                "Luca",
                "Verdi",
                LocalDate.of(1988, 2, 15),
                Sesso.M);

        Persona p4 = new Persona(
                "Sara",
                "Neri",
                LocalDate.of(2000, 11, 5),
                Sesso.F);

        Persona p5 = new Persona(
                "Andrea",
                "Ferrari",
                LocalDate.of(1993, 7, 30),
                Sesso.M);


        /*personaDAO.save(p1);
        personaDAO.save(p2);
        personaDAO.save(p3);
        personaDAO.save(p4);
        personaDAO.save(p5);*/

// EVENTO
        Evento e1 = new Evento(
                "Concerto Rock",
                LocalDate.of(2026, 7, 10),
                "Grande concerto rock",
                TipoEvento.PUBBLICO,
                5000,
                loc1);

        Evento e2 = new Evento(
                "Fiera del Libro",
                LocalDate.of(2026, 5, 20),
                "Evento culturale",
                TipoEvento.PUBBLICO,
                1000,
                loc2);

        Evento e3 = new Evento(
                "Meeting Aziendale",
                LocalDate.of(2026, 3, 15),
                "Riunione annuale",
                TipoEvento.PRIVATO,
                200,
                loc2);

        Evento e4 = new Evento(
                "Spettacolo Teatrale",
                LocalDate.of(2026, 9, 12),
                "Commedia brillante",
                TipoEvento.PUBBLICO,
                800,
                loc3);

        Evento e5 = new Evento(
                "Festival Jazz",
                LocalDate.of(2026, 6, 18),
                "Musica jazz dal vivo",
                TipoEvento.PUBBLICO,
                1500,
                loc4);

        Evento e6 = new Evento(
                "Workshop Java",
                LocalDate.of(2026, 4, 8),
                "Corso avanzato Java",
                TipoEvento.PRIVATO,
                50,
                loc1);

        Evento e7 = new Evento(
                "Mostra d'Arte",
                LocalDate.of(2026, 8, 22),
                "Esposizione artistica",
                TipoEvento.PUBBLICO,
                400,
                loc3);

        Evento e8 = new Evento(
                "Hackathon",
                LocalDate.of(2026, 10, 3),
                "Competizione di programmazione",
                TipoEvento.PRIVATO,
                120,
                loc1);

        Evento e9 = new Evento(
                "Concerto Classico",
                LocalDate.of(2026, 11, 11),
                "Orchestra sinfonica",
                TipoEvento.PUBBLICO,
                2000,
                loc4);

        Evento e10 = new Evento(
                "Conferenza AI",
                LocalDate.of(2026, 12, 1),
                "Intelligenza artificiale e futuro",
                TipoEvento.PUBBLICO,
                600,
                loc2);


        /*eventoDAO.save(e1);
        eventoDAO.save(e2);
        eventoDAO.save(e3);
        eventoDAO.save(e4);
        eventoDAO.save(e5);
        eventoDAO.save(e6);
        eventoDAO.save(e7);
        eventoDAO.save(e8);
        eventoDAO.save(e9);
        eventoDAO.save(e10);*/

//PARTECIPAZIONE
        Partecipazione part1 =
                new Partecipazione(p1, e1, Stato.CONFERMATA);

        Partecipazione part2 =
                new Partecipazione(p2, e1, Stato.DA_CONFERMARE);

        Partecipazione part3 =
                new Partecipazione(p3, e4, Stato.CONFERMATA);

        Partecipazione part4 =
                new Partecipazione(p4, e5, Stato.DA_CONFERMARE);

        Partecipazione part5 =
                new Partecipazione(p5, e10, Stato.CONFERMATA);

        Partecipazione part6 =
                new Partecipazione(p1, e8, Stato.DA_CONFERMARE);


        /*partecipazioneDAO.save(part1);
        partecipazioneDAO.save(part2);
        partecipazioneDAO.save(part3);
        partecipazioneDAO.save(part4);
        partecipazioneDAO.save(part5);
        partecipazioneDAO.save(part6);*/

        UUID id_partecipazione = UUID.fromString("5675f4e5-014e-472f-8f61-f4c0e5e4c48d");
        UUID id_evento = UUID.fromString("2749589b-eb43-484f-a1f7-2bb7271127be");
        UUID id_persona = UUID.fromString("2d8fca77-8eb6-4fad-85b5-97c2edf67492");
        UUID id_location = UUID.fromString("0b0601b7-ef97-4b70-a720-1786a924f5f3");

        //GetById
        try {
            partecipazioneDAO.getById(id_partecipazione);
        } catch (NotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }

        try {
            eventoDAO.getById(id_evento);
        } catch (NotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }

        try {
            personaDAO.getById(id_persona);
        } catch (NotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }

        try {
            locationDAO.getById(id_location);
        } catch (NotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }


        // remove
        try {
            partecipazioneDAO.delete(id_partecipazione);
        } catch (NotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }

        try {
            eventoDAO.delete(id_evento);
        } catch (NotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }

        try {
            personaDAO.delete(id_persona);
        } catch (NotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }

        try {
            locationDAO.delete(id_location);
        } catch (NotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }
    }
}
