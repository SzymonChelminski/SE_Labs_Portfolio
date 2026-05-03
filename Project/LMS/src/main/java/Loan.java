import java.time.LocalDate;

public class Loan {
    private Book book;
    private User user;
    private LocalDate loanDate;

    public Loan(Book book, User user, LocalDate loanDate) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
    }

    public Book getBook() { return book; }
    public User getUser() { return user; }
    public LocalDate getLoanDate() { return loanDate; }
}