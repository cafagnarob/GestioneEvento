package entities;

import Enum.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// dichiariamo che questa classe sarà un Entity, questo è l'inizio per creare la
// struttura della tabella.
@Entity
// dichiariamo la tabella e ne cambiamo il nome
@Table(name = "evento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento {
    // dichiarimao che il seguente attributo sarà un attributo unico per ogni evento
    @Id
    // dichiariamo che sarà il server a generare un valore per questo attributo
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String titolo;

    // possiamo dichiarare gli altri attributi come colonne della tabella e anche
    // dare un nome specifico o anche altre info come nullable=false (= not null)

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;


    @Column(nullable = false)
    private String descrizione;

    @Column(name = "tipo_evento", nullable = false)
    // di solito JAP considera gli enum di tipo integer quindi dobbiamo utilizzarte
    // @Enumerated(EnumType.STRING) per dirgli di considerarlo con il valore di stringa
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;


    @Column(name = "n_max_partecipanti")
    private Integer numeroMassimoPartecipanti;


    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
    private List<Partecipazione> partecipazioni;


// creiamo un construttore vuoto INDISPENSABILE

    public Evento() {

    }

    public Evento(String titolo, LocalDate dataEvento,
                  String descrizione, TipoEvento tipoEvento,
                  Integer numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public UUID getId() {
        return id;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public String getTitolo() {
        return titolo;
    }

    public Location getLocation() {
        return location;
    }

    public List<Partecipazione> getEventi() {
        return partecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}