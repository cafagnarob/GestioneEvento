package entities;

import Enum.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Evento {


    @OneToMany
    private List<Persona> setAtleti;

    @ManyToOne
    @JoinColumn(name = "id_vincitore")
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento,
                          String descrizione, TipoEvento tipoEvento,
                          Integer numeroMassimoPartecipanti, Location location, List<Persona> setAtleti, Persona vincitore) {
        super(titolo,
                dataEvento,
                descrizione,
                tipoEvento,
                numeroMassimoPartecipanti,
                location);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;

    }

    public Persona getVincitore() {
        return vincitore;
    }

    public List<Persona> getSetAtleti() {
        return setAtleti;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                ", setAtleti=" + setAtleti +
                ", vincitore=" + vincitore +
                "} " + super.toString();
    }
}
