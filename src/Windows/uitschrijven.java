package Windows;

import DB.dbCon;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class uitschrijven extends JFrame {

    private JButton b1, b2, b3;
    private JLabel lbl1;

    private JLabel splr, toer, zoek;
    private JTextField splrt, toert, zoekt;
    private JRadioButton r1, r2;


    public static int width = 400;
    public static int hight = 425;


    public uitschrijven(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Terug");
        b1.setBounds(305,380,80,35);
        lbl1 = new JLabel("Uitschrijven");
        lbl1.setFont(lbl1.getFont().deriveFont(16.0f));
        lbl1.setBounds(120, 20,160,35);

        splr = new JLabel("Speler nummer :");
        splr.setBounds(90, 70, 120, 35);
        splrt = new JTextField();
        splrt.setBounds(220, 75, 120, 25);

        toer = new JLabel("Toernooi nummer :");
        toer.setBounds(90, 110, 120, 35);
        toert = new JTextField();
        toert.setBounds(220, 115, 120, 25);

        r1 = new JRadioButton("Betaald");
        r1.setBounds(120, 150, 70, 25);
        r1.setSelected(true);
        r2 = new JRadioButton("Niet betaald");
        r2.setBounds(200, 150, 100, 25);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);


        b2 = new JButton("Verwijderen");
        b2.setBounds(150,190,130,35);

        //-------------------------------------------------//
        //                 zoek                            //

        zoek = new JLabel("Zoek Inschrijving nummer:");
        zoek.setBounds(50, 300, 160, 35);
        zoekt = new JTextField();
        zoekt.setBounds(50, 330, 120, 25);
        b3 = new JButton("Zoek");
        b3.setBounds(50, 360, 100, 35);


        //-------------------------------------------------//



        //button Listener
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                uitschrijven.super.dispose();
            }
        });

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement ps;
                String query = "DELETE FROM `Inschrijving` WHERE `inschrijving_nr` =" +  zoekt.getText();

                try {

                    ps =  dbCon.getConnnection().prepareStatement(query);

                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null, "Uitschrijving voltooid");


                    }


                }catch(Exception es){ System.out.println(es); }

                finally { System.out.println("Operation Done"); }

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement ps;
                String query = "SELECT * FROM `Inschrijving` WHERE `inschrijving_nr` =" + zoekt.getText();

                try {

                    ps =  dbCon.getConnnection().prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        int sple = rs.getInt("speler_nr");
                        int toerr = rs.getInt("toernooi_nr");
                        boolean betld = rs.getBoolean("betaald");

                        splrt.setText(Integer.toString(sple));
                        toert.setText(Integer.toString(toerr));

                        if(betld == true){
                            r1.setSelected(true);
                        }else if(betld == false){
                            r2.setSelected(true);
                        }


                    }


                }catch(Exception es){ System.out.println(es); }

                finally { System.out.println("Operation Done"); }


            }
        });

        add(b1);
        add(b2);
        add(zoekt);
        add(b3);
        add(zoek);
        add(lbl1);
        add(r1);
        add(r2);
        add(splr);
        add(splrt);
        add(toer);
        add(toert);

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


