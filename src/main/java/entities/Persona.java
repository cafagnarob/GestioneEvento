package entities;

import Enum.Sesso;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
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
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> listaPartecipazioni;


    public Persona() {
    }

    public Persona(String nome, String cognome, LocalDate data_di_nascita,
                   Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
        this.sesso = sesso;

    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", sesso=" + sesso +
                ", listaPartecipazioni=" + listaPartecipazioni +
                '}';
    }
}
