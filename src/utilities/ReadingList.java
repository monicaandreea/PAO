package utilities;
import books.Book;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReadingList {
    Book book;
    ReadingState status;
    int pages_read;
    ReadingScore score;
    Date start_date;
    Date end_date;

    public ReadingList() {
    }

    public ReadingList(Book book, ReadingState status, int pages_read, ReadingScore score, Date start_date, Date end_date) {
        this.book = book;
        this.status = status;
        this.pages_read = pages_read;
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

    public int getPages_read() {
        return pages_read;
    }

    public void setPages_read(int pages_read) {
        this.pages_read = pages_read;
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
}
