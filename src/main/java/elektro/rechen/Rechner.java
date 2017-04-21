package elektro.rechen;
//Testing gitignore
public class Rechner {

    // FIXME extract 1000 / -1000 as upper and lower boundary to class variable
    public int plus(int summand1, int summand2) {
        if (summand1 <= 1000) {
            if (summand2 <= 1000) {
                if (summand1 >= -1000) {
                    if (summand2 >= -1000) {
                        return summand1 + summand2;
                    } else {
                        throw new IllegalArgumentException("Summand darf nicht kleiner als -1000 sein!");
                    }
                } else {
                    throw new IllegalArgumentException("Summand darf nicht kleiner als -1000 sein!");
                }
            } else {
                throw new IllegalArgumentException("Summand darf nicht größer als 1000 sein!");
            }
        } else {
            throw new IllegalArgumentException("Summand darf nicht größer als 1000 sein!");
        }
    }

    public int minus(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    public int mal(int faktor1, int faktor2) {
        int ergebnis = faktor1;
        for (int i = 1; i < faktor2; i++) {
            ergebnis += faktor1;
        }
        return ergebnis;
    }

    public double geteilt(int dividend, int divisor) {
        if (divisor == 0)  // division by 0 is illegal
            throw new IllegalArgumentException("Divisor darf nicht 0 sein!");
        return (double) dividend / divisor;
    }

    public double hoch(int basis, int potenz) {
        return Math.pow(potenz, basis);
    }

    public int ultimativeAntwort(String frage) {
        return 42;
    }
}
