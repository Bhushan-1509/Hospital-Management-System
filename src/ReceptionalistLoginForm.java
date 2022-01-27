import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class ReceptionalistLoginForm extends JFrame {
    JLabel userNameLabel;
    JLabel passwordLabel;
    JTextField userNameField;
    JPasswordField passwordField;
    LoginBtn loginBtn;

    public ReceptionalistLoginForm() {

        userNameLabel = new JLabel("Username : ");
        userNameLabel.setBounds(320, 295, 190, 30);
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        passwordLabel = new JLabel("Password : ");
        passwordLabel.setBounds(320, 395, 190, 40);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        userNameField = new JTextField();
        userNameField.setBounds(520, 300, 350, 50);
        userNameField.setFont(new Font("Arial", Font.PLAIN, 19));
        passwordField = new JPasswordField();
        passwordField.setBounds(520, 400, 350, 50);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        loginBtn = new LoginBtn("LOGIN");
        loginBtn.setText("Login");
        loginBtn.setBounds(570, 490, 180, 50);
        loginBtn.setFont(new Font("Arial", Font.PLAIN, 17));
//            loginBtn.addActionListener();
        loginBtn.addActionListener(new ReceptionlistLoginBtnActionListener());
        setLayout(new BorderLayout());
        setSize(1500, 700);
        setTitle("Admin Login Panel ");
        JLabel backgroundImage = new JLabel(new ImageIcon("images/recback.jpg"));
        add(userNameLabel);
        add(passwordLabel);
        add(userNameField);
        add(passwordField);
        add(loginBtn);
        add(backgroundImage);
        setVisible(true);
        setLocation(0, 0);
        setDefaultCloseOperation(3);
    }

    class ReceptionalistLoginPanelActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           //


        }
    }
}

