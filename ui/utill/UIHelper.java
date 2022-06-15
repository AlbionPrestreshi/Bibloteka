package bibloteka.ui.utill;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
        newIcon = new ImageIcon(UIHelper.class.getResource("/Create.png"));
        saveIcon = new ImageIcon(UIHelper.class.getResource("/Save.png"));
        deleteIcon = new ImageIcon(UIHelper.class.getResource("/Delete.png"));
        abortIcon = new ImageIcon(UIHelper.class.getResource("/Abort.png"));
        exitIcon = new ImageIcon(UIHelper.class.getResource("/Exit.png"));
        okIcon = new ImageIcon(UIHelper.class.getResource("/OK.png"));
        wrenchIcon = new ImageIcon(UIHelper.class.getResource("/Wrench.png"));
        aboutIcon = new ImageIcon(UIHelper.class.getResource("/About.png"));
        addIcon = new ImageIcon(UIHelper.class.getResource("/Add.png"));
        searchIcon = new ImageIcon(UIHelper.class.getResource("/Search.png"));
        findIcon = new ImageIcon(UIHelper.class.getResource("/Find.png"));
        authorsIcon = new ImageIcon(UIHelper.class.getResource("/Authors.png"));
        notesIcon = new ImageIcon(UIHelper.class.getResource("/Notes.png"));
        repairIcon = new ImageIcon(UIHelper.class.getResource("/Repair.png"));
        infoIcon = new ImageIcon(UIHelper.class.getResource("/Info.png"));
        errorIcon = new ImageIcon(UIHelper.class.getResource("/Error.png"));
        confirmIcon = new ImageIcon(UIHelper.class.getResource("/Question.png"));
        warningIcon = new ImageIcon(UIHelper.class.getResource("/Warning.png"));
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
        return JOptionPane.showConfirmDialog(null, "A jeni te sigurt per veprimin?", "Konfirmo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, confirmIcon);
    }
}

