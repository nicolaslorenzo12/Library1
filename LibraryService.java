import java.util.ArrayList;

public class LibraryService {

    private ArrayList<Book> books;
    private PersonService personsService;

    public LibraryService()
    {

        books = new ArrayList<Book>();
        personsService = new PersonService();
    }

    private boolean findBookAvailability(int number){

        boolean found = false;
        int index = 0;

        while(index < books.size() && !found){

            Book book = books.get(index);
            if (book.getNumber() == number && book.getAvailability()) {
                found = true;
            }
            index++;
        }
        return found;
    }

    private int findBookPosition(int number){

        int position = 0;
        int cont = 0;

        while(cont <= books.size()){

            if (books.get(cont).getNumber() == number) {
                position = cont;
                cont = books.size();
            }
            cont++;
        }
        return position;
    }



    public Book addBook(String name, String author, boolean availability, int bookNumber){
        Book newBookToAdd = new Book(name, author, availability, bookNumber);
        books.add(newBookToAdd);
        return newBookToAdd;
    }


    public ArrayList<Book> getBooks(){
        return books;
    }

    public PersonService getPersonsService(){
        return personsService;
    }

    public boolean checkAvailability(int number){
        return  findBookAvailability(number);
    }



    public String checkRentability(int number){
        String message;
        boolean found = findBookAvailability(number);

        if(found){
            message = "You just rented this book";
            books.get(findBookPosition(number)).setAvailability(false);
        }
        else{
            message = "There should be a mistake, this book is already rented";
        }
        return message;
    }

    public String lendOut(int number){
        String message;
        boolean found = findBookAvailability(number);

        if (found) {
            message = "There should be a mistake, this book is available";
        }
        else{
            message = "You just lent out this book";
            books.get(findBookPosition(number)).setAvailability(true);
        }

        return message;
    }

    public Book addNewBooks(String name, String author, boolean availability, int bookNumber){
        Book newBookToAdd = new Book(name, author, availability, bookNumber);
        books.add(newBookToAdd);
        return newBookToAdd;
    }


}