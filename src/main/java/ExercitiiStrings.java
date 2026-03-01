public class ExercitiiStrings {

    //==========Sesiunea 18 Febr ==========//
    public static void main(String[]args) {

        //Afiseaza lungimea unui text//
        String text = "Ana are 7 mere verzi";
        System.out.println("Lungimea este: "+ text.length());

        //Pt un cuv afiseaza prima si ultima litera//
        String cuvant = "catel";
        System.out.println("Prima litera este: " + cuvant.charAt(0));
        System.out.println("Ultima litera este: " +cuvant.charAt(cuvant.length() -1));

        //Verifica daca 2 texte sunt egale//
        String text1 = "java";
        String text2 = "python";
        boolean equals = text1.equals(text2);
        System.out.println("Textele sunt egale: " + equals);

        //Verifica daca un text contine un cuvant//
        System.out.println("contine textul " + text.contains("catel"));
        System.out.println("contine textul " + text.contains("mere"));

        //elimina spatiile dintr-un text - din toata propozitia//
        String noulText = text.replace(" ", "");
        System.out.println(noulText);
        String caise = text.replace("mere", "caise");
        System.out.println(caise);

    }
}
