package pwo;

import java.math.BigDecimal;

/**
 * Klasa generująca wyrazy ciągu Fibonacciego. Dostarcza metody do resetowania,
 * pobierania konkretnego wyrazu oraz generowania kolejnego wyrazu ciągu.
 *
 * @author michal
 * @version 1.0.0
 */
public class FibonacciGenerator {

    /**
     * Indeks ostatnio uzyskanego wyrazu ciągu.
     */
    private int lastIndex = 0;

    /**
     * Aktualny wyraz ciągu.
     */
    private BigDecimal current = new BigDecimal(0);

    /**
     * Poprzedni wyraz ciągu.
     */
    private BigDecimal f_1 = new BigDecimal(1),
            /**
             * Przedprzedni wyraz ciągu.
             */
            f_2 = new BigDecimal(0);

    /**
     * Metoda resetująca stan generatora.
     */
    public void reset() {
        lastIndex = 0;
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Metoda generująca kolejny wyraz ciągu Fibonacciego.
     *
     * @return Kolejny wyraz ciągu.
     */
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }

    /**
     * Metoda pobierająca konkretny wyraz ciągu Fibonacciego.
     *
     * @param i Indeks wyrazu do pobrania.
     * @return Wyraz ciągu o zadanym indeksie.
     * @throws IllegalArgumentException Jeżeli indeks jest ujemny.
     */
    public BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Indeks nie może być ujemny.");
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }
}
