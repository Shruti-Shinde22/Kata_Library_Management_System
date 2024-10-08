package Main;

import Exceptions.BookNotAvailable;
import Exceptions.BookNotBorrowed;

public class Book implements BookInterface {
    private final String isbn;
    private final String title;
    private final String author;
    private final int year;
    private boolean borrowed;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrowed = false; //by default the book is not borrowed
    }


    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYear() {
        return year;
    }


    //method to borrow the book
    @Override
    public void bookBorrow() throws BookNotAvailable {
        if(borrowed){
            throw new BookNotAvailable("Book already Borrowed");
        }
        borrowed=true;
    }

    //method to return the book
    @Override
    public void bookReturn() throws BookNotBorrowed {
        if(!borrowed){
            throw new BookNotBorrowed("Book not Borrowed");
        }
        borrowed =false;
    }


    //book is currently borrowed or not
    @Override
    public boolean isBorrowed() {
        return borrowed;
    }
}
