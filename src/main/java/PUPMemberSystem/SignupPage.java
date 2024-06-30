package PUPMemberSystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class SignupPage extends JFrame implements ActionListener {

    private JLabel lblbg, lbltitle, lblDescription, lblLName, lblFName, lblMName, lblStudNo, lblCourse, lblYear, lblAddress, lblContactNo, lblBday, lblPosition, lblAffiliation, lblEmail, lblPassword;
    private JPanel pnlYellow;
    private JTextField txfLName, txfFName, txfMName, txfStudNo, txfCourse, txfYear, txfAddress, txfContactNo, txfBday, txfPosition, txfAffiliation, txfEmail;
    private JPasswordField pwfPassword;
    private JButton btnMenu, btnSignup;

    SignupPage() {
        
        setTitle("SIGNUP PAGE");
        setSize(1000,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // background image
        lblbg = new JLabel();
        lblbg.setBounds(0, 0, 1000, 600);
        lblbg.setIcon(new ImageIcon(new ImageIcon("pup bg.png").getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
        lblbg.setLayout(null);
        add(lblbg);
        
        // title text
        lbltitle = new JLabel("CREATE AN ACCOUNT", SwingConstants.CENTER);
        lbltitle.setBounds(0, 40, 1000, 50);
        lbltitle.setForeground(new Color(150, 0, 0));
        lbltitle.setFont(new Font("Impact", Font.PLAIN, 40));
        lblbg.add(lbltitle);
        
        // Yellow JPanel
        pnlYellow = new JPanel();
        pnlYellow.setLayout(null);
        pnlYellow.setBackground(new Color(255, 255, 230));
        pnlYellow.setBounds(130, 120, 730, 370);
        lblbg.add(pnlYellow);

        // Please fill in every field
        lblDescription = new JLabel("Please fill in every field.");
        lblDescription.setBounds(15, 7, 200, 30);
        lblDescription.setFont(new Font("Aptos", Font.PLAIN, 14));
        pnlYellow.add(lblDescription);
        
        // Last Name
        lblLName = new JLabel("Last Name");
        lblLName.setBounds(35, 45, 150, 40);
        lblLName.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblLName);
        
        txfLName = new JTextField();
        txfLName.setBounds(35,80,200,30);
        pnlYellow.add(txfLName);
        
        // First Name
        lblFName = new JLabel("First Name");
        lblFName.setBounds(265, 45, 150, 40);
        lblFName.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblFName);
        
        txfFName = new JTextField();
        txfFName.setBounds(265,80,200,30);
        pnlYellow.add(txfFName);
        
        // Middle Name
        lblMName = new JLabel("Middle Name");
        lblMName.setBounds(495, 45, 150, 40);
        lblMName.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblMName);
        
        txfMName = new JTextField();
        txfMName.setBounds(495,80,200,30);
        pnlYellow.add(txfMName);
        
        //Student Number
        lblStudNo = new JLabel("Student Number");
        lblStudNo.setBounds(35, 115, 150, 40);
        lblStudNo.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblStudNo);
        
        txfStudNo = new JTextField();
        txfStudNo.setBounds(35,150,200,30);
        pnlYellow.add(txfStudNo);
        
        //Course
        lblCourse = new JLabel("Course");
        lblCourse.setBounds(265, 115, 100, 40);
        lblCourse.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblCourse);
        
        txfCourse = new JTextField();
        txfCourse.setBounds(265,150,90,30);
        pnlYellow.add(txfCourse);
        
        //Year
        lblYear = new JLabel("Year");
        lblYear.setBounds(375, 115, 100, 40);
        lblYear.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblYear);
        
        txfYear = new JTextField();
        txfYear.setBounds(375,150,90,30);
        pnlYellow.add(txfYear);
        
        //Address
        lblAddress = new JLabel("Address");
        lblAddress.setBounds(495, 115, 150, 40);
        lblAddress.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblAddress);
        
        txfAddress = new JTextField();
        txfAddress.setBounds(495,150,200,30);
        pnlYellow.add(txfAddress);
        
        //Contact Number
        lblContactNo = new JLabel("Contact Number");
        lblContactNo.setBounds(35, 185, 150, 40);
        lblContactNo.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblContactNo);
        
        txfContactNo = new JTextField();
        txfContactNo.setBounds(35,220,200,30);
        pnlYellow.add(txfContactNo);
        
        //Birthday
        lblBday = new JLabel("Birthday");
        lblBday.setBounds(265, 185, 150, 40);
        lblBday.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblBday);
        
        txfBday = new JTextField();
        txfBday.setBounds(265,220,200,30);
        pnlYellow.add(txfBday);
        
        //Position
        lblPosition = new JLabel("Position");
        lblPosition.setBounds(495, 185, 150, 40);
        lblPosition.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblPosition);

        txfPosition = new JTextField();
        txfPosition.setBounds(495,220,200,30);
        pnlYellow.add(txfPosition);
        
        //Affiliation
        lblAffiliation = new JLabel("Affiliation");
        lblAffiliation.setBounds(35, 255, 150, 40);
        lblAffiliation.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblAffiliation);
        
        txfAffiliation = new JTextField();
        txfAffiliation.setBounds(35,285,200,30);
        pnlYellow.add(txfAffiliation);
        
        //Email
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(265, 255, 150, 40);
        lblEmail.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblEmail);
        
        txfEmail = new JTextField();
        txfEmail.setBounds(265,285,200,30);
        pnlYellow.add(txfEmail);
        
        //Password
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(495, 255, 150, 40);
        lblPassword.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblPassword);

        pwfPassword = new JPasswordField();
        pwfPassword.setBounds(495,290,200,30);
        pnlYellow.add(pwfPassword);
        
        // button to return to main menu
        btnMenu = new JButton("Main Menu");
        btnMenu.setBounds(395, 515, 100, 30);
        btnMenu.setBackground(new Color(179, 0, 0));
        btnMenu.setForeground(Color.WHITE);
        btnMenu.addActionListener(this);
        lblbg.add(btnMenu);
        
        // button to signup page
        btnSignup = new JButton("Sign up");
        btnSignup.setBounds(510, 515, 100, 30);
        btnSignup.setBackground(new Color(179, 0, 0));
        btnSignup.setForeground(Color.WHITE);
        btnSignup.addActionListener(this);
        lblbg.add(btnSignup);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMenu) {
            dispose();
            MainMenu mm = new MainMenu();
            mm.setVisible(true);
        }
        if (e.getSource() == btnSignup) {
            dispose();
            // Navigate to the signup action or page
        }
    }
}