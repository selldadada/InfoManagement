package PUPMemberSystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class SignupPage extends JFrame implements ActionListener {

    private JLabel lblbg, lbltitle, lblDescription, lblLName, lblFName, lblMName, lblStudNo, lblCourse, lblYear, lblAddress;
    private JPanel pnlYellow;
    private JTextField txfLName, txfFName, txfMName, txfStudNo, txfCourse, txfYear, txfAddress;
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

        // Please fill in every field text
        lblDescription = new JLabel("Please fill in every field.");
        lblDescription.setBounds(15, 5, 200, 30);
        lblDescription.setFont(new Font("Aptos", Font.PLAIN, 13));
        pnlYellow.add(lblDescription);
        
        // Last Name
        lblLName = new JLabel("Last Name");
        lblLName.setBounds(35, 40, 150, 40);
        lblLName.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblLName);
        
        txfLName = new JTextField();
        txfLName.setBounds(35,75,200,30);
        pnlYellow.add(txfLName);
        
        // First Name
        lblFName = new JLabel("First Name");
        lblFName.setBounds(265, 40, 150, 40);
        lblFName.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblFName);
        
        txfFName = new JTextField();
        txfFName.setBounds(265,75,200,30);
        pnlYellow.add(txfFName);
        
        // Middle Name
        lblMName = new JLabel("Middle Name");
        lblMName.setBounds(495, 40, 150, 40);
        lblMName.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblMName);
        
        txfMName = new JTextField();
        txfMName.setBounds(495,75,200,30);
        pnlYellow.add(txfMName);
        
        //Student Number
        lblStudNo = new JLabel("Student Number");
        lblStudNo.setBounds(35, 110, 150, 40);
        lblStudNo.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblStudNo);
        
        txfStudNo = new JTextField();
        txfStudNo.setBounds(35,145,200,30);
        pnlYellow.add(txfStudNo);
        
        //Course
        lblCourse = new JLabel("Course");
        lblCourse.setBounds(265, 110, 100, 40);
        lblCourse.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblCourse);
        
        txfCourse = new JTextField();
        txfCourse.setBounds(265,145,90,30);
        pnlYellow.add(txfCourse);
        
        //Year
        
        //Address
        lblAddress = new JLabel("Address");
        lblAddress.setBounds(495, 110, 150, 40);
        lblAddress.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblAddress);
        
        txfAddress = new JTextField();
        txfAddress.setBounds(495,145,200,30);
        pnlYellow.add(txfAddress);
        
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