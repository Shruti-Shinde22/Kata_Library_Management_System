package Main;

import Exceptions.BookNotAvailable;
import Exceptions.BookNotBorrowed;

public interface BookInterface {
    String getIsbn();
    String getTitle();
    String getAuthor();
    int getYear();

    void bookBorrow() throws BookNotAvailable;
    void bookReturn() throws BookNotBorrowed;
    boolean isBorrowed();
}
