package Test;

import Main.Book;
import Main.BookInterface;
import Main.Library;
import Main.LibraryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class LibraryTests {

    private LibraryInterface library;
    private BookInterface book;

    @BeforeEach
    public void setUp(){
        library = new Library();
        book = new Book(
                "123456",
                "Atomic Habits",
                "James Clear",
                2018
        );
        try {
            library.addBook(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAddbook(){
        assertEquals(1,library.viewAvailabeBooks().size());
    }

    @Test
    public void testBookBorrowSuccess() throws Exception {
        library.bookBorrow(book.getIsbn());
        assertTrue(book.isBorrowed());
    }

    @Test
    public void testBookBorrowFailure() throws Exception {
        library.bookBorrow(book.getIsbn());
        assertThrows(Exception.class, ()->library.bookBorrow(book.getIsbn()));
    }

    @Test
    public void testBookReturnSuccess() throws Exception {
        library.bookBorrow(book.getIsbn());
        library.bookReturn(book.getIsbn());
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testBookReturnFailure(){
        assertThrows(Exception.class,()->library.bookReturn(book.getIsbn()));
    }

    @Test
    public void testViewAvailableBooks() throws Exception {
        assertEquals(1,library.viewAvailabeBooks().size());
        library.bookBorrow(book.getIsbn());
        assertEquals(0,library.viewAvailabeBooks().size());
        library.bookReturn(book.getIsbn());
        assertEquals(1,library.viewAvailabeBooks().size());
    }
}
