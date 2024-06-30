package PUPMemberSystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenu extends JFrame implements ActionListener {
    
    private JButton btnLogin, btnSignup;
    private JLabel lblbg, lblstud, lblpw, lblwelcome, lbllogin, lblsignup;
    private JPanel pnlstud, pnlpw;
    private JTextField txfstud;
    private JPasswordField pwfPw;
    private JProgressBar pgbloading;
    
    MainMenu() {
        setTitle("PUP SYSTEM");
        setSize(1000,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //background image
        lblbg = new JLabel();
        add(lblbg);
        lblbg.setBounds(0,0,1000,600);
        lblbg.setIcon(new ImageIcon(new ImageIcon("pup bg.png").getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
        
        //text bago mag login student ememe
        lblwelcome = new JLabel("WELCOME TO PUP!", SwingConstants.CENTER);
        lblbg.add(lblwelcome);
        lblwelcome.setBounds(0,100,1000,70);
        lblwelcome.setForeground(new Color(150, 0, 0));
        lblwelcome.setFont(new Font("Impact", Font.PLAIN, 80));
        
        lbllogin = new JLabel("Please log in to continue.", SwingConstants.CENTER);
        lblbg.add(lbllogin);
        lbllogin.setBounds(0,220,1000,30);
        lbllogin.setForeground(Color.BLACK);
        lbllogin.setFont(new Font("Aptos", Font.BOLD, 18));
        
        lblsignup = new JLabel("Dont have an account? Go to Sign up.", SwingConstants.CENTER);
        lblbg.add(lblsignup);
        lblsignup.setBounds(0,240,1000,30);
        lblsignup.setForeground(Color.BLACK);
        lblsignup.setFont(new Font("Aptos", Font.PLAIN, 15));
        
        
        //Student login elements
        pnlstud = new JPanel();
        lblbg.add(pnlstud);
        pnlstud.setBounds(320,300,120,35);
        pnlstud.setBackground(new Color(150, 0, 0));   
        pnlstud.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        lblstud = new JLabel("Student Number");
        pnlstud.add(lblstud);
        lblstud.setForeground(Color.WHITE);
        lblstud.setFont(new Font("Aptos", Font.PLAIN, 15));
        
        txfstud = new JTextField();
        lblbg.add(txfstud);
        txfstud.setBounds(460,300,200,35);
        
        //
        pnlpw = new JPanel();
        lblbg.add(pnlpw);
        pnlpw.setBounds(320,350,120,35);
        pnlpw.setBackground(new Color(255,255,203));
        pnlpw.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        lblpw = new JLabel("Password");
        pnlpw.add(lblpw);
        lblpw.setForeground(Color.BLACK);
        lblpw.setFont(new Font("Aptos", Font.PLAIN, 15));
        
        pwfPw = new JPasswordField();
        lblbg.add(pwfPw);
        pwfPw.setBounds(460,350,200,35);

        //login button
        btnLogin = new JButton("Login");
        lblbg.add(btnLogin);
        btnLogin.setBounds(385,420,100,28);
        btnLogin.setBackground(new Color(179, 0, 0));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.addActionListener(this);
        
        //sign up button
        btnSignup = new JButton("Sign up");
        lblbg.add(btnSignup);
        btnSignup.setBounds(500,420,100,28);
        btnSignup.setBackground(new Color(179, 0, 0));
        btnSignup.setForeground(Color.WHITE);
        btnSignup.addActionListener(this);
        
        
        //Loading screen
        pgbloading = new JProgressBar(SwingConstants.CENTER);
        lblbg.add(pgbloading);
        pgbloading.setBounds(370,500,250,30);
        pgbloading.setVisible(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int i=0;
        if (e.getSource() == btnLogin) {
        pgbloading.setVisible(true);
        while (i <= 100) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            pgbloading.paintImmediately(0, 0, 260, 20);
            pgbloading.setValue(i);
            i++;
        }
        dispose();
        RecordsPage rp = new RecordsPage();
        rp.setVisible(true);
        }
        else if (e.getSource() == btnSignup) {
        pgbloading.setVisible(true);
        while (i <= 100) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            pgbloading.paintImmediately(0, 0, 250, 20);
            pgbloading.setValue(i);
            i++;
        }
        dispose();
        SignupPage sp = new SignupPage();
        sp.setVisible(true);   
        }
    }
}