package davidemancini.dao;

import davidemancini.entities.Libri;
import davidemancini.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitiDAO {
    private final EntityManager entityManager;
    public PrestitiDAO (EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void save (Prestito newPrestito){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPrestito);
        transaction.commit();
        System.out.println("nuovo prestito aggiunto " + newPrestito);
    }
    public List<Prestito> findByNumTessera (long numTessera){
        TypedQuery<Prestito> query= entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.id = :numtessera", Prestito.class);
        query.setParameter("numtessera", numTessera);
        return query.getResultList();

    }
    public List<Prestito> findByPrestitiScadutiNonRestituiti(){
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestPrevista < p.dataRestEffettiva", Prestito.class);
        return query.getResultList();

    }
}
