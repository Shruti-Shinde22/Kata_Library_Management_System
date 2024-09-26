package Exceptions;

public class BookNotAvailable extends RuntimeException{

    public BookNotAvailable(String message){
        super(message);
    }
}