package davidemancini;

import com.github.javafaker.Faker;
import davidemancini.dao.CatalogoDAO;
import davidemancini.dao.PrestitiDAO;
import davidemancini.dao.UtenteDAO;
import davidemancini.entities.*;
import davidemancini.exceptions.SceltaNonValida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        Periodicità[]periodicità = Periodicità.values(); //SALVO I VALORI DELL'ENUM IN UN ARRAY COSI CHE POSSO RANDOMIZZARLI


        //--------------AGGIUNGO 20 LIBRI CASUALO NEL DB-------------------
//        for (int i = 0; i < 20; i++) {
//            Libri libro1 = new Libri(faker.book().title(),random.nextInt(50,500), random.nextInt(1970,2025),faker.book().author(),faker.book().genre());
//            catalogoDAO.save(libro1);
//        }
        //---------------AGGIUNGO 20 RIVISTE CASUALI NEL DB------------------
//        for (int i = 0; i < 20; i++) {
//            Periodicità valoreCasualePeriodicità = periodicità[random.nextInt(periodicità.length)]; //RANDOMIZZO LA SCELTA DELL'INDICE DELL'ARRAY
//            Riviste rivista1 = new Riviste(faker.book().title(),random.nextInt(10,50),random.nextInt(1990,2025), valoreCasualePeriodicità);
//            catalogoDAO.save(rivista1);
//        }
        //---------------AGGIUNGO 10 UTENTI CASUALI NEL DB------------------
//        for (int i = 0; i < 10; i++) {
//        Utente utente1 = new Utente(faker.name().firstName(),faker.name().lastName(),LocalDate.of(random.nextInt(1925,2015),random.nextInt(1,12), random.nextInt(1,28) ));
//        utenteDAO.save(utente1);
//        }

//        Utente utente1 = new Utente(faker.name().firstName(),faker.name().lastName(),LocalDate.of(random.nextInt(1925,2015),random.nextInt(1,12), random.nextInt(1,28) ));
//        Libri libro1 = new Libri(faker.book().title(),random.nextInt(50,500), random.nextInt(1970,2025),faker.book().author(),faker.book().genre());

       //RECUPERO UN LIBRO GIA PRESENTRE NEL DB TRAMITE IL SUO ID COSI CHE POSSA INSERIRLO NEL PRESTITO
//       Catalogo libroFromDB = catalogoDAO.findById("aa8bec9a-3a85-4d01-af7e-745896c71f9b");

        //RECUPERO UN UTENTE GIA PRESENTRE NEL DB TRAMITE IL SUO ID COSI CHE POSSA INSERIRLO NEL PRESTITO
//        Utente utenteFromDB = utenteDAO.findById(6);

        //CREO UN NUOVO PRESTITO CON IL LIBRO E L'UTENTE RECUPERATO DAL DB TRAMITE IL LORO ID
//        Prestito prestito1 = new Prestito(utenteFromDB,libroFromDB,LocalDate.now(),LocalDate.now().plusDays(30),LocalDate.of(random.nextInt(2025,2026),random.nextInt(10,12), random.nextInt(1,28) ));
//       prestitiDAO.save(prestito1);

        //ELIMINAZIONE DI UN ELEMENTO NEL CATALOGO TRAMITE LA RICERCA DEL SUO ID
//        catalogoDAO.findByIdAndDelete("41317369-3890-4d9b-a17b-301d32c8049e");

        //RICERCA DI UN ELEMENTO NEL CATALOGO TRAMITE ID
//       Catalogo elementoCercato =  catalogoDAO.findById("637c04eb-922d-462d-a2b0-01c1f099da40");
//       System.out.println(elementoCercato);

        //RICERCA ELEMENTO TRAMITE ANNO DI PUBBLICAZIONE
//       List<Catalogo> ricercaConAnno = catalogoDAO.findByAnnoPubblicazione(2002); //TORNA UNA LISTA DI TUTTI I LIBRI O RIVISTE USCITE NELL'ANNO SPECIFICATIO COME PARAMETRO
//        System.out.println(ricercaConAnno);

        //RICERCA DI UN ELEMENTO NEL CATALOGO TRAMITE L'AUTORE
//        List<Catalogo> recercaPerAutore = catalogoDAO.findByAutore("Rocco Mazza");
//        System.out.println(recercaPerAutore);

        //RICERCA PER TITOLON O PARTE DI ESSO
//        List<Catalogo> ricercaPerTitoloOParteDiEsso = catalogoDAO.findByTitleOParte("a");
//        ricercaPerTitoloOParteDiEsso.forEach(System.out::println); //UTILIZZO IL FOR EACH CON UN SOUTC CHE UTILIZZA LA LAMBDA IN FORMA CONTRATTA

        //RICERCA ELEMENTI IN PRESTITO
//        List<Prestito> ricercaPerNumTessera=prestitiDAO.findByNumTessera(2);
//        ricercaPerNumTessera.forEach(System.out::println); //UTILIZZO IL FOR EACH CON UN SOUTC CHE UTILIZZA LA LAMBDA IN FORMA CONTRATTA

        //RICERCA PRESTITI SCADUIT NON RESITUITI
