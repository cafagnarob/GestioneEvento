package entities;

import Enum.Sesso;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
public class Persona {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private LocalDate data_di_nascita;

    @Column
    private Sesso sesso;

    @Column(name = "lista_partecipazioni")
    private List<Partecipazioni> listaPartecipazioni;
}
