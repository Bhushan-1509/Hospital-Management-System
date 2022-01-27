import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class AdminLoginBtnActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        InitialLoading.load.dispose();
        InitialLoading.load = new AdminLoginForm();
        try{
            new PlayAudio();
        } catch(LineUnavailableException ex) {
            ex.printStackTrace();
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        }
        InitialLoading.load.setVisible(true);
        InitialLoading.load.setDefaultCloseOperation(3);

    }
}

class ReceptionlistLoginBtnActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        InitialLoading.load.dispose();
        InitialLoading.load  = new ReceptionalistLoginForm();
        try{
            new PlayAudio();
        } catch(LineUnavailableException ex) {
            ex.printStackTrace();
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        }

    }
}

public class Main extends JFrame{
    LoginBtn AdminLoginBtn;
    LoginBtn ReceptionistLoginBtn;
    LoginBtn DoctorLoginBtn;
    public static Main main;
    public Main(){

        setLayout(null);
        setSize(1500,700);
        setTitle("Hospital Management System ");
        setLayout(new BorderLayout());
        JLabel backgroundImage = new JLabel(new ImageIcon("images/hmbackground.png"));
        this.setLocation(0,0);

        AdminLoginBtn = new LoginBtn("ADMIN");
//        AdminLoginBtn.setBounds(30,200,200,60);
        AdminLoginBtn.addActionListener((ActionListener)new AdminLoginBtnActionListener());
        ReceptionistLoginBtn = new LoginBtn("RECEPTIONLIST");
//        ReceptionistLoginBtn.setBounds(70,90,300,300);
        ReceptionistLoginBtn.addActionListener((ActionListener) new ReceptionlistLoginBtnActionListener());
        DoctorLoginBtn = new LoginBtn("DOCTOR");
//        DoctorLoginBtn.setBounds(120,100,300,300);
        JLabel adminImage = new JLabel(new ImageIcon("images/admin.png"));
        JLabel receptionlistImage = new JLabel(new ImageIcon("images/receptionist.png"));
        JLabel doctorImage = new JLabel(new ImageIcon("images/doctor.png"));
        Section admin = new Section();
        admin.setBounds(200 ,240,200,250);
        admin.add(adminImage);
        admin.add(AdminLoginBtn);
        Section receptionist = new Section();
        receptionist.setBounds(580,240,200,250);
//        receptionist.setBackground(Color.red);
        receptionist.add(receptionlistImage);
        receptionist.add(ReceptionistLoginBtn);
        Section doctor = new Section();
        doctor.setBounds(940,240,200,250);
//        doctor.setBackground(Color.CYAN);
        doctor.add(doctorImage);
        doctor.add(DoctorLoginBtn);
        add(admin);
        add(receptionist);
        add(doctor);
        add(backgroundImage);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(3);

    }


}
