package sys.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sys.models.BookInfo;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "SELECT book " + "FROM sys.models.BookInfo book ";

        Query<BookInfo> query = session.createQuery(hql);
        List<BookInfo> books = query.getResultList();
        for (BookInfo book : books) {
            System.out.println(book);
        }

        session.close();
    }
}
