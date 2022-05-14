package bibloteka.domain;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "books")
public class Book extends BaseEntity {
    @DatabaseField(foreign = true, columnName = "category_id", foreignColumnName = "id")

    private Category category;
    @DatabaseField
    private String title;
    @DatabaseField
    private String photo;
    @DatabaseField
    private String isbn;
    @DatabaseField(columnName = "publish_date")
    private Date publishDate;

    public Category getCategory() {

        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null)

            return false;
        if (getClass() != obj.getClass())

            return false;
        Book other = (Book) obj;
        if (id != other.id)

            return false;
        return true;

    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", category=" + category + ", title=" +

                title + ", photo=" + photo + ", isbn=" + isbn

                + ", publishDate=" + publishDate + "]";

    }

}
