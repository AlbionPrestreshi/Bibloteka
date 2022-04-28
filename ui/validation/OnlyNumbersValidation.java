package bibloteka.ui.validation;

import bibloteka.ui.utill.UIHelper;

import javax.swing.*;

public class OnlyNumbersValidation extends InputVerifier {

    @Override
    public boolean verify(JComponent component) {
        if (component instanceof JTextField) {
            String content = ((JTextField) component).getText();
            try {
                Integer.parseInt(content);
                return true;
            } catch (Exception ex) {
                UIHelper.error("Vetem numra please!");
                return false;
            }

        }
        return true;

    }

}