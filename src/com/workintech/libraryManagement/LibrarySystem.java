package com.workintech.libraryManagement;

import com.workintech.bookCollection.Book;
import com.workintech.persons.Reader;

import java.util.*;

public class LibrarySystem {
    private int choice;


    public LibrarySystem() {

    }

    public void setChoice(int choice) {
        this.choice = choice;
    }


    public static void addBook(Scanner scanner) {

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

    }


    public static void showBook(Scanner scanner){
        System.out.println("Lütfen kategori seçiniz:");
        System.out.println("1. Magazine");
        System.out.println("2. Study Books");
        System.out.println("3. Novels");

        int choice;
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
    }
}


    public static void updateBook(Scanner scanner){
        System.out.println("Güncelleyeceğiniz kitabı hangi verisi ile seçmek istersiniz:");

        System.out.println("1. ID ye göre seç");
        System.out.println("2. Başlığa göre seç");
        int choice;
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
    }



    public static void deleteBook(Scanner scanner){

        System.out.println("Kitabı hangi verisine göre silmek istersiniz?");
        System.out.println("1. ID ile sil");
        System.out.println("2. Başlık ile sil");
        int choice;
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



    }



    public static void borrowBook(Scanner scanner){
        Librarian librarian = new Librarian("Samet");

        System.out.println("Kitabı hangi verisine göre seçmek istersiniz?");
        System.out.println("1. ID ile seç");
        System.out.println("2. Başlık ile seç");
int choice;
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
                            System.out.println("Kitap " + person.getName() + " adına başarıyla ödünç alındı.");
                            librarian.createBill(bookId, person.getRecord().getMember_id());
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
                            librarian.createBill(book.getId(), person.getRecord().getMember_id());
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



        }



    public static void returnBook(Scanner scanner){
        Librarian librarian = new Librarian("Samet");

        System.out.println("Lütfen iade etmek istediğiniz kitabın adını ve kullanıcı id nizi giriniz ");
        System.out.println("****************");
        System.out.println("****************");
        System.out.println("Lütfen önce kullanıcı id nizi giriniz:");


        int readerId = 0;

        while (true) {
            try {
                readerId = scanner.nextInt();
                scanner.nextLine();

                if (Library.getReaders().containsKey(readerId) && Library.getReaders().get(readerId).getBooks().size() == 0) {
                    System.out.println("Bu kullanıcıda herhangi bir kitap bulunmamaktadır. Lütfen listesinde kitap bulunan bir kullanıcı seçiniz");

                } else if (Library.getReaders().containsKey(readerId)) {
                    break;
                } else {
                    System.out.println("Bu ID'ye sahip bir kullanıcı yok, lütfen geçerli bir ID giriniz.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Lütfen geçerli bir değer giriniz.");
                scanner.next();
            }
        }


        System.out.println("Lütfen iade etmek istediğiniz kitabın adını giriniz:");
        String bookTitle = scanner.nextLine();


        String cleanedBookTitle = bookTitle.replaceAll("[\\p{Punct}\\s]", "").toLowerCase();

        boolean bookFound = false;


        for (Book book : Library.getReaders().get(readerId).getBooks()) {
            String cleanedTitle = book.getTitle().replaceAll("[\\p{Punct}\\s]", "").toLowerCase();
            if (cleanedTitle.contains(cleanedBookTitle)) {
                librarian.returnBook(book, readerId);
                System.out.println("İşlem başarılı!");
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Bu kullanıcıya ait böyle bir kitap bulunamadı.");
        }




    }


    public  static void booksOfThisAuthor(Scanner scanner){
        System.out.println("Lütfen yazar adı giriniz:");
        String authorName = scanner.nextLine();
        while (true) {
            try {
                String cleanedAuthorName = authorName.replaceAll("[\\p{Punct}\\s]", "").toLowerCase();
                Set<String> autorsNamesAtTheLibrary = Library.getAuthors().keySet();
                boolean authorFound = false;
                for (String name : autorsNamesAtTheLibrary) {
                    String cleanedName = name.replaceAll("[\\p{Punct}\\s]", "").toLowerCase();
                    if (cleanedName.contains(cleanedAuthorName)) {
                        Set<Integer> booksOfAuthorKeySet = Library.getAuthors().get(name).keySet();
                        for (Integer key : booksOfAuthorKeySet) {
                            System.out.println(Library.getAuthors().get(name).get(key).getTitle());
                        }
                        authorFound = true;
                        break;
                    }
                }


                if (authorFound) {

                    break;
                } else {
                    System.out.println("Böyle bir yazar bulunamadı.");
                    System.out.println("Lütfen yazar adı giriniz:");
                    authorName = scanner.nextLine();
                }


            } catch (InputMismatchException e) {
                System.out.println("Lütfen geçerli bir değer giriniz.");
                scanner.next();
            }
        }
    }



    }










































