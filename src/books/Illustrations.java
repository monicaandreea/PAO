package books;

import utilities.Author;

public final class Illustrations extends Book{
    Author illustrator;
    int pages;

    public Illustrations() {
    }

    public Illustrations(Author illustrator, int pages) {
        this.illustrator = illustrator;
        this.pages = pages;
    }

    public Author getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(Author illustrator) {
        this.illustrator = illustrator;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
