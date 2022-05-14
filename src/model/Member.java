package model;

import entity.BookIdEntity;
import service.AuthorService;
import service.BookService;
import service.DatabaseService;
import service.MemberService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.parseInt;

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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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

                int member_id = MemberService.getMemberIdByName(Admin.getInstance().LoggedUser.nickname);
                BookIdEntity bookIdEntity = BookService.getBookByName(book_name);

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

                    System.out.println("When did you start reading? (yyyy-mm-dd) (Please write '0' if you dont remember.)");
                    String start_date = read.nextLine();

                    System.out.println("When did you finish reading? (yyyy-mm-dd) (Please write '0' if you dont remember.)");
                    String end_date = read.nextLine();

                    if(!Objects.equals("0", end_date) && !Objects.equals("0", start_date)){
                        Date start = formatter.parse(start_date);
                        updateStartDate(book_name, start);

                        Date end = formatter.parse(end_date);
                        updateEndDate(book_name, end);

                        DatabaseService.insertQuery("insert into reading_list(member_id, book_id, status, amount, score, start_date, end_date, type) values ("+
                                member_id+", "+bookIdEntity.getId()+", 'completed', -1, '"+ ReadingScore.forInt(parseInt(score))+
                                "' , {ts '"+ start_date +" 18:47:52.69'}, {ts '"+ end_date +" 18:47:52.69'}, '" + bookIdEntity.getType() +"' )");
                    }
                    else if(Objects.equals("0", end_date)){
                        Date start = formatter.parse(start_date);
                        updateStartDate(book_name, start);

                        DatabaseService.insertQuery("insert into reading_list(member_id, book_id, status, amount, score, start_date, type) values ("+
                                member_id+", "+bookIdEntity.getId()+", 'completed', -1, '"+ ReadingScore.forInt(parseInt(score))+
                                "' , {ts '"+ start_date +" 18:47:52.69'}, '" + bookIdEntity.getType() +"' )");
                    }
                    else if(Objects.equals("0", start_date)){
                        Date end = formatter.parse(end_date);
                        updateEndDate(book_name, end);

                        DatabaseService.insertQuery("insert into reading_list(member_id, book_id, status, amount, score, end_date, type) values ("+
                                member_id+", "+bookIdEntity.getId()+", 'completed', -1, '"+ ReadingScore.forInt(parseInt(score))+
                                "' , {ts '"+ end_date +" 18:47:52.69'}, '" + bookIdEntity.getType() +"' )");
                    }



                }
                else if(Objects.equals(status, "4")){
                   updateAmountRead(book_name, 0);
                    DatabaseService.insertQuery("insert into reading_list(member_id, book_id, status, amount, score, type) values ("+
                            member_id+", "+bookIdEntity.getId()+", 'plan_to_read', 0, 'average', '" + bookIdEntity.getType() +"' )");
                }
                else{
                    System.out.println("How much have you read?");
                    String value = read.nextLine();
                    updateAmountRead(book_name, parseInt(value));

                    System.out.println("What score do you give this book?");
                    System.out.println("1- masterpiece -- 2. good -- 3. average -- 4. bad -- 5. horrible");
                    String score = read.nextLine();
                    updateScore(book_name, ReadingScore.forInt(parseInt(score)));

                    System.out.println("When did you start reading? (yyyy-mm-dd) (Please write '0' if you dont remember.)");
                    String start_date = read.nextLine();

                    if(!Objects.equals("0", start_date)){
                        Date start = formatter.parse(start_date);
                        updateStartDate(book_name, start);

                        if(Objects.equals(status, "2")) {
                            DatabaseService.insertQuery("insert into reading_list(member_id, book_id, status, amount, score, start_date, type) values (" +
                                    member_id + ", " + bookIdEntity.getId() + ", 'reading',"+ value +",'" + ReadingScore.forInt(parseInt(score)) +
                                    "' , {ts '" + start_date + " 18:47:52.69'}, '" + bookIdEntity.getType() + "' )");
                        }
                        else{
                            DatabaseService.insertQuery("insert into reading_list(member_id, book_id, status, amount, score, start_date, type) values (" +
                                    member_id + ", " + bookIdEntity.getId() + ", 'dropped',"+ value +",'" + ReadingScore.forInt(parseInt(score)) +
                                    "' , {ts '" + start_date + " 18:47:52.69'}, '" + bookIdEntity.getType() + "' )");
                        }
                    }
                    else{
                        if(Objects.equals(status, "2")) {
                            DatabaseService.insertQuery("insert into reading_list(member_id, book_id, status, amount, score, type) values (" +
                                    member_id + ", " + bookIdEntity.getId() + ", 'reading',"+ value +",'" + ReadingScore.forInt(parseInt(score)) +
                                    "' , '" + bookIdEntity.getType() + "' )");
                        }
                        else{
                            DatabaseService.insertQuery("insert into reading_list(member_id, book_id, status, amount, score, type) values (" +
                                    member_id + ", " + bookIdEntity.getId() + ", 'dropped',"+ value +",'" + ReadingScore.forInt(parseInt(score)) +
                                    "' , '" + bookIdEntity.getType() + "' )");
                        }
                    }
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

                int member_id = MemberService.getMemberIdByName(Admin.getInstance().LoggedUser.nickname);
                BookIdEntity bookIdEntity = BookService.getBookByName(title);
                DatabaseService.updateQuery("update reading_list set score = '" +
                        score +"' where member_id = " + member_id + " and book_id =" + bookIdEntity.getId());
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

                int member_id = MemberService.getMemberIdByName(Admin.getInstance().LoggedUser.nickname);
                BookIdEntity bookIdEntity = BookService.getBookByName(title);
                DatabaseService.updateQuery("update reading_list set status = '" +
                        status +"' where member_id = " + member_id + " and book_id =" + bookIdEntity.getId());
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
                        if(amount == -1) {
                            entry.setAmount_read( ((Comics) entry.getBook()).getVolumes());
                            MemberService.updateAmountRead(title, ((Comics) entry.getBook()).getVolumes());
                        }
                        else entry.setAmount_read(amount);
                        MemberService.updateAmountRead(title, amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Comics) entry.getBook()).getVolumes() + " volumes.");
                    }
                }
                else if(entry.getBook() instanceof Illustrations) {
                    if(((Illustrations) entry.getBook()).getPages() >= amount){
                        if(amount == -1) {
                            entry.setAmount_read( ((Illustrations) entry.getBook()).getPages());
                            MemberService.updateAmountRead(title, ((Illustrations) entry.getBook()).getPages());
                        }
                        else entry.setAmount_read(amount);
                        MemberService.updateAmountRead(title, amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Illustrations) entry.getBook()).getPages() + " pages.");
                    }
                }
                else if(entry.getBook() instanceof Novel) {
                    if(((Novel) entry.getBook()).getChapters() >= amount){
                        if(amount == -1) {
                            entry.setAmount_read( ((Novel) entry.getBook()).getChapters());
                            MemberService.updateAmountRead(title,  ((Novel) entry.getBook()).getChapters());
                        }
                        else entry.setAmount_read(amount);
                        MemberService.updateAmountRead(title, amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Novel) entry.getBook()).getChapters() + " chapters.");
                    }
                }
                else if(entry.getBook() instanceof Poetry) {
                    if(((Poetry) entry.getBook()).getNo_poems() >= amount){
                        if(amount == -1) {
                            entry.setAmount_read( ((Poetry) entry.getBook()).getNo_poems());
                            MemberService.updateAmountRead(title, ((Poetry) entry.getBook()).getNo_poems());
                        }
                        else entry.setAmount_read(amount);
                        MemberService.updateAmountRead(title, amount);
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<ReadingList> list = getList();
        int member_id = MemberService.getMemberIdByName(Admin.getInstance().LoggedUser.nickname);
        BookIdEntity bookIdEntity = BookService.getBookByName(title);

        for(ReadingList entry : list){
            if(Objects.equals(entry.getBook().getTitle(), title)){
                if (entry.getStatus() == ReadingState.completed){
                    System.out.println("When did you start reading?");
                    System.out.println("Please input the date yyyy-mm-dd or 0 if you don't remember.");

                    String start_date = read.nextLine();
                    if(!Objects.equals(start_date, "0")){
                        Date start = formatter.parse(start_date);

                        DatabaseService.updateQuery("update reading_list set start_date = {ts '"+ start_date +" 18:47:52.69'} where member_id = " +
                                member_id + " and book_id =" + bookIdEntity.getId());

                        updateStartDate(title, start);
                    }

                    System.out.println("When did you finish reading?");
                    System.out.println("Please input the date yyyy-mm-dd or 0 if you don't remember.");

                    String end_date = read.nextLine();
                    if(!Objects.equals(end_date, "0")){
                        Date end = formatter.parse(end_date);

                        DatabaseService.updateQuery("update reading_list set end_date = {ts '"+ end_date +" 18:47:52.69'} where member_id = " +
                                member_id + " and book_id =" + bookIdEntity.getId());


                        updateEndDate(title, end, end_date);
                    }
                }
                else if (entry.getStatus() == ReadingState.reading || entry.getStatus() == ReadingState.dropped){
                    System.out.println("When did you start reading?");
                    System.out.println("Please input the date yyyy-mm-dd or 0 if you don't remember.");

                    String start_date = read.nextLine();
                    if(!Objects.equals(start_date, "0")){
                        try{
                            Date start = formatter.parse(start_date);

                            DatabaseService.updateQuery("update reading_list set start_date = {ts '"+ start_date +" 18:47:52.69'} where member_id = " +
                                    member_id + " and book_id =" + bookIdEntity.getId());

                            updateStartDate(title, start);
                        }
                        catch (ParseException e){
                            System.out.println("Introduced the date wrong. Please try again.");
                            e.printStackTrace();
                        }

                    }
                    }
                else{
                    System.out.println("You have this book set as 'plan to read'. Please change the status first.");
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

    public void updateEndDate(String title, Date date, String... db_date){
        ArrayList<ReadingList> list = getList();
        for(ReadingList entry : list){
            if(Objects.equals(entry.getBook().getTitle(), title)){
                entry.setEnd_date(date);

                int member_id = MemberService.getMemberIdByName(Admin.getInstance().LoggedUser.nickname);
                BookIdEntity bookIdEntity = BookService.getBookByName(title);
                DatabaseService.updateQuery("update reading_list set end_date = {ts '"+ db_date +" 18:47:52.69'} where member_id = " +
                        member_id + " and book_id =" + bookIdEntity.getId());
                return;
            }
        }
        System.out.println(title + " is not in your reading list.");
    }

}
