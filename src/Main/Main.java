package Main;

import DB.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main extends JFrame{

    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
    public static boolean vis = true;

    public static int width = 450;
    public static int hight = 500;

    public Main(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Speler Registreren");
        b1.setBounds(100,25,200,35);

        b2 = new JButton("Gegevens wijzigen");
        b2.setBounds(100,65,200,35);

        b3 = new JButton("Speler verwijderen");
        b3.setBounds(100,105,200,35);

        b4 = new JButton("Inschrijven");
        b4.setBounds(100,145,200,35);

        b5 = new JButton("Uitschrijven");
        b5.setBounds(100,185,200,35);

        b6 = new JButton("Uitlezen");
        b6.setBounds(100,225,200,35);

        b7 = new JButton("Toernooi plaatsen");
        b7.setBounds(100,265,200,35);

        b8 = new JButton("Toernooi verwijderen");
        b8.setBounds(100,305,200,35);

        b9 = new JButton("Winnaar Registreren");
        b9.setBounds(100,345,200,35);

        b10 = new JButton("Masterclass registreren");
        b10.setBounds(100,385,200,35);

        b11 = new JButton("Inschrijven masterclass");
        b11.setBounds(100,425,200,35);

        //button Listener
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.register reg = new Windows.register();
                Main.super.dispose();
            }
        });

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.gegevensWijz geg = new Windows.gegevensWijz();
                Main.super.dispose();
            }
        });

        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.spelerVerwijderen spe = new Windows.spelerVerwijderen();
                Main.super.dispose();
            }
        });

        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.inschrijven ins = new Windows.inschrijven();
                Main.super.dispose();
            }
        });

        b5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.uitschrijven uit = new Windows.uitschrijven();
                Main.super.dispose();
            }
        });

        b6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.uitlezenInschrijvingen uitl = new Windows.uitlezenInschrijvingen();
                Main.super.dispose();
            }
        });

        b7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.toernooiPlaatsen toe = new Windows.toernooiPlaatsen();
                Main.super.dispose();
            }
        });

        b8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.toernooiVerwijderen toer = new Windows.toernooiVerwijderen();
                Main.super.dispose();
            }
        });

        b9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.winnaarRegistreren win = new Windows.winnaarRegistreren();
                Main.super.dispose();
            }
        });

        b10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.masterclassRegistreren mreg = new Windows.masterclassRegistreren();
                Main.super.dispose();
            }
        });

        b11.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Windows.inschrijvenMasterclass insm = new Windows.inschrijvenMasterclass();
                Main.super.dispose();
            }
        });

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);

        add(panel);
        //Frame Size
        setSize(width, hight);
        //Start Position frame
        setLocationRelativeTo(null);
        //default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Title
        setTitle("FullHouse");
        //turn off resizable
        setResizable(false);
        setLayout(null);
        setVisible(vis);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();


    }
}
