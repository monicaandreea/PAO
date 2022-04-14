package users;
import utilities.ReadingList;
import books.*;
import utilities.ReadingScore;
import utilities.ReadingState;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

//show book by name in list
// daca se poate simplifica update amount read

public class Member extends User{
    ArrayList<ReadingList> list = new ArrayList<ReadingList>();

    public Member(String email, String nickname, Date birthday, String password) {
        super(email, nickname, birthday, password);
    }

    public ArrayList<ReadingList> getList() {
        return list;
    }

    public void addBook(Book book, ReadingState status, int pages, ReadingScore score, Date start_date, Date end_date){
        ReadingList reading = new ReadingList(book, status, pages, score, start_date, end_date);
        list.add(reading);
    }

    public void createBookEntry(String book_name) throws ParseException {
        Scanner read = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        ArrayList<Book> books = Admin.getInstance().getBooks();
        for(Book book : books){
            if(Objects.equals(book.getTitle(), book_name)){
                ArrayList<ReadingList> list = getList();
                for(ReadingList entry : list){
                    if(Objects.equals(entry.getBook().getTitle(), book_name)){
                        System.out.println("The book is already in your list. If you wish to change information, please update it.");
                        return;
                    }
                }

                ReadingList entry = new ReadingList(book);
                addBook(book, null, 0, null, null, null);

                System.out.println("What is the status of this book?");
                System.out.println("1- completed -- 2. reading -- 3. dropped -- 4. plan to read");
                String status = read.nextLine();
                updateStatus(book_name, ReadingState.forInt(parseInt(status)));
                if(Objects.equals(status, "1")){
                    updateAmountRead(book_name, -1);

                    System.out.println("What score do you give this book?");
                    System.out.println("1- masterpiece -- 2. good -- 3. average -- 4. bad -- 5. horrible");
                    String score = read.nextLine();
                    updateScore(book_name, ReadingScore.forInt(parseInt(score)));

                    System.out.println("When did you start reading? (dd-mm-yyyy)");
                    String start_date = read.nextLine();
                    Date start = formatter.parse(start_date);
                    updateStartDate(book_name, start);

                    System.out.println("When did you finish reading? (dd-mm-yyyy)");
                    String end_date = read.nextLine();
                    Date end = formatter.parse(end_date);
                    updateEndDate(book_name, end);
                }
                else if(Objects.equals(status, "4")){
                   updateAmountRead(book_name, 0);
                }
                else{
                    System.out.println("How much have you read?");
                    String value = read.nextLine();
                    updateAmountRead(book_name, parseInt(value));

                    System.out.println("What score do you give this book?");
                    System.out.println("1- masterpiece -- 2. good -- 3. average -- 4. bad -- 5. horrible");
                    String score = read.nextLine();
                    updateScore(book_name, ReadingScore.forInt(parseInt(score)));

                    System.out.println("When did you start reading? (dd-mm-yyyy)");
                    String start_date = read.nextLine();
                    Date start = formatter.parse(start_date);
                    updateStartDate(book_name, start);
                }
                return;
            }
        }
        System.out.println("The title you introduced isn't a book in our system.");
    }

    public void updateScore(String title, ReadingScore score){
        ArrayList<ReadingList> list = getList();
        for(ReadingList entry : list){
            if(Objects.equals(entry.getBook().getTitle(), title)){
                entry.setScore(score);
                return;
            }
        }
        System.out.println(title + " is not in your reading list.");
    }
    public void updateStatus(String title, ReadingState status){
        ArrayList<ReadingList> list = getList();
        for(ReadingList entry : list){
            if(Objects.equals(entry.getBook().getTitle(), title)){
                entry.setStatus(status);
                return;
            }
        }
        System.out.println(title + " is not in your reading list.");
    }

    public void updateAmountRead(String title, int amount){
        ArrayList<ReadingList> list = getList();
        for(ReadingList entry : list){
            if(Objects.equals(entry.getBook().getTitle(), title)){
                if(entry.getBook() instanceof Comics){
                    if(((Comics) entry.getBook()).getVolumes() >= amount){
                        if(amount == -1) {entry.setAmount_read( ((Comics) entry.getBook()).getVolumes());}
                        else entry.setAmount_read(amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Comics) entry.getBook()).getVolumes() + " volumes.");
                    }
                }
                else if(entry.getBook() instanceof Illustrations) {
                    if(((Illustrations) entry.getBook()).getPages() >= amount){
                        if(amount == -1) {entry.setAmount_read( ((Illustrations) entry.getBook()).getPages());}
                        else entry.setAmount_read(amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Illustrations) entry.getBook()).getPages() + " pages.");
                    }
                }
                else if(entry.getBook() instanceof Novel) {
                    if(((Novel) entry.getBook()).getChapters() >= amount){
                        if(amount == -1) {entry.setAmount_read( ((Novel) entry.getBook()).getChapters());}
                        else entry.setAmount_read(amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Novel) entry.getBook()).getChapters() + " chapters.");
                    }
                }
                else if(entry.getBook() instanceof Poetry) {
                    if(((Poetry) entry.getBook()).getNo_poems() >= amount){
                        if(amount == -1) {entry.setAmount_read( ((Poetry) entry.getBook()).getNo_poems());}
                        else entry.setAmount_read(amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Poetry) entry.getBook()).getNo_poems() + " poems.");
                    }
                }
                return;
            }
        }
        System.out.println(title + " is not in your reading list.");
    }

    public void updateDates(String title) throws ParseException {
        Scanner read = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        ArrayList<ReadingList> list = getList();

        for(ReadingList entry : list){
            if(Objects.equals(entry.getBook().getTitle(), title)){
                if (entry.getStatus() == ReadingState.completed){
                    System.out.println("When did you start reading?");
                    System.out.println("Please input the date dd-mm-yyyy or 0 if you don't remember.");

                    String start_date = read.nextLine();
                    if(!Objects.equals(start_date, "0")){
                        Date start = formatter.parse(start_date);
                        updateStartDate(title, start);
                    }

                    System.out.println("When did you finish reading?");
                    System.out.println("Please input the date dd-mm-yyyy or 0 if you don't remember.");

                    String end_date = read.nextLine();
                    if(!Objects.equals(end_date, "0")){
                        Date end = formatter.parse(end_date);
                        updateEndDate(title, end);
                    }
                }
                return;
            }
        }
        System.out.println(title + " is not in your reading list.");
    }

    public void updateStartDate(String title, Date date){
        ArrayList<ReadingList> list = getList();
        for(ReadingList entry : list){
            if(Objects.equals(entry.getBook().getTitle(), title)){
                entry.setStart_date(date);
                return;
            }
        }
        System.out.println(title + " is not in your reading list.");
    }

    public void updateEndDate(String title, Date date){
        ArrayList<ReadingList> list = getList();
        for(ReadingList entry : list){
            if(Objects.equals(entry.getBook().getTitle(), title)){
                entry.setEnd_date(date);
                return;
            }
        }
        System.out.println(title + " is not in your reading list.");
    }

/*
    Functions:
        deleteBook
        addBook
        check if book exists
        show reading list

    */
}
