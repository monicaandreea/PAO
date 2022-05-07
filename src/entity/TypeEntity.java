package entity;

public class TypeEntity {
    private int author_id;
    private int type_id;

    public TypeEntity(int author_id, int type_id) {
        this.author_id = author_id;
        this.type_id = type_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "TypeEntity{" +
                "author_id=" + author_id +
                ", type_id=" + type_id +
                '}';
    }
}