//        prestitiDAO.findByPrestitiScadutiNonRestituiti();

        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //-------------------------PROVE FATTE PRIMA DI INSERIRE TUTTO NELLO SCANNER-------------------------------------


        //--------------------------------------------SCANNER-------------------------------------------------------------
        //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

        while (true) {
            System.out.println("Ciao! Cosa vuoi fare?");
            System.out.println("premi 1 per aggiungere un elemento nel catalogo");
            System.out.println("premi 2 per rimuovere un elemento dal catalogo");
            System.out.println("premi 3 ricerca un elemento tramite il suo anno di pubblicazione");
            System.out.println("premi 4 ricerca un elemento tramite il suo autore");
            System.out.println("premi 5 ricerca un elemento tramite il titolo o parte di esso");
            System.out.println("premi 6 per vedere gli elementi attualmente in prestito tramite tessera utente");
            System.out.println("premi 7 per la ricerca dei prestiti scaduti e non riconsegnati");
            System.out.println("premi 0 per uscire");
            try {
                int scelta = scanner.nextInt();
                if (scelta > 7) {
                    throw new SceltaNonValida(scelta);
                }

                switch (scelta) {
                    case (1):
                        System.out.println("cosa vuoi aggiungere? premi L per libro o R per rivista");
                        scanner.nextLine();
                        String sceltaLoR = scanner.nextLine();
                        if (sceltaLoR.equals("L")) {
                            System.out.println("inserisci titolo libro");
                            String titolo = scanner.nextLine();
                            System.out.println("inserisci numero pagine");
                            int numPagine = scanner.nextInt();
                            System.out.println("inserisci anno di pubblicazione");
                            int annoDiPubblicazione = scanner.nextInt();
                            System.out.println("inserisci autote");
                            scanner.nextLine();
                            String autore = scanner.nextLine();
                            System.out.println("inserisci il genere del libro");

                            String genere = scanner.nextLine();
                            Libri libroAggiunto = new Libri(titolo, numPagine, annoDiPubblicazione, autore, genere);
                            catalogoDAO.save(libroAggiunto);
                            System.out.println("libro aggiunto al catalogo");
                        } else if (sceltaLoR.equals("R")) {
                            System.out.println("inserisci titolo della rivista");
                            Periodicità valoreCasualePeriodicità2 = periodicità[random.nextInt(periodicità.length)];
                            String titolo = scanner.nextLine();
                            System.out.println("inserisci numero pagine");
                            int numPagine = scanner.nextInt();
                            System.out.println("inserisci anno di pubblicazione");
                            int annoDiPubblicazione = scanner.nextInt();
                            Riviste rivistaAggiunta = new Riviste(titolo, numPagine, annoDiPubblicazione, valoreCasualePeriodicità2);
                            catalogoDAO.save(rivistaAggiunta);
                            System.out.println("rivista aggiunta al catalogo");
                        }
                        break;
                    case (2):
                        System.out.println("inserisci l'id dell'elemento che vuoi eliminare");
                        scanner.nextLine();
                        String idElementoDaEliminare = scanner.nextLine();
                        catalogoDAO.findByIdAndDelete(idElementoDaEliminare);
                        break;
                    case (3):
                        System.out.println("inserisci l'anno di pubblicazione per la ricerca");
                        int annoPubblicazionePerRicerca = scanner.nextInt();
                        List<Catalogo> ricercaConAnno1 = catalogoDAO.findByAnnoPubblicazione(annoPubblicazionePerRicerca);
                        System.out.println("ecco il risultato della ricerca ");
                        ricercaConAnno1.forEach(System.out::println);
                        break;
                    case (4):
                        System.out.println("inserisci l'autore per la ricerca");
                        scanner.nextLine();
                        String autoreRicerca = scanner.nextLine();
                        List<Catalogo> recercaPerAutoreScanner = catalogoDAO.findByAutore(autoreRicerca);
                        recercaPerAutoreScanner.forEach(System.out::println);
                        break;
                    case (5):
                        System.out.println("inserisci titolo o parte di esso per la ricerca");
                        scanner.nextLine();
                        String titoloRicerca = scanner.nextLine();
                        List<Catalogo> ricercaPerTitoloOParteDiEssoScanner = catalogoDAO.findByTitleOParte(titoloRicerca);
                        ricercaPerTitoloOParteDiEssoScanner.forEach(System.out::println);
                        break;
                    case (6):
                        System.out.println("insersci id dell'utente di cui vuoi vedere la lista di prestiti");
                        int idUtentePrestiti = scanner.nextInt();
                        List<Prestito> ricercaPerNumTesseraScanner = prestitiDAO.findByNumTessera(idUtentePrestiti);
                        ricercaPerNumTesseraScanner.forEach(System.out::println);
                        break;
                    case (7):
                        System.out.println("ecco tutti i prestiti scaduti e non ancora restituiti");
                        List<Prestito> prestitiScaduti = prestitiDAO.findByPrestitiScadutiNonRestituiti();
                        prestitiScaduti.forEach(System.out::println);
                        break;
                    case (0):
                        break;

                }
        }catch (SceltaNonValida ex){
            System.out.println(ex.getMessage());

    }
            }

}}
