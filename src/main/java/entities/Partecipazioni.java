package entities;

import Enum.Stato;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Partecipazioni {
    @Id
    @GeneratedValue
    private UUID Id;

    @Column
    private Persona persona;

    @Column
    private Evento evento;

    @Column
    private Stato stato;
}
