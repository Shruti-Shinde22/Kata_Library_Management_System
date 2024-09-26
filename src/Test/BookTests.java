package Test;

import Main.Book;
import Main.BookInterface;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BookTests {
    private BookInterface book;

    @BeforeEach
    public void setUp(){
        book = new Book(
                "123456",
                "Atomic Habits",
                "James Clear",
                2018
        );
    }

    @Test
    public void testGetIsbn(){
        assertEquals("123456",book.getIsbn());
    }

    @Test
    public void testGetTitle(){
        assertEquals("Atomic Habits",book.getTitle());
    }

    @Test
    public void testGetAuthor(){
        assertEquals("James Clear", book.getAuthor());
    }

    @Test
    public void testGetYear(){
        assertEquals(2018,book.getYear());
    }

    @Test
    public void testBookBorrowSuccess() throws Exception {
        try{
            book.bookBorrow();
        }catch(Exception e){
            throw new Exception(e);
        }
        assertTrue(book.isBorrowed());
    }

    @Test
    public void testBookBorrowFailure() throws Exception {
        try{
            book.bookBorrow();
        }catch(Exception e){
            throw new Exception(e);
        }
        assertThrows(Exception.class, ()-> book.bookBorrow());
    }

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

    @Test
    public void testBookReturnFailure(){
        assertThrows(Exception.class, ()-> book.bookReturn());
    }
}
