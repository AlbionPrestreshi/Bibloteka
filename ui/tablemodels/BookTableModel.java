package bibloteka.ui.tablemodels;

import bibloteka.domain.Book;

import java.util.List;

public class BookTableModel extends BaseTableModel<Book> {

    public BookTableModel() {
    }

    public BookTableModel(String[] columns, List<Book> elements) {
        super(columns, elements);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return elements.get(rowIndex).getId();
            case 1:
                return elements.get(rowIndex).getTitle();
            case 2:
                return elements.get(rowIndex).getIsbn();
            case 3:
                return elements.get(rowIndex).getPublishDate();
            default:
                break;
        }
        return null;
    }
}
