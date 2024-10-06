package com.workintech.libraryManagement;

import com.workintech.bookCollection.Book;
import com.workintech.persons.Person;
import com.workintech.persons.Reader;

public class Librarian extends Person {


    public Librarian(String name) {
        super(name);
    }

    @Override
    public String whoYouAre() {
        return super.whoYouAre() + " >>>> Title: >>>> Librarian";
    }


    public void verifyMember(String name){
        boolean userFound = false;

        for(Object obj : Library.getReaders().values()){
            Reader reader = (Reader) obj;
            if(reader.getName().contains(name.toLowerCase())){
                System.out.println("There is such a user");
                userFound=true;
                break;
            }
        }

        if(!userFound){
            System.out.println("There is no such record");
        }
    }

    public void newBook(Book book){
        Library.newBook(book);
    }

    public void deleteBook(int id){
        Library.deleteBook(id);
    }


    public void searchBook(String bookTitle){
        boolean bookFound = false;

        for(Object obj : Library.getBooks().values()){
            Book book = (Book) obj;
            if(book.getTitle().contains(bookTitle.toLowerCase())){
                System.out.println(book);
                bookFound=true;
                break;
            }
        }

        if(!bookFound){
            System.out.println("There is no such book");
        }

    }

    public void searchBook(int book_id){
        boolean bookFound = false;

        for(Object obj : Library.getBooks().values()){
            Book book = (Book) obj;
            if(book.getId() == book_id){
                System.out.println(book.toString());
                bookFound=true;
                break;
            }
        }

        if(!bookFound){
            System.out.println("There is no book with this id");
        }

    }


    public void updateBook(int book_id , Book uptadeInfo){
        boolean bookFound = false;

        for(Object obj : Library.getBooks().values()){
            Book book = (Book) obj;
            if(book.getId() == book_id){
                System.out.println(book.toString());
                Library.updateBook(book_id , uptadeInfo);
                bookFound=true;
                break;
            }
        }

        if(!bookFound){
            System.out.println("There is no book with this id");
        }

    }







}
