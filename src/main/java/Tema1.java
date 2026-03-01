public class Tema1 {
    // 1.   Creează variabile pentru: varsta unui student, inaltimea acestuia, daca este prezent la curs. Afiseaza datele prin mesaje/propozitii.
    public static void main(String[] args) {
        int varsta = 28;
        double inaltime = 1.80;
        boolean estePrezent = true;

        System.out.println("Studentul are varsta de " + varsta + " ani.");
        System.out.println("Studentul are inaltimea de " + inaltime + " metri.");
        System.out.println("Este prezent la curs: " + estePrezent);


        // 2.   Crează doua variabile int si una double. Calculeaza suma celor doua valori int. Calculeaza media dintre toate 3.
        int a = 12;
        int b = 15;
        double c = 22.5;
        //suma celor 2 int
        int suma = a + b;

        // media dintre cele 3

        double media = (a + b + c) / 3;

        System.out.println("Suma celor doua numere int este: " + suma);
        System.out.println("Media celor trei valori este: " + media);


        //  3.  Creaza o variabila pentru varsta. Dacă persoana are 18 sau mai mult, afișează: “Acces permis”, altfel “Acces interzis”.
        int varstaPersoana = 17;
        if (varstaPersoana >= 18) {
            System.out.println("Acces permis");
        } else {
            System.out.println("Acces interzis");
        }
//    4. Calculeaza suma numerelor de la 20 la 50.
        int sumaNumerelor = 0;

        for (int i = 20; i <= 50; i++) {
            sumaNumerelor = sumaNumerelor + i;
        }

        System.out.println("Suma numerelor de la 20 la 50 este: " + sumaNumerelor);


//  5.   Afișează numerele de la 10 la 1 folosind while.

        int i = 10; // pornim de la 10

        while (i >= 1) { // cât timp i e mai mare sau egal cu 1
            System.out.println(i);
            i--; // scădem 1 la fiecare pas
        }
        //apelam metoda de la punctul 6.
        String mesaj = obtineMesaj();
        System.out.println(mesaj);

        // apelam metoda de la punctul 7 .
        System.out.println("Produsul parametriilor este " + produsParametrii(15,23));

        // apelam metoda de la punctul 8.
        System.out.println(sumaNumerePare(0));
        //sau
        int rezultat = sumaNumerelorPare(); // apelăm metoda
        System.out.println("Suma numerelor pare de la 1 la 50 este: " + rezultat);

        //apelam metoda de la punctul 9.
        System.out.println(mediaParametrii(15,76,23));

        // apelam metoda de la punctul 10.
        numereCuprinse(23,78);
    }
    //   6.  Creează o metodă care afișează: “Invat Java!”
    static String obtineMesaj() {
        return "Invat Java!";
    }
    // 7.   Creaza o metoda cu 2 parametrii int, care returneaza produsul celor doi parametrii.
    static int produsParametrii (int n,int z) {
        int produs = n*z;
        return produs;
    }
    //  8.  Calculează suma numerelor pare de la 1 la 50. Crează o metoda care returneaza rezultatul.
    static int sumaNumerePare (int suma ){
        for (int i = 1; i <=50; i++) {
            if (i % 2 ==0) {
                suma = suma + i;
            }
        }
        return suma;

    }

    //sau
    static int sumaNumerelorPare() {
        int suma = 0;
        for (int i = 1; i <= 50; i++) {
            if (i % 2 == 0) { // verificăm dacă numărul e par
                suma = suma + i;
            }
        }
        return suma;
    }

//  9.  Creaza o metoda cu 3 parametrii. Returneaza media celor trei parametrii.

    static double mediaParametrii (int parametruUnu, int parametruDoi, int parametruTrei) {
        double media = (parametruUnu + parametruDoi + parametruTrei) / 3;
        return media;
    }
    //  10.   Creeaza o metoda care primeste 2 parametrii: start si end. Afiseaza toate numerele cuprinse intre aceste doua numere
    static void numereCuprinse (int start, int end){
        for (int i = start;i <= end; i ++) {
            System.out.println(i);
        }
    }
}
