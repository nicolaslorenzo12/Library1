public class Person {

    private String name;
    private String surname;
    private int numberID;

    public Person(String name , String surname, int numberID){
        this.name = name;
        this.surname = surname;
        this.numberID = numberID;
    }

    public String getNamePerson(){
        return name;
    }
    public void setNamePerson(String name){
        this.name = name;
    }
    public String getSurnamePerson(){
        return surname;
    }
    public void setSurnamePerson(String surname){
        this.surname = surname;
    }
    public int getNumberIDPerson(){
        return numberID;
    }
    public void setNumberIDPerson(int numberID){
        this.numberID = numberID;
    }

}
