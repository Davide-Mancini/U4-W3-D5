package davidemancini.exceptions;

public class SceltaNonValida extends RuntimeException {
    public SceltaNonValida(int scelta) {
        super(scelta + " non è valido, scegli fra 1 e 7 oppure 0 per uscire");
    }
}
