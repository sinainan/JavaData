package Windows;

import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uitlezen.*;


public class uitlezenInschrijvingen extends JFrame {

    private JButton b1, b2, b3, b4, b5, b6, b7, b8;
    private JLabel lbl1;

    public static int width = 300;
    public static int hight = 400;


    public uitlezenInschrijvingen(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Terug");
        b1.setBounds(50,350,200,35);
        lbl1 = new JLabel("Uitlezen");
        lbl1.setFont(lbl1.getFont().deriveFont(16.0f));
        lbl1.setBounds(115, 10,160,35);

        b2 = new JButton("Spelers");
        b2.setBounds(50,50,200,35);
        b3 = new JButton("Toernooi");
        b3.setBounds(50,90,200,35);
        b4 = new JButton("Inschrijvingen");
        b4.setBounds(50,130,200,35);
        b5 = new JButton("Locatie");
        b5.setBounds(50,170,200,35);
        b6 = new JButton("Winnaars");
        b6.setBounds(50,210,200,35);
        b7 = new JButton("Masterclass");
        b7.setBounds(50,250,200,35);
        b8 = new JButton("Mc Inschrijving");
        b8.setBounds(50,290,200,35);



        //button Listener
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                uitlezenInschrijvingen.super.dispose();
            }
        });

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        uSpelers.showFrame();
                    }
                });
            }
        });

        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        uToernooi.showFrame1();
                    }
                });
            }
        });

        b7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        uMarsterClass.showFrame2();
                    }
                });
            }
        });

        b6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        uWinnaar.showFrame3();
                    }
                });
            }
        });

        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        uInschrijving.showFrame4();
                    }
                });
            }
        });

        b5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        uLocatie.showFrame5();
                    }
                });
            }
        });

        b8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        uMC_inschrijving.showFrame6();
                    }
                });
            }
        });


        add(b1);
        add(lbl1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        add(panel);
        //Frame Size
        setSize(width, hight);
        //Start Position frame
        setLocationRelativeTo(null);
        //default close operation
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        //Title
        setTitle("FullHouse-Register");
        //turn off resizable
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }


}



