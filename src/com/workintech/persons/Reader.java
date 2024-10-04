package com.workintech.persons;

import com.workintech.bookCollection.Book;
import com.workintech.libraryManagement.Member_Record;

import java.util.ArrayList;

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

    public void  purchase_book(){

    }

    public void borrow_book(Book book) {
        books.add(book);
    }

    public void return_book(Book book){
        books.remove(book);
    }

    public void show_book(){
        for(Object book:books){
            System.out.println(book);
        }
    }


    @Override
    public String whoYouAre() {
        return   super.whoYouAre() + ">>>> Title >>>> Reader";
    }
}
