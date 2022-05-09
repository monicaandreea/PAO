package entity;

public class ComicsEntity {
    private int id;
    private int writer_id;
    private int illust_id;
    private String title;
    private String language;
    private int volumes;
    private int chapters;

    public ComicsEntity(int id, int writer_id, int illust_id, String title, String language, int volumes, int chapters) {
        this.id = id;
        this.writer_id = writer_id;
        this.illust_id = illust_id;
        this.title = title;
        this.language = language;
        this.volumes = volumes;
        this.chapters = chapters;
    }

    public ComicsEntity() {
    }

    public int getId() {
        return id;
    }

    public int getWriter_id() {
        return writer_id;
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

    public int getVolumes() {
        return volumes;
    }

    public int getChapters() {
        return chapters;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
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

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "ComicsEntity{" +
                "id=" + id +
                ", writer_id=" + writer_id +
                ", illust_id=" + illust_id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", volumes=" + volumes +
                ", chapters=" + chapters +
                '}';
    }
}
