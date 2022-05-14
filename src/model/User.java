package model;

import java.text.SimpleDateFormat;
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
        this.calculateAge();
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

    public static LocalDate asLocalDate(java.util.Date date) {
        return date == null ? null : LocalDate.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }
    
    public void calculateAge() {
        //      System.out.println("Enter your date of birth (dd-MM-yyyy): ");
        //      String dob = sc.next();
        //      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //      Date date = formatter.parse(dob);
        //        System.out.println(bday.getClass().getSimpleName());
        //        Instant instant = bday.toInstant();
        //        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        //        LocalDate givenDate = zone.toLocalDate();
        //        Period period = Period.between(givenDate, LocalDate.now());
        LocalDate bday = asLocalDate(birthday);
        LocalDate date = LocalDate.now();
        Period period = bday.until(date);

        this.age = period.getYears();
    }

    @Override
    public String toString() {
        return "Nickname: " + nickname + ", age: " + age +
                ", email: "+ email;
    }
}
