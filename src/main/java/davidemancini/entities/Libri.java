package davidemancini.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "libri")
public class Libri extends Catalogo {
    //ATTRIBUTI
  private String autore;
  private String genere;
  //COSTRUTTORI

    public Libri (){}

    public Libri( String titolo, int numeroPagine, int annoDIPubblicazione, String autore, String genere) {
        super( titolo, numeroPagine, annoDIPubblicazione);
        this.autore = autore;
        this.genere = genere;
    }
    //METODI

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDIPubblicazione=" + annoDIPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }
}
