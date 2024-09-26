package Main;

public class Book implements BookInterface{

    @Override
    public String getIsbn() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public int getYear() {
        return 0;
    }

    @Override
    public void bookBorrow() throws Exception {

    }

    @Override
    public void bookReturn() throws Exception {

    }

    @Override
    public boolean isBorrowed() {
        return false;
    }
}
