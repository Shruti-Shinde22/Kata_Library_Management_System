package Main;

import java.util.List;

public interface LibraryInterface {
    void addBook(BookInterface book) throws Exception;
    void bookBorrow(String isbn) throws Exception;
    void bookReturn(String isbn) throws Exception;
    List<BookInterface> viewAvailabeBooks();
}
