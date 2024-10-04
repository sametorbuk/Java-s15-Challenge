import com.workintech.bookCollection.Book;
import com.workintech.bookCollection.Novel;
import com.workintech.libraryManagement.Library;
import com.workintech.libraryManagement.Member_Record;
import com.workintech.persons.Person;
import com.workintech.persons.Reader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Object[][] booksData = {
                {1, "Victor Hugo", "Sefiller", 14.43, "2023-10-01"},
                {2, "George Orwell", "1984", 12.99, "2023-10-02"},
                {3, "J.K. Rowling", "Harry Potter ve Felsefe Taşı", 15.50, "2023-10-03"},
                {4, "Jane Austen", "Gurur ve Ön Yargı", 11.00, "2023-10-04"},
                {5, "F. Scott Fitzgerald", "Muhteşem Gatsby", 13.75, "2023-10-05"},
                {6, "Mark Twain", "Tom Sawyer'ın Maceraları", 10.25, "2023-10-06"},
                {7, "Herman Melville", "Moby Dick", 16.00, "2023-10-07"},
                {8, "Charles Dickens", "İki Şehrin Hikayesi", 9.99, "2023-10-08"},
                {9, "Leo Tolstoy", "Anna Karenina", 14.00, "2023-10-09"},
                {10, "Gabriel Garcia Marquez", "Yüzyıllık Yalnızlık", 18.00, "2023-10-10"},
                {11, "J.R.R. Tolkien", "Yüzüklerin Efendisi", 20.00, "2023-10-11"},
                {12, "Stephen King", "O", 15.75, "2023-10-12"},
                {13, "Agatha Christie", "Doğu Ekspresinde Cinayet", 12.50, "2023-10-13"},
                {14, "Harper Lee", "Bülbülü Öldürmek", 10.50, "2023-10-14"},
                {15, "Ray Bradbury", "Fahrenheit 451", 13.00, "2023-10-15"},
        };


          Library library = new Library();





        for(int i = 0 ; i < booksData.length ; i++){
           int id = (int) booksData[i][0];
           String author =(String) booksData[i][1];
           String title = (String) booksData[i][2];
           double price = (double) booksData[i][3];
           String edition = (String) booksData[i][4];

           Book novel = new Novel(id , author , title , price , edition);
           Library.newBook(novel);

        }


        Person reader1 = new Reader("Samet" , new Member_Record(23 ,
                "0505780213" , "Akbelen mahallesi 84090. sokak" ,
                "Samet " , 5,"04.10.24" ,
                "Reader") , new ArrayList<Book>() );

        Person reader2 = new Reader("Hakan" , new Member_Record(24 ,
                "050578234323" , "Saz mahallesi 823423. sokak" ,
                "Hakan " , 5,"04.10.24" ,
                "Reader") , new ArrayList<Book>() );

        Library.addReader((Reader) reader1);
        Library.addReader((Reader) reader2);


        System.out.println("***********************");

        System.out.println(Library.getBooks().get(5).toString());








    }
}