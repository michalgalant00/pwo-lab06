package pwo.app;

import pwo.utils.SequenceTools;

/**
 * Klasa aplikacji generującej i wypisującej ciąg liczbowy na ekran konsoli.
 * Obsługuje argumenty przekazane z linii poleceń. Rozszerza klasę
 * {@link SeqToFileApp}.
 *
 * @author michal
 * @version 1.0.0
 */
public class SeqToOutApp extends SeqToFileApp {

    @Override
    protected boolean getArgs(String[] args) {

        if (super.getArgs(args)) {
            return true;
        }

        return seqType != null && from >= 0 && to >= 0;
    }

    @Override
    protected boolean writeSeq() {

        System.out.println(SequenceTools.getTermsAsColumn(
                seqType.getGenerator(), from, to));

        return true;
    }

    @Override
    public void run(String[] args) {

        System.out.println("Sequence to terminal CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to");
            return;
        }

        writeSeq();

    }
}
