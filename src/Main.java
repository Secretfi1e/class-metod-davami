
import java.util.Scanner;

public class Main {

    static Book[] books = new Book[2];

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Secim edin");
            System.out.println("1 - butun kitablara bax");
            System.out.println("2 - Kitab elave et");
            System.out.println("3 - Searching et");

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    showBooks();
                    break;

                case 2:
                    addBook();
                    System.out.println("Yeniden elave etmek istersinizmi");
                    break;

                case 3:
                    Searching();
                    break;


            }
        }
    }

    public static void showBooks() {
        for (Book book : books) {
            if (book != null) {
                System.out.println("Name :" + book.name + " price :" + book.price + " count " + book.count);
            }
        }
    }

    public static void addBook() {
        String bookName = scanner.nextLine();
        int bookCount = scanner.nextInt();
        int bookPrice = scanner.nextInt();


        Book book = new Book(bookName, bookPrice, bookCount);
        boolean hasEmpty = true;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                hasEmpty = false;
                break;
            }
        }

        if (hasEmpty) {
            Book[] newBook = new Book[books.length * 2];
            for (int i = 0; i < books.length; i++) {
                newBook[i] = books[i];
            }
            int setToIndex = books.length;
            books = newBook;
            books[setToIndex] = book;

        }

    }

    public static void Searching() {
        System.out.println("Price daxil edin: ");
        int searchPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Name daxil edin: ");
        String searchName = scanner.nextLine();


        for (Book book : books) {
            if (book != null) {

                if (book.name.equals(searchName) || book.price == searchPrice) {


                    System.out.println("Axtarılan item tapıldı: " + book.name + " - " + book.price);
                    break;
                } else
                    System.out.println("Axtarilan item tapilmadi: ");
                break;

            }
        }
    }


}







