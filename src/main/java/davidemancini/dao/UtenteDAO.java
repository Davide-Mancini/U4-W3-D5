package davidemancini.dao;

import davidemancini.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class UtenteDAO {
    private final EntityManager entityManager;
    public UtenteDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void save (Utente newUtente){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newUtente);
        transaction.commit();
        System.out.println("utente " + newUtente.getNome() + "" + newUtente.getCognome() + " è stato aggiunto");
    }
    public Utente findById (long utenteId){
        TypedQuery<Utente> query = entityManager.createQuery("SELECT u FROM Utente u WHERE u.id = :utenteid", Utente.class);
        query.setParameter("utenteid",utenteId );
        return query.getSingleResult();
    }
}
