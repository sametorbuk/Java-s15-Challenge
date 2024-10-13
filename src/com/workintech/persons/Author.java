package com.workintech.persons;

import com.workintech.libraryManagement.Member_Record;

import javax.sound.midi.MetaMessage;
import java.util.ArrayList;

public class Author extends Person {
    private ArrayList books;
    private Member_Record record;


    public Author(String name) {
        super(name);
    }

    public void new_book() {

    }

    public void show_book() {
        for (Object book : books) {
            System.out.println(book);
        }
    }


    @Override
    public String whoYouAre() {
        return super.whoYouAre() + ">>>> Title >>>> Author";
    }


}
