package sys.excptions;

public class NullBookByISBNException extends Exception{
    public NullBookByISBNException(String ISBN) {
        new Exception("cannot find the book by ISBN:" + ISBN);
    }
}
