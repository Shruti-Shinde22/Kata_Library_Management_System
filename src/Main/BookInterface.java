package Main;

public interface BookInterface {
    String getIsbn();
    String getTitle();
    String getAuthor();
    int getYear();

    void bookBorrow() throws Exception;
    void bookReturn() throws Exception;
    boolean isBorrowed();
}
