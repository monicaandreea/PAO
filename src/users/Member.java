package users;
import utilities.ReadingList;
import books.*;
import utilities.ReadingScore;
import utilities.ReadingState;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

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

    public void createBookEntry(){
        // TO DO
        // read book title
        // read status
        // read amount read
        // read score
        // read dates
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
                // check if its smaller than pages/vols of book
                if(entry.getBook() instanceof Comics){
                    if(((Comics) entry.getBook()).getVolumes() >= amount){
                        entry.setAmount_read(amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Comics) entry.getBook()).getVolumes() + " volumes.");
                    }
                }
                else if(entry.getBook() instanceof Illustrations) {
                    if(((Illustrations) entry.getBook()).getPages() >= amount){
                        entry.setAmount_read(amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Illustrations) entry.getBook()).getPages() + " pages.");
                    }
                }
                else if(entry.getBook() instanceof Novel) {
                    if(((Novel) entry.getBook()).getChapters() >= amount){
                        entry.setAmount_read(amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Novel) entry.getBook()).getChapters() + " chapters.");
                    }
                }
                else if(entry.getBook() instanceof Poetry) {
                    if(((Poetry) entry.getBook()).getNo_poems() >= amount){
                        entry.setAmount_read(amount);
                        return;
                    }
                    else{
                        System.out.println("Number is bigger than expected. Book has "+ ((Poetry) entry.getBook()).getNo_poems() + " poems.");
                    }
                }
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
