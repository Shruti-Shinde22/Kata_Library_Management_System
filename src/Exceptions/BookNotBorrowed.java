package Exceptions;

public class BookNotBorrowed extends RuntimeException{
    public BookNotBorrowed(String message){
        super(message);
    }
}