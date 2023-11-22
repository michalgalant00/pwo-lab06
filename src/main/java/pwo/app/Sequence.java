package pwo.app;

/**
 * Klasa uruchamiająca aplikację generującą ciągi liczbowe. Akceptuje argumenty
 * z linii poleceń i wywołuje odpowiednią aplikację w zależności od ich liczby.
 *
 * @author michal
 * @version 1.0.0
 */
public class Sequence {

    /**
     * Metoda main aplikacji.
     *
     * @param args Argumenty z linii poleceń.
     */
    public static void main(String[] args) {

        switch (args.length) {
            case 3:
                (new SeqToOutApp()).run(args);
                break;
            case 4:
                (new SeqToFileApp()).run(args);
                break;
            default:
                System.out.println("!Illegal arguments\n"
                        + "Legal usage: seqName from to [fileName]");
        }
    }
}
