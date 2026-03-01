public class Variabile {
    public static void main(String[] args) {
        // ================= Sesiune 9 Febr================

        // ================= EXERCITIUL 1 =================
        // Afișează o propoziție formatată, cu variabile:
        //-	“Ma numesc X, am Y ani, am Z animale de companie”
        String name = "Iulia";
        int age = 35;
        int pets = 2;

        System.out.println("Ma numesc " + name + ", am " + age + " ani, am " + pets + " animale de companie.");

        // ================= EXERCITIUL 2 =================
        //Consideră două variabile: a = 10, b = 11
        //-	Verifică dacă numărul din variabila a este par
        //-	Afișează valoarea mai mare
        //-	Verifică dacă valoarea lui b este cuprinsă între 11 si 15
        int a = 10;
        int b = 11;

        // 1.Verificam daca a este par
        //% = operator modulo (restul împărțirii)
        //dacă restul la împărțirea la 2 este 0 = număr par
        if (a % 2 == 0) {
            System.out.println("Numarul a este par");
        } else {
            System.out.println("Numarul a este impar");
        }

        // 2. Afisam valoarea mai mare
        // folosim else if pt ca verificam 3 situatii
        // daca foloseam doar if si else = in caz de egalitate intre a si b, se afisa  valoarea "a", ceea ce nu e corect
        if (a > b) {
            System.out.println("Valoarea mai mare este: " + a);
        } else if (b > a) {
            System.out.println("Valoarea mai mare este: " + b);
        } else {
            System.out.println("Valorile sunt egale");
        }

        // 3. Verificam daca b este intre 11 si 15
        //>= mai mare sau egal
        //<= mai mic sau egal
        //&& = ȘI logic (ambele conditii trebuie sa fie adevarate)
        //Java nu poate evalua două comparatii intr-una singura
        //if (valoare >= limita_minima && valoare <= limita_maxima) = intra in if, daca nu, intra in else
        if (b >= 11 && b <= 15) {
            System.out.println("b este cuprins intre 11 si 15");
        } else {
            System.out.println("b NU este cuprins intre 11 si 15");
        }

        // ================= EXERCITIUL 3 =================
        //Crează o instrucțiune care:
        //Se primește o nota (prin variabila)
        //Afișează “Admis” daca nota este >= 5
        int grade = 4;

        if (grade >= 5) {
            System.out.println("Admis");
        } else {
            System.out.println("Respins");
        }

        // ================= EXERCITIUL 4 =================
        // Calculator simplu:
        //-	dacă operatorul este "+"
        //-	atunci adună 2 numere
        int nr1 = 12;
        int nr2 = 7;
        String operator = "+";

        // verificam operatorul
        if (operator.equals("+")) { //.equals() compară conținutul textului > cand compari numere (variabile de tip int sau double > folosesti operatorul "==". Cand compari text (String) > folosesti operatorul ".equals".
            // == verifică dacă două variabile sunt același obiect în memorie (aceeași adresă), NU dacă au același text. Este aceeasi cutie? nu Scrie aceslasi lucru pe cutie? .
            int sum = nr1 + nr2;
            System.out.println("Suma este: " + sum);
        }

        // ================= EXERCITIUL 5 =================
        // Verificare discount:
        //-	dacă preț > 100 → aplică 10% reducere
        //-	Afișează prețul după reducere
        double price = 122;   // pretul initial, folosim double la variabila pt ca preturile pot avea zecimale
        // verificam daca se aplica reducerea
        if (price > 100) {
            price = price - price * 0.10;  // reducere 10%
        }

        System.out.println("Pretul final este: " + price);

    }
}
