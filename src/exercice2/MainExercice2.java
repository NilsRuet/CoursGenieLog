package exercice2;

import datamocklib.Person;
import datamocklib.TxtHelper;
import exercice1.MainExercice1;
import exercice2.models.*;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainExercice2 implements Exo2 {
    private final static int AGE_LIMIT = 25;

    private final static String SERVER_FILE = "server.txt";
    /* EXO 2
     * Recupérez depuis le serveur la liste des gens qui sont nés à Chambéry.
     * La récupération de Data se fait dans l'ordre :
     *  - Récupération de data sur le server grâce à TxtHelper.getDataFromTxt("server.txt");
     *  - Vider la base de données locale grâce à la fonction TxtHelper.clearDataLocal();
     *  - Insérer les données dans la database locale grâce à la fonction TxtHelper.insertDataInTxt(line, "local.txt")
     *  - Afficher les données locale grace à TxtHelper.getDataFromTxt("local.txt")
     */

    /*
    * Fetchs all persons on the server
    * returns the list of person objects
    * */
    private List<Person> fetchAll()
    {
        List<String> data = TxtHelper.getDataFromTxt(SERVER_FILE);
        MainExercice1 parser = new MainExercice1();
        return parser.parse(data);
    }

    /*
    * Displays persons among a list of person which match a predicate
    * */
    private void displayWhere(Predicate<Person> personFilter)
    {
        List<Person> persons = fetchAll();
        List<Person> matching = persons.stream()
                .filter(personFilter)
                .collect(Collectors.toList());
        for (Person person: matching)
        {
            System.out.println(person.toString());
        }
    }

    /*
    * Displays persons whose city of residence is chambéry
    * */
    @Override
    public void displayPersonFromChambery() {
        displayWhere((Person person) -> person.getCityOfResidence().toLowerCase().equals("chambery")); // Todo méthode de Person
    }

    /*
     * Recupérez depuis le serveur la liste des gens qui ont plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     * Tips : Vous avez dans la class Person la fonction getAge();
     */
    @Override
    public void displayBoomers() {
        displayWhere((Person person) -> person.getAge() > AGE_LIMIT); // Todo méthode de Person
    }


    /*
     * Recupérez depuis le serveur la liste des gens de sexe féminin.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemales() {
        displayWhere((Person person) -> person.getGender().toLowerCase().equals("female")); // Todo méthode de Person
    }

    /*
     * Recupérez depuis le serveur la liste des femmes de plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemaleBoomers() {
        displayWhere((Person person) -> (person.getGender().toLowerCase().equals("female") &&  person.getAge() > AGE_LIMIT)); // Todo méthode de Person
    }

    public static void main(String[] args) {
        Exo2 exo2 = new MainExercice2();
        exo2.displayPersonFromChambery();
    }
}
