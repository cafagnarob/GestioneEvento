package entities;

import Enum.Stato;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
@NamedQuery(
        name = "Partecipazioni.daConfermare",
        query = "SELECT p FROM Partecipazione p WHERE p.stato = 'DA_CONFERMARE'"
)
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID Id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Column
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona,
                          Evento evento,
                          Stato stato) {

        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazioni{" +
                "Id=" + Id +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
