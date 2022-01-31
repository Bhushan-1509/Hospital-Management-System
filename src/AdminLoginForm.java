import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
            Connection cn = null;
            PreparedStatement stmt = null;

            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "");
                stmt = cn.prepareStatement("SELECT * FROM admin_users WHERE username = ? AND password = ?");
                stmt.setString(1, userNameField.getText());
                stmt.setString(2, passwordField.getPassword().toString());
                ResultSet result = stmt.executeQuery();
                String uname = null;
                String passwd = null;
                if(result.getRow() == 1){
                    result.absolute(1);
                    uname = result.getString("username");
                    passwd = result.getString("password");
                    if(uname == userNameField.getText() && passwd == passwordField.getPassword().toString() ){
                        InitialLoading.load.dispose();
                        new PlayAudio();
                        InitialLoading.load = new AdminPortal();
                        DesktopNotificationGenerator.generateDesktopNotification("Login Successful !","Admin Portal");

                    }

                }
                else{
                    new PlayAudio();
                    JOptionPane.showMessageDialog(InitialLoading.load,"User not found ","Alert",JOptionPane.INFORMATION_MESSAGE);

                }


            } catch(SQLException throwables) {
                throwables.printStackTrace();
            } catch(IOException ioException) {
                ioException.printStackTrace();
            } catch(InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch(AWTException awtException) {
                awtException.printStackTrace();
            } catch(UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            } catch(LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }


        }
    }


};
