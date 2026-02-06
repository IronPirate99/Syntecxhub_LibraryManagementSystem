import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(book.getId())) {
                return false;
            }
        }
        books.add(book);
        return true;
    }

    public boolean removeBook(String id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId().equalsIgnoreCase(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Book> searchBook(String keyword) {
        List<Book> results = new ArrayList<>();
        keyword = keyword.toLowerCase();

        for (Book book : books) {
            if (book.getId().toLowerCase().contains(keyword) ||
                book.getTitle().toLowerCase().contains(keyword)) {
                results.add(book);
            }
        }
        return results;
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }
}
