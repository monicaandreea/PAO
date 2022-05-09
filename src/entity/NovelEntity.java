package entity;

import model.Author;

public class NovelEntity {
    private int id;
    private int novelist_id;
    private String name;
    private String country;
    private String title;
    private String language;
    private int chapters;
    private int pages;

    public NovelEntity(int id, int novelist_id, String name, String country, String title, String language, int chapters, int pages) {
        this.id = id;
        this.novelist_id = novelist_id;
        this.name = name;
        this.country = country;
        this.title = title;
        this.language = language;
        this.chapters = chapters;
        this.pages = pages;
    }

    public NovelEntity() {
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public int getId() {
        return id;
    }

    public int getNovelist_id() {
        return novelist_id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getChapters() {
        return chapters;
    }

    public int getPages() {
        return pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNovelist_id(int novelist_id) {
        this.novelist_id = novelist_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "NovelEntity{" +
                "id=" + id +
                ", novelist_id=" + novelist_id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", chapters=" + chapters +
                ", pages=" + pages +
                '}';
    }
}

