package PUPMemberSystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RecordsPage extends JFrame implements ActionListener {

    private JPanel bgcream = new JPanel();
    private JPanel header = new JPanel();
    private JButton btnMenu = new JButton("Main Menu");

    RecordsPage() {
        setTitle("VIEWING OF RECORDS");
        setSize(1000,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        //background image
        add(header);
        header.setBounds(0,0,1000,70);
        header.setBackground(new java.awt.Color(150,0,0));

        add(bgcream);
        bgcream.setBounds(0,70,1000,600);
        bgcream.setBackground(new java.awt.Color(255,255,203));

        //button to return to main menu
        bgcream.add(btnMenu);
        btnMenu.setBounds(385,350,100,28);
        btnMenu.setBackground(new Color(179, 0, 0));
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
    }
}
