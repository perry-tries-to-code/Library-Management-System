import java.util.*;

public class LibraryManagement {

    static class Book {
        int id;
        String name;
        boolean issued;

        Book(int id, String name) {
            this.id = id;
            this.name = name;
            this.issued = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    books.add(new Book(id, name));
                    System.out.println("Book added!");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book b : books) {
                            System.out.println("ID: " + b.id +
                                    " | Name: " + b.name +
                                    " | Issued: " + (b.issued ? "Yes" : "No"));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    boolean found = false;

                    for (Book b : books) {
                        if (b.id == issueId) {
                            found = true;
                            if (!b.issued) {
                                b.issued = true;
                                System.out.println("Book issued!");
                            } else {
                                System.out.println("Already issued.");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    boolean found2 = false;

                    for (Book b : books) {
                        if (b.id == returnId) {
                            found2 = true;
                            if (b.issued) {
                                b.issued = false;
                                System.out.println("Book returned!");
                            } else {
                                System.out.println("Not issued.");
                            }
                        }
                    }

                    if (!found2) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
