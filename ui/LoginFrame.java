package bibloteka.ui;

import bibloteka.dao.UserDao;
import bibloteka.domain.User;
import bibloteka.ui.utill.UIHelper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;



public class LoginFrame extends JFrame implements ActionListener {
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JCheckBox chkSaveDetails;
    private JButton btnLogin;
    private JButton btnCancel;
    private JButton btnSettings;
    private UserDao dao;

    public LoginFrame() {

        setContentPane(doComponentLayout()); //default butoni kur shtypet tasti ENTER getRootPane().setDefaultButton(btnLogin); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setResizable(false); setLocationRelativeTo(null);// me vendose dritaren ne qender dao = new UserDao(); pack(); setVisible(true);

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
        txtPassword = new JPasswordField(10);
        txtPassword.setName("Fjalekalimi");

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
            try {
                User loginUser = dao.login(txtUsername.getText(), txtPassword.getText());
                if (loginUser == null) UIHelper.error("Username / Password gabim !");
                else {
                    dispose();
                    UIHelper.info("Logged in sucesfully");
                }
            } catch (Exception e) {
                UIHelper.error(e.getMessage());
            }

        }

    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame();
            }

        });
    }

}
