## Prérequis

Pour participer à ce cours, _récupérez le projet_ en le [forkant](https://github.com/TomLeCollegue/CoursGenieLog/fork) :
![fork](https://user-images.githubusercontent.com/36131543/148802800-d571b902-d7ad-4190-8bcd-0bf4a17db1e9.jpg)
Vous pouvez ensuite le cloner sur votre machine.
Dès que vous avez terminé un exercice, veuillez Push immédiatemment afin que nous puissions faire la correction.

Vous aurez aussi besoin d'un environnement Java fonctionnel.

> Si votre fork n'est pas à jour par rapport au main (si vous l'avez fork hier soir), vous pouvez le mettre à jour de cette manière :
> https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/syncing-a-fork

---

## Organisation

Nous allons réaliser avec vous __2 exercices__, le premier se concentrera sur _les bonnes pratiques_ de programmation en règle générale, tandis que le deuxième vous testera sur _la clean architecture_.

Afin de vous aider dans la réalisation de cette exercice, nous vous fournissons une __librairie__.
Celle-ci est directement dans le projet, en voici la documentation.


![docFile](https://user-images.githubusercontent.com/36131543/148832398-83a73546-a5a5-4453-a20a-d6f57b843f87.jpg)

### Documentation de la librairie fournie :

_src/datamocklib/TxtHelper.java_ :
```java
/**
* retrieve data from a txt file
* @param file the name of the file containing the data
* @return a list of strings, one string being a line of the text file.
*/
List<String> getDataFromTxt(String file);

/**
* Insert a line of data at the end of a txt file
* @param data the line of data you want to add in the file
* @param file the file you want to store the data in
* @return 200 if the operation succeed, 400 if it fails
*/
int insertDataInTxt(String data, String file);
```


---

### Exercice 1
Vous disposez d'une liste de personnes sous la forme du fichier _persons.txt_. Vous devez compléter la fonction PersonParser() dans _MainExercice1.java_ pour convertir les informations en objets _Personne_.

_MainExercice1.java_ :
```java
// Format du fichier : firstName,lastName,birthDate,gender,cityOfResidence,cityOfBirth
// Pas de header
public static List<Person> parse(List<String> data){}
```

_Person.java_ :
```java
public class Person {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String cityOfResidence;
    private String cityOfBirth;
[...]
}
```

---

### Exercice 2
Vous disposez d’une API pour récupérer des données depuis un serveur.
Faites 3 points d’entrées d’une application pour :
  - Récupérer la liste des personnes habitant Chambéry.
  - Récupérer la liste des personnes de plus de 25 ans.
  - Récupérer la liste des personnes habitant leur ville de naissance.
  - Récupérer la liste des femmes de plus de 25 ans.


Voir les consignes dans le fichier MainExercice2.java.

Pour implémenter ces points d’entrées :
  - Pour récuperer les données sur le serveur, on utilise _TxtHelper.getDataFromTxt("server.txt")_
  - Vider la base de données locale grâce à la fonction _TxtHelper.clearDataLocal();_
  - Insérer les données dans la database locale _TxtHelper.insertDataInTxt(String data, String file)_
  - Afficher les données locale grâce à _TxtHelper.getDataFromTxt(data, "local.txt")_;

> Ces functions imitent une connexion à une base de données et simulent une persistance des données en local.


---




