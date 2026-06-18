package robertocafagna;

import Enum.TipoEvento;
import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.GaraDiAtletica;
import entities.Location;
import entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        /*Location loc1 = new Location("Forum Assago", "Milano");
        Location loc2 = new Location("Palalottomatica", "Roma");
        Location loc3 = new Location("Teatro Massimo", "Palermo");
        Location loc4 = new Location("Arena di Verona", "Verona");


        locationDAO.save(loc1);
        locationDAO.save(loc2);
        locationDAO.save(loc3);
        locationDAO.save(loc4);
*/
        UUID id_loc1 = UUID.fromString("6e32c052-6d5c-4fe1-8e34-104c7b588e78");
        Location loc1FromDB = locationDAO.getById(id_loc1);
        UUID id_loc2 = UUID.fromString("89e24605-d8c7-4fb7-bd39-6a50cfc26bde");
        Location loc2FromDB = locationDAO.getById(id_loc2);
        UUID id_loc3 = UUID.fromString("ce86d6d9-d176-46ab-87a7-3afa3adca465");
        Location loc3FromDB = locationDAO.getById(id_loc3);
        UUID id_loc4 = UUID.fromString("d1f64d7a-f5eb-46fd-afa3-b80a238a7448");
        Location loc4FromDB = locationDAO.getById(id_loc4);


//PERSON
        /*Persona p1 = new Persona(
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


        personaDAO.save(p1);
        personaDAO.save(p2);
        personaDAO.save(p3);
        personaDAO.save(p4);
        personaDAO.save(p5);*/

        UUID id_p1FromDB = UUID.fromString("56562752-7b06-4ef6-baf0-da839a2da804");
        Persona p1FromDB = personaDAO.getById(id_p1FromDB);

        UUID id_p2FromDB = UUID.fromString("79d7381b-a679-4eac-9442-5d04d89fa6af");
        Persona p2FromDB = personaDAO.getById(id_p2FromDB);
        UUID id_p3FromDB = UUID.fromString("970ba954-bffd-4c45-ad02-8c6c186180f6");
        Persona p3FromDB = personaDAO.getById(id_p3FromDB);
        UUID id_p4FromDB = UUID.fromString("a5c5cd61-68b0-46c6-8b33-5363273411bc");
        Persona p4FromDB = personaDAO.getById(id_p4FromDB);
        UUID id_p5FromDB = UUID.fromString("baf38b1d-2ca1-489b-896a-bd0835d727c3");
        Persona p5FromDB = personaDAO.getById(id_p5FromDB);


        //concerti
        /*Concerto c1 = new Concerto("Rock Night",
                LocalDate.of(2026, 7, 10),
                "Concerto rock internazionale",
                TipoEvento.PUBBLICO,
                5000,
                loc1FromDB, Genere.ROCK, true);

        Concerto c2 = new Concerto(
                "Classical Evening",
                LocalDate.of(2026, 7, 12),
                "Musica sinfonica",
                TipoEvento.PUBBLICO,
                2000,
                loc2FromDB,
                Genere.CLASSICO,
                false
        );

        Concerto c3 = new Concerto(
                "Pop Live",
                LocalDate.of(2026, 7, 15),
                "Hit pop del momento",
                TipoEvento.PUBBLICO,
                8000,
                loc4FromDB,
                Genere.POP,
                true
        );*/

        /*eventoDAO.save(c1);
        eventoDAO.save(c2);
        eventoDAO.save(c3);*/

        //PartitaDiCalcio
        /*PartitaDiCalcio pa1 = new PartitaDiCalcio(
                "Derby di Milano",
                LocalDate.of(2026, 6, 10),
                "Partita storica tra Milan e Inter",
                TipoEvento.PUBBLICO,
                80000,
                loc1FromDB,
                "Milan",
                "Inter",
                "Milan",
                2,
                1
        );

        PartitaDiCalcio pa2 = new PartitaDiCalcio(
                "Classico Roma-Juve",
                LocalDate.of(2026, 6, 11),
                "Big match Serie A",
                TipoEvento.PUBBLICO,
                60000,
                loc2FromDB,
                "Juventus",
                "Roma",
                "Roma",
                0,
                2
        );

        PartitaDiCalcio pa3 = new PartitaDiCalcio(
                "Napoli Lazio",
                LocalDate.of(2026, 6, 12),
                "Partita equilibrata",
                TipoEvento.PUBBLICO,
                50000,
                loc4FromDB,
                "Napoli",
                "Lazio",
                null, // pareggio
                1,
                1
        );

        PartitaDiCalcio pa4 = new PartitaDiCalcio(
                "Atalanta Fiorentina",
                LocalDate.of(2026, 6, 13),
                "Match offensivo",
                TipoEvento.PUBBLICO,
                40000,
                loc3FromDB,
                "Atalanta",
                "Fiorentina",
                "Atalanta",
                3,
                2
        );

        eventoDAO.save(pa1);
        eventoDAO.save(pa2);
        eventoDAO.save(pa3);
        eventoDAO.save(pa4);*/


        //gare di altetica

        List<Persona> atletiGara1 = new ArrayList<>(List.of(p1FromDB, p2FromDB, p3FromDB));


        GaraDiAtletica g1 = new GaraDiAtletica(
                "100 metri piani",
                LocalDate.of(2026, 6, 10),
                "Gara sprint 100m",
                TipoEvento.PUBBLICO,
                3,
                loc3FromDB,
                atletiGara1,
                p1FromDB
        );
        List<Persona> atletiGara2 = new ArrayList<>(List.of(p4FromDB, p2FromDB, p3FromDB));

        GaraDiAtletica g2 = new GaraDiAtletica(
                "Salto in lungo",
                LocalDate.of(2026, 6, 11),
                "Gara di salto",
                TipoEvento.PUBBLICO,
                3,
                loc2FromDB,
                atletiGara2,
                p2FromDB
        );
        List<Persona> atletiGara3 = new ArrayList<>(List.of(p1FromDB, p2FromDB, p4FromDB));
        GaraDiAtletica g3 = new GaraDiAtletica(
                "400 metri",
                LocalDate.of(2026, 6, 12),
                "Gara di resistenza veloce",
                TipoEvento.PUBBLICO,
                3,
                loc3FromDB,
                atletiGara3,
                p4FromDB
        );

        //eventoDAO.save(g1);
        /*eventoDAO.save(g2);
        eventoDAO.save(g3);
*/

