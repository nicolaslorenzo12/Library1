
import java.util.ArrayList;

public class PersonService {

    private final ArrayList<Person> person;

    public PersonService(){
        person = new ArrayList<Person>();
    }


    public Person addPerson(String name, String surname, int numberID){
        Person personToAdd = new Person(name, surname, numberID);
        person.add(personToAdd);
        return personToAdd;
    }


    public ArrayList<Person> getPersons(){
        return person;
    }

    private int findPersonNumber(int number){
        int position = 0;
        int cont = 0;

        while(cont <= person.size()){

            if (person.get(cont).getNumberIDPerson() == number) {
                position = cont;
                cont = person.size();
            }
            cont++;
        }
        return position;
    }

    public String checkName(int number){

        return person.get(findPersonNumber(number)).getNamePerson();
    }

    public String checkSurname(int number){
        return person.get(findPersonNumber(number)).getSurnamePerson();
    }
}
