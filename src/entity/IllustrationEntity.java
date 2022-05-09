package entity;

public class IllustrationEntity {
    private int id;
    private int illust_id;
    private String title;
    private String language;
    private int pages;

    public IllustrationEntity(int id, int illust_id, String title, String language, int pages) {
        this.id = id;
        this.illust_id = illust_id;
        this.title = title;
        this.language = language;
        this.pages = pages;
    }

    public IllustrationEntity() {
    }

    public int getId() {
        return id;
    }

    public int getIllust_id() {
        return illust_id;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public int getPages() {
        return pages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIllust_id(int illust_id) {
        this.illust_id = illust_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "IllustrationEntity{" +
                "id=" + id +
                ", illust_id=" + illust_id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                '}';
    }
}
