package com.workintech.bookCollection;

import com.workintech.libraryManagement.Library;

import java.util.Objects;

public abstract class Book {

    private int id;
    private String author;
    private String title;
    private double price;
    private boolean available;
    private String edition;
    private String owner;


    public Book(int id, String author, String title, double price, String edition) {

        if (Library.getBooks().containsKey(id)) {
            throw new IllegalArgumentException("A book with ID " + id +
                    " already exists in the system. Please enter another ID.");
        }

        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.edition = edition;
        this.available = true;


    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }



    public String getEdition() {
        return edition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Book book)) return false;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isAvailable() {
        return available;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", edition='" + edition + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
