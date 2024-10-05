package com.workintech.libraryManagement;

import com.workintech.bookCollection.Book;
import com.workintech.persons.Reader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Library {
    private static Map<Integer , Object> books;
    private static Map<Integer , Object> readers;
    private  static Map<Integer , Object> authors;



    public Library() {
        this.books = new HashMap<>();
        this.readers = new HashMap<>();
    }

    public Library(Map<Integer, Object> books, Map<Integer, Object> authors) {
        this.books = books;
        this.authors = authors;
    }


    public static Map<Integer, Object> getBooks() {
        return books;
    }

    public static Map<Integer, Object> getReaders() {
        return readers;
    }

    public  static Map<Integer, Object> getAuthors() {
        return authors;
    }

    public static void setBooks(Map<Integer, Object> books) {
        Library.books = books;
    }

    public static void setAuthors(Map<Integer, Object> authors) {
        Library.authors = authors;
    }

    public static void setReaders(Map<Integer, Object> readers) {
        Library.readers = readers;
    }

    public static void newBook(Book book){
        if(books == null){
            Library.books = new HashMap<>();
        }
        books.put(book.getId(), book);

    }

    public static void addReader(Reader reader){

        if (readers == null) {
            readers = new HashMap<>();
        }

        Library.readers.put(reader.getRecord().getMember_id() , reader);
    }

    public static void lendBook(Book book , Reader reader){

        if(book.isAvailable() &&  !(reader.getBooks().contains(book)) ){
            book.setOwner(reader.getName());
            book.setAvailable(false);
            reader.borrow_book(book);
        } else if(book.isAvailable() && reader.getBooks().contains(book)) {
            System.out.println("The person already has this book");
        } else if(!book.isAvailable()){
            System.out.println("The book is not available");
        }

    }


    public static void takeBackBook(Book book , Reader reader){

        if(reader.getBooks().contains(book)){
            reader.return_book(book);
            book.setAvailable(true);
            System.out.println("Book successfully returned");
        } else {
            System.out.println("This person doesn't have this book");
        }


    }


    public static void showBook(){

        books.forEach((key , value) -> {
            System.out.println(value.toString());
        });
    }


    public static void deleteBook(int id){
        if(books.containsKey(id)){
            books.remove(id);
            System.out.println("Book with " + id  + " id deleted successfully");
        } else {
            System.out.println("There is no book with this id");
        }
    }


    public static
    void deleteBook(String title){
        String cleanedInputTitle = title.replaceAll("[\\s+\\.\\,\\!\\?\\;\\:\\-]", "").toLowerCase();

        Set<Integer> keys = books.keySet();

        for(Integer key : keys){
           Book book =(Book) books.get(key);
           String cleanedTitle = book.getTitle().replaceAll("[\\s+\\.\\,\\!\\?\\;\\:\\-]", "").toLowerCase();
            boolean bookFound = false;


           if(cleanedTitle.contains(cleanedInputTitle)){
               books.remove(book.getId());
               System.out.println("Book successfully deleted");
               bookFound=true;
               break;
           }


           if(!bookFound){
               System.out.println("There is no book with this title");
           }


        }
    }








}
