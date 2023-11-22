package pwo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasa narzędziowa do obsługi ciągów liczbowych. Dostarcza metodę do zapisu
 * wyrazów ciągu Fibonacciego do pliku. Wykorzystuje generator ciągu
 * Fibonacciego.
 *
 * @author michal
 * @version 1.0.0
 */
public class SequenceTools {

    /**
     * Metoda zapisująca wyrazy ciągu Fibonacciego do pliku.
     *
     * @param generator Generator ciągu Fibonacciego.
     * @param from Początkowy indeks wyrazu do zapisu.
     * @param to Końcowy indeks wyrazu do zapisu.
     * @param fileName Nazwa pliku, do którego zapisywane są wyrazy ciągu.
     * @return true jeżeli zapis do pliku powiódł się, false w przeciwnym
     * wypadku.
     */
    public static boolean writeToFile(
            FibonacciGenerator generator,
            int from, int to,
            String fileName) {
        try {
            BufferedWriter writer
                    = new BufferedWriter(new FileWriter(fileName));
            for (int i = from; i <= to; i++) {
                writer.write(generator.getTerm(i) + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
