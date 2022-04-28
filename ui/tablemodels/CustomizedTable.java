package bibloteka.ui.tablemodels;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.*;

public class CustomizedTable extends JTable {
    public CustomizedTable(TableModel model) {
        super(model);
        setRowHeight(30);
        setFont(new Font("Tahoma", Font.PLAIN, 18));
        getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
    }

}