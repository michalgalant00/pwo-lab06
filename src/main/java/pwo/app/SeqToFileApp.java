package pwo.app;

import pwo.seq.SeqType;
import pwo.utils.SequenceTools;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

/**
 * Klasa aplikacji generującej i zapisującej ciąg liczbowy do pliku. Obsługuje
 * argumenty przekazane z linii poleceń.
 *
 * @author michal
 * @version 1.0.0
 */
class SeqToFileApp {

    /**
     * Typ ciągu do wygenerowania.
     */
    protected SeqType seqType = null;

    /**
     * Początkowy indeks generowanego ciągu.
     */
    protected Integer from = null;

    /**
     * Końcowy indeks generowanego ciągu.
     */
    protected Integer to = null;

    /**
     * Nazwa pliku, do którego zapisywany będzie ciąg.
     */
    protected String fileName = null;

    /**
     * Metoda parsująca argumenty przekazane z linii poleceń.
     *
     * @param args Tablica argumentów z linii poleceń.
     * @return true jeżeli argumenty są poprawne, false w przeciwnym wypadku.
     */
    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            return false;
        }

        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda zapisująca ciąg do pliku na podstawie wcześniej przekazanych
     * argumentów.
     *
     * @return true jeżeli zapis do pliku powiódł się, false w przeciwnym
     * wypadku.
     */
    protected boolean writeSeq() {
        return SequenceTools.writeToFile(seqType.getGenerator(), from, to, fileName);
    }

    /**
     * Metoda uruchamiająca aplikację.
     *
     * @param args Tablica argumentów z linii poleceń.
     */
    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to fileName");
            return;
        }

        if (!writeSeq()) {
            System.out.println("!Write to the file: " + fileName + " FAILED");
            return;
        }

        System.out.println("Results write to " + fileName);
    }
}
