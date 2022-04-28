package bibloteka.ui;


import bibloteka.ui.utill.UIHelper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BibliotekaMainFrame extends JFrame {

    private JDesktopPane desktop;

    private JToolBar toolbar;

    private JButton btnRegister;

    private JButton btnSearch;

    public BibliotekaMainFrame() {
        super("Biblioteka");

        desktop = new JDesktopPane();
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("Skedar");
        menuFile.setMnemonic(KeyEvent.VK_S);
        menuBar.add(menuFile);

        JMenuItem menuItem = new JMenuItem();
        menuItem.setAction(new BookAction("Librat"));
        KeyStroke keyStrokeToRegister = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
        menuItem.setAccelerator(keyStrokeToRegister);

        menuFile.add(menuItem);

        menuItem = new JMenuItem();
        menuItem.setAction(new AuthorsAction("Autoret"));
        menuFile.add(menuItem);

        menuItem = new JMenuItem();
        menuItem.setAction(new CategoriesAction("Kategorite"));
        menuFile.add(menuItem);

        menuItem = new JMenuItem();
        menuItem.setAction(new ExitAction("Dil"));
        menuFile.add(menuItem);

        JMenu menuAbout = new JMenu();
        menuItem = new JMenuItem();
        menuItem.setAction(new AboutAction("Per ne"));
        menuAbout.add(menuItem);

        menuBar.add(menuAbout);

        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(((int) d.getWidth()) / 2, ((int) d.getHeight()) / 2);

        getContentPane().add(desktop);

        createToolBar();

        getContentPane().add(toolbar, BorderLayout.NORTH);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }

    private class AuthorsAction extends AbstractAction {
        public AuthorsAction(String title) {
            super(title, UIHelper.authorsIcon);

        }

        @Override
        public void actionPerformed(ActionEvent arg0) { // ketu vjen kodi qe hap frame-in e autorve
        }

    }

    private class BookAction extends AbstractAction {
        public BookAction(String title) {
            super(title, UIHelper.notesIcon);

        }

        @Override
        public void actionPerformed(ActionEvent arg0) { // ketu vjen kodi qe hap frame-in e librave
        }

    }

    private class CategoriesAction extends AbstractAction {
        public CategoriesAction(String title) {
            super(title, UIHelper.repairIcon);

        }

        @Override
        public void actionPerformed(ActionEvent arg0) { // ketu vjen kodi qe hap frame-in e kategorive
        }

    }

    private class ExitAction extends AbstractAction {
        public ExitAction(String title) {
            super(title, UIHelper.exitIcon);

        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (UIHelper.confirm("Aje i sigurte?") == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    private class AboutAction extends AbstractAction {
        public AboutAction(String title) {
            super(title, UIHelper.aboutIcon);

        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            UIHelper.info("TICK");
        }

    }

    public void createToolBar() {
        toolbar = new JToolBar();

        btnRegister = new JButton();
        btnRegister.setAction(new BookAction(""));
        btnRegister.setToolTipText("Regjistro liber te ri");

        toolbar.add(btnRegister);

        btnSearch = new JButton();
        btnSearch.setIcon(UIHelper.searchIcon);
        toolbar.add(btnSearch);

    }

}
