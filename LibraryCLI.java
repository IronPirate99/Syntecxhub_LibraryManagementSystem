import java.util.List;
import java.util.Scanner;

public class LibraryCLI {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {

        library.setBooks(FileManager.loadBooks());

        while (true) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addBook();
                case "2" -> removeBook();
                case "3" -> searchBook();
                case "4" -> viewBooks();
                case "5" -> exitProgram();
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Book");
        System.out.println("4. View All Books");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();

        if (id.isEmpty()) {
            System.out.println("Book ID cannot be empty.");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Title and author cannot be empty.");
            return;
        }

        Book book = new Book(id, title, author);

        if (library.addBook(book)) {
            FileManager.saveBooks(library.getBooks());
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book with this ID already exists.");
        }
    }

    private static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        String id = scanner.nextLine();

        if (library.removeBook(id)) {
            FileManager.saveBooks(library.getBooks());
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchBook() {
        System.out.print("Enter Book ID or Title: ");
        String keyword = scanner.nextLine();

        List<Book> results = library.searchBook(keyword);

        if (results.isEmpty()) {
            System.out.println("No matching books found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void viewBooks() {
        if (library.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        library.getBooks().forEach(System.out::println);
    }

    private static void exitProgram() {
        FileManager.saveBooks(library.getBooks());
        System.out.println("Exiting program. Goodbye!");
        System.exit(0);
    }
}
