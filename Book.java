public class Book {
      private String id;
    private String title;
    private String author;

    public Book(String id, String title, String author) {
        this.id = id.trim();
        this.title = title.trim();
        this.author = author.trim();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String toFileString() {
        return id + "," + title + "," + author;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Author: " + author;
    }
    
}
