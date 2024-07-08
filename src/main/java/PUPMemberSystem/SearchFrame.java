package PUPMemberSystem;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SearchFrame extends JFrame implements ActionListener {
    
    private ImageIcon iipup;
    private JPanel pnlLName, pnlFName, pnlMName, pnlStudNo, pnlCourse, pnlYear, pnlAdd, pnlContactNo, pnlBday, pnlPosition, pnlAffiliation; 
    private JLabel lblTitle, lblLName, lblFName, lblMName, lblStudNo, lblCourse, lblYear, lblAdd, lblContactNo, lblBday, lblPosition, lblAffiliation;
    private JLabel LName, FName, MName, StudNo, Course, Year, Add, ContactNo, Bday, Position, Affiliation;
    private JButton btnClose;
    
    
    SearchFrame(){
        setTitle("SEARCH STUDENT");
        setSize(500,500);
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
        lblTitle.setBounds(0,0,500,50);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Impact", Font.PLAIN, 25));
        
        
        //Last Name
        lblLName = new JLabel("Last Name");
        add(lblLName);
        lblLName.setBounds(50,100,100,30);
        
        //close frame button
        btnClose = new JButton("Close");
        add(btnClose);
        btnClose.setBounds(386,430,90,24);
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
