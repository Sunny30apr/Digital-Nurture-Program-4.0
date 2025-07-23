import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title.toLowerCase();
        this.author = author;
    }

    @Override
    public String toString() {
        return "[" + bookId + "] \"" + title + "\" by " + author;
    }
}



class Library {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        title = title.toLowerCase();

        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = books[mid].title.compareTo(title);

            if (compare == 0)
                return books[mid];
            else if (compare < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void sortBooksByTitle(Book[] books) {
        Arrays.sort(books, Comparator.comparing(b -> b.title));
    }
}

public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book(101, "Java Programming", "James Gosling"),
                new Book(102, "Data Structures", "Mark Allen"),
                new Book(103, "Operating Systems", "Abraham Silberschatz"),
                new Book(104, "Database Systems", "Raghu Ramakrishnan"),
                new Book(105, "Computer Networks", "Andrew Tanenbaum")
        };
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book name to search >> ");
        str = sc.nextLine();
        System.out.println("Linear Search for "+str);
        Book found1 = Library.linearSearch(books, str);
        System.out.println(found1 != null ? found1 : "Book not found");

        Library.sortBooksByTitle(books);

        System.out.println("\nBinary Search for "+str);
        Book found2 = Library.binarySearch(books, str);
        System.out.println(found2 != null ? found2 : "Book not found");
    }
}
