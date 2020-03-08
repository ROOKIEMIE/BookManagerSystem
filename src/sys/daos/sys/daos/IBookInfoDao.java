package sys.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.excptions.NullBookByISBNException;
import sys.excptions.NullBookByNameException;
import sys.models.BookInfo;

import java.util.List;

public interface IBookInfoDao {
    public List<BookInfo> getBooks(Session session);
    public BookInfo getBookByISBN(Session session, String ISBN) throws NullBookByISBNException;
    public List<BookInfo> getBooksByName(Session session, String name) throws NullBookByNameException;
    public boolean inserABook(Session session, BookInfo book);
    public boolean deleteABookByISBN(Session session, Transaction transaction, String ISBN);
    public boolean deleteABookByName(Session session, Transaction transaction, String Name);
}
