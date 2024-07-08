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
    private JButton btnLogout, btnNewRecord, btnDelRecord, btnUpdRecord, btnEnter, btnClear;

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
        tblRecords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
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
        
        btnClear = new JButton("Clear");
        add(btnClear);
        btnClear.setBounds(1190,540,100,25);
        btnClear.setBackground(new Color(119, 7, 55));
        btnClear.setForeground(Color.WHITE);
        btnClear.addActionListener(this);

        //button to return to main menu
        btnLogout = new JButton("Log out");
        add(btnLogout);
        btnLogout.setBounds(30,612,100,28);
        btnLogout.setBackground(new Color(119, 7, 55));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.addActionListener(this);
        
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
        if(e.getSource() == btnLogout) {
            dispose();
            MainMenu mm = new MainMenu();
            mm.setVisible(true);
        }
        else if(e.getSource() == btnClear) {
            txfLName.setText("");
            txfFName.setText("");
        }
        else if(e.getSource() == btnEnter) {
            String lastName = txfLName.getText().trim();
            String firstName = txfFName.getText().trim();
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcite", "root", "");
            String query = "SELECT * FROM tblcite WHERE LName=? AND FName=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                SearchFrame sf = new SearchFrame();
                sf.setVisible(true);
                
                sf.LName.setText(rs.getString("LName"));
                sf.FName.setText(rs.getString("FName"));
                sf.MName.setText(rs.getString("MName"));
                sf.StudNo.setText(rs.getString("StudNo"));
                sf.Course.setText(rs.getString("Course"));
                sf.Year.setText(rs.getString("Year"));
                sf.Add.setText(rs.getString("Address"));
                sf.ContactNo.setText(rs.getString("ContactNo"));
                sf.Bday.setText(rs.getString("Bday"));
                sf.Position.setText(rs.getString("Position"));
                sf.Affiliation.setText(rs.getString("Affiliation"));
            } else {
                JOptionPane.showMessageDialog(null, "No matching record found.", "Search", JOptionPane.INFORMATION_MESSAGE);
            }
            
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
        else if (e.getSource() == btnUpdRecord) {
            int selectedRow = tblRecords.getSelectedRow();
            if (selectedRow != -1) {
                updateRecordInDatabase(selectedRow);
                JOptionPane.showMessageDialog(null, "Record Updated Successfully!", "Update Record", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to update.", "Update Record", JOptionPane.WARNING_MESSAGE);
            }
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
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void updateRecordInDatabase(int row) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcite", "root", "");
        String query = "UPDATE tblcite SET LName=?, FName=?, MName=?, Course=?, Year=?, Address=?, ContactNo=?, Bday=?, Position=?, Affiliation=? WHERE StudNo=?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, (String) tblRecords.getValueAt(row, 0)); // LName
        ps.setString(2, (String) tblRecords.getValueAt(row, 1)); // FName
        ps.setString(3, (String) tblRecords.getValueAt(row, 2)); // MName
        ps.setString(4, (String) tblRecords.getValueAt(row, 4)); // Course
        ps.setString(5, (String) tblRecords.getValueAt(row, 5)); // Year
        ps.setString(6, (String) tblRecords.getValueAt(row, 6)); // Address
        ps.setString(7, (String) tblRecords.getValueAt(row, 7)); // ContactNo

        String bday = (String) tblRecords.getValueAt(row, 8);
        if (isValidDate(bday)) {
            ps.setString(8, bday); // Bday
        } else {
            throw new SQLException("Invalid date format for Bday: " + bday);
        }

        ps.setString(9, (String) tblRecords.getValueAt(row, 9)); // Position
        ps.setString(10, (String) tblRecords.getValueAt(row, 10)); // Affiliation
        ps.setString(11, (String) tblRecords.getValueAt(row, 3)); // StudNo 

        ps.executeUpdate();
        ps.close();
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

    private boolean isValidDate(String date) {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } 
        catch (java.text.ParseException e) {
            return false;
        }
    }
}
