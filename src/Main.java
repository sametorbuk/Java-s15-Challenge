import com.workintech.bookCollection.Book;
import com.workintech.bookCollection.Magazines;
import com.workintech.bookCollection.Novel;
import com.workintech.bookCollection.StudyBooks;
import com.workintech.libraryManagement.Library;
import com.workintech.libraryManagement.Member_Record;
import com.workintech.persons.Person;
import com.workintech.persons.Reader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Library Library = new Library();

        Object[][] novelsData = {
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
        for(int i = 0 ; i < novelsData.length ; i++){
           int id = (int) novelsData[i][0];
           String author =(String) novelsData[i][1];
           String title = (String) novelsData[i][2];
           double price = (double) novelsData[i][3];
           String edition = (String) novelsData[i][4];

           Book novel = new Novel(id , author , title , price , edition);
           Library.newBook(novel);

        }
        Object[][] studyBooksData = {
                {16, "Thomas H. Cormen", "Algoritmalar", 45.00, "2023-10-01"},
                {17, "Herbert Schildt", "Java: Kapsamlı Referans", 50.00, "2023-10-02"},
                {18, "Robert C. Martin", "Temiz Kod", 42.00, "2023-10-03"},
                {19, "David Flanagan", "JavaScript: Kesin Kılavuz", 39.00, "2023-10-04"},
                {20, "Andrew S. Tanenbaum", "Bilgisayar Ağları", 55.00, "2023-10-05"},
                {21, "Bjarne Stroustrup", "C++ Programlama Dili", 60.00, "2023-10-06"},
                {22, "John K. Ousterhout", "Unix İşletim Sistemi Tasarımı", 48.00, "2023-10-07"},
                {23, "Martin Fowler", "Yeniden Yapılandırma", 40.00, "2023-10-08"},
                {24, "Daniel Shiffman", "Kodun Doğası", 37.00, "2023-10-09"},
                {25, "Jesse Liberty", "C# Programlama", 44.00, "2023-10-10"},
                {26, "Jim Heskett", "C# Derinlemesine", 52.00, "2023-10-11"},
                {27, "Andrew S. Tanenbaum", "Modern İşletim Sistemleri", 58.00, "2023-10-12"},
                {28, "Michael T. Nygard", "Bırakın Gitsin!", 46.00, "2023-10-13"},
                {29, "Martin Kleppmann", "Veri Yoğun Uygulamaları Tasarlamak", 55.00, "2023-10-14"},
                {30, "Kathy Sierra", "Head First Java", 49.00, "2023-10-15"},
        };


        for(int i = 0 ; i < studyBooksData.length ; i++){
            int id = (int) studyBooksData[i][0];
            String author =(String) studyBooksData[i][1];
            String title = (String) studyBooksData[i][2];
            double price = (double) studyBooksData[i][3];
            String edition = (String) studyBooksData[i][4];

            Book studyBook = new StudyBooks(id , author , title , price , edition);
            Library.newBook(studyBook);

        }

        Object[][] magazineData = {
                {31, "National Geographic", "Ekim 2023 Sayısı", 6.99, "2023-10-01"},
                {32, "TIME", "İklim Krizi", 5.99, "2023-10-02"},
                {33, "Forbes", "2023 Milyarderleri", 7.50, "2023-10-03"},
                {34, "Vogue", "2023 Moda Trendleri", 8.50, "2023-10-04"},
                {35, "Scientific American", "Uzay Keşifleri", 6.50, "2023-10-05"},
                {36, "The New Yorker", "Siyasi Yorumlar", 7.25, "2023-10-06"},
                {37, "Wired", "Teknoloji ve İnovasyon", 6.00, "2023-10-07"},
                {38, "Sports Illustrated", "2023 Spor Önizlemesi", 5.50, "2023-10-08"},
                {39, "Rolling Stone", "Müzik Trendleri", 7.00, "2023-10-09"},
                {40, "The Economist", "Küresel Ekonomik Görünüm", 6.75, "2023-10-10"},
                {41, "Men's Health", "Fitness İpuçları", 5.99, "2023-10-11"},
                {42, "Women's Health", "Beslenme Rehberi", 5.99, "2023-10-12"},
                {43, "PC Magazine", "2023'ün En İyi Teknolojileri", 6.49, "2023-10-13"},
                {44, "Architectural Digest", "Ev Tasarımı", 8.00, "2023-10-14"},
                {45, "Better Homes & Gardens", "Bahçecilik İpuçları", 4.99, "2023-10-15"},
        };

        for(int i = 0 ; i < magazineData.length ; i++){
            int id = (int) magazineData[i][0];
            String author =(String) magazineData[i][1];
            String title = (String) magazineData[i][2];
            double price = (double) magazineData[i][3];
            String edition = (String) magazineData[i][4];

            Book magazine = new Magazines(id , author , title , price , edition);
            Library.newBook(magazine);

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
        for(Object[] readerData : readersData){
            String name =(String) readerData[0];
            Member_Record record = (Member_Record) readerData[1];
            Library.addReader(new Reader(name,record,new ArrayList<>()));
        }






        System.out.println("***********************");

     Library.deleteBook(80);





    }
}