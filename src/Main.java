import javax.swing.*;
import java.awt.*;




public class Main extends JFrame{
    LoginBtn AdminLoginBtn;
    LoginBtn ReceptionistLoginBtn;
    LoginBtn DoctorLoginBtn;

    public Main(){
        setLayout(null);
        setSize(1500,700);
        setTitle("Hospital Management System ");
        setLayout(new BorderLayout());
        JLabel backgroundImage = new JLabel(new ImageIcon("images/hmbackground.png"));
        this.setLocation(0,0);

        AdminLoginBtn = new LoginBtn("ADMIN");
//        AdminLoginBtn.setBounds(30,200,200,60);
        ReceptionistLoginBtn = new LoginBtn("RECEPTIONLIST");
//        ReceptionistLoginBtn.setBounds(70,90,300,300);
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
