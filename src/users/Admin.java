package users;
import books.Book;
import jdk.swing.interop.SwingInterOpUtils;
import utilities.Author;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

// check input information

public class Admin extends User{
    User LoggedUser;
    ArrayList<Member> members = new ArrayList<Member>();
    ArrayList<Author> authors = new ArrayList<Author>();
    ArrayList<Book> books = new ArrayList<Book>();

    public Admin() {
        LoggedUser = null;
    }

    public User getLoggedUser() {
        return LoggedUser;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void login(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Email: ");
        String myEmail = myObj.nextLine();
        System.out.println("Password: ");
        String myPassword = myObj.nextLine();
        ArrayList<Member> members = getMembers();
        for(Member member : members){
            if(Objects.equals(member.email, myEmail) && Objects.equals(member.password, myPassword)){
                System.out.println("Welcome, " + member.nickname + "!");
                this.LoggedUser = member;
                return;
            }
        }
        System.out.println("Incorrect information.");
        login();
    }

    public void createAccount() throws ParseException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Email: ");
        String myEmail = myObj.nextLine();
        System.out.println("Password: ");
        String myPassword = myObj.nextLine();
        System.out.println("Nickname: ");
        String myName = myObj.nextLine();
        System.out.println("Date of birth (dd-mm-yyyy): ");
        String birthday = myObj.next();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date myBirthday = formatter.parse(birthday);
        ArrayList<Member> members = getMembers();
        Member member = new Member(myEmail, myName, myBirthday, myPassword);
        addMember(member);

    }

    /*
    Functions:
        login
        remove book
        remove author
        remove member
        show books
        show authors
        show memebers
     */
}
