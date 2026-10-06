import java.time.LocalDate;
import java.util.*;

interface LibraryItem {
    LocalDate getDueDate();
    String getTitle();
}

class Book implements LibraryItem {
    String title;
    LocalDate currentDate;

    Book(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate getDueDate() {
        return currentDate.plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    String title;
    LocalDate currentDate;

    DVD(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate getDueDate() {
        return currentDate.plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    String title;
    LocalDate currentDate;

    Magazine(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate getDueDate() {
        return currentDate.plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocalDate currentDate =
                LocalDate.of(2023, 10, 26);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);

            String type = parts[0];
            String title = parts[1];

            // Remove quotes from title
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title, currentDate);
            } else if (type.equals("DVD")) {
                item = new DVD(title, currentDate);
            } else {
                item = new Magazine(title, currentDate);
            }

            System.out.println(
                    item.getTitle() + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}