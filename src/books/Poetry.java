package books;

import utilities.Author;

public final class Poetry extends Book{
    Author poet;
    int no_poems;

    public Poetry() {
    }

    public Poetry(Author poet, int no_poems) {
        this.poet = poet;
        this.no_poems = no_poems;
    }

    public Author getPoet() {
        return poet;
    }

    public void setPoet(Author poet) {
        this.poet = poet;
    }

    public int getNo_poems() {
        return no_poems;
    }

    public void setNo_poems(int no_poems) {
        this.no_poems = no_poems;
    }
}
