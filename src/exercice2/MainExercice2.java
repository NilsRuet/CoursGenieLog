package exercice2;

import datamocklib.Person;
import datamocklib.TxtHelper;
import exercice1.MainExercice1;
import exercice2.models.*;

import java.util.List;
import java.util.stream.Collectors;

public class MainExercice2 implements Exo2 {
    private final static String SERVER_FILE = "server.txt";
    /* EXO 2
     * Recupérez depuis le serveur la liste des gens qui sont nés à Chambéry.
     * La récupération de Data se fait dans l'ordre :
     *  - Récupération de data sur le server grâce à TxtHelper.getDataFromTxt("server.txt");
     *  - Vider la base de données locale grâce à la fonction TxtHelper.clearDataLocal();
     *  - Insérer les données dans la database locale grâce à la fonction TxtHelper.insertDataInTxt(line, "local.txt")
     *  - Afficher les données locale grace à TxtHelper.getDataFromTxt("local.txt")
     */

    private List<Person> fetchAll()
    {
        List<String> data = TxtHelper.getDataFromTxt(SERVER_FILE);
        MainExercice1 parser = new MainExercice1();
        return parser.parse(data);
    }

    @Override
    public void displayPersonFromChambery() {
        List<Person> persons = fetchAll();
        List<Person> fromChambery = persons.stream()
                .filter((Person person) -> person.getCityOfResidence() == "Chambéry")
                .collect(Collectors.toList());
        for (Person person: fromChambery)
        {
            System.out.println(person.toString());
        }

    }

    /*
     * Recupérez depuis le serveur la liste des gens qui ont plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     * Tips : Vous avez dans la class Person la fonction getAge();
     */
    @Override
    public void displayBoomers() {

    }

    /*
     * Recupérez depuis le serveur la liste des gens de sexe féminin.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemales() {

    }

    /*
     * Recupérez depuis le serveur la liste des femmes de plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemaleBoomers() {

    }

    public static void main(String[] args) {
        Exo2 exo2 = new MainExercice2();
        exo2.displayBoomers();
    }
}
