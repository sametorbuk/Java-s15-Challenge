package com.workintech.persons;

import com.workintech.bookCollection.Book;
import com.workintech.libraryManagement.Library;
import com.workintech.libraryManagement.Member_Record;

import java.util.ArrayList;
import java.util.Set;

public class Reader extends Person {

    private ArrayList<Book> books;
    private Member_Record record;

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Reader(String name, Member_Record record, ArrayList<Book> books) {
        super(name);
        this.record = record;
        this.books = books;
    }



    public Member_Record getRecord() {
        return record;
    }

    public void borrow_book(Book book) {

        if (book.isAvailable() && books.size() < 5) {
            books.add(book);
            book.setAvailable(false);
            book.setOwner(record.getName());
            System.out.println("Kitap başarıyla kişiye ödünç verildi");
            System.out.println("Hesabınızdan" + " " + book.getPrice() + "TL tahsil edildi");
        } else if (!book.isAvailable()) {
            System.out.println("Bu kitap şuan " + book.getOwner() + " adlı üyede olduğu için ödünç alamazsınız");
        } else if (book.isAvailable() && books.size() == 5) {
            System.out.println("Kullanıcı alabileceği kitap  limitine zaten ulaşmıştır");
        }
    }

    public void borrow_book(int id) {
        Book book = (Book) Library.getBooks().get(id);
        if (books.size() < 5) {

            if (Library.getBooks().containsKey(id) && book.isAvailable()) {
                books.add(book);
                book.setAvailable(false);
                book.setOwner(getName());
                System.out.println("Kitap başarıyla" + " " + getName() + " adlı kişiye ödünç verildi");
            } else if (Library.getBooks().containsKey(id) && !book.isAvailable()) {
                System.out.println("Bu kitap şuan " + book.getOwner() + " adlı üyede olduğu için ödünç alamazsınız");
            } else if (!Library.getBooks().containsKey(id)) {
                System.out.println("Sistemde böyle bir kitap bulunmamaktadır");
            }

        } else {
            System.out.println("Kullanıcı alabileceği kitap limitine ulaşmıştır");
        }

    }


    public void borrow_book(String bookTitle) {
        String cleanedInput = bookTitle.replaceAll("[\\s+,.!?:;]", "");
        Set<Integer> keys = Library.getBooks().keySet();
        if (books.size() < 5) {
            for (Integer key : keys) {
                String title = Library.getBooks().get(key).getTitle().replaceAll("[\\s+,.!?:;]", "").toLowerCase();
                Book book = Library.getBooks().get(key);
                if (title.contains(cleanedInput) && book.isAvailable()) {
                    books.add(book);
                    book.setAvailable(false);
                    book.setOwner(getName());
                    System.out.println("Kitap başarıyla kişiye ödünç verildi");
                } else if (title.contains(cleanedInput) && !book.isAvailable()) {
                    System.out.println("Kitap şuan" + book.getOwner() + " " + "adlı kişide olduğu için kitabı ödünç alamazsınız.");
                } else {
                    System.out.println("Sistemde böyle bir kitap bulunamadı");
                }
            }
        } else {
            System.out.println("Kullanıcı alabileceği kitap limitine zaten ulaşmıştır");
        }

    }


    public void return_book(Book book) {
        books.remove(book);
    }

    public void return_book(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Kitap iadesi başarıyla alındı teşekkürler");
            } else {
                System.out.println("Bu kullanıcıda böyle bir kitap mevcut değil");
            }
        }
    }

    public void show_book() {
        for (Object book : books) {
            System.out.println(book);
        }
    }


    @Override
    public String whoYouAre() {
        return super.whoYouAre() + ">>>> Title >>>> Reader";
    }


    @Override
    public String toString() {
        return "Reader{" +
                "books=" + books +
                ", record=" + record +
                '}';
    }


}
