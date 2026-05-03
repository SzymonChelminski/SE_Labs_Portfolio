public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        if (isbn == null || !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}