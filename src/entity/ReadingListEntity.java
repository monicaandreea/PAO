package entity;

import model.Book;
import model.ReadingScore;
import model.ReadingState;

import java.util.Date;

public class ReadingListEntity {
    private int id;
    private int member_id;
    private int book_id;
    private String status;
    private int amount_read;
    private String score;
    private Date start_date;
    private Date end_date;
    private String type;

    public ReadingListEntity(int id, int member_id, int book_id, String status, int amount_read, String score, Date start_date, Date end_date, String type) {
        this.id = id;
        this.member_id = member_id;
        this.book_id = book_id;
        this.status = status;
        this.amount_read = amount_read;
        this.score = score;
        this.start_date = start_date;
        this.end_date = end_date;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getMember_id() {
        return member_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getStatus() {
        return status;
    }

    public int getAmount_read() {
        return amount_read;
    }

    public String getScore() {
        return score;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount_read(int amount_read) {
        this.amount_read = amount_read;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReadingListEntity{" +
                "id=" + id +
                ", member_id=" + member_id +
                ", book_id=" + book_id +
                ", status='" + status + '\'' +
                ", amount_read=" + amount_read +
                ", score='" + score + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", type='" + type + '\'' +
                '}';
    }
}
