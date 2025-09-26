package davidemancini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Catalogo {
    //ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID codiceISBN;
    protected String titolo;
    protected int annoDIPubblicazione;
    protected int numeroPagine;
    //COSTRUTTORI
    public Catalogo(){}

    public Catalogo(String titolo, int numeroPagine, int annoDIPubblicazione) {
        this.titolo = titolo;
        this.numeroPagine = numeroPagine;
        this.annoDIPubblicazione = annoDIPubblicazione;
    }
    //METODI

    public UUID getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoDIPubblicazione() {
        return annoDIPubblicazione;
    }

    public void setAnnoDIPubblicazione(int annoDIPubblicazione) {
        this.annoDIPubblicazione = annoDIPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDIPubblicazione=" + annoDIPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
