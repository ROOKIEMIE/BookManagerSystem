package sys.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="books_brief_information")
public class BookInfo {
    @Id
    @Column(name="ISBN")
    @GeneratedValue(generator = "keyValue")
    @GenericGenerator(name = "keyValue", strategy = "assigned")
    private String ISBN;
    private String name;

    public  BookInfo() {
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInfo bookInfo = (BookInfo) o;
        return ISBN.equals(bookInfo.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }

    @Override
    public String toString() {
        return ISBN + ":" + name;
    }
}
