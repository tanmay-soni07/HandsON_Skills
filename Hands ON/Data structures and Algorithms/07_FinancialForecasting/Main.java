import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Book[] books = {

                new Book(101, "Algorithms", "Thomas Cormen"),
                new Book(102, "Clean Code", "Robert Martin"),
                new Book(103, "Data Structures", "Narasimha Karumanchi"),
                new Book(104, "Java Programming", "Herbert Schildt"),
                new Book(105, "Operating System", "Galvin")

        };

        System.out.print("Enter Book Title to Search: ");
        String title = sc.nextLine();

        // Linear Search

        Book linearResult = linearSearch(books, title);

        if (linearResult != null) {

            System.out.println("\nBook Found using Linear Search");
            System.out.println(linearResult);

        } else {

            System.out.println("\nBook Not Found (Linear Search)");
        }

        // Sort array before Binary Search

        Arrays.sort(books, Comparator.comparing(book -> book.title));

        Book binaryResult = binarySearch(books, title);

        if (binaryResult != null) {

            System.out.println("Book Found using Binary Search");
            System.out.println(binaryResult);

        } else {

            System.out.println("Book Not Found (Binary Search)");
        }

        sc.close();
    }
}