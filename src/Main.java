import com.workintech.bookCollection.Book;
import com.workintech.bookCollection.Magazines;
import com.workintech.bookCollection.Novel;
import com.workintech.bookCollection.StudyBooks;
import com.workintech.libraryManagement.Librarian;
import com.workintech.libraryManagement.Library;
import com.workintech.libraryManagement.Member_Record;
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


        Object[][] novelsData = {
                {1, "Victor Hugo", "Sefiller", 14.43, "2023-10-01", "Novel"},
                {2, "George Orwell", "1984", 12.99, "2023-10-02", "Novel"},
                {3, "J.K. Rowling", "Harry Potter ve Felsefe Taşı", 15.50, "2023-10-03", "Novel"},
                {4, "Jane Austen", "Gurur ve Ön Yargı", 11.00, "2023-10-04", "Novel"},
                {5, "F. Scott Fitzgerald", "Muhteşem Gatsby", 13.75, "2023-10-05", "Novel"},
                {6, "Mark Twain", "Tom Sawyer'ın Maceraları", 10.25, "2023-10-06", "Novel"},
                {7, "Herman Melville", "Moby Dick", 16.00, "2023-10-07", "Novel"},
                {8, "Charles Dickens", "İki Şehrin Hikayesi", 9.99, "2023-10-08", "Novel"},
                {9, "Leo Tolstoy", "Anna Karenina", 14.00, "2023-10-09", "Novel"},
                {10, "Gabriel Garcia Marquez", "Yüzyıllık Yalnızlık", 18.00, "2023-10-10", "Novel"},
                {11, "J.R.R. Tolkien", "Yüzüklerin Efendisi", 20.00, "2023-10-11", "Novel"},
                {12, "Stephen King", "Hayvan Mezarlığı", 15.75, "2023-10-12", "Novel"},
                {13, "Agatha Christie", "Doğu Ekspresinde Cinayet", 12.50, "2023-10-13", "Novel"},
                {14, "Harper Lee", "Bülbülü Öldürmek", 10.50, "2023-10-14", "Novel"},
                {15, "Ray Bradbury", "Fahrenheit 451", 13.00, "2023-10-15", "Novel"},
                // Yeni Eklemeler
                {16, "Victor Hugo", "Notre-Dame'ın Kamburu", 16.50, "2023-10-16", "Novel"},
                {17, "George Orwell", "Hayvan Çiftliği", 11.50, "2023-10-17", "Novel"},
                {18, "J.K. Rowling", "Harry Potter ve Sırlar Odası", 16.00, "2023-10-18", "Novel"},
                {19, "Jane Austen", "Emma", 12.75, "2023-10-19", "Novel"},
                {20, "F. Scott Fitzgerald", "Güzel ve Çirkin", 14.00, "2023-10-20", "Novel"},
                {21, "Mark Twain", "Huckleberry Finn", 11.25, "2023-10-21", "Novel"},
                {22, "Herman Melville", "Omoo", 17.50, "2023-10-22", "Novel"},
                {23, "Charles Dickens", "David Copperfield", 12.00, "2023-10-23", "Novel"},
                {24, "Leo Tolstoy", "Savaş ve Barış", 18.50, "2023-10-24", "Novel"},
                {25, "Gabriel Garcia Marquez", "Kırmızı Pazartesi", 15.00, "2023-10-25", "Novel"},
                {26, "J.R.R. Tolkien", "Hobbit", 19.00, "2023-10-26", "Novel"},
                {27, "Stephen King", "Şu An Burada", 14.75, "2023-10-27", "Novel"},
                {28, "Agatha Christie", "On Küçük Zenci", 13.25, "2023-10-28", "Novel"},
                {29, "Harper Lee", "Bülbülü Öldürmek", 10.50, "2023-10-29", "Novel"},
                {30, "Ray Bradbury", "Mars Yıllıkları", 16.00, "2023-10-30", "Novel"}
        };
        for (int i = 0; i < novelsData.length; i++) {
            int id = (int) novelsData[i][0];
            String author = (String) novelsData[i][1];
            String title = (String) novelsData[i][2];
            double price = (double) novelsData[i][3];
            String edition = (String) novelsData[i][4];
            String category = (String) novelsData[i][5];Book novel = new Novel(id, author, title, price, edition, category);
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
                Map<Integer, Object> authorBooks = Library.getAuthors().get(author);
                authorBooks.put(id, novel);
            } else {

                Map<Integer, Object> authorBooks = new HashMap<>();
                authorBooks.put(id, novel);
                Library.getAuthors().put(author, authorBooks);

            }

        }
        Object[][] studyBooksData = {
                {31, "Thomas H. Cormen", "Algoritmalar", 45.00, "2023-10-01", "StudyBook"},
                {32, "Herbert Schildt", "Java: Kapsamlı Referans", 50.00, "2023-10-02", "StudyBook"},
                {33, "Robert C. Martin", "Temiz Kod", 42.00, "2023-10-03", "StudyBook"},
                {34, "David Flanagan", "JavaScript: Kesin Kılavuz", 39.00, "2023-10-04", "StudyBook"},
                {35, "Andrew S. Tanenbaum", "Bilgisayar Ağları", 55.00, "2023-10-05", "StudyBook"},
                {36, "Bjarne Stroustrup", "C++ Programlama Dili", 60.00, "2023-10-06", "StudyBook"},
                {37, "John K. Ousterhout", "Unix İşletim Sistemi Tasarımı", 48.00, "2023-10-07", "StudyBook"},
                {38, "Martin Fowler", "Yeniden Yapılandırma", 40.00, "2023-10-08", "StudyBook"},
                {39, "Daniel Shiffman", "Kodun Doğası", 37.00, "2023-10-09", "StudyBook"},
                {40, "Jesse Liberty", "C# Programlama", 44.00, "2023-10-10", "StudyBook"},
                {41, "Jim Heskett", "C# Derinlemesine", 52.00, "2023-10-11", "StudyBook"},
                {42, "Andrew S. Tanenbaum", "Modern İşletim Sistemleri", 58.00, "2023-10-12", "StudyBook"},
                {43, "Michael T. Nygard", "Bırakın Gitsin!", 46.00, "2023-10-13", "StudyBook"},
                {44, "Martin Kleppmann", "Veri Yoğun Uygulamaları Tasarlamak", 55.00, "2023-10-14", "StudyBook"},
                // Yeni Eklemeler
                {45, "Thomas H. Cormen", "Algoritmalar 2", 47.00, "2023-10-16", "StudyBook"},
                {46, "Herbert Schildt", "Java 2: Kapsamlı Referans", 55.00, "2023-10-17", "StudyBook"},
                {47, "Robert C. Martin", "İyi Yazılım", 43.00, "2023-10-18", "StudyBook"},
                {48, "David Flanagan", "Java: Temel Kılavuz", 41.00, "2023-10-19", "StudyBook"},
                {49, "Andrew S. Tanenbaum", "İşletim Sistemleri", 62.00, "2023-10-20", "StudyBook"},
                {50, "Bjarne Stroustrup", "C++: Derinlemesine İnceleme", 65.00, "2023-10-21", "StudyBook"},
                {51, "Martin Fowler", "Domain-Driven Design", 39.50, "2023-10-22", "StudyBook"},
                {52, "Daniel Shiffman", "Yarışmalar için JavaScript", 36.00, "2023-10-23", "StudyBook"}
        };


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
                Map<Integer, Object> authorBooks = Library.getAuthors().get(author);
                authorBooks.put(id, studyBook);
            } else {

                Map<Integer, Object> authorBooks = new HashMap<>();
                authorBooks.put(id, studyBook);
                Library.getAuthors().put(author, authorBooks);

            }


        }

        Object[][] magazineData = {
                {53, "National Geographic", "Ekim 2023 Sayısı", 6.99, "2023-10-01", "Magazine"},
                {54, "TIME", "İklim Krizi", 5.99, "2023-10-02", "Magazine"},
                {55, "Forbes", "2023 Milyarderleri", 7.50, "2023-10-03", "Magazine"},
                {56, "Vogue", "2023 Moda Trendleri", 8.50, "2023-10-04", "Magazine"},
                {57, "Scientific American", "Uzay Keşifleri", 6.50, "2023-10-05", "Magazine"},
                {58, "The New Yorker", "Siyasi Yorumlar", 7.25, "2023-10-06", "Magazine"},
                {59, "Wired", "Teknoloji ve İnovasyon", 6.00, "2023-10-07", "Magazine"},
                {60, "Sports Illustrated", "2023 Spor Önizlemesi", 5.50, "2023-10-08", "Magazine"},
                {61, "Rolling Stone", "Müzik Trendleri", 7.00, "2023-10-09", "Magazine"},
                {62, "The Economist", "Küresel Ekonomik Görünüm", 6.75, "2023-10-10", "Magazine"},
                {63, "Men's Health", "Fitness İpuçları", 5.99, "2023-10-11", "Magazine"},
                {64, "Women's Health", "Beslenme Rehberi", 5.99, "2023-10-12", "Magazine"},
                {65, "PC Magazine", "2023'ün En İyi Teknolojileri", 6.49, "2023-10-13", "Magazine"},
                {66, "Architectural Digest", "Ev Tasarımı", 8.00, "2023-10-14", "Magazine"},
                {67, "Better Homes & Gardens", "Bahçecilik İpuçları", 4.99, "2023-10-15", "Magazine"},
                // Yeni Eklemeler
                {68, "National Geographic", "Kasım 2023 Sayısı", 7.99, "2023-10-16", "Magazine"},
                {69, "TIME", "Dijital Dönüşüm", 6.99, "2023-10-17", "Magazine"},
                {70, "Forbes", "2024 Ekonomik Tahminler", 7.99, "2023-10-18", "Magazine"},
                {71, "Vogue", "Yeni Moda İkonları", 8.99, "2023-10-19", "Magazine"},
                {72, "Scientific American", "Bilimsel İlerlemeler", 6.99, "2023-10-20", "Magazine"},
                {73, "The New Yorker", "Kültürel Değişim", 7.50, "2023-10-21", "Magazine"},
                {74, "Wired", "Gelecek Teknolojileri", 6.75, "2023-10-22", "Magazine"},
                {75, "Sports Illustrated", "2024 Olimpiyatları", 5.75, "2023-10-23", "Magazine"}
        };

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
                Map<Integer, Object> authorBooks = Library.getAuthors().get(author);
                authorBooks.put(id, magazine);
            } else {

                Map<Integer, Object> authorBooks = new HashMap<>();
                authorBooks.put(id, magazine);
                Library.getAuthors().put(author, authorBooks);

            }

        }
        Object[][] readersData = {
                {"Samet", new Member_Record(23, "0505780213", "Akbelen mahallesi 84090. sokak", "Samet", 5, "04.10.24", "Reader")},
                {"Ayşe", new Member_Record(24, "0534567890", "Çiğdem sokak No:5", "Ayşe", 3, "15.11.25", "Reader")},
                {"Mehmet", new Member_Record(25, "0543210987", "Güzelyalı mahallesi 12. sokak", "Mehmet", 2, "20.12.23", "Reader")},
                {"Fatma", new Member_Record(26, "0500123456", "Sakarya caddesi 7", "Fatma", 4, "30.01.26", "Reader")},
                {"Emre", new Member_Record(27, "0521234567", "Atatürk caddesi 45", "Emre", 1, "22.08.24", "Reader")},
                {"Zeynep", new Member_Record(28, "0512345678", "Barış mahallesi 19. sokak", "Zeynep", 6, "10.05.25", "Reader")},
                {"Ali", new Member_Record(29, "0545678901", "Kurtuluş caddesi 33", "Ali", 3, "15.09.24", "Reader")},
                {"Merve", new Member_Record(30, "0509876543", "Yıldız mahallesi 24. sokak", "Merve", 2, "18.03.26", "Reader")},
                {"Can", new Member_Record(31, "0532345678", "Ekin mahallesi 11", "Can", 4, "28.07.25", "Reader")},
                {"Elif", new Member_Record(32, "0523456789", "Huzur caddesi 15", "Elif", 5, "02.02.24", "Reader")}
        };
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

            Map<Integer, Object> authorMap = Library.getAuthors().get(key);
            if (authorMap != null) {
                Set<Integer> bookKeys = authorMap.keySet();

                for (Integer bookKey : bookKeys) {
                    System.out.println(authorMap.get(bookKey).toString());
                }
            } else {
                System.out.println("Bu yazara ait hiç kitap yok: " + key);
            }
        }


        Reader reader = new Reader("Samet", new Member_Record(23,
                "0505780213", "Akbelen mahallesi 84090." +
                " sokak", "Samet", 5, "04.10.24", "Reader"), new ArrayList<>());

        reader.borrow_book(25);
        reader.borrow_book(35);
        reader.borrow_book(21);
        reader.borrow_book(21);
        reader.borrow_book(23);
        reader.borrow_book(26);
        reader.borrow_book(27);


        Set<Integer> readerKeys = Library.getReaders().keySet();

        for (Integer key : readerKeys) {
            System.out.println(Library.getReaders().get(key).getRecord().toString());
        }

        System.out.println(readerKeys.size());

        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");



        Scanner scanner = new Scanner(System.in);

        int choice = 0;


        while (choice != 7) {
            System.out.println("Kütüphane Sistemi");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Göster");
            System.out.println("3. Kitap Güncelle");
            System.out.println("4. Kitap Sil");
            System.out.println("5. Kitap Ödünç Al");
            System.out.println("6. Kitap Geri İade Et");
            System.out.println("7. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            choice = scanner.nextInt();

            scanner.nextLine();


            switch (choice) {

//MAİN CASE KİTAP EKLE
                case 1:
                    System.out.println("Kitabın ismini girin:");
                    String title = scanner.nextLine();
                    System.out.println("Yazarın adını girin:");
                    String author = scanner.nextLine();
                    System.out.println("Kitap id si girin:");


                    int id = scanner.nextInt();
                    scanner.nextLine();

                    while (Library.getBooks().containsKey(id)) {
                        System.out.println("Sistemde zaten bu id ye sahip bir kitap var başka bir id giriniz");
                        id = scanner.nextInt();
                        scanner.nextLine();
                    }

                    double price = 0.0;

                    while (true) {
                        System.out.println("Kitabın ücretini girin:");
                        try {

                            price = scanner.nextDouble();
                            if (price <= 0) {
                                System.out.println("Lütfen pozitif bir değer girin");
                            } else {
                                break;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Lütfen geçerli bir sayı girin");
                            scanner.next();
                        }
                    }
                    scanner.nextLine();

                    System.out.println("Lütfen baskı tarihini girin:");
                    String edition = scanner.nextLine();

                    System.out.println("Lütfen kategori girin:");
                    String category = scanner.nextLine();

                    Library.newBook(new Book(id, author, title, price, edition, category));
                    System.out.println("Kitap başarıyla sisteme eklendi.");
                    break;


//MAİN CASE KİTAPLARI GÖSTER
                case 2:
                    System.out.println("Lütfen kategori seçiniz:");
                    System.out.println("1. Magazine");
                    System.out.println("2. Study Books");
                    System.out.println("3. Novels");

                    while (true) {
                        try {
                            choice = scanner.nextInt();
                            if (choice == 1 || choice == 2 || choice == 3) {
                                break;
                            } else {
                                System.out.println("Lütfen geçerli bir seçim yapınız");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Lütfen geçerli bir değer giriniz");
                            scanner.next();
                        }
                    }
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println("***********************************");
                            System.out.println("************MAGAZINES**************");
                            System.out.println("***********************************");

                            HashMap<Integer, Book> magazineBooks = new HashMap<>(Library.getCategories().get("Magazine"));

                            Set<Integer> magazineBookKeys = magazineBooks.keySet();

                            for (Integer key : magazineBookKeys) {
                                System.out.println(magazineBooks.get(key).toString());
                            }
                            break;

                        case 2:
                            System.out.println("***********************************");
                            System.out.println("************STUDY BOOKS**************");
                            System.out.println("***********************************");

                            HashMap<Integer, Book> studyBooks = new HashMap<>(Library.getCategories().get("StudyBook"));

                            Set<Integer> studyBooksKeys = studyBooks.keySet();

                            for (Integer key : studyBooksKeys) {
                                System.out.println(studyBooks.get(key).toString());
                            }
                            break;


                        case 3:

                            System.out.println("***********************************");
                            System.out.println("************NOVELS**************");
                            System.out.println("***********************************");

                            HashMap<Integer, Book> novels = new HashMap<>(Library.getCategories().get("Novel"));

                            Set<Integer> novelsKeys = novels.keySet();

                            for (Integer key : novelsKeys) {
                                System.out.println(novels.get(key).toString());
                            }
                            break;

                    }
                    break;


//MAİN CASE KİTAP GÜNCELLE
                case 3:

                    System.out.println("Güncelleyeceğiniz kitabı hangi verisi ile seçmek istersiniz:");

                    System.out.println("1. ID ye göre seç");
                    System.out.println("2. Başlığa göre seç");

                    while (true) {
                        try {
                            choice = scanner.nextInt();
                            if (choice == 1 || choice == 2) {
                                break;
                            } else {
                                System.out.println("Lütfen geçerli bir seçim yapınız ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Lütfen geçerli bir değer giriniz");
                            scanner.next();
                        }
                    }
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("Lütfen güncellemek istediğiniz kitabın id sini girin:");

                        int bookId = scanner.nextInt();

                        while (!Library.getBooks().containsKey(bookId)) {
                            System.out.println("Sistemde  bu id ye sahip bir kitap yok id nin doğru olduğundan emin misiniz ?");
                            bookId = scanner.nextInt();
                            scanner.nextLine();
                        }

                        if (Library.getBooks().containsKey(bookId)) {
                            scanner.nextLine();

                            System.out.println("Kitabın yeni ismini girin:");
                            String newTitle = scanner.nextLine();


                            System.out.println("Yazarın yeni adını girin:");
                            String newAuthor = scanner.nextLine();

                            double priceOfBook = 0.0;

                            while (true) {
                                System.out.println("Kitabın yeni ücretini girin:");
                                try {

                                    priceOfBook = scanner.nextDouble();
                                    if (priceOfBook <= 0) {
                                        System.out.println("Lütfen pozitif bir değer girin");
                                    } else {
                                        break;
                                    }

                                } catch (InputMismatchException e) {
                                    System.out.println("Lütfen geçerli bir sayı girin");
                                    scanner.next();
                                }
                            }
                            scanner.nextLine();

                            System.out.println("Lütfen yeni baskı tarihini girin:");
                            String newEdition = scanner.nextLine();

                            System.out.println("Lütfen yeni kategori girin:");
                            String newCategory = scanner.nextLine();

                            Book book = Library.getBooks().get(bookId);

                            book.setTitle(newTitle);
                            book.setAuthor(newAuthor);
                            book.setPrice(priceOfBook);
                            book.setEdition(newEdition);
                            book.setCategory(newCategory);

                            System.out.println(bookId + " " + " ID Lİ KİTAP BİLGİLERİ BAŞARIYLA GÜNCELLENDİ");

                        } else {
                            System.out.println("Sistemde böyle bir kitap bulunmuyor id yi doğru girin.");
                        }

                    } else if (choice == 2) {
                        System.out.println("Güncellemek  istediğiniz kitabın başlığını girin");
                        String titleInput = scanner.nextLine();
                        String cleanedInput = titleInput.replaceAll("[\\s+,.!?:;]", "");

                        boolean bookFound = false;
                        for (Book book : new HashSet<>(Library.getBooks().values())) {
                            String cleanedTitle = book.getTitle().replaceAll("[\\s+,.!?:;]", "").toLowerCase();
                            if (cleanedTitle.contains(cleanedInput)) {

                                System.out.println("Kitabın yeni ismini girin:");
                                String newTitle = scanner.nextLine();
                                System.out.println("Yazarın yeni adını girin:");
                                String newAuthor = scanner.nextLine();

                                double priceOfBook = 0.0;

                                while (true) {
                                    System.out.println("Kitabın yeni ücretini girin:");
                                    try {

                                        priceOfBook = scanner.nextDouble();
                                        if (priceOfBook <= 0) {
                                            System.out.println("Lütfen pozitif bir değer girin");
                                        } else {
                                            break;
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Lütfen geçerli bir sayı girin");
                                        scanner.next();
                                    }
                                }
                                scanner.nextLine();

                                System.out.println("Lütfen yeni baskı tarihini girin:");
                                String newEdition = scanner.nextLine();

                                System.out.println("Lütfen yeni kategori girin:");
                                String newCategory = scanner.nextLine();


                                book.setTitle(newTitle);
                                book.setAuthor(newAuthor);
                                book.setPrice(priceOfBook);
                                book.setEdition(newEdition);
                                book.setCategory(newCategory);

                                System.out.println(book.getId() + " " + " ID Lİ KİTAP BİLGİLERİ BAŞARIYLA GÜNCELLENDİ");

                                bookFound = true;
                            }
                        }

                        if (!bookFound) {
                            System.out.println("Sistemde böyle bir kitap yok, lütfen tekrar deneyin.");
                        }

                    }
                    break;


//MAİN CASE KİTAP SİL
                case 4:

                    System.out.println("Kitabı hangi verisine göre silmek istersiniz?");
                    System.out.println("1. ID ile sil");
                    System.out.println("2. Başlık ile sil");

                    while (true) {
                        try {
                            choice = scanner.nextInt();
                            if (choice == 1 || choice == 2) {
                                break;
                            } else {
                                System.out.println("Lütfen geçerli bir seçim yapınız ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Lütfen geçerli bir değer giriniz");
                            scanner.next();
                        }
                    }
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("Lütfen silmek istediğiniz kitabın id sini girin:");
                        int bookId = scanner.nextInt();

                        if (Library.getBooks().containsKey(bookId)) {
                            Library.deleteBook(bookId);

                        } else {
                            System.out.println("Sistemde böyle bir kitap bulunmuyor id yi doğru girin.");
                        }

                    } else if (choice == 2) {
                        System.out.println("Silmek istediğiniz kitabın başlığını girin");
                        String titleInput = scanner.nextLine();
                        String cleanedInput = titleInput.replaceAll("[\\s+,.!?:;]", "");

                        boolean bookFound = false;
                        for (Book book : new HashSet<>(Library.getBooks().values())) {
                            String cleanedTitle = book.getTitle().replaceAll("[\\s+,.!?:;]", "").toLowerCase();
                            if (cleanedTitle.contains(cleanedInput)) {
                                Library.getBooks().remove(book.getId());
                                System.out.println("Kitap sistemden başarıyla silindi: " + book.getTitle().toUpperCase());
                                bookFound = true;
                            }
                        }

                        if (!bookFound) {
                            System.out.println("Sistemde böyle bir kitap yok, lütfen tekrar deneyin.");
                        }

                    }

                    break;


                // MAIN CASE KİTAP ÖDÜNÇ AL


                case 5:
                    System.out.println("Kitabı hangi verisine göre seçmek istersiniz?");
                    System.out.println("1. ID ile seç");
                    System.out.println("2. Başlık ile seç");

                    while (true) {
                        try {
                            choice = scanner.nextInt();
                            if (choice == 1 || choice == 2) {
                                break;
                            } else {
                                System.out.println("Lütfen geçerli bir seçim yapınız.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Lütfen geçerli bir değer giriniz.");
                            scanner.next();
                        }
                    }
                    scanner.nextLine();

                    if (choice == 1) {
                        while (true) {
                            System.out.println("Lütfen ödünç almak istediğiniz kitabın ID'sini girin:");
                            int bookId = scanner.nextInt();

                            if (Library.getBooks().containsKey(bookId)) {
                                Book selectedBook = Library.getBooks().get(bookId);
                                System.out.println("Almak istediğiniz kitap: " + selectedBook.toString());

                                if (!selectedBook.isAvailable()) {
                                    System.out.println("Almak istediğiniz kitap şu an " + selectedBook.getOwner() + " adlı üyede olduğu için kitabı alamazsınız.");
                                    System.out.println("Lütfen başka bir kitap ID'si giriniz.");
                                    continue;
                                }

                                while (true) {
                                    System.out.println("Lütfen kullanıcı ID'nizi giriniz, kitabı kendi adınıza mı alacaksınız?");
                                    int readerId = scanner.nextInt();

                                    if (Library.getReaders().containsKey(readerId)) {
                                        Reader person = Library.getReaders().get(readerId);
                                        person.borrow_book(selectedBook.getId());
                                        System.out.println("Kitap " + person.getName()  +" adına başarıyla ödünç alındı.");
                                        break;
                                    } else {
                                        System.out.println("Sistemde böyle bir kullanıcı bulunmuyor, lütfen ID'yi doğru girin.");
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Sistemde böyle bir kitap bulunmuyor, ID'yi doğru girin.");
                            }
                        }
                    } else if (choice == 2) {
                        System.out.println("Ödünç almak istediğiniz kitabın başlığını girin:");
                        String titleInput = scanner.nextLine();
                        String cleanedInput = titleInput.replaceAll("[\\s+,.!?:;]", "").toLowerCase();

                        boolean bookFound = false;
                        for (Book book : Library.getBooks().values()) {
                            String cleanedTitle = book.getTitle().replaceAll("[\\s+,.!?:;]", "").toLowerCase();
                            if (cleanedTitle.contains(cleanedInput) && book.isAvailable()) {
                                System.out.println("Bulunan kitap: " + book.toString());

                                while (true) {
                                    System.out.println("Lütfen kullanıcı ID'nizi giriniz, kitabı kendi adınıza mı alacaksınız?");
                                    int readerId = scanner.nextInt();

                                    if (Library.getReaders().containsKey(readerId)) {
                                        Reader person = Library.getReaders().get(readerId);
                                        person.borrow_book(book.getId());
                                        System.out.println("Kitap başarıyla ödünç alındı.");
                                        bookFound = true;
                                        break;
                                    } else {
                                        System.out.println("Sistemde böyle bir kullanıcı bulunmuyor, lütfen ID'yi doğru girin.");
                                    }
                                }
                                break;
                            }
                        }

                        if (!bookFound) {
                            System.out.println("Sistemde böyle bir kitap yok, lütfen tekrar deneyin.");
                        }
                    }
                    break;



                // MAIN CASE GERİ İADE ET



                default:
                    System.out.println("Lütfen seçimizi düzgün yapın.");
            }

        }


    }
}