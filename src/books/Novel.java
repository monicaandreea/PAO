package books;

import utilities.Author;

public final class Novel extends Book{
    Author novelist;
    int chapters;
    int pages;

    public Novel() {
    }

    public Novel(Author novelist, int chapters, int pages) {
        this.novelist = novelist;
        this.chapters = chapters;
        this.pages = pages;
    }

    public Author getNovelist() {
        return novelist;
    }

    public void setNovelist(Author novelist) {
        this.novelist = novelist;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
