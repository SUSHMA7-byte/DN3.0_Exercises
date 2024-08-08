package Data_Structures_and_Algorithms.LibraryMgmtSystem;

import java.util.*;

public class LibraryManagementSystem {

    static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    // Linear Search Implementation
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search Implementation
    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Setup
        Book[] books = {
                new Book(1, "Introduction to Algorithms", "Thomas H. Cormen"),
                new Book(2, "Effective Java", "Joshua Bloch"),
                new Book(3, "The Art of Computer Programming", "Donald E. Knuth"),
                new Book(4, "Clean Code", "Robert C. Martin"),
                new Book(5, "Design Patterns", "Erich Gamma")
        };

        // Sort books by title for binary search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        // Linear Search
        String searchTitleLinear = "Effective Java";
        System.out.println("Linear Search:");
        Book resultLinear = linearSearch(books, searchTitleLinear);
        System.out.println(resultLinear != null ? resultLinear : "Book not found.");

        // Binary Search
        String searchTitleBinary = "Clean Code";
        System.out.println("\nBinary Search:");
        Book resultBinary = binarySearch(books, searchTitleBinary);
        System.out.println(resultBinary != null ? resultBinary : "Book not found.");
    }
}
