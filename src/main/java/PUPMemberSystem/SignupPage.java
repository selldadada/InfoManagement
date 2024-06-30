package PUPMemberSystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class SignupPage extends JFrame implements ActionListener {

    private JLabel lblbg, lbltitle, lblDescription;
    private JPanel pnlform, pnlYellow;
    private JButton btnMenu, btnSignup;

    SignupPage() {
        setTitle("SIGNUP PAGE");
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
        
        //text sa taas lel
        lbltitle = new JLabel("CREATE AN ACCOUNT", SwingConstants.CENTER);
        lblbg.add(lbltitle);
        lbltitle.setBounds(0,40,1000,50);
        lbltitle.setForeground(new Color(150, 0, 0));
        lbltitle.setFont(new Font("Impact", Font.PLAIN, 40));
        
        // Yellow JPanel
        pnlYellow = new JPanel();
        pnlYellow.setLayout(null);
        pnlYellow.setBackground(new Color(250, 254, 224));
        pnlYellow.setBounds(130, 130, 730, 370);
        lblbg.add(pnlYellow);

        // Please fill in every field text
        lblDescription = new JLabel("Please fill in every field.");
        lblDescription.setBounds(15, 5, 150, 30);
        lblDescription.setFont(new Font("Aptos", Font.PLAIN, 13));
        pnlYellow.add(lblDescription);
        
        //button to return to main menu
        btnMenu = new JButton("Main Menu");
        lblbg.add(btnMenu);
        btnMenu.setBounds(395,515,100,30);
        btnMenu.setBackground(new Color(179, 0, 0));
        btnMenu.setForeground(Color.WHITE);
        btnMenu.addActionListener(this);
        
        //button to return to main menu
        btnSignup = new JButton("Sign up");
        lblbg.add(btnSignup);
        btnSignup.setBounds(510,515,100,30);
        btnSignup.setBackground(new Color(179, 0, 0));
        btnSignup.setForeground(Color.WHITE);
        btnSignup.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnMenu) {
        dispose();
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
        }
        if(e.getSource() == btnSignup) {
        dispose();
        
        }
    }
}
