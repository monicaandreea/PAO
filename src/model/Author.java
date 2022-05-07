package model;

import java.util.ArrayList;

public class Author {
    private int id;
    private ArrayList<AuthorType> type;
    private String name;
    private String country;

    public Author() {
    }

    public Author(ArrayList<AuthorType> type, String name, String country) {
        this.type = type;
        this.name = name;
        this.country = country;
    }

    public Author(int id, ArrayList<AuthorType> type, String name, String country) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.country = country;
    }

    public ArrayList<AuthorType> getType() {
        return type;
    }

    public void setType(ArrayList<AuthorType> type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                "type=" + type +
                '}';
    }
}
