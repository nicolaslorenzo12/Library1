import org.w3c.dom.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Library {

    private LibraryService libraryService;
    private PersonService personsService;

    public  Library() {

        libraryService = new LibraryService();
        libraryService.addBook("Harry Potter", "JK Rowling",  true, 1);
        libraryService.addBook("To Kill a Mockingbird", "Harper Lee", true, 2);
        libraryService.addBook("Things Fall Apart", "Chinua Achebe", false, 3);
        libraryService.addBook("Moby-Dick", "Herman Melville", true, 4);
        libraryService.addBook("The Color Purple", "Alice Walker", false, 5);
        libraryService.addBook("Catch-22", "Joseph Heller", false, 6);
        libraryService.addBook("Atlas Shrugged", "Ayn Rand", true, 7);
        libraryService.addBook("1984", "George Orwell", true, 8);
        libraryService.addBook("Hamlet", "William Shakespeare", false, 9);
        libraryService.addBook("The Catcher in the Rye", "J.D. Salinger", true, 10);

        personsService = libraryService.getPersonsService();

        personsService.addPerson("Nicolas", "Lorenzo", 1 );
        personsService.addPerson("Patricia", "Hernandez", 2 );
        personsService.addPerson("Gabriela", "Marques", 3 );
        personsService.addPerson("Martijn", "Wouters", 4 );
        try {
            File file = new File("src/test.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            String name = document.getElementsByTagName("book").item(0).getChildNodes().item(1).getNodeName();

            System.out.println("i hate java");

        }
        catch (Exception exception)
        {
            System.out.println("i hate java");

        }


    }

    public static void main(String[] args) {
        System.out.println("Welcome to my library");
        Library nico = new Library();
        nico.Register();
        nico.Welcome();

    }




    public void Register(){
        Scanner scanner  = new Scanner(System.in);
        int answer = 20;
        ArrayList<Person> persons =  personsService.getPersons();

        while(answer != 0){
            System.out.println("Please if you are already registered enter your number, otherwise, please enter 0 to register yourself");
            answer = Integer.parseInt(scanner.nextLine());
            if(answer == 0){
                System.out.println("Please enter your name");
                String name = scanner.nextLine();
                System.out.println("Please enter your surname");
                String surname = scanner.nextLine();

                int numberID = persons.size() + 1;

                personsService.addPerson(name, surname, numberID);

                System.out.println( "Welcome " + persons.get(numberID - 1).getNamePerson() + " " +  persons.get(numberID - 1).getSurnamePerson() + " your numberID is " + persons.get(numberID-1).getNumberIDPerson() );
            }

            else if(answer > persons.size()){
                System.out.println("This is not a valid number");
            }
            else  if(answer <= persons.size() && answer != 0){
                System.out.println("Welcome " + personsService.checkName(answer) + " " + personsService.checkSurname(answer));
                answer = 0;
            }

        }

    }


    public void Welcome(){

        String choose = "";
        Library nico = new Library();
        Scanner scanner  = new Scanner(System.in);

        while(!choose.equals("exit")) {


            System.out.println("Please enter showallthebooks if you want to see all the books, enter availability to see the availability of a book, enter rent if you want to rent a book, enter lend out if you want to lend out a book, enter add if you want to add a book or enter remove if you want to remove a book.");
            choose = scanner.nextLine();

            if (choose.equals("showallthebooks")) {
                nico.showAllBooks();
            } else if (choose.equals("availability")) {
                nico.showAvailability();
            } else if (choose.equals("rent")) {
                nico.showRentability();
            } else if (choose.equals("lend out")) {
                nico.showLendOut();
            } else if (choose.equals("add")) {
                nico.addingNewBooks();
            } else if (choose.equals("remove")) {
                nico.removingBooks();
            }
            else{
                if(!choose.equals("exit"))
                    System.out.println("Please enter a valid string");
            }


        }
    }

    public void showAllBooks(){

        ArrayList<Book> books = libraryService.getBooks();

        for (Book book : books) {
            System.out.println("#" + book.getNumber() + " " + book.getName() + " of " + book.getAuthor());
        }
    }

    public void showAvailability(){
        int number = 1;
        ArrayList<Book> books = libraryService.getBooks();
        Scanner scanner  = new Scanner(System.in);


        while(number != 0){
            System.out.println("Please enter a valid number of the book you want to check.If you do not want to check more please enter 0");
            number = Integer.parseInt(scanner.nextLine());

            if(number > books.size()){
                System.out.println("Not a valid number");
            }
            else if(number <= books.size() && number != 0){
                System.out.println(libraryService.checkAvailability(number));
            }
        }
    }

    public void showRentability(){
        int number = 1;
        ArrayList<Book> books = libraryService.getBooks();
        Scanner scanner  = new Scanner(System.in);

        while(number != 0){
            System.out.println("Please enter a valid number of the book you want to rent.If you do not want to check more please enter 0");
            number = Integer.parseInt(scanner.nextLine());

            if(number > books.size()){
                System.out.println("Not a valid number");
            }
            else if(number <= books.size() && number != 0){
                System.out.println(libraryService.checkRentability(number));
            }
        }
        System.out.println();
    }

    public void showLendOut(){
        int number = 1;
        ArrayList<Book> books = libraryService.getBooks();
        Scanner scanner  = new Scanner(System.in);

        while(number != 0){
            System.out.println("Please enter a valid number of the book you want to lend out.If you do not want to check more please enter 0");
            number = Integer.parseInt(scanner.nextLine());

            if(number > books.size()){
                System.out.println("Not a valid number");
            }
            else if(number <= books.size() && number != 0){
                System.out.println(libraryService.lendOut(number));
            }
        }
    }

    public void addingNewBooks(){
        System.out.println("Please enter the number of books you want to add, if you do not want to add books please enter 0");
        ArrayList<Book> books = libraryService.getBooks();
        Scanner scanner  = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int cont = 1;
        String name;
        String author;
        int bookNumber;
        bookNumber = books.size() + 1;
        while(cont <= number){
            System.out.println("Please enter the name of the new book");
            name = scanner.nextLine();
            System.out.println("Please enter the author of the new book");
            author = scanner.nextLine();

            libraryService.addBook(name, author, true, bookNumber);
            System.out.println("#" + books.get(bookNumber - 1).getNumber() + " " +  books.get(bookNumber - 1).getName() + " of " + books.get(bookNumber - 1).getAuthor() + " was already added");
            bookNumber++;
            cont++;
        }

    }

    public void removingBooks(){
        ArrayList<Book> books = libraryService.getBooks();
        Scanner scanner  = new Scanner(System.in);
        int number = 1;

        while(number != 0){
            System.out.println("Please enter a valid number of the book you want to remove, if you do not want to remove more please enter 0");
            number = Integer.parseInt(scanner.nextLine());
            boolean found = false;
            int index = 0;

            while(index < books.size() && !found){
                if(books.get(index).getNumber() == number){
                    found = true;
                    books.remove(index);
                    System.out.println("This books was deleted");
                }
                index++;
            }

            if(!found){
                System.out.println("This is not a valid number");
            }

        }

    }


}

