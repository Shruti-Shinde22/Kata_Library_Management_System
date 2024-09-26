package Test;

import Exceptions.BookNotAvailable;
import Exceptions.BookNotBorrowed;
import Main.Book;
import Main.BookInterface;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BookTests {
    private BookInterface book;

    //sets up new object with fixed values for each test case
    @BeforeEach
    public void setUp(){
        book = new Book(
                "123456",
                "Atomic Habits",
                "James Clear",
                2018
        );
    }

    //to verify correct isbn is returned or not
    @Test
    public void testGetIsbn(){
        assertEquals("123456",book.getIsbn());
    }


    //to verify correct title is returned
    @Test
    public void testGetTitle(){
        assertEquals("Atomic Habits",book.getTitle());
    }


    //to verfiy correct author returend
    @Test
    public void testGetAuthor(){
        assertEquals("James Clear", book.getAuthor());
    }

    //to verfiy correct year is returned
    @Test
    public void testGetYear(){
        assertEquals(2018,book.getYear());
    }

    //to check borrowing a book marks isborrowed true
    @Test
    public void testBookBorrowSuccess() throws Exception {
        try{
            book.bookBorrow();
        }catch(Exception e){
            throw new Exception(e);
        }
        assertTrue(book.isBorrowed());
    }

    //to check if borrowed book is borrowed again
    @Test
    public void testBookBorrowFailure() throws Exception {
        try{
            book.bookBorrow();
        }catch(Exception e){
            throw new Exception(e);
        }
        assertThrows(BookNotAvailable.class, ()-> book.bookBorrow());
    }

    //to check returning a book makrs isborrowed false
    @Test
    public void testBookReturnSucess() throws Exception {
        try{
            book.bookBorrow();
        }catch(Exception e){
            throw new Exception(e);
        }

        book.bookReturn();
        assertFalse(book.isBorrowed());
    }


    //to check if returned book or unborrowed book tried to return again
    @Test
    public void testBookReturnFailure(){
        assertThrows(BookNotBorrowed.class, ()-> book.bookReturn());
    }
}
