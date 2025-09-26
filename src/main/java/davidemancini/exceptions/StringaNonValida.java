package davidemancini.exceptions;

public class StringaNonValida extends RuntimeException {

    public StringaNonValida(String scelta) {
        super(scelta + " non è una scelta valida. Scegli R o L");
    }
}
