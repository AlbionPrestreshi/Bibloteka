package bibloteka.ui.tablemodels;

import bibloteka.domain.Author;

import java.util.List;


public class AuthorTableModel extends BaseTableModel<Author> {

    public AuthorTableModel(String[] columns, List<Author> elements) {
        super(columns, elements);
    }

    @Override
    public Object getValueAt(int row, int col) {

        switch (col) {
            case 0:

                return elements.get(row).getId();

            case 1:
                return elements.get(row).getName();
            case 2:

                return elements.get(row).getLastName();
            case 3:

                return elements.get(row).getCountry();
            default:

                break;
        }
        return null;

    }
}
