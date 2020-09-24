package Windows;

import DB.dbCon;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;

public class winnaarRegistreren extends JFrame {

    private JButton b1 , b2;
    private JLabel lbl1;
    private JLabel rlbln, rlbla, rlblw, rlblp, rlbli, rlblr;
    private JTextField rtfn, rtfa, rtfw, rtfp , rtfi,  rtfr;
    public static int width = 400;
    public static int hight = 425;



    public winnaarRegistreren(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Terug");
        b1.setBounds(305,380,80,35);
        lbl1 = new JLabel("Winnaar Registreren");
        lbl1.setFont(lbl1.getFont().deriveFont(16.0f));
        lbl1.setBounds(120, 20,160,35);


        //-----------------------------------//
        //            masterclass               //

        rlbln = new JLabel("Tafel :");
        rlbln.setBounds(175, 70, 120, 35);
        rtfn = new JTextField();
        rtfn.setBounds(220, 75, 120, 25);

        rlbla = new JLabel("Speler nummer :");
        rlbla.setBounds(115, 110, 120, 35);
        rtfa = new JTextField();
        rtfa.setBounds(220, 115, 120, 25);

        rlblw = new JLabel("Gewonnen Prijs :");
        rlblw.setBounds(110, 150, 120, 35);
        rtfw = new JTextField();
        rtfw.setBounds(220, 155, 120, 25);

        rlblp = new JLabel("Toernooi nummer :");
        rlblp.setBounds(100, 190, 120, 35);
        rtfp = new JTextField();
        rtfp.setBounds(220, 195, 120, 25);

        rlbli = new JLabel("Ronde:");
        rlbli.setBounds(140, 225, 120, 35);
        rtfi = new JTextField();
        rtfi.setBounds(220, 230, 120, 25);

        b2 = new JButton("Opslaan");
        b2.setBounds(190,275 ,100,35);


        //button Listener
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                winnaarRegistreren.super.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tafel = Integer.parseInt(rtfn.getText());
                int speler_nr = Integer.parseInt(rtfa.getText());
                double GWN_prijs = Double.parseDouble(rtfw.getText());
                int toernooi_nummer = Integer.parseInt(rtfp.getText());
                int ronde = Integer.parseInt(rtfi.getText());


                PreparedStatement ps;
                String query = "INSERT INTO `Winnaar`(`gewonnen_prijs`, `tefel_nr`, `ronde_nr`, `speler_nr`,`toernooi_nr`) VALUES (?,?,?,?,?)";

                try {

                    ps =  dbCon.getConnnection().prepareStatement(query);
                    ps.setDouble(1, GWN_prijs);
                    ps.setInt(2, tafel);
                    ps.setInt(3, ronde);
                    ps.setInt(4, speler_nr);
                    ps.setInt(5, toernooi_nummer);





                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null, "Winnaar is geregistreed");

                        rtfn.setText("");
                        rtfa.setText("");
                        rtfw.setText("");
                        rtfp.setText("");




                    }


                }catch(Exception es){ System.out.println(es); }

                finally { System.out.println("Operation Done"); }


            }
        });


        add(b1);
        add(lbl1);
        add(b2);
        add(rlbla);
        add(rtfa);
        add(rtfp);
        add(rlblp);
        add(rtfw);
        add(rlblw);
        add(rlbln);
        add(rtfn);
        add(rtfi);
        add(rlbli);

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



