package sys.excptions;

public class NullBookByNameException extends Exception{
    public NullBookByNameException(String name) {
        new Exception("cannot find the book by name:" + name);
    }
}