// EVENTO
        /*UUID id_loc1 = UUID.fromString("5873313b-e740-4fb2-b8bb-1dd9ec04074c");
        Location loc1FromDB = locationDAO.getById(id_loc1);
        UUID id_loc2 = UUID.fromString("8de600aa-89b6-4eaa-9673-e0b542baf3b2");
        Location loc2FromDB = locationDAO.getById(id_loc2);
        UUID id_loc3 = UUID.fromString("b01df81c-c853-4509-bc99-77c7d9ac82e6");
        Location loc3FromDB = locationDAO.getById(id_loc3);
        UUID id_loc4 = UUID.fromString("c3c952bf-fafa-4b9d-bfd1-db7c4187293d");
        Location loc4FromDB = locationDAO.getById(id_loc4);
*/

        /*UUID id_p1FromDB = UUID.fromString("4f778ee2-f6e3-4fc7-9e51-42271027aecf");
        Persona p1FromDB = personaDAO.getById(id_p1FromDB);

        UUID id_p2FromDB = UUID.fromString("b77f0d73-1d38-44d6-9db0-7f414ca98ef5");
        Persona p2FromDB = personaDAO.getById(id_p2FromDB);
        UUID id_p3FromDB = UUID.fromString("de5f2836-ad84-4150-bb43-1d254d34d47c");
        Persona p3FromDB = personaDAO.getById(id_p3FromDB);
        UUID id_p4FromDB = UUID.fromString("e17f7c87-e8f5-48ec-bfc8-c693a28fb742");
        Persona p4FromDB = personaDAO.getById(id_p4FromDB);
        UUID id_p5FromDB = UUID.fromString("f561ab4a-fe54-43ef-bbf1-2a446da5b36a");
        Persona p5FromDB = personaDAO.getById(id_p5FromDB);

        UUID id_e1FromDB = UUID.fromString("02651dfc-aba8-4030-8522-8aaab004c052");
        Evento e1FromDB = eventoDAO.getById(id_e1FromDB);
        UUID id_e2FromDB = UUID.fromString("7214fa6a-cf4d-4243-9dbf-3ea8fa6878f5");
        Evento e2FromDB = eventoDAO.getById(id_e2FromDB);
        UUID id_e3FromDB = UUID.fromString("83211401-9a0f-4f60-addc-1c18448cfcea");
        Evento e3FromDB = eventoDAO.getById(id_e3FromDB);
        UUID id_e4FromDB = UUID.fromString("ac4787b9-4ad7-4793-a16b-e52df8d22038");
        Evento e4FromDB = eventoDAO.getById(id_e4FromDB);
        UUID id_e5FromDB = UUID.fromString("ac6368f1-4d2b-4f45-a9ae-f7bb3e992323");
        Evento e5FromDB = eventoDAO.getById(id_e5FromDB);
        UUID id_e6FromDB = UUID.fromString("b0224dd7-c77f-44dc-81c3-6182dc67834d");
        Evento e6FromDB = eventoDAO.getById(id_e6FromDB);
        UUID id_e7FromDB = UUID.fromString("b758fa51-6bbc-45b0-af98-91a0d933816e");
        Evento e7FromDB = eventoDAO.getById(id_e7FromDB);
        UUID id_e8FromDB = UUID.fromString("d0e5b545-02fc-4170-8147-ebe698b73b40");
        Evento e8FromDB = eventoDAO.getById(id_e8FromDB);
        UUID id_e9FromDB = UUID.fromString("deebe10e-0b68-4434-badd-67ae572cdf9e");
        Evento e9FromDB = eventoDAO.getById(id_e9FromDB);
        UUID id_e10FromDB = UUID.fromString("f82d9c9e-d7fd-44e0-994f-497821d15b3a");
        Evento e10FromDB = eventoDAO.getById(id_e9FromDB);*/


//PARTECIPAZIONE
       /* Partecipazione part1 =
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
