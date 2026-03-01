import java.util.Random;

public class Arrays {

    //===============Sesiune 18 Februarie============//
    /* Un array este o colectie de elemente de acelasi tip, stocate intr-o singura variabila\*/
/* Varianta 1
    int[] numere = new int [5]
    indexul incepe de la 0
    //valorile implicite sunt 0

   Varianta 2
   int[] numere = {4,7,1,9,3};
  ! mai scurt is mai des folosit!

  Acces prin index
     int[] numere = {4,7,1,9,3};
     sout(numere[0]); - primul element
     sout(numere([4]); - ultimul element

     - Indexul incepe de la 0
     - ultimul index = lungimea colectiei - 1
     - numere.length > aflam dimesniunea colectiei
    */
// Ex 1 - creeaza un array cu 5 numere introduse de tine//
    // Afiseaza valorile arrayului//

    public static void main(String[] args) {
        int[] scor = {2, 3, 5, 2, 4, 8, 10, 6};
        for (int i : scor) {
            System.out.print(i + " ");
        }
        System.out.println();
//Calculeaza suma elementelor din array//

        int suma = 0;
        for (int i = 0; i <= scor.length - 1; i++) {
            suma = suma + scor[i];
        }
        System.out.println("Suma numerelor din sir este: " + suma);

//Gaseste numarul maxim din array//
        int valMaxim = scor[0];
        for (int i = 0; i < scor.length; i++) {
            if (scor[i] > valMaxim) {
                valMaxim = scor[i];
            }
        }

        System.out.println("Valoare maxima este: " + valMaxim);

        //Numara cate numere pare exista//
        int counter = 0;
        for (int i = 0; i < scor.length; i++) {
            if (scor[i] % 2 == 0) {
                counter++;
            }
        }
        System.out.println("Numarul numerelor pare este " + counter);

        //Calculeaza media numerelor//
        System.out.println("Media numerelor este: " + suma / (scor.length - 1));


        //Creeaza un array de 10 numere random
        Random random = new Random();
        int[] numere = new int[10];

        for (int i = 0; i < numere.length; i++) {
            numere[i] = random.nextInt(100); // număr între 0 și 99
        }

        for (int i : numere) {
            System.out.print(i + " ");
        }
        System.out.println();

        //Inverseaza un array//
        for (int i = 0; i < numere.length / 2; i++) {
            int a;
            a = numere[i];
            numere[i] = numere[numere.length - 1 - i];
            numere[numere.length - 1 - i] = a;
        }
        for (int i : numere) {
            System.out.print(i + " ");
        }
    }
}
