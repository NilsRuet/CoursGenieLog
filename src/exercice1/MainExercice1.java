package exercice1;

import datamocklib.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainExercice1 {

    /*
    Transforms a list of string representing Person objects into actual Person objects
    data : list of string (one person = one string)
    returns a list of Person parsed from data
    */
    public List<Person> parse(List<String> data) {
        int expectedTokens = 6;
        ArrayList<Person> res = new ArrayList<Person>();
        for(int i = 0; i < data.size(); i++) {
            String row = data.get(i);
            StringTokenizer tokenizer = new StringTokenizer(row, ",");
            if(tokenizer.countTokens() == expectedTokens)
            {
                String firstName = tokenizer.nextToken();
                String lastName = tokenizer.nextToken();
                String birthDate = tokenizer.nextToken();
                String gender = tokenizer.nextToken();
                String cityResidence = tokenizer.nextToken();
                String cityBirth = tokenizer.nextToken();
                res.add(new Person(firstName, lastName, birthDate, gender, cityResidence, cityBirth));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // EXO 1
        /*
         * - Récuperez la liste des personnes sous la forme -> firstName,lastName,birthDate,gender,cityOfResidence,cityOfBirth
         *   grâce à la fonction TxtHelper.getDataFromTxt("persons.txt")
         * - Parser la liste des Personnes grâce à la fonction parse())
         * - Calculer le nombre de personnes nées dans chaque ville avec les données obtenues.
         * Les données contiennent une trentaine de villes, Bonne chance !
        */


    }
}
