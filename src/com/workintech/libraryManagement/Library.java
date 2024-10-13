package com.workintech.libraryManagement;

import com.workintech.bookCollection.Book;
import com.workintech.persons.Reader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Library {
    private static Map<Integer , Book> books;
    private static Map<Integer , Reader> readers;
    private  static Map<String , Map<Integer , Book>> authors;
    private static Map<String , Map<Integer , Book>> categories;


    public static void setCategories(Map<String, Map<Integer , Book>> categories) {
        Library.categories = categories;
    }

    public static Map<String, Map<Integer, Book>> getCategories() {
        return categories;
    }

    public Library() {
        Library.books = new HashMap<>();
        Library.readers = new HashMap<>();
        Library.categories = new HashMap<>();
        Library.authors = new HashMap<>();
    }

    public Library(Map<Integer, Book> books,Map<String , Map<Integer , Book>> authors) {
        this.books = books;
        this.authors = authors;
    }

    public static Map<Integer, Book> getBooks() {
        return books;
    }

    public static Map<Integer, Reader> getReaders() {
        return readers;
    }

    public  static Map<String , Map<Integer , Book>> getAuthors() {
        return authors;
    }

    public static void setBooks(Map<Integer, Book> books) {
        Library.books = books;
    }

    public static void setAuthors(Map<String , Map<Integer , Book>> authors) {
        Library.authors = authors;
    }

    public static void setReaders(Map<Integer, Reader> readers) {
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



    public static void updateBook(int id , Book book){
        if(books.get(id) != null){
            books.put(id , book);
        } else {
            System.out.println("There is no book with this id");
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


    public static void takeBackBook(int bookId , Reader reader){
        for(Book book : reader.getBooks()){
            if (book.getId() == bookId){
                reader.getBooks().remove(book);
                System.out.println("Kitap başarıyla iade edildi");
                System.out.println("Ücret iadeniz" + " " + book.getPrice() + "TL dir");
            } else {
                System.out.println("Kullanıcıda böyle bir kitap bulunmuyor");
            }
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



      public void listBooksByCategory(String category){
        String cleanedInput = category.replaceAll("[\\s+.,!?:;\"'()\\[\\]{}]", "").toLowerCase();
        Set<String> keys = categories.keySet();

        for(String key : keys){

            if(key.contains(cleanedInput)){

                Set<Integer> bookKeys=categories.get(key).keySet();

                for(Integer bookKey : bookKeys){

                    System.out.println(categories.get(key).get(bookKey).toString());
                }
            } else{
                System.out.println("There is no category with this input");



            }
        }
      }




}
