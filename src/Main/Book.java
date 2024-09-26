package Main;

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
        this.borrowed = false;
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

    @Override
    public void bookBorrow() throws Exception {
        if(borrowed){
            throw new Exception("Book already Borrowed");
        }
        borrowed=true;
    }

    @Override
    public void bookReturn() throws Exception{
        if(!borrowed){
            throw new Exception("Book not Borrowed");
        }
        borrowed =false;
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }
}
