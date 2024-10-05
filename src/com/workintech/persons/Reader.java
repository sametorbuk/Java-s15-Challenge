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

    public Member_Record getRecord() {
        return record;
    }

    public void borrow_book(Book book) {

       if(book.isAvailable() && books.size() < 5){
           books.add(book);
           book.setAvailable(false);
           book.setOwner(record.getName());
       } else if(!book.isAvailable()) {
           System.out.println("Bu kitap şuan " + book.getOwner() + " adlı üyede olduğu için ödünç alamazsınız");
       } else if(book.isAvailable() && books.size() == 5){
           System.out.println("Kullanıcı alabileceği kitap  limitine zaten ulaşmıştır");
       }
    }

    public void return_book(Book book){
        books.remove(book);
    }

    public void return_book(int id){
        for(Book book : books){
            if(book.getId() == id){
                books.remove(book);
            } else {
                System.out.println("Bu kullanıcıda böyle bir kitap mevcut değil");
            }
        }
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


    @Override
    public String toString() {
        return "Reader{" +
                "books=" + books +
                ", record=" + record +
                '}';
    }






}
