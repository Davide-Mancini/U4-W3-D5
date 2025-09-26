package davidemancini;

import com.github.javafaker.Faker;
import davidemancini.dao.CatalogoDAO;
import davidemancini.dao.PrestitiDAO;
import davidemancini.dao.UtenteDAO;
import davidemancini.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Application {
private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d5");
    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        CatalogoDAO catalogoDAO = new CatalogoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitiDAO prestitiDAO = new PrestitiDAO(em);
        Faker faker = new Faker(Locale.ITALIAN);
        Random random = new Random();
        Periodicità periodicità[] = Periodicità.values(); //SALVO I VALORI DELL'ENUM IN UN ARRAY
        Periodicità valoreCasualePeriodicità = periodicità[random.nextInt(0,2)]; //RANDOMIZZO LA SCELTA DELL'INDICE DELL'ARRAY

        //--------------AGGIUNGO 20 LIBRI CASUALO NEL DB-------------------
//        for (int i = 0; i < 20; i++) {
//            Libri libro1 = new Libri(faker.book().title(),random.nextInt(50,500), random.nextInt(1970,2025),faker.book().author(),faker.book().genre());
//            catalogoDAO.save(libro1);
//        }
        //---------------AGGIUNGO 20 RIVISTE CASUALI NEL DB------------------
//        for (int i = 0; i < 20; i++) {
//            Riviste rivista1 = new Riviste(faker.book().title(),random.nextInt(10,50),random.nextInt(1990,2025), valoreCasualePeriodicità);
//            catalogoDAO.save(rivista1);
//        }
        //---------------AGGIUNGO 10 UTENTI CASUALI NEL DB------------------
//        for (int i = 0; i < 10; i++) {
//        Utente utente1 = new Utente(faker.name().firstName(),faker.name().lastName(),LocalDate.of(random.nextInt(1925,2015),random.nextInt(1,12), random.nextInt(1,28) ));
//        utenteDAO.save(utente1);
//        }

        Utente utente1 = new Utente(faker.name().firstName(),faker.name().lastName(),LocalDate.of(random.nextInt(1925,2015),random.nextInt(1,12), random.nextInt(1,28) ));
        Libri libro1 = new Libri(faker.book().title(),random.nextInt(50,500), random.nextInt(1970,2025),faker.book().author(),faker.book().genre());
       //RECUPERO UN LIBRO GIA PRESENTRE NEL DB TRAMITE IL SUO ID COSI CHE POSSA INSERIRLO NEL PRESTITO
        Catalogo libroFromDB = catalogoDAO.findById("4ba74577-fdfb-4fcd-b09c-b997f6f8cf78");
        //RECUPERO UN UTENTE GIA PRESENTRE NEL DB TRAMITE IL SUO ID COSI CHE POSSA INSERIRLO NEL PRESTITO
        Utente utenteFromDB = utenteDAO.findById(2);
        //CREO UN NUOVO PRESTITO CON IL LIBRO E L'UTENTE RECUPERATO DAL DB TRAMITE IL LORO ID
        Prestito prestito1 = new Prestito(utenteFromDB,libroFromDB,LocalDate.now(),LocalDate.now().plusDays(30),LocalDate.of(random.nextInt(2025,2026),random.nextInt(10,12), random.nextInt(1,28) ));
       prestitiDAO.save(prestito1);

        //ELIMINAZIONE DI UN ELEMENTO NEL CATALOGO TRAMITE LA RICERCA DEL SUO ID
//        catalogoDAO.findByIdAndDelete("41317369-3890-4d9b-a17b-301d32c8049e");

        //RICERCA DI UN ELEMENTO NEL CATALOGO TRAMITE ID
//       Catalogo elementoCercato =  catalogoDAO.findById("637c04eb-922d-462d-a2b0-01c1f099da40");
//       System.out.println(elementoCercato);

        //RICERCA ELEMENTO TRAMITE ANNO DI PUBBLICAZIONE
       List<Catalogo> ricercaConAnno = catalogoDAO.findByAnnoPubblicazione(2002); //TORNA UNA LISTA DI TUTTI I LIBRI O RIVISTE USCITE NELL'ANNO SPECIFICATIO COME PARAMETRO
        System.out.println(ricercaConAnno);

        //RICERCA DI UN ELEMENTO NEL CATALOGO TRAMITE L'AUTORE
        List<Catalogo> recercaPerAutore = catalogoDAO.findByAutore("Rocco Mazza");
        System.out.println(recercaPerAutore);

        //RICERCA PER TITOLON O PARTE DI ESSO
        List<Catalogo> ricercaPerTitoloOParteDiEsso = catalogoDAO.findByTitleOParte("a");
        ricercaPerTitoloOParteDiEsso.forEach(System.out::println); //UTILIZZO IL FOR EACH CON UN SOUTC CHE UTILIZZA LA LAMBDA IN FORMA CONTRATTA

        //RICERCA ELEMENTI IN PRESTITO
        List<Prestito> ricercaPerNumTessera=prestitiDAO.findByNumTessera(2);
        ricercaPerNumTessera.forEach(System.out::println); //UTILIZZO IL FOR EACH CON UN SOUTC CHE UTILIZZA LA LAMBDA IN FORMA CONTRATTA

        //RICERCA PRESTITI SCADUIT NON RESITUITI
        prestitiDAO.findByPrestitiScadutiNonRestituiti();

    }
}
