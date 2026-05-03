import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public int countBooks() {
        return books.size();
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public void borrowBook(String isbn, User user) throws Exception {
        Book book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new Exception());

        if (!book.isAvailable()) {
            throw new Exception();
        }

        book.setAvailable(false);
        loans.add(new Loan(book, user, LocalDate.now()));
    }

    public int countLoans() {
        return loans.size();
    }
}