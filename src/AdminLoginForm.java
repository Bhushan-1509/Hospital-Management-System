import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.*;


class ResultRows {
    public static int getNoOfRows(ResultSet r) throws SQLException {
        int count = 1;
        while(r.next()){
            count++;
        }
        return count - 1;
    }
}



public class AdminLoginForm extends JFrame {
    JLabel userNameLabel;
    JLabel passwordLabel;
    JTextField userNameField;
    JPasswordField passwordField;
    LoginBtn loginBtn;
    public AdminLoginForm(){
        userNameLabel = new JLabel("Username : ");
        userNameLabel.setBounds(320,295,190,30);
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        passwordLabel = new JLabel("Password : ");
        passwordLabel.setBounds(320,395,190,40);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        userNameField = new JTextField();
        userNameField.setBounds(520,300, 350,50);
        userNameField.setFont(new Font("Arial", Font.PLAIN, 19));
        passwordField = new JPasswordField();
        passwordField.setBounds(520,400, 350,50);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        loginBtn = new LoginBtn("LOGIN");
        loginBtn.setText("Login");
        loginBtn.setBounds(570,490,180,50);
        loginBtn.setFont(new Font("Arial", Font.PLAIN, 17));
        loginBtn.addActionListener(new AdminPaneLoginBtnActionListener());
        setLayout(new BorderLayout());
        setSize(1500,700);
        setTitle("Admin Login Panel ");
        JLabel backgroundImage = new JLabel(new ImageIcon("images/adminpanel.png"));
        add(userNameLabel);
        add(passwordLabel);
        add(userNameField);
        add(passwordField);
        add(loginBtn);
        add(backgroundImage);
        setVisible(true);
        setLocation(0,0);
    }
    class AdminPaneLoginBtnActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //only existing user can login
        /*
            SQL query for sqlite database
            SELECT * from admin_users
            WHERE username = 'inputusername' AND password = 'inputpassword';
        */
            String inputUsername = userNameField.getText();
            char[] inputPassword = passwordField.getPassword();
            try{
                Connection cn = null;
                Class.forName("com.mysql.jdbc.Driver");
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","");

                String query = "select * from admin_users " + "where username = "+ "'" + inputUsername.toString() + "'" + "and "+ "'" + inputPassword.toString() + "'" + ";";
                Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet result = st.executeQuery(query);
                String uname = null;
                String passwd = null;
                boolean res = result.first();
                if(res == true) {
                    uname = result.getString("username");
                    passwd = result.getString("password");
                }
                if((uname == inputUsername) && (passwd == inputPassword.toString())) {

                    InitialLoading.load.dispose();
                    InitialLoading.load = new AdminPortal();
                    new PlayAudio();
                    DesktopNotificationGenerator.generateDesktopNotification("Login successful !","Admin Portal");

                }
               else if(uname != inputUsername && passwd == inputPassword.toString()){
                    new PlayAudio();
                    JOptionPane.showMessageDialog(InitialLoading.load, "This user does not exists !", "Alert", JOptionPane.WARNING_MESSAGE);
               }
//                if(result.isFirst()){
//                    DesktopNotificationGenerator.generateDesktopNotification("First","ahhhhhhhh!");
//
//                }
//                if(result.isBeforeFirst()){
//                    DesktopNotificationGenerator.generateDesktopNotification("before first","ahhhhhhhh!");
//
//                }
//                if(result.isAfterLast()){
//                    DesktopNotificationGenerator.generateDesktopNotification("after last","ahhhhhhhh!");
//
//                }


                st.close();
                cn.close();


            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

        }
    }


};
