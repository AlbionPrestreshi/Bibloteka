package bibloteka.ui.validation;


import bibloteka.ui.utill.UIHelper;

import javax.swing.*;


public class TextNonEmptyValidation extends InputVerifier {

    @Override
    public boolean verify(JComponent component) {

        if (component instanceof JTextField) {
            if (((JTextField) component).getText().length() > 0) return true;
            else {
                UIHelper.error("Fusha eshte obligative");
                return false;
            }

        }

        return true;

    }

}