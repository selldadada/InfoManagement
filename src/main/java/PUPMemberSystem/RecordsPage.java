package PUPMemberSystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class RecordsPage extends JFrame implements ActionListener {
    
    private ImageIcon iipup;
    private JLabel lblTitle, lblSearch, lblLName, lblFName;
    private JTextField txfLName, txfFName;
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
        
        //frame icon
        iipup = new ImageIcon("pup logo.png");
        setIconImage(iipup.getImage());
        
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
        
        lblFName = new JLabel("First Name");
        add(lblFName);
        lblFName.setBounds(1155,400,100,30);
        lblFName.setFont(new Font("Arial", Font.BOLD, 13));
        
        txfFName = new JTextField("");
        add(txfFName);
        txfFName.setBounds(1155,430,170,30);
        
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
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcite","root","");

            Statement st = conn.createStatement();
            String query =  "SELECT * FROM tblcite";
            ResultSet rs = st.executeQuery(query);
    
            while(rs.next()){
                String LName = rs.getString("LName");
                String FName = rs.getString("FName");
                String MName = rs.getString("MName");
                String StudNo = rs.getString("StudNo");
                String Course = rs.getString("Course");
                String Year = rs.getString("Year");
                String Address = rs.getString("Address");
                String ContactNo = rs.getString("ContactNo");
                String Bday = rs.getString("Bday");
                String Position = rs.getString("Position");
                String Affiliation = rs.getString("Affiliation");
        
                String tblInfo[] = {LName, FName, MName, StudNo, Course, Year, Address, ContactNo, Bday, Position, Affiliation};
                DefaultTableModel record = (DefaultTableModel)tblRecords.getModel();
        
                record.addRow(tblInfo);
            }
            conn.close();
        }
        catch(Exception e){
        System.out.println(e);
        }
        
        //mouse action For deleting records
        tblRecords.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblRecords.getSelectedRow();
                if (selectedRow != -1) {
                }
            }
        });

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
            int selectedRow = tblRecords.getSelectedRow();
            if (selectedRow != -1) {
                String studNo = (String) tblRecords.getValueAt(selectedRow, 3);
                DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();
                model.removeRow(selectedRow);
                deleteRecordFromDatabase(studNo);
                JOptionPane.showMessageDialog(null, "Record Deleted Successfully!", "Delete Record", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Delete Record", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getSource() == btnUpdRecord) {
            JOptionPane.showMessageDialog(null, "Record/s Updated Successfully!", "Update Record/s", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void deleteRecordFromDatabase(String studNo) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcite", "root", "");
            String query = "DELETE FROM tblcite WHERE StudNo=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, studNo);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
