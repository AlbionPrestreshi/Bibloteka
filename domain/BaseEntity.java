package bibloteka.domain;

import com.j256.ormlite.field.DatabaseField;

public abstract class BaseEntity {

    @DatabaseField(columnName = "id", generatedId = true)
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == 0;
    }
}

