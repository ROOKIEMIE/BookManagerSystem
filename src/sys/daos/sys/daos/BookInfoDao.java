package sys.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.query.Query;
import sys.excptions.NullBookByISBNException;
import sys.excptions.NullBookByNameException;
import sys.models.BookInfo;

import java.util.List;

public class BookInfoDao implements IBookInfoDao {
    public BookInfoDao() {
    }

    public List<BookInfo> getBooks(Session session) {
        String hql = "SELECT book " + "FROM sys.models.BookInfo book ";
        List<BookInfo> books = null;
        Query<BookInfo> query = session.createQuery(hql);
        books = query.getResultList();
        return books;
    }

    public BookInfo getBookByISBN(Session session, String ISBN) throws NullBookByISBNException {
        String hql = "SELECT book " + "FROM sys.models.BookInfo book ";
        List<BookInfo> books = null;
        Query<BookInfo> query = session.createQuery(hql);
        books = query.getResultList();
        for (BookInfo book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        throw new NullBookByISBNException(ISBN);
    }

    public List<BookInfo> getBooksByName(Session session, String name) throws NullBookByNameException {
        String hql = "SELECT book " + "FROM sys.models.BookInfo book ";
        List<BookInfo> books = null;
        Query<BookInfo> query = session.createQuery(hql);
        books = query.getResultList();
        for (BookInfo book : books) {
            if (book.getName().equals(name)) {
                continue;
            }
            books.remove(book);
        }
        if (books.isEmpty()) {
            throw new NullBookByNameException(name);
        }
        return books;
    }

    public boolean inserABook(Session session, BookInfo book) {
        Transaction transaction = session.beginTransaction();
        session.save(book);
        try {
            transaction.commit();
        } catch (TransactionException te) {
            te.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteABookByISBN(Session session, Transaction transaction, String ISBN) {
        if (!transaction.isActive()) {
            transaction = session.beginTransaction();
        }
        String hql = "DELETE "
                + "FROM sys.models.BookInfo book "
                + "WHERE book.ISBN = '" + ISBN + "'";
        Query query = session.createQuery(hql);
        try {
            query.executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteABookByName(Session session, Transaction transaction, String Name) {
        if (!transaction.isActive()) {
            transaction = session.beginTransaction();
        }
        String hql = "DELETE "
                + "FROM sys.models.BookInfo book "
                + "WHERE book.name = '" + Name + "'";
        Query query = session.createQuery(hql);
        try {
            query.executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
