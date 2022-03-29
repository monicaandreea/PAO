package utilities;

public class Author {
    AuthorType[] type;
    String name;
    String country;

    public Author() {
    }

    public Author(AuthorType[] type, String name, String country) {
        this.type = type;
        this.name = name;
        this.country = country;
    }

    public AuthorType[] getType() {
        return type;
    }

    public void setType(AuthorType[] type) {
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

}
