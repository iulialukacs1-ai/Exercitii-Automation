import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;

public class LoopsandMethods {
    public static void main(String[] args) {

        //==================Sesiune 11 Februarie===================
        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            System.out.println();
        }

        for (int i = 10; i >= 1; i--) {
            System.out.print(i);

            System.out.println();
        }
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i);

                System.out.println();
            }
        }

        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum = sum + i;
        }
        System.out.print("Suma este: " + sum);

        System.out.println();

        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        int j = 10;
        while (j >= 1) {
            System.out.print(j + " ");
            j--;
            System.out.println();
        }
        int x = 1;
        while (x <= 30) {
            if (x % 3 ==0) {
                System.out.print(x + " ");
            }
            x++;
            System.out.println();
        }
    }
}

