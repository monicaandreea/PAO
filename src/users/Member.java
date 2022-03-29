package users;
import utilities.ReadingList;
import books.*;
import utilities.ReadingState;

import java.util.Date;


public class Member extends User{
    ReadingList[] list;

    public Member(ReadingList[] list) {
        this.list = list;
    }

    public Member(String email, String nickname, Date birthday, ReadingList[] list) {
        super(email, nickname, birthday);
        this.list = list;
    }

    public ReadingList[] getList() {
        return list;
    }

    public void setList(ReadingList[] list) {
        this.list = list;
    }

    public void addBook(ReadingList book){

    }

    public void deleteBook(String title){

    }

    public void updateStatus(String title, ReadingState status){

    }
/*
    public void updateScore{

    }

    public void updateDates{

    }

    public void updatePages{

    }*/
}
