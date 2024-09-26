package Main;

import Exceptions.BookNotAvailable;
import Exceptions.BookNotBorrowed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library implements LibraryInterface{

    private final Map<String, BookInterface> books;

    public Library() {
        this.books = new HashMap<>();
    }

    @Override
    public void addBook(BookInterface book) throws Exception {
        if(books.containsKey(book.getIsbn())){
            throw new Exception("Book Already Exists.");
        }
        books.put(book.getIsbn(),book);
    }

    @Override
    public void bookBorrow(String isbn) throws Exception {
        BookInterface book = books.get(isbn);
        if(book!=null){
            try{
                book.bookBorrow();
            }catch(BookNotAvailable e){
                throw e;
            }
        }else{
            throw new Exception("Book not found!!");
        }

    }

    @Override
    public void bookReturn(String isbn) throws Exception {
        BookInterface book = books.get(isbn);
        if(book!=null){
            if(!book.isBorrowed()){
                throw new BookNotBorrowed("Book not borrowed");
            }
            book.bookReturn();
        }else{
            throw new Exception("Book not found!!");
        }
    }

    @Override
    public List<BookInterface> viewAvailabeBooks() {
        return books.values().stream()
                .filter(book -> !book.isBorrowed())
                .collect(Collectors.toList());
    }
}
