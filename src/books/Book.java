package books;

public sealed class Book permits Novel, Poetry, Comics, Illustrations{
    String title;
    String language;

    public Book(String title, String language) {
        this.title = title;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
