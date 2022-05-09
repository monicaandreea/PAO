package model;

import java.util.Date;

public class ReadingList {
    private Book book;
    private ReadingState status;
    private int amount_read;
    private ReadingScore score;
    private Date start_date;
    private Date end_date;

    public ReadingList(Book book) {
        this.book = book;
        this.status = null;
        this.amount_read = 0;
        this.score = null;
        this.start_date = null;
        this.end_date = null;
    }

    public ReadingList(Book book, ReadingState status, int amount_read, ReadingScore score, Date start_date, Date end_date) {
        this.book = book;
        this.status = status;
        this.amount_read = amount_read;
        this.score = score;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAmount_read() {
        return amount_read;
    }

    public void setAmount_read(int pages_read) {
        this.amount_read = pages_read;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public ReadingState getStatus() {
        return status;
    }

    public void setStatus(ReadingState status) {
        this.status = status;
    }

    public ReadingScore getScore() {
        return score;
    }

    public void setScore(ReadingScore score) {
        this.score = score;
    }

    @Override
    public String toString() {
        String amount_of = null;
        if(this.book instanceof Comics){
            amount_of = "volumes";
        }
        else if(this.book instanceof Illustrations) {
            amount_of = "pages";
        }
        else if(this.book instanceof Novel) {
            amount_of = "chapters";
        }
        else if(this.book instanceof Poetry) {
            amount_of = "no_poems";
        }

        String s = "\n" +
                "Title=" + book.getTitle() +
                ", status=" + status +
                ", " + amount_of + "=" + amount_read +
                ", score=" + score +
                ", start_date=" + start_date +
                ", end_date=" + end_date ;
        return s;
    }
}
