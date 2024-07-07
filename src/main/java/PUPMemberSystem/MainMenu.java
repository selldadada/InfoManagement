package PUPMemberSystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class MainMenu extends JFrame implements ActionListener {
    
    private ImageIcon iipup;
    private JLabel lblbg, lblusn, lblpw, lblwelcome, lbllogin, lblloading;
    private JPanel pnlstud, pnlpw;
    private JTextField txfadmin;
    private JPasswordField pwfPw;
    private JButton btnLogin;
    private JProgressBar pgbloading;
    private JCheckBox ckbreveal;
    
    MainMenu() {
        setTitle("PUP SYSTEM");
        setSize(1000,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //frame icon
        iipup = new ImageIcon("pup logo.png");
        setIconImage(iipup.getImage());
        
        //background image
        lblbg = new JLabel();
        add(lblbg);
        lblbg.setBounds(0,0,1000,600);
        lblbg.setIcon(new ImageIcon(new ImageIcon("pup bg.png").getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH)));
        
        //text bago mag login student ememe
        lblwelcome = new JLabel("WELCOME PUP ADMIN!", SwingConstants.CENTER);
        lblbg.add(lblwelcome);
        lblwelcome.setBounds(0,100,1000,70);
        lblwelcome.setForeground(new Color(150, 0, 0));
        lblwelcome.setFont(new Font("Impact", Font.PLAIN, 80));
        
        lbllogin = new JLabel("Please log in to continue.", SwingConstants.CENTER);
        lblbg.add(lbllogin);
        lbllogin.setBounds(0,220,1000,30);
        lbllogin.setForeground(Color.BLACK);
        lbllogin.setFont(new Font("Aptos", Font.BOLD, 18));    
        
        //Student login elements
        pnlstud = new JPanel();
        lblbg.add(pnlstud);
        pnlstud.setBounds(320,290,120,35);
        pnlstud.setBackground(new Color(150, 0, 0));   
        pnlstud.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        lblusn = new JLabel("Username");
        pnlstud.add(lblusn);
        lblusn.setForeground(Color.WHITE);
        lblusn.setFont(new Font("Aptos", Font.PLAIN, 15));
        
        txfadmin = new JTextField();
        lblbg.add(txfadmin);
        txfadmin.setBounds(460,290,210,35);
        
        //Password elements
        pnlpw = new JPanel();
        lblbg.add(pnlpw);
        pnlpw.setBounds(320,340,120,35);
        pnlpw.setBackground(new Color(255,255,203));
        pnlpw.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        lblpw = new JLabel("Password");
        pnlpw.add(lblpw);
        lblpw.setForeground(Color.BLACK);
        lblpw.setFont(new Font("Aptos", Font.PLAIN, 15));
        
        pwfPw = new JPasswordField();
        lblbg.add(pwfPw);
        pwfPw.setBounds(460,340,210,35);
        
        ckbreveal = new JCheckBox();
        lblbg.add(ckbreveal);
        ckbreveal.setBounds(670,350,18,15);
        ckbreveal.setOpaque(false);
        ckbreveal.addActionListener(this);

        //login button
        btnLogin = new JButton("Login");
        lblbg.add(btnLogin);
        btnLogin.setBounds(450,420,100,28);
        btnLogin.setBackground(new Color(179, 0, 0));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.addActionListener(this);
        
        //Loading screen
        pgbloading = new JProgressBar(SwingConstants.CENTER);
        lblbg.add(pgbloading);
        pgbloading.setBounds(370,500,250,30);
        pgbloading.setVisible(false);
        pgbloading.setStringPainted(true);
        
        lblloading = new JLabel("Loading.....", SwingConstants.CENTER);
        lblloading.setBounds(0,475,1000,30);
        lblloading.setFont(new Font("Arial", Font.BOLD, 14));
        lblloading.setForeground(Color.BLACK);
        lblbg.add(lblloading);
        lblloading.setVisible(false);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ckbreveal) {
            if (ckbreveal.isSelected()) {
                pwfPw.setEchoChar((char)0);
            } 
            else {
                pwfPw.setEchoChar('•');
            }
        } 
        else if (e.getSource() == btnLogin) {
            String usn = txfadmin.getText();
            String pw = pwfPw.getText();
            if(usn.equals("ADMIN") && pw.equals("PASSWORD")) {
                JOptionPane.showMessageDialog(null, "Login Successful!", "Credentials Correct", JOptionPane.INFORMATION_MESSAGE);
                lblloading.setVisible(true);
                pgbloading.setVisible(true);

                SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i <= 100; i++) {
                        Thread.sleep(10);
                        publish(i);
                    }
                    return null;
                }

                @Override
                protected void process(java.util.List<Integer> chunks) {
                    pgbloading.setValue(chunks.get(chunks.size() - 1));
                }

                @Override
                protected void done() {
                    lblloading.setVisible(false);
                    dispose();
                    new RecordsPage().setVisible(true);
                }
                };
                worker.execute();
            }
        }
    }
}
