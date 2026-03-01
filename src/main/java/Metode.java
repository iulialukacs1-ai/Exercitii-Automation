
public class Metode {

    //============Sesiune 16 Februarie=============//

    static void salut(String name) {
        System.out.println("Salut, " + name + "!");
    }

    static void ridicareLaPatrat(double numar) {
        System.out.println(numar * numar);
    }

    static int dublulUnuiNumar(int x) {
        return x * 2;
    }

    static boolean numarPar(int y) {
        return y % 2 == 0;
    }

    static int suma(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(suma(n));

        int sumaDeLaUnu = suma(10);
        System.out.println(sumaDeLaUnu);
    }
}


