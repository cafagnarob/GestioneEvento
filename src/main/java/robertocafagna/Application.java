package robertocafagna;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneEventopu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("hello");
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
       /* Persona p1 = new Persona(
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
*/

       /* personaDAO.save(p1);
        personaDAO.save(p2);
        personaDAO.save(p3);
        personaDAO.save(p4);
        personaDAO.save(p5);*/

// EVENTO
       /* UUID id_loc1 = UUID.fromString("128dc2ef-807b-4d9b-8073-d0a054dc2f7b");
        Location loc1FromDB = locationDAO.getById(id_loc1);
        UUID id_loc2 = UUID.fromString("6e2838b9-c708-4c3b-9f57-07d2921d4aa0");
        Location loc2FromDB = locationDAO.getById(id_loc2);
        UUID id_loc3 = UUID.fromString("7f8aacf0-ff99-440b-962b-0ae2fde8e916");
        Location loc3FromDB = locationDAO.getById(id_loc3);
        UUID id_loc4 = UUID.fromString("d5ed2ce6-a0e0-4070-9133-0a17834dee39");
        Location loc4FromDB = locationDAO.getById(id_loc4);*/

        /*Evento e1 = new Evento(
                "Concerto Rock",
                LocalDate.of(2026, 7, 10),
                "Grande concerto rock",
                TipoEvento.PUBBLICO,
                5000,
                loc1FromDB);

        Evento e2 = new Evento(
                "Fiera del Libro",
                LocalDate.of(2026, 5, 20),
                "Evento culturale",
                TipoEvento.PUBBLICO,
                1000,
                loc2FromDB);

        Evento e3 = new Evento(
                "Meeting Aziendale",
                LocalDate.of(2026, 3, 15),
                "Riunione annuale",
                TipoEvento.PRIVATO,
                200,
                loc2FromDB);

        Evento e4 = new Evento(
                "Spettacolo Teatrale",
                LocalDate.of(2026, 9, 12),
                "Commedia brillante",
                TipoEvento.PUBBLICO,
                800,
                loc3FromDB);

        Evento e5 = new Evento(
                "Festival Jazz",
                LocalDate.of(2026, 6, 18),
                "Musica jazz dal vivo",
                TipoEvento.PUBBLICO,
                1500,
                loc4FromDB);

        Evento e6 = new Evento(
                "Workshop Java",
                LocalDate.of(2026, 4, 8),
                "Corso avanzato Java",
                TipoEvento.PRIVATO,
                50,
                loc1FromDB);

        Evento e7 = new Evento(
                "Mostra d'Arte",
                LocalDate.of(2026, 8, 22),
                "Esposizione artistica",
                TipoEvento.PUBBLICO,
                400,
                loc3FromDB);

        Evento e8 = new Evento(
                "Hackathon",
                LocalDate.of(2026, 10, 3),
                "Competizione di programmazione",
                TipoEvento.PRIVATO,
                120,
                loc1FromDB);

        Evento e9 = new Evento(
                "Concerto Classico",
                LocalDate.of(2026, 11, 11),
                "Orchestra sinfonica",
                TipoEvento.PUBBLICO,
                2000,
                loc4FromDB);

        Evento e10 = new Evento(
                "Conferenza AI",
                LocalDate.of(2026, 12, 1),
                "Intelligenza artificiale e futuro",
                TipoEvento.PUBBLICO,
                600,
                loc2FromDB);

        eventoDAO.save(e1);
        eventoDAO.save(e2);
        eventoDAO.save(e3);
        eventoDAO.save(e4);
        eventoDAO.save(e5);
        eventoDAO.save(e6);
        eventoDAO.save(e7);
        eventoDAO.save(e8);
        eventoDAO.save(e9);
        eventoDAO.save(e10);*/

      /*  UUID id_p1FromDB = UUID.fromString("3c57822e-a169-43ab-b4f5-864303fb2c2c");
        Persona p1FromDB = personaDAO.getById(id_p1FromDB);

        UUID id_p2FromDB = UUID.fromString("86e8c966-72f6-46b4-a578-608605217df8");
        Persona p2FromDB = personaDAO.getById(id_p2FromDB);
        UUID id_p3FromDB = UUID.fromString("9fd9f228-00a4-4b88-bc62-46d930d63fb2");
        Persona p3FromDB = personaDAO.getById(id_p3FromDB);
        UUID id_p4FromDB = UUID.fromString("f2d462ce-daba-49c9-b780-71cdbb51521e");
        Persona p4FromDB = personaDAO.getById(id_p4FromDB);
        UUID id_p5FromDB = UUID.fromString("fa7593b7-97b2-43c9-88e1-8c7939c5c029");
        Persona p5FromDB = personaDAO.getById(id_p5FromDB);

        UUID id_e1FromDB = UUID.fromString("23ca6a5f-f45d-41fa-87d5-4af7ff9af687");
        Evento e1FromDB = eventoDAO.getById(id_e1FromDB);
        UUID id_e2FromDB = UUID.fromString("55821df5-c9fd-4805-9776-e4fe351207fc");
        Evento e2FromDB = eventoDAO.getById(id_e2FromDB);
        UUID id_e3FromDB = UUID.fromString("5b60c407-6157-4af9-aebf-35631f6c8fca");
        Evento e3FromDB = eventoDAO.getById(id_e3FromDB);
        UUID id_e4FromDB = UUID.fromString("79b84602-bc83-48ba-87fd-bbf3d01205ef");
        Evento e4FromDB = eventoDAO.getById(id_e4FromDB);
        UUID id_e5FromDB = UUID.fromString("89895f47-6404-4464-b32a-f13a7c250359");
        Evento e5FromDB = eventoDAO.getById(id_e5FromDB);
        UUID id_e6FromDB = UUID.fromString("9fe85ed0-e5e0-4255-afb2-e66e08a473de");
        Evento e6FromDB = eventoDAO.getById(id_e6FromDB);
        UUID id_e7FromDB = UUID.fromString("d4f2edf7-c44d-4123-924c-3d289cd1be87");
        Evento e7FromDB = eventoDAO.getById(id_e7FromDB);
        UUID id_e8FromDB = UUID.fromString("ea15bedc-7501-4707-80e2-aef1da4cd5e5");
        Evento e8FromDB = eventoDAO.getById(id_e8FromDB);
        UUID id_e9FromDB = UUID.fromString("ef7f8ed9-77b6-4ef7-a89a-2ffb88317d86");
        Evento e9FromDB = eventoDAO.getById(id_e9FromDB);


//PARTECIPAZIONE
        Partecipazione part1 =
                new Partecipazione(p1FromDB, e1FromDB, Stato.CONFERMATA);

        Partecipazione part2 =
                new Partecipazione(p2FromDB, e2FromDB, Stato.DA_CONFERMARE);

        Partecipazione part3 =
                new Partecipazione(p3FromDB, e3FromDB, Stato.CONFERMATA);

        Partecipazione part4 =
                new Partecipazione(p4FromDB, e4FromDB, Stato.DA_CONFERMARE);

        Partecipazione part5 =
                new Partecipazione(p5FromDB, e9FromDB, Stato.CONFERMATA);

        Partecipazione part6 =
                new Partecipazione(p1FromDB, e8FromDB, Stato.DA_CONFERMARE);

        partecipazioneDAO.save(part1);
        partecipazioneDAO.save(part2);
        partecipazioneDAO.save(part3);
        partecipazioneDAO.save(part4);
        partecipazioneDAO.save(part5);
        partecipazioneDAO.save(part6);*/

       /* UUID id_partecipazione = UUID.fromString("2863b212-c7cc-4880-afed-08b834b4e975");
        UUID id_evento = UUID.fromString("89895f47-6404-4464-b32a-f13a7c250359");
        UUID id_persona = UUID.fromString("9fd9f228-00a4-4b88-bc62-46d930d63fb2");
        UUID id_location = UUID.fromString("6e2838b9-c708-4c3b-9f57-07d2921d4aa0");*/

        /*//GetById
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
        }*/


        // remove
        /*try {
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
        }*/

      /*  try {
            locationDAO.delete(id_location);
        } catch (NotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }*/

    }
}
