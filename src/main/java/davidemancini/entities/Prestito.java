package davidemancini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestito {
    //ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private Catalogo elementoPrestato;
    private LocalDate dataInizioPrestito;
    private LocalDate dataRestPrevista;
    private LocalDate dataRestEffettiva;
    //COSTRUTTORI
    public Prestito(){}

    public Prestito(Utente utente, Catalogo elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestPrevista, LocalDate dataRestEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestPrevista = dataRestPrevista;
        this.dataRestEffettiva = dataRestEffettiva;
    }
    //METODI

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Catalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestPrevista() {
        return dataRestPrevista;
    }

    public void setDataRestPrevista(LocalDate dataRestPrevista) {
        this.dataRestPrevista = dataRestPrevista;
    }

    public LocalDate getDataRestEffettiva() {
        return dataRestEffettiva;
    }

    public void setDataRestEffettiva(LocalDate dataRestEffettiva) {
        this.dataRestEffettiva = dataRestEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestPrevista=" + dataRestPrevista +
                ", dataRestEffettiva=" + dataRestEffettiva +
                '}';
    }
}
