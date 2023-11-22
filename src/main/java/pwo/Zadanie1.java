package pwo;

/**
 * Klasa główna programu generującego i zapisującego wyrazy ciągu Fibonacciego
 * do pliku. Wykorzystuje narzędzia z klasy {@link SequenceTools}.
 *
 * @author michal
 * @version 1.0.0
 */
public class Zadanie1 {

    /**
     * Początkowy indeks generowanego ciągu.
     */
    public static final int FROM = 0;

    /**
     * Końcowy indeks generowanego ciągu.
     */
    public static final int TO = 100;

    /**
     * Nazwa pliku, do którego zapisywane są wyrazy ciągu.
     */
    public static final String FILE_NAME = "fibseq100.txt";

    /**
     * Metoda main programu.
     *
     * @param args Argumenty z linii poleceń (nie są używane).
     */
    public static void main(String[] args) {

        System.out.println("Fibonacci wersja 2");

        boolean ok = SequenceTools.writeToFile(
                new FibonacciGenerator(), FROM, TO, FILE_NAME);
        if (ok) {
            System.out.println("Wynik zapisany do pliku: " + FILE_NAME);
        } else {
            System.out.println("Błąd");
        }
    }
}
