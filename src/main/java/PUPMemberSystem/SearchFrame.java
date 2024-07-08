package PUPMemberSystem;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SearchFrame extends JFrame implements ActionListener {
    
    private ImageIcon iipup;
    private JPanel pnlLName, pnlFName, pnlMName, pnlStudNo, pnlCourse, pnlYear, pnlAdd, pnlContactNo, pnlBday, pnlPosition, pnlAffiliation; 
    private JLabel lblTitle, lblLName, lblFName, lblMName, lblStudNo, lblCourse, lblYear, lblAdd, lblContactNo, lblBday, lblPosition, lblAffiliation;
    public JLabel LName, FName, MName, StudNo, Course, Year, Add, ContactNo, Bday, Position, Affiliation;
    private JButton btnClose;
    
    
    SearchFrame(){
        setTitle("SEARCH STUDENT");
        setSize(450,550);
        setLayout(null);
        getContentPane().setBackground(new java.awt.Color(230, 220, 240));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //frame icon
        iipup = new ImageIcon("pup logo.png");
        setIconImage(iipup.getImage());
        
        //Title
        lblTitle = new JLabel("Student Information", SwingConstants.CENTER);
        add(lblTitle);
        lblTitle.setBounds(0,0,450,50);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Impact", Font.PLAIN, 25));
        
        //Last Name
        pnlLName = new JPanel();
        add(pnlLName);
        pnlLName.setBounds(20,60,106,27);
        pnlLName.setBackground(Color.LIGHT_GRAY);
        pnlLName.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblLName = new JLabel("Last Name", SwingConstants.CENTER);
        lblLName.setFont(new Font("Arial", Font.BOLD, 13));
        pnlLName.add(lblLName);
        
        LName = new JLabel("");
        add(LName);
        LName.setBounds(135,60,150,27);
        LName.setFont(new Font("Arial", Font.BOLD, 13));
        
        //First name
        pnlFName = new JPanel();
        add(pnlFName);
        pnlFName.setBounds(20,100,106,27);
        pnlFName.setBackground(Color.LIGHT_GRAY);
        pnlFName.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblFName = new JLabel("First Name", SwingConstants.CENTER);
        lblFName.setFont(new Font("Arial", Font.BOLD, 13));
        pnlFName.add(lblFName);
        
        FName = new JLabel("");
        add(FName);
        FName.setBounds(135,100,150,27);
        FName.setFont(new Font("Arial", Font.BOLD, 13));
        
        //Middle name
        pnlMName = new JPanel();
        add(pnlMName);
        pnlMName.setBounds(20,140,106,27);
        pnlMName.setBackground(Color.LIGHT_GRAY);
        pnlMName.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblMName = new JLabel("Middle Name", SwingConstants.CENTER);
        lblMName.setFont(new Font("Arial", Font.BOLD, 13));
        pnlMName.add(lblMName);
        
        MName = new JLabel("");
        add(MName);
        MName.setBounds(135,140,150,27);
        MName.setFont(new Font("Arial", Font.BOLD, 13));
        
        //Stud num
        pnlStudNo = new JPanel();
        add(pnlStudNo);
        pnlStudNo.setBounds(20,180,106,27);
        pnlStudNo.setBackground(Color.LIGHT_GRAY);
        pnlStudNo.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblStudNo = new JLabel("Student Number", SwingConstants.CENTER);
        lblStudNo.setFont(new Font("Arial", Font.BOLD, 13));
        pnlStudNo.add(lblStudNo);
        
        StudNo = new JLabel("");
        add(StudNo);
        StudNo.setBounds(135,180,150,27);
        StudNo.setFont(new Font("Arial", Font.BOLD, 13));
        
        //Course
        pnlCourse = new JPanel();
        add(pnlCourse);
        pnlCourse.setBounds(20,220,106,27);
        pnlCourse.setBackground(Color.LIGHT_GRAY);
        pnlCourse.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblCourse = new JLabel("Course", SwingConstants.CENTER);
        lblCourse.setFont(new Font("Arial", Font.BOLD, 13));
        pnlCourse.add(lblCourse);
        
        Course = new JLabel("");
        add(Course);
        Course.setBounds(135,220,150,27);
        Course.setFont(new Font("Arial", Font.BOLD, 13));
        
        //Year
        pnlYear = new JPanel();
        add(pnlYear);
        pnlYear.setBounds(20,260,106,27);
        pnlYear.setBackground(Color.LIGHT_GRAY);
        pnlYear.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblYear = new JLabel("Year", SwingConstants.CENTER);
        lblYear.setFont(new Font("Arial", Font.BOLD, 13));
        pnlYear.add(lblYear);
        
        Year = new JLabel("");
        add(Year);
        Year.setBounds(135,260,150,27);
        Year.setFont(new Font("Arial", Font.BOLD, 13));
        
        //Address
        pnlAdd = new JPanel();
        add(pnlAdd);
        pnlAdd.setBounds(20,300,106,27);
        pnlAdd.setBackground(Color.LIGHT_GRAY);
        pnlAdd.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblAdd = new JLabel("Address", SwingConstants.CENTER);
        lblAdd.setFont(new Font("Arial", Font.BOLD, 13));
        pnlAdd.add(lblAdd);
        
        Add = new JLabel("");
        add(Add);
        Add.setBounds(135,300,150,27);
        Add.setFont(new Font("Arial", Font.BOLD, 13));
        
        //ContactNo
        pnlContactNo = new JPanel();
        add(pnlContactNo);
        pnlContactNo.setBounds(20,340,106,27);
        pnlContactNo.setBackground(Color.LIGHT_GRAY);
        pnlContactNo.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblContactNo = new JLabel("Contact Number", SwingConstants.CENTER);
        lblContactNo.setFont(new Font("Arial", Font.BOLD, 13));
        pnlContactNo.add(lblContactNo);
        
        ContactNo = new JLabel("");
        add(ContactNo);
        ContactNo.setBounds(135,340,150,27);
        ContactNo.setFont(new Font("Arial", Font.BOLD, 13));
        
        //Bday
        pnlBday = new JPanel();
        add(pnlBday);
        pnlBday.setBounds(20,380,106,27);
        pnlBday.setBackground(Color.LIGHT_GRAY);
        pnlBday.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblBday = new JLabel("Birthday", SwingConstants.CENTER);
        lblBday.setFont(new Font("Arial", Font.BOLD, 13));
        pnlBday.add(lblBday);
        
        Bday = new JLabel("");
        add(Bday);
        Bday.setBounds(135,380,150,27);
        Bday.setFont(new Font("Arial", Font.BOLD, 13));
        
        //Position
        pnlPosition = new JPanel();
        add(pnlPosition);
        pnlPosition.setBounds(20,420,106,27);
        pnlPosition.setBackground(Color.LIGHT_GRAY);
        pnlPosition.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblPosition = new JLabel("Position", SwingConstants.CENTER);
        lblPosition.setFont(new Font("Arial", Font.BOLD, 13));
        pnlPosition.add(lblPosition);
        
        Position = new JLabel("");
        add(Position);
        Position.setBounds(135,420,150,27);
        Position.setFont(new Font("Arial", Font.BOLD, 13));
        
        //Affiliation
        pnlAffiliation = new JPanel();
        add(pnlAffiliation);
        pnlAffiliation.setBounds(20,460,106,27);
        pnlAffiliation.setBackground(Color.LIGHT_GRAY);
        pnlAffiliation.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        lblAffiliation = new JLabel("Affiliation", SwingConstants.CENTER);
        lblAffiliation.setFont(new Font("Arial", Font.BOLD, 13));
        pnlAffiliation.add(lblAffiliation);
        
        Affiliation = new JLabel("");
        add(Affiliation);
        Affiliation.setBounds(135,460,150,27);
        Affiliation.setFont(new Font("Arial", Font.BOLD, 13));
        
        //close frame button
        btnClose = new JButton("Close");
        add(btnClose);
        btnClose.setBounds(336,480,90,24);
        btnClose.setBackground(new Color(119, 7, 55));
        btnClose.setForeground(Color.WHITE);
        btnClose.addActionListener(this);

    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClose) {
            dispose();
        }
    }
    
}
