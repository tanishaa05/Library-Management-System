import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title);
    }

    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println((i + 1) + ". " + b.title + " by " + b.author +
                " | " + (b.isAvailable ? "Available" : "Issued"));
        }
    }

    void issueBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (b.isAvailable) {
                    b.isAvailable = false;
                    System.out.println("Book issued: " + title);
                } else {
                    System.out.println("Book already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void returnBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                b.isAvailable = true;
                System.out.println("Book returned: " + title);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + b.title + " by " + b.author +
                    " | " + (b.isAvailable ? "Available" : "Issued"));
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        // Adding some default books
        lib.addBook("The Alchemist", "Paulo Coelho");
        lib.addBook("Harry Potter", "J.K. Rowling");
        lib.addBook("Clean Code", "Robert Martin");

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Display All Books");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: lib.displayBooks(); break;
                case 2:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    lib.addBook(title, author);
                    break;
                case 3:
                    System.out.print("Enter book title to issue: ");
                    lib.issueBook(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    lib.returnBook(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter book title to search: ");
                    lib.searchBook(sc.nextLine());
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}