package PUPMemberSystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class RecordsPage extends JFrame implements ActionListener {
    
    private JLabel lblTitle, lblSearch, lblLName, lblCourse;
    private JTextField txfLName, txfCourse;
    private JTable tblRecords;
    private JScrollPane spScroll;
    private DefaultTableModel ColumnHeaders;
    private JTableHeader tableheader;
    private JButton btnMenu, btnNewRecord, btnDelRecord, btnUpdRecord, btnEnter;

    RecordsPage() {
        setTitle("VIEWING OF RECORDS");
        setSize(1370,700);
        setLayout(null);
        getContentPane().setBackground(new java.awt.Color(230, 220, 240));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        lblTitle = new JLabel("STUDENT RECORDS", SwingConstants.CENTER);
        add(lblTitle);
        lblTitle.setBounds(0,20,1400,50);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Impact", Font.PLAIN, 40));
        
        //table
        ColumnHeaders = new DefaultTableModel(new Object[]{"Last Name","First Name","Middle Name","Student Number","Course","Year","Address","Contact Number","Birthday","Position","Affiliation"}, 0);
        tblRecords = new JTable(ColumnHeaders);
        tblRecords.setOpaque(false);
        
        tableheader = tblRecords.getTableHeader();
        tblRecords.getTableHeader().setBackground(Color.LIGHT_GRAY);
        tblRecords.getTableHeader().setForeground(Color.BLACK);
        tblRecords.getTableHeader().setFont(new Font("Aptos", Font.BOLD, 12));
        
        //scroll for table
        spScroll = new JScrollPane(tblRecords);
        spScroll.setBounds(30,90,1100,500);
        spScroll.setBorder(new LineBorder(Color.BLACK, 1));
        add(spScroll);
        
        //buttons for editing student records
        btnNewRecord = new JButton("Add Record");
        add(btnNewRecord);
        btnNewRecord.setBounds(1175,110,135,30);
        btnNewRecord.setBackground(new Color(119, 7, 55));
        btnNewRecord.setForeground(Color.WHITE);
        btnNewRecord.addActionListener(this);
        
        btnDelRecord = new JButton("Delete Record");
        add(btnDelRecord);
        btnDelRecord.setBounds(1175,155,135,30);
        btnDelRecord.setBackground(new Color(119, 7, 55));
        btnDelRecord.setForeground(Color.WHITE);
        btnDelRecord.addActionListener(this);
        
        btnUpdRecord = new JButton("Update Record");
        add(btnUpdRecord);
        btnUpdRecord.setBounds(1175,200,135,30);
        btnUpdRecord.setBackground(new Color(119, 7, 55));
        btnUpdRecord.setForeground(Color.WHITE);
        btnUpdRecord.addActionListener(this);
        
        //Search elements
        lblSearch = new JLabel("Search :");
        add(lblSearch);
        lblSearch.setBounds(1155,295,120,30);
        lblSearch.setFont(new Font("Impact", Font.PLAIN, 18));
        
        lblLName = new JLabel("Last Name");
        add(lblLName);
        lblLName.setBounds(1155,330,100,30);
        lblLName.setFont(new Font("Arial", Font.BOLD, 13));
        
        txfLName = new JTextField("");
        add(txfLName);
        txfLName.setBounds(1155,360,170,30);
        
        lblCourse = new JLabel("Course");
        add(lblCourse);
        lblCourse.setBounds(1155,400,100,30);
        lblCourse.setFont(new Font("Arial", Font.BOLD, 13));
        
        txfCourse = new JTextField("");
        add(txfCourse);
        txfCourse.setBounds(1155,430,170,30);
        
        btnEnter = new JButton("Enter");
        add(btnEnter);
        btnEnter.setBounds(1190,500,100,25);
        btnEnter.setBackground(new Color(119, 7, 55));
        btnEnter.setForeground(Color.WHITE);
        btnEnter.addActionListener(this);

        //button to return to main menu
        btnMenu = new JButton("Main Menu");
        add(btnMenu);
        btnMenu.setBounds(30,612,100,28);
        btnMenu.setBackground(new Color(119, 7, 55));
        btnMenu.setForeground(Color.WHITE);
        btnMenu.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnMenu) {
            dispose();
            MainMenu mm = new MainMenu();
            mm.setVisible(true);
        }
        else if(e.getSource() == btnNewRecord) {
            dispose();
            SignupPage sp = new SignupPage();
            sp.setVisible(true);
        }
        else if(e.getSource() == btnDelRecord) {
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!", "Delete Record", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource() == btnUpdRecord) {
            JOptionPane.showMessageDialog(null, "Record/s Updated Successfully!", "Update Record/s", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
