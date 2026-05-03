import junit.framework.TestCase;
import java.util.List;

public class LibraryManagementTest extends TestCase {
    private Library lib;
    private User testUser;

    protected void setUp() throws Exception {
        lib = new Library();
        testUser = new User("U1", "Test User");
    }

    public void testEmptyLibrary() {
        assertEquals(0, lib.countBooks());
    }

    public void testAddBook() {
        lib.addBook(new Book("Title", "Author", "1234567890123"));
        assertEquals(1, lib.countBooks());
    }

    public void testInvalidIsbn() {
        try {
            new Book("Title", "Author", "123");
            fail();
        } catch (IllegalArgumentException e) {}
    }

    public void testSearch() {
        lib.addBook(new Book("Java", "Author", "1111111111111"));
        List<Book> result = lib.searchByTitle("Java");
        assertEquals(1, result.size());
    }

    public void testBorrowing() throws Exception {
        String isbn = "1111111111111";
        lib.addBook(new Book("Java", "Author", isbn));
        lib.borrowBook(isbn, testUser);
        assertEquals(1, lib.countLoans());
    }

    public void testBorrowUnavailable() throws Exception {
        String isbn = "1111111111111";
        lib.addBook(new Book("Java", "Author", isbn));
        lib.borrowBook(isbn, testUser);
        try {
            lib.borrowBook(isbn, testUser);
            fail();
        } catch (Exception e) {}
    }
}