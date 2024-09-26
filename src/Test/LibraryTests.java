package Test;

import Exceptions.BookNotAvailable;
import Exceptions.BookNotBorrowed;
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


    //sets up the object with fixed values for each test
    @BeforeEach
    public void setUp() throws Exception {
        library = new Library();
        book = new Book(
                "123456",
                "Atomic Habits",
                "James Clear",
                2018
        );
        library.addBook(book);
    }

    //to verify correctly adding the book to libarray
    @Test
    public void testAddbook(){
        assertEquals(1,library.viewAvailabeBooks().size());
    }

    //to verify book borrowing
    @Test
    public void testBookBorrowSuccess() throws Exception {
        library.bookBorrow(book.getIsbn());
        assertTrue(book.isBorrowed());
    }


    //to verify already borrowed book borrowed again throws exception or not
    @Test
    public void testBookBorrowFailure() throws Exception {
        library.bookBorrow(book.getIsbn());
        assertThrows(BookNotAvailable.class, ()->library.bookBorrow(book.getIsbn()));
    }


    //to verify book returning
    @Test
    public void testBookReturnSuccess() throws Exception {
        library.bookBorrow(book.getIsbn());
        library.bookReturn(book.getIsbn());
        assertFalse(book.isBorrowed());
    }

    //to verify returned book agan returned throws exception or not
    @Test
    public void testBookReturnFailure(){
        assertThrows(BookNotBorrowed.class,()->library.bookReturn(book.getIsbn()));
    }

    //to verify shows all availble book or not
    @Test
    public void testViewAvailableBooks() throws Exception {
        assertEquals(1,library.viewAvailabeBooks().size());
        library.bookBorrow(book.getIsbn());
        assertEquals(0,library.viewAvailabeBooks().size());
        library.bookReturn(book.getIsbn());
        assertEquals(1,library.viewAvailabeBooks().size());
    }
}
