package entity;

import java.util.Date;

public class MemberEntity {
    int id;
    String email;
    String nickname;
    String password;
    Date birthday;
    int age;

    public MemberEntity(int id, String email, String nickname, String password, Date birthday, int age) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }
}
