package davidemancini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "utenti")
public class Utente {
    //ATTRIBUTI
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //COSTRUTTORI
    public Utente(){}

    public Utente(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;

    }
    //METODI

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", id=" + id +
                '}';
    }
}
