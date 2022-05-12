package entity;

public class BookIdEntity {
    int id;
    String title;
    String type;

    public BookIdEntity(int id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public BookIdEntity() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BookIdEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
