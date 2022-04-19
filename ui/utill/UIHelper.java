package bibloteka.ui.utill;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Objects;

public class UIHelper {

    public static ImageIcon infoIcon;
    public static ImageIcon errorIcon;
    public static ImageIcon confirmIcon;
    public static ImageIcon warningIcon;
    public static ImageIcon deleteIcon;
    public static ImageIcon saveIcon;
    public static ImageIcon abortIcon;
    public static ImageIcon newIcon;
    public static ImageIcon exitIcon;
    public static ImageIcon okIcon;
    public static ImageIcon wrenchIcon;
    public static ImageIcon aboutIcon;
    public static ImageIcon addIcon;
    public static ImageIcon searchIcon;
    public static ImageIcon findIcon;
    public static ImageIcon authorsIcon;
    public static ImageIcon notesIcon;
    public static ImageIcon repairIcon;

    static {
        newIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Create.png"));

        saveIcon = new ImageIcon(Objects.requireNonNull(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Save.png")));
        deleteIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Delete.png"));

        abortIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Abort.png"));

        exitIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Exit.png"));
        okIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/OK.png"));
        wrenchIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Wrench.png"));

        aboutIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/About.png"));

        addIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Add.png"));
        searchIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Search.png"));

        findIcon = new ImageIcon(UIHelper.class.getResource("biblioteka/ui/resources/Find.png"));
        authorsIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Authors.png"));

        notesIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Notes.png"));

        repairIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Repair.png"));

        infoIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Info.png"));
        errorIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Error.png"));

        confirmIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Question.png"));

        warningIcon = new ImageIcon(UIHelper.class.getResource("/edu/tick/biblioteka/ui/resources/Warning.png"));

    }

    public static void info(String message) {
        JOptionPane.showMessageDialog(null, message, "Informate", JOptionPane.INFORMATION_MESSAGE, infoIcon);

    }

    public static void warning(String message) {
        JOptionPane.showMessageDialog(null, message, "Kujdes", JOptionPane.WARNING_MESSAGE, warningIcon);

    }

    public static void error(String message) {
        JOptionPane.showMessageDialog(null, message, "Gabim", JOptionPane.ERROR_MESSAGE, errorIcon);

    }

    public static int confirm(String message) {
        return JOptionPane.showConfirmDialog(null, "A jeni te sigurt per veprimin?", "Konfirmo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, confirmIcon);

    }
}