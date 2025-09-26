package davidemancini.dao;

import davidemancini.entities.Catalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class CatalogoDAO {
    private final EntityManager entityManager;
    public CatalogoDAO( EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void save (Catalogo newCatalogo){
        EntityTransaction transaction= entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newCatalogo);
        transaction.commit();
        System.out.println("elemento " + newCatalogo.getTitolo() + " aggiunto al catalogo!");
    }
    public Catalogo findById (String catalogoId){
        UUID converti = UUID.fromString(catalogoId); //PER POTER PASSARE UN UUID NEL PARAMETRO LO DEVO CONVERTIRE IN STRINGA
        TypedQuery<Catalogo> query = entityManager.createQuery("SELECT c FROM Catalogo c WHERE c.codiceISBN = :catalogoid", Catalogo.class);
        query.setParameter("catalogoid", converti);
        return query.getSingleResult();
    }
    public void findByIdAndDelete (String catalogoId){
        UUID converti = UUID.fromString(catalogoId);//PER POTER PASSARE UN UUID NEL PARAMETRO LO DEVO CONVERTIRE IN STRINGA
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Catalogo c WHERE c.codiceISBN = :catalogoid");
        query.setParameter("catalogoid", converti);
        query.executeUpdate();
        transaction.commit();
        System.out.println("elemento con id " + catalogoId + " è stato eliminato");
    }
    public List<Catalogo> findByAnnoPubblicazione (int annoPubblicazione){
        TypedQuery<Catalogo> query = entityManager.createQuery("SELECT c FROM Catalogo c WHERE c.annoDIPubblicazione = :annoPubblicazione", Catalogo.class);
        query.setParameter("annoPubblicazione",annoPubblicazione);
        return query.getResultList();
    }
    public List<Catalogo> findByAutore (String autore){
        TypedQuery<Catalogo> query = entityManager.createQuery("SELECT l FROM Catalogo l WHERE l.autore = :autore", Catalogo.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }
    public List<Catalogo> findByTitleOParte(String titoloOParte){
//        TypedQuery<Catalogo>query= entityManager.createQuery("SELECT c FROM Catalogo c WHERE c.titolo LIKE CONCAT('%',:titoloOParte,'%')", Catalogo.class); //COSI PUO ESSERCI QUALSIASI COSA SIA PRIMA CHE DOPO LA sTRINGA PASSATA COME PARAMENTRO

        //COSI PUOI ESSERCI QUALCOSA SOLO DOPO, QUINDI TROVERA ELEMENTI CON TITOLO CHE INIZAI COME LA STRINGA NEL PARTAMETRO. METTO TUTTO COME LOWER CASE COSI NON DEVO STARE ATTENTO ALLE MAIUSCOLE
        TypedQuery<Catalogo>query= entityManager.createQuery("SELECT c FROM Catalogo c WHERE LOWER(c.titolo) LIKE LOWER (CONCAT(:titoloOParte,'%'))", Catalogo.class);
        query.setParameter("titoloOParte",titoloOParte);
        return query.getResultList();
    }
}
