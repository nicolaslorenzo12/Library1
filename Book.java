public class Book {

    private String name;
    private String author;
    private boolean availability;
    private int number;

    public Book(String name, String author, boolean availability, int number) {
        this.name = name;
        this.author = author;
        this.availability = availability;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public boolean getAvailability(){
        return availability;
    }

    public void setAvailability(boolean availability){
        this.availability = availability;
    }

    public void setNumber(int number){
        this.number = number;
    }
    public int getNumber(){
        return number;
    }


}
