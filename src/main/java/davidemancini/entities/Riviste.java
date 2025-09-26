package davidemancini.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "riviste")
public class Riviste extends Catalogo{
    //ATTRIBUTI
    @Enumerated(EnumType.STRING) //COSI ANCHE NEL DB C'è IL VALORE DELL'ENUM E NON OSLO IL SUO INDICE
    private Periodicità periodicità;
    //COSTRUTTORI
    public Riviste(){}

    public Riviste( String titolo, int numeroPagine, int annoDIPubblicazione, Periodicità periodicità) {
        super( titolo, numeroPagine, annoDIPubblicazione);
        this.periodicità = periodicità;
    }
    //METODI

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDIPubblicazione=" + annoDIPubblicazione +
                ", numeroPagine=" + numeroPagine +
                "periodicità=" + periodicità +
                '}';
    }
}
