package bibloteka.ui;

import bibloteka.dao.UserDao;
import bibloteka.domain.User;
import bibloteka.ui.utill.AppProperties;
import bibloteka.ui.utill.UIHelper;
import bibloteka.ui.validation.TextNonEmptyValidation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.IOException;
import javax.swing.border.EmptyBorder;


public class LoginFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JLabel lblUsername;
    private JLabel lblPassword;

    private JTextField txtUsername;
    private JTextField txtPassword;

    private JCheckBox chkSaveDetails;

    private JButton btnLogin;
    private JButton btnCancel;
    private JButton btnSettings;
    private UserDao dao;

    private TextNonEmptyValidation textNonEmptyValidation;

    public LoginFrame() {

        setContentPane(doComponentLayout());
        getRootPane().setDefaultButton(btnLogin);
        setFocusTraversalPolicy(new ComponentOrderPolicy());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel doComponentLayout() {

        JPanel content = new JPanel(new GridLayout(4, 1));
        content.setBorder(new EmptyBorder(3, 3, 3, 3));

        JLabel title = new JLabel("Kyqu ne sistem");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(title);

        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        lblUsername = new JLabel("Shfrytezuesi:");
        lblPassword = new JLabel("Fjalekalimi:");
        txtUsername = new JTextField(10);
        txtUsername.setName("Shfrytezuesi");
        textNonEmptyValidation = new TextNonEmptyValidation();
        txtUsername.setInputVerifier(textNonEmptyValidation);
        txtUsername.setText(AppProperties.username);

        txtPassword = new JPasswordField(10);
        txtPassword.setName("Fjalekalimi");
        txtPassword.setName(String.valueOf(textNonEmptyValidation));
        txtPassword.setText(AppProperties.password);

        chkSaveDetails = new JCheckBox("Ruaj shenimet");

        topPanel.add(lblUsername);
        topPanel.add(txtUsername);
        topPanel.add(lblPassword);
        topPanel.add(txtPassword);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnLogin = new JButton("Kyqu");
        btnCancel = new JButton("Anulo");
        btnSettings = new JButton();
        bottomPanel.add(btnSettings);
        bottomPanel.add(btnCancel);
        bottomPanel.add(btnLogin);

        txtUsername.addActionListener(this);
        txtPassword.addActionListener(this);

        btnCancel.addActionListener(this);
        btnCancel.setIcon(UIHelper.exitIcon);

        btnLogin.addActionListener(this);
        btnLogin.setIcon(UIHelper.okIcon);

        btnSettings.addActionListener(this);
        btnSettings.setIcon(UIHelper.wrenchIcon);

        content.add(topPanel);
        content.add(chkSaveDetails);
        content.add(bottomPanel);

        return content;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (btnCancel == ae.getSource()) System.exit(0);
        else if (txtUsername == ae.getSource()) {

            txtPassword.requestFocus();
        } else if (txtPassword == ae.getSource()) {

            btnLogin.requestFocus();
        } else if (btnLogin == ae.getSource()) {

            new LoginTask().execute();
        }

    }

    private class LoginTask extends SwingWorker<Void, Void> {
        private User user;
        private UserDao dao;

        public LoginTask() {
            dao = new UserDao();
        }

        @Override
        protected Void doInBackground() throws Exception { // login logic
            try {
                user = dao.login(txtUsername.getText(), txtPassword.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void done() {
            if (user != null) {
                if (chkSaveDetails.isSelected()) {
                    AppProperties.username = txtUsername.getText();
                    AppProperties.password = txtPassword.getText();
                }
                AppProperties.storeProperties();
                AppProperties.LOGGED_IN_USER = user;
                new BibliotekaMainFrame();
                dispose();
            } else {
                UIHelper.error("Shfrytezuesi / Fjalekalimi jane gabim !");

            }

        }

    }

    private class ComponentOrderPolicy extends FocusTraversalPolicy {
        @Override
        public Component getComponentAfter(Container aContainer, Component aComponent) {
            if (aComponent == txtUsername) return txtPassword;
            else if (aComponent == txtPassword) return btnLogin;
            else if (aComponent == btnLogin) return btnCancel;
            else if (aComponent == btnCancel) return txtUsername;
            else return txtUsername;

        }

        @Override
        public Component getComponentBefore(Container aContainer, Component aComponent) {
            if (aComponent == txtUsername) return btnCancel;
            else if (aComponent == txtPassword) return txtUsername;
            else if (aComponent == btnLogin)

                return txtPassword;
            else if (aComponent == btnCancel)

                return btnLogin;
            else

                return txtUsername;

        }

        @Override
        public Component getDefaultComponent(Container aContainer) {
            return txtUsername;
        }

        @Override
        public Component getFirstComponent(Container aContainer) {
            return txtUsername;
        }

        @Override
        public Component getLastComponent(Container aContainer) {
            return btnCancel;
        }

    }

    public void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame();
            }

        });
    }
}
