import com.workintech.bookCollection.Book;
import com.workintech.bookCollection.Magazines;
import com.workintech.bookCollection.Novel;
import com.workintech.bookCollection.StudyBooks;
import com.workintech.libraryManagement.*;
import com.workintech.persons.Person;
import com.workintech.persons.Reader;
import jdk.jfr.Category;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Library library = new Library();
        Librarian librarian = new Librarian("samet");


        Object[][] novelsData = DataBase.novelsData;

        for (int i = 0; i < novelsData.length; i++) {
            int id = (int) novelsData[i][0];
            String author = (String) novelsData[i][1];
            String title = (String) novelsData[i][2];
            double price = (double) novelsData[i][3];
            String edition = (String) novelsData[i][4];
            String category = (String) novelsData[i][5];
            Book novel = new Novel(id, author, title, price, edition, category);
            Library.newBook(novel);
            if (Library.getCategories().containsKey(novel.getCategory())) {
                Map<Integer, Book> categoryBooks = Library.getCategories().get(category);
                categoryBooks.put(id, novel);
            } else {
                Map<Integer, Book> categoryBooks = new HashMap<>();
                categoryBooks.put(id, novel);
                Library.getCategories().put(category, categoryBooks);

            }
            if (Library.getAuthors().containsKey(novel.getAuthor())) {
                Map<Integer, Book> authorBooks = Library.getAuthors().get(author);
                authorBooks.put(id, novel);
            } else {

                Map<Integer, Book> authorBooks = new HashMap<>();
                authorBooks.put(id, novel);
                Library.getAuthors().put(author, authorBooks);

            }

        }
        Object[][] studyBooksData = DataBase.studyBooksData;


        for (int i = 0; i < studyBooksData.length; i++) {
            int id = (int) studyBooksData[i][0];
            String author = (String) studyBooksData[i][1];
            String title = (String) studyBooksData[i][2];
            double price = (double) studyBooksData[i][3];
            String edition = (String) studyBooksData[i][4];
            String category = (String) studyBooksData[i][5];

            Book studyBook = new StudyBooks(id, author, title, price, edition, category);
            Library.newBook(studyBook);

            if (Library.getCategories().containsKey(studyBook.getCategory())) {
                Map<Integer, Book> categoryBooks = Library.getCategories().get(category);
                categoryBooks.put(id, studyBook);
            } else {

                Map<Integer, Book> categoryBooks = new HashMap<>();
                categoryBooks.put(id, studyBook);
                Library.getCategories().put(category, categoryBooks);

            }


            if (Library.getAuthors().containsKey(studyBook.getAuthor())) {
                Map<Integer, Book> authorBooks = Library.getAuthors().get(author);
                authorBooks.put(id, studyBook);
            } else {

                Map<Integer, Book> authorBooks = new HashMap<>();
                authorBooks.put(id, studyBook);
                Library.getAuthors().put(author, authorBooks);

            }


        }

        Object[][] magazineData = DataBase.magazinesData;

        for (int i = 0; i < magazineData.length; i++) {
            int id = (int) magazineData[i][0];
            String author = (String) magazineData[i][1];
            String title = (String) magazineData[i][2];
            double price = (double) magazineData[i][3];
            String edition = (String) magazineData[i][4];
            String category = (String) magazineData[i][5];

            Book magazine = new Magazines(id, author, title, price, edition, category);
            Library.newBook(magazine);


            if (Library.getCategories().containsKey(magazine.getCategory())) {
                Map<Integer, Book> categoryBooks = Library.getCategories().get(category);
                categoryBooks.put(id, magazine);
            } else {

                Map<Integer, Book> categoryBooks = new HashMap<>();
                categoryBooks.put(id, magazine);
                Library.getCategories().put(category, categoryBooks);
            }


            if (Library.getAuthors().containsKey(magazine.getAuthor())) {
                Map<Integer, Book> authorBooks = Library.getAuthors().get(author);
                authorBooks.put(id, magazine);
            } else {

                Map<Integer, Book> authorBooks = new HashMap<>();
                authorBooks.put(id, magazine);
                Library.getAuthors().put(author, authorBooks);

            }

        }
        Object[][] readersData = DataBase.readersData;
        for (Object[] readerData : readersData) {
            String name = (String) readerData[0];
            Member_Record record = (Member_Record) readerData[1];
            Library.addReader(new Reader(name, record, new ArrayList<>()));
        }


        System.out.println("***********************");


        Set<String> categoriesKeys = Library.getCategories().keySet();

        for (String key : categoriesKeys) {
            System.out.println("*****************" + key.toUpperCase() + "*****************");

            Map<Integer, Book> categoryMap = Library.getCategories().get(key);
            if (categoryMap != null) {
                Set<Integer> bookKeys = categoryMap.keySet();

                for (Integer bookKey : bookKeys) {
                    System.out.println(categoryMap.get(bookKey).toString());
                }
            } else {
                System.out.println("Bu kategoride hiç kitap yok: " + key);
            }
        }


        Set<String> authorKeys = Library.getAuthors().keySet();

        for (String key : authorKeys) {
            System.out.println("*****************" + key.toUpperCase() + "*****************");

            Map<Integer, Book> authorMap = Library.getAuthors().get(key);
            if (authorMap != null) {
                Set<Integer> bookKeys = authorMap.keySet();

                for (Integer bookKey : bookKeys) {
                    System.out.println(authorMap.get(bookKey).toString());
                }
            } else {
                System.out.println("Bu yazara ait hiç kitap yok: " + key);
            }
        }


        Set<Integer> readerKeys = Library.getReaders().keySet();

        for (Integer key : readerKeys) {
            System.out.println(Library.getReaders().get(key).getRecord().toString());
        }

        System.out.println(readerKeys.size());


        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");


        LibrarySystem system = new LibrarySystem();

        while (true) {

            Scanner scanner = new Scanner(System.in);

            int choice = 0;

            system.setChoice(choice);


            while (choice != 8) {
                System.out.println("Kütüphane Sistemi");
                System.out.println("1. Kitap Ekle");
                System.out.println("2. Kitapları Göster");
                System.out.println("3. Kitap Güncelle");
                System.out.println("4. Kitap Sil");
                System.out.println("5. Kitap Ödünç Al");
                System.out.println("6. Kitap Geri İade Et");
                System.out.println("7. Bir yazara ait kitapları listele");
                System.out.println("8. Çıkış");
                System.out.print("Seçiminizi yapın: ");
                choice = scanner.nextInt();

                scanner.nextLine();


                switch (choice) {


                    case 1:

                        LibrarySystem.addBook(scanner);

                        break;


                    case 2:

                        LibrarySystem.showBook(scanner);

                        break;


                    case 3:

                        LibrarySystem.updateBook(scanner);

                        break;


                    case 4:

                        LibrarySystem.deleteBook(scanner);

                        break;


                    case 5:
                        LibrarySystem.borrowBook(scanner);
                        break;


                    case 6:
                        LibrarySystem.returnBook(scanner);
                        break;


                    case 7:
                        LibrarySystem.booksOfThisAuthor(scanner);
                        break;


                    default:
                        System.out.println("Lütfen geçerli bir seçim yapın.");
                }

            }


        }
    }
}