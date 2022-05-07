package model;

public final class Comics extends Book{
    private Author writer;
    private Author illustrator;
    private int volumes;
    private int chapters;

    public Comics(String title, String language, Author writer, Author illustrator, int volumes, int chapters) {
        super(title, language);
        this.writer = writer;
        this.illustrator = illustrator;
        this.volumes = volumes;
        this.chapters = chapters;
    }

    public Author getWriter() {
        return writer;
    }

    public void setWriter(Author writer) {
        this.writer = writer;
    }

    public Author getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(Author illustrator) {
        this.illustrator = illustrator;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }
}
