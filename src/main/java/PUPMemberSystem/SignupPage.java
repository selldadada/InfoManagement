package PUPMemberSystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;

public class SignupPage extends JFrame implements ActionListener {
    
    private ImageIcon iipup;
    private JLabel lbltitle, lblDescription, lblLName, lblFName, lblMName, lblStudNo, lblCourse, lblYear, lblAddress, lblContactNo, lblBday, lblPosition, lblAffiliation;
    private JPanel pnlYellow;
    private JTextField txfLName, txfFName, txfMName, txfStudNo, txfAddress, txfContactNo, txfBday, txfPosition;
    private JComboBox<String> cbCourse, cbYear, cbAffiliation;
    private JButton btnSubmit, btnReturn;
    
    private String[] coursechoices = {"", "BSIT", "DICT", "DIT"};
    private String[] yearchoices = {"", "First Year", "Second Year", "Third Year", "Fourth Year"};
    private String[] affiliationchoices = {"", "IBITS"};

    SignupPage() {
        
        setTitle("SIGNUP PAGE");
        setSize(1000,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(230, 220, 240));
        setResizable(false);
        setLocationRelativeTo(null);
        
        //frame icon
        iipup = new ImageIcon("pup logo.png");
        setIconImage(iipup.getImage());
        
        // title text
        lbltitle = new JLabel("CREATE NEW STUDENT RECORD", SwingConstants.CENTER);
        lbltitle.setBounds(0, 40, 1000, 50);
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setFont(new Font("Impact", Font.PLAIN, 40));
        add(lbltitle);
        
        // Yellow JPanel
        pnlYellow = new JPanel();
        pnlYellow.setLayout(null);
        pnlYellow.setBackground(new Color(255, 255, 230));
        pnlYellow.setBounds(115, 120, 760, 370);
        add(pnlYellow);

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
        lblMName = new JLabel("Middle Name (Leave blank if none)");
        lblMName.setBounds(495, 45, 250, 40);
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
        
        cbCourse = new JComboBox(coursechoices);
        cbCourse.setBounds(265,150,90,30);
        pnlYellow.add(cbCourse);
        
        //Year
        lblYear = new JLabel("Year");
        lblYear.setBounds(375, 115, 100, 40);
        lblYear.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblYear);
        
        cbYear = new JComboBox(yearchoices);
        cbYear.setBounds(375,150,90,30);
        pnlYellow.add(cbYear);
        
        //Address
        lblAddress = new JLabel("Address");
        lblAddress.setBounds(495, 115, 150, 40);
        lblAddress.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblAddress);
        
        txfAddress = new JTextField();
        txfAddress.setBounds(495,150,200,30);
        pnlYellow.add(txfAddress);
        
        //Contact Number
        lblContactNo = new JLabel("Contact Number (09)");
        lblContactNo.setBounds(35, 185, 190, 40);
        lblContactNo.setFont(new Font("Aptos", Font.BOLD, 14));
        pnlYellow.add(lblContactNo);
        
        txfContactNo = new JTextField();
        txfContactNo.setBounds(35,220,200,30);
        pnlYellow.add(txfContactNo);
        
        //Birthday
        lblBday = new JLabel("Birthday (YYYY-MM-DD)");
        lblBday.setBounds(265, 185, 180, 40);
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
        
        cbAffiliation = new JComboBox(affiliationchoices);
        cbAffiliation.setBounds(35,290,200,30);
        pnlYellow.add(cbAffiliation);
        
        // button to add record and return to records page
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(510, 512, 100, 28);
        btnSubmit.setBackground(new Color(119, 7, 55));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.addActionListener(this);
        add(btnSubmit);
        
        //return btn
        btnReturn = new JButton("Return");
        btnReturn.setBounds(380, 512, 100, 28);
        btnReturn.setBackground(new Color(119, 7, 55));
        btnReturn.setForeground(Color.WHITE);
        btnReturn.addActionListener(this);
        add(btnReturn);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
        if (txfLName.getText().isEmpty() || txfFName.getText().isEmpty() || txfStudNo.getText().isEmpty() || 
            cbCourse.getSelectedItem() == null || cbYear.getSelectedItem() == null || txfAddress.getText().isEmpty() || 
            txfContactNo.getText().isEmpty() || txfBday.getText().isEmpty() || txfPosition.getText().isEmpty() || 
            cbAffiliation.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
                return;
            }
        else {
        try {
        String[] data = new String[11];
        data[0] = txfLName.getText();
        data[1] = txfFName.getText();
        data[2] = txfMName.getText();
        data[3] = txfStudNo.getText();
        data[4] = (String)cbCourse.getSelectedItem();
        data[5] = (String)cbYear.getSelectedItem();
        data[6] = txfAddress.getText();
        data[7] = txfContactNo.getText();
        data[8] = txfBday.getText();
        data[9] = txfPosition.getText();
        data[10] = (String)cbAffiliation.getSelectedItem();
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcite", "root", "");
        String query = "INSERT INTO tblcite (LName, FName, MName, StudNo, Course, Year, Address, ContactNo, Bday, Position, Affiliation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        for (int i = 0; i < data.length; i++) {
            ps.setString(i + 1, data[i]);
        }
        ps.executeUpdate();
        ps.close();
        conn.close();
        } 
        catch (SQLException a) {
        a.printStackTrace();
        }
            JOptionPane.showMessageDialog(null, "Record Added Successfully!", "Add New Record", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            RecordsPage rp = new RecordsPage();
            rp.setVisible(true);
        }
        }
        else if (e.getSource() == btnReturn) {
                dispose();
                RecordsPage rp = new RecordsPage();
                rp.setVisible(true);
            }
    }
}