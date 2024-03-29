package model;

import service.AuthorService;
import service.BookService;
import service.DatabaseService;
import service.MemberService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

// check input information
// check if author is a poet etc when adding a book

public class Admin extends User{
    User LoggedUser;
    ArrayList<User> members = new ArrayList<User>();
    ArrayList<Author> authors = new ArrayList<Author>();
    ArrayList<Book> books = new ArrayList<Book>();

    private static Admin single_instance = null;

    private Admin() {
        LoggedUser = null;
    }

    public Admin(String email, String nickname, String password){
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        LoggedUser = null;
        members = (ArrayList<User>) MemberService.getAllMembers();
        authors = (ArrayList<Author>) AuthorService.getAllAuthors();
        books = (ArrayList<Book>) BookService.getAllBooks();
    }

    public static Admin getInstance(){
        if (single_instance == null){
            single_instance = new Admin("admin", "admin", "admin");
        }
        return single_instance;
    }

    public User getLoggedUser() {
        return LoggedUser;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addMember(User member){
        members.add(member);
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addComic(){
        Scanner read = new Scanner(System.in);
        Author writer = null;
        Author illustrator = null;

        System.out.println("Title: ");
        String myTitle = read.nextLine();
        System.out.println("Language: ");
        String myLanguage = read.nextLine();
        System.out.println("Writer: ");
        String myWriter = read.nextLine();
        System.out.println("Illustrator: ");
        String myIllustrator = read.nextLine();
        System.out.println("Volumes: ");
        String myVolumes = read.nextLine();
        System.out.println("Chapters: ");
        String myChapters = read.nextLine();

        ArrayList<Author> authors = getAuthors();
        boolean ok_1 = false, ok_2 = false;
        while(!ok_1 || !ok_2){
            for(Author author : authors){
                if(Objects.equals(author.getName(), myWriter)){
                    writer = author;
                    ok_1 = true;
                }
                if(Objects.equals(author.getName(), myIllustrator)){
                    illustrator = author;
                    ok_2 = true;
                }
            }
            if (!ok_1){
                System.out.println("The author you have introduced is not valid. Try again or write 'exit' in order to quit this menu.");
                System.out.println("Writer: ");
                myWriter = read.nextLine();
                if(Objects.equals(myWriter, "exit")) return;

            }
            if (!ok_2){
                System.out.println("The author you have introduced is not valid. Try again or write 'exit' in order to quit this menu.");
                System.out.println("Illustrator: ");
                myIllustrator = read.nextLine();
                if(Objects.equals(myIllustrator, "exit")) return;

            }
        }

        Comics comic = new Comics(myTitle, myLanguage, writer, illustrator, parseInt(myVolumes), parseInt(myChapters));

        int writer_id = AuthorService.getAuthorIdByName(writer.getName());
        int illust_id = AuthorService.getAuthorIdByName(illustrator.getName());
        DatabaseService.insertQuery("insert into comics(writer_id, illust_id, title, language, volumes, chapters) values ("+
                writer_id+","+illust_id+", '"+myTitle+"', '"+myLanguage+"', "+ myVolumes+","+myChapters+")");

        addBook(comic);
    }

    public void addIllustration(){
        Scanner read = new Scanner(System.in);
        Author illustrator = null;

        System.out.println("Title: ");
        String myTitle = read.nextLine();
        System.out.println("Language: ");
        String myLanguage = read.nextLine();
        System.out.println("Illustrator: ");
        String myIllustrator = read.nextLine();
        System.out.println("Pages: ");
        String myPages = read.nextLine();

        ArrayList<Author> authors = getAuthors();
        boolean ok = false;
        while(!ok){
            for(Author author : authors){
                if(Objects.equals(author.getName(), myIllustrator)){
                    illustrator = author;
                    ok = true;
                    break;
                }
            }
            if (!ok){
                System.out.println("The author you have introduced is not valid. Try again or write 'exit' in order to quit this menu.");
                System.out.println("Illustrator: ");
                myIllustrator = read.nextLine();
                if(Objects.equals(myIllustrator, "exit")) return;
            }
        }

        Illustrations illust = new Illustrations(myTitle, myLanguage, illustrator, parseInt(myPages));

        int illust_id = AuthorService.getAuthorIdByName(illustrator.getName());
        DatabaseService.insertQuery("insert into illustrations(illust_id, title, language, pages) values ("+
                illust_id+", '"+myTitle+"', '"+myLanguage+"', "+ myPages+")");

        addBook(illust);
    }

    public void addNovel(){
        Scanner read = new Scanner(System.in);
        Author novelist = null;

        System.out.println("Title: ");
        String myTitle = read.nextLine();
        System.out.println("Language: ");
        String myLanguage = read.nextLine();
        System.out.println("Novelist: ");
        String myNovelist = read.nextLine();
        System.out.println("Chapters: ");
        String myChapters = read.nextLine();
        System.out.println("Pages: ");
        String myPages = read.nextLine();

        ArrayList<Author> authors = getAuthors();
        boolean ok = false;
        while(!ok){
            for(Author author : authors){
                if(Objects.equals(author.getName(), myNovelist)){
                    novelist = author;
                    ok = true;
                    break;
                }
            }
            if (!ok){
                System.out.println("The author you have introduced is not valid. Try again or write 'exit' in order to quit this menu.");
                System.out.println("Novelist: ");
                myNovelist = read.nextLine();
                if(Objects.equals(myNovelist, "exit")) return;
            }
        }

        Novel novel = new Novel(myTitle, myLanguage, novelist, parseInt(myChapters), parseInt(myPages));

        int novelist_id = AuthorService.getAuthorIdByName(novelist.getName());
        DatabaseService.insertQuery("insert into novel(novelist_id, title, language, chapters, pages) values ("+
                novelist_id+", '"+myTitle+"', '"+myLanguage+"', "+ myChapters+", "+ myPages+")");

        addBook(novel);
    }

    public void addPoetry(){
        Scanner read = new Scanner(System.in);
        Author poet = null;

        System.out.println("Title: ");
        String myTitle = read.nextLine();
        System.out.println("Language: ");
        String myLanguage = read.nextLine();
        System.out.println("Poet: ");
        String myPoet = read.nextLine();
        System.out.println("Number of poems: ");
        String myPoems = read.nextLine();

        ArrayList<Author> authors = getAuthors();
        boolean ok = false;
        while(!ok){
            for(Author author : authors){
                if(Objects.equals(author.getName(), myPoet)){
                    poet = author;
                    ok = true;
                    break;
                }
            }
            if (!ok){
                System.out.println("The author you have introduced is not valid. Try again or write 'exit' in order to quit this menu.");
                System.out.println("Poet: ");
                myPoet = read.nextLine();
                if(Objects.equals(myPoet, "exit")) return;

            }
        }

        Poetry poetry = new Poetry(myTitle, myLanguage, poet, parseInt(myPoems));

        int poet_id = AuthorService.getAuthorIdByName(poet.getName());
        DatabaseService.insertQuery("insert into poetry(poet_id, title, language, poems) values ("+
                poet_id+", '"+myTitle+"', '"+myLanguage+"', "+ myPoems+")");

        addBook(poetry);
    }
    public void CreateAuthor() {
        Scanner read = new Scanner(System.in);
        ArrayList<AuthorType> author_type = new ArrayList<AuthorType>();

        System.out.println("Name: ");
        String myName = read.nextLine();
        System.out.println("Country of origin: ");
        String myCountry = read.nextLine();
        System.out.println("What kind of author is this?");
        System.out.println("Novelist? (yes/no)");
        String novelist_check = read.nextLine();
        System.out.println("Poet? (yes/no)");
        String poet_check = read.nextLine();
        System.out.println("Illustrator? (yes/no)");
        String illustrator_check = read.nextLine();

        DatabaseService.insertQuery("insert into author(name, country) values ('"+myName+"','"+myCountry+"')");
        int author_id = AuthorService.getAuthorIdByName(myName);

        if (Objects.equals(novelist_check, "yes")) {
            author_type.add(AuthorType.novelist);
            DatabaseService.insertQuery("insert into author_type(author_id, type_id) values ("+author_id+", 1)");
        }
        if (Objects.equals(poet_check, "yes")) {
            author_type.add(AuthorType.poet);
            DatabaseService.insertQuery("insert into author_type(author_id, type_id) values ("+author_id+", 2)");
        }
        if (Objects.equals(illustrator_check, "yes")) {
            author_type.add(AuthorType.illustrator);
            DatabaseService.insertQuery("insert into author_type(author_id, type_id) values ("+author_id+", 3)");
        }

        Author author = new Author(author_type ,myName, myCountry);

        addAuthor(author);
    }

    public void login(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Email: ");
        String myEmail = myObj.nextLine();
        System.out.println("Password: ");
        String myPassword = myObj.nextLine();
        ArrayList<User> members = getMembers();
        for(User member : members){
            if(Objects.equals(member.email, myEmail) && Objects.equals(member.password, myPassword)){
                System.out.println("Welcome, " + member.nickname + "!");
                this.LoggedUser = member;
                return;
            }
        }
        System.out.println("Incorrect information.");
    }

    public void logout(){
        this.LoggedUser = null;
    }

    public void createAccount() throws ParseException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Email: ");
        String myEmail = myObj.nextLine();
        System.out.println("Password: ");
        String myPassword = myObj.nextLine();
        System.out.println("Nickname: ");
        String myName = myObj.nextLine();
        System.out.println("Date of birth (yyyy-mm-dd): ");
        String birthday = myObj.next();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirthday = formatter.parse(birthday);
        ArrayList<User> members = getMembers();
        Member member = new Member(myEmail, myName, myBirthday, myPassword);
        addMember(member);

        int myAge = 20;

        DatabaseService.insertQuery("insert into member(email, nickname, password, birthday, age) values ('"+
                myEmail+"', '"+ myName+"', '"+myPassword+"', {ts '"+ birthday +" 18:47:52.69'} ,"+myAge+")");

    }

}
