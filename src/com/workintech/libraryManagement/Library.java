package com.workintech.libraryManagement;

import com.workintech.bookCollection.Book;
import com.workintech.persons.Reader;

import java.util.Map;

public class Library {
    private static Map<Integer , Object> books;
    private static Map<Integer , Object> readers;
    private  static Map<Integer , Object> authors;

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

    public static Map<Integer, Object> getAuthors() {
        return authors;
    }

    public void setBooks(Map<Integer, Object> books) {
        this.books = books;
    }

    public void setAuthors(Map<Integer, Object> authors) {
        this.authors = authors;
    }

    public void setReaders(Map<Integer, Object> readers) {
        this.readers = readers;
    }

    public void newBook(Book book){
        books.put(book.getId(), book);

    }

    public void lendBook(Book book , Reader reader){

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


    public void takeBackBook(Book book , Reader reader){

        if(reader.getBooks().contains(book)){
            reader.return_book(book);
            book.setAvailable(true);
            System.out.println("Book successfully returned");
        } else {
            System.out.println("This person doesn't have this book");
        }


    }


    public void showBook(){

        books.forEach((key , value) -> {
            System.out.println(value.toString());
        });
    }




}
