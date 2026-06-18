package entities;

import Enum.TipoEvento;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@NamedQueries({
        @NamedQuery(

                name = "PartitaDiCalcio.vinteInCasa",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa"
        ),
        @NamedQuery(

                name = "PartitaDiCalcio.vinteInTrasferta",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite"
        ),
        @NamedQuery(

                name = "PartitaDiCalcio.pareggiate",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = null"
        )
})
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Evento {

    @Column
    private String squadraDiCasa;

    @Column
    private String squadraOspite;

    @Column
    private String squadraVincente;

    @Column(name = "numero_gol_squadra_casa")
    private int nGolCasa;

    @Column(name = "numero_gol_squadra_ospiti")
    private int nGolOspiti;


    public PartitaDiCalcio() {

    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento,
                           String descrizione, TipoEvento tipoEvento,
                           Integer numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite,
                           String squadraVincente, int nGolCasa, int nGolOspiti) {
        super(titolo,
                dataEvento,
                descrizione,
                tipoEvento,
                numeroMassimoPartecipanti,
                location);

        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.nGolCasa = nGolCasa;
        this.nGolOspiti = nGolOspiti;
    }


    public int getnGolCasa() {
        return nGolCasa;
    }

    public int getnGolOspiti() {
        return nGolOspiti;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", nGolCasa=" + nGolCasa +
                ", nGolOspiti=" + nGolOspiti +
                "} " + super.toString();
    }
}
