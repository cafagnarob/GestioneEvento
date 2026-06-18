package entities;

import Enum.Genere;
import Enum.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Concerto extends Evento {


    @Column
    @Enumerated(EnumType.STRING)
    private Genere genere;

    @Column
    private boolean inStreaming;


    public Concerto() {
    }

    public Concerto(String titolo,
                    LocalDate dataEvento,
                    String descrizione,
                    TipoEvento tipoEvento,
                    Integer numeroMassimoPartecipanti,
                    Location location,
                    Genere genere,
                    boolean inStreaming) {

        super(titolo,
                dataEvento,
                descrizione,
                tipoEvento,
                numeroMassimoPartecipanti,
                location);

        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }
}
