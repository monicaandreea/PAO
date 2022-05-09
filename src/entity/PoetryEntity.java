package entity;

public class PoetryEntity {
    private int id;
    private int poet_id;
    private String title;
    private String language;
    private int poems;

    public PoetryEntity(int id, int poet_id, String title, String language, int poems) {
        this.id = id;
        this.poet_id = poet_id;
        this.title = title;
        this.language = language;
        this.poems = poems;
    }

    public PoetryEntity() {
    }

    public int getId() {
        return id;
    }

    public int getPoet_id() {
        return poet_id;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public int getPoems() {
        return poems;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPoet_id(int poet_id) {
        this.poet_id = poet_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPoems(int poems) {
        this.poems = poems;
    }

    @Override
    public String toString() {
        return "PoetryEntity{" +
                "id=" + id +
                ", poet_id=" + poet_id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", poems=" + poems +
                '}';
    }
}
