package bibloteka.ui.tablemodels;

import bibloteka.domain.Category;

import java.util.List;


public class CategoryTableModel extends BaseTableModel<Category> {

    public CategoryTableModel() {
    }

    public CategoryTableModel(String[] columns, List<Category> elements) {

        super(columns, elements);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {

            case 0:

                return elements.get(rowIndex).getId();

            case 1:

                return elements.get(rowIndex).getName();

            default:

                break;

        }

        return null;

    }
}