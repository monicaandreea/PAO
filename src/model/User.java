package model;

import java.time.*;
import java.util.Date;

public class User {

    int id;
    String email;
    String nickname;
    String password;
    Date birthday;
    //new Date(2001, 6, 20)
    int age;


    public User() {
    }

    public User(String email, String nickname, Date birthday, String password) {
        this.email = email;
        this.nickname = nickname;
        this.birthday = birthday;
        this.password = password;
        //this.calculateAge();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void calculateAge() {
        //      System.out.println("Enter your date of birth (dd-MM-yyyy): ");
        //      String dob = sc.next();
        //      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //      Date date = formatter.parse(dob);
        Instant instant = birthday.toInstant();
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        LocalDate givenDate = zone.toLocalDate();
        Period period = Period.between(givenDate, LocalDate.now());

        this.age = period.getYears();
    }

    @Override
    public String toString() {
        return "\nNickname='" + nickname + '\'' +
                ", age=" + age +
                ", pass="+ password;
    }
}
