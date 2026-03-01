public class ExercitiiMetode {

    //==========Sesiune 18 Februarie ==============//

    static void inmultire(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i * 7);
        }
    }

    static int primulMultiplu7(int numar) {
        int rest = numar % 7;
        if (rest == 0) {
            return numar;
        } else {
            return numar + (7 - rest);
        }
    }

    static int plus(int x, int y) {
        return x + y;
    }

    static int minus(int z, int w) {
        return z - w;
    }

    static void interval(int limitaInferioara, int limitaSuperioara) {
        for (int i = limitaInferioara; i <= limitaSuperioara; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    static String numeVarsta(String nume, int varsta) {
        return nume + " are " + varsta + " de ani";
    }

    static void multiplu(int nr) {
        for (int i = 100; i <= 1000; i++) {
            if (i % nr == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    static void afiseazaFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Factorialul lui " + n + " este: " + factorial);
    }

    static void factorial(int s) {
        int inmultire = 1;
        for (int i = 1; i <= s; i++) {
            inmultire *= i;
        }
        System.out.println(inmultire);
    }

    public static void main(String[] args) {
        multiplu(7);

        String nume = "Iulia";
        int varsta = 35;
        System.out.println(numeVarsta(nume, varsta));

        System.out.println(plus(2, 5));
        System.out.println(minus(10, 7));

        interval(5, 45);

        afiseazaFactorial(5);
        afiseazaFactorial(10);

        factorial(9);
    }
}


