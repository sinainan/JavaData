package Windows;

import DB.dbCon;
import Main.Main;
import javafx.scene.control.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Properties;

import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class gegevensWijz extends JFrame {

    private JButton b1, b2, b3;
    private JLabel lbl1, rlbln, rlbla, rlblw, rlblp, rlblt, rlble, rlblgeb, rlblr, zoek;
    private JTextField rtfn, rtfa, rtfw, rtfp, rtft, rtfe, rtfr, zoekt;
    private JRadioButton r1, r2, r3, r4;
    private UtilDateModel model;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;



    public static int width = 500;
    public static int hight = 700;


    public gegevensWijz(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Terug");
        b1.setBounds(405,660,80,35);
        lbl1 = new JLabel("Wijzigen");
        lbl1.setFont(lbl1.getFont().deriveFont(16.0f));
        lbl1.setBounds(200, 20,120,35);

        //-----------------------------------//
        //            Wijzigen               //

        rlbln = new JLabel("Naam :");
        rlbln.setBounds(170, 70, 120, 35);
        rtfn = new JTextField();
        rtfn.setBounds(220, 75, 120, 25);

        rlbla = new JLabel("Adres :");
        rlbla.setBounds(170, 110, 120, 35);
        rtfa = new JTextField();
        rtfa.setBounds(220, 115, 120, 25);

        rlblw = new JLabel("Woonplaats :");
        rlblw.setBounds(135, 150, 120, 35);
        rtfw = new JTextField();
        rtfw.setBounds(220, 155, 120, 25);

        rlblp = new JLabel("Postcode :");
        rlblp.setBounds(150, 190, 120, 35);
        rtfp = new JTextField();
        rtfp.setBounds(220, 195, 120, 25);

        rlblt = new JLabel("Telefoon Nummer :");
        rlblt.setBounds(105, 230, 120, 35);
        rtft = new JTextField();
        rtft.setBounds(220, 235, 120, 25);

        rlble = new JLabel("Email :");
        rlble.setBounds(170, 270, 120, 35);
        rtfe = new JTextField();
        rtfe.setBounds(220, 275, 120, 25);

        rlblgeb = new JLabel("Geboorte datum :");
        rlblgeb.setBounds(115, 310, 120, 35);

        model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(220, 315, 120, 25);

        rlblr = new JLabel("Rating :");
        rlblr.setBounds(170, 350, 120, 35);
        rtfr = new JTextField();
        rtfr.setBounds(220, 355, 120, 25);

        r1 = new JRadioButton("Man");
        r1.setBounds(190, 400, 70, 25);
        r1.setSelected(true);
        r2 = new JRadioButton("Vrouw");
        r2.setBounds(270, 400, 100, 25);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        r3 = new JRadioButton("Leraar");
        r3.setBounds(190, 430, 80, 25);
        r3.setSelected(true);
        r4 = new JRadioButton("Geen Leraar");
        r4.setBounds(270, 430, 100, 25);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(r3);
        group1.add(r4);

        b2 = new JButton("Opslaan");
        b2.setBounds(225,475,100,35);

        //--------------------------------------------------//

        //-------------------------------------------------//
        //                 zoek                            //

        zoek = new JLabel("Zoek Speler:");
        zoek.setBounds(50, 600, 100, 35);
        zoekt = new JTextField();
        zoekt.setBounds(50, 630, 120, 25);
        b3 = new JButton("zoek");
        b3.setBounds(50, 660, 100, 35);


        //-------------------------------------------------//

        //button Listener
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                gegevensWijz.super.dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement ps;
                String query = "SELECT * FROM `Speler` WHERE `speler_nr` = " + zoekt.getText();

                try {

                    ps =  dbCon.getConnnection().prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        String naam = rs.getString("naam");
                        String adres = rs.getString("adres");
                        String woonplts = rs.getString("woonplaats");
                        String postc = rs.getString("postcode");
                        String tel = rs.getString("tel_nrm");
                        String email = rs.getString("email");
                        java.sql.Date date = rs.getDate("geb_datum");
                        int rating = rs.getInt("rating");
                        String ges = rs.getString("geslacht");
                        boolean leer = rs.getBoolean("mc_leraar");

                        rtfn.setText(naam);
                        rtfa.setText(adres);
                        rtfw.setText(woonplts);
                        rtfp.setText(postc);
                        rtft.setText(tel);
                        rtfe.setText(email);

                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        String tekst = df.format(date);
                        String[] parts = tekst.split("/");
                        String part1 = parts[0];
                        String part2 = parts[1];
                        String part3 = parts[2];

                        System.out.println("T" + tekst + "   :   parts " + part1 + " : " + part2 + " : " + part3);

                        int min = Integer.parseInt(part2);
                        int res = min - 1;

                        datePicker.getModel().setYear(Integer.parseInt(part3));
                        datePicker.getModel().setMonth(res);
                        datePicker.getModel().setDay(Integer.parseInt(part1));
                        datePicker.getModel().setSelected(true);


                        //model.setDate(Integer.parseInt(part3), Integer.parseInt(part2), Integer.parseInt(part1));
                        //model.setSelected(true);

                        if(ges.equals("M")){
                            r1.setSelected(true);
                        }else if(ges.equals("V")){
                            r2.setSelected(true);
                        }

                        rtfr.setText(Integer.toString(rating));

                        if(leer == true){
                            r3.setSelected(true);
                        }else if(leer == false){
                            r4.setSelected(true);
                        }



                    }


                }catch(Exception es){ System.out.println(es); }

                finally { System.out.println("Operation Done"); }


            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naam = rtfn.getText();
                String adres = rtfa.getText();
                String woonplts = rtfw.getText();
                String postc = rtfp.getText();
                String tel = rtft.getText();
                String email = rtfe.getText();

                Date selectedDate = (Date) datePicker.getModel().getValue();
                java.sql.Date selectedDate1 = new java.sql.Date(selectedDate.getTime());

                int rating = Integer.parseInt(rtfr.getText());
                String ges = "M";
                boolean leer = true;

                if(r2.isSelected()){
                    ges = "V";
                    System.out.println(ges);
                }else{
                    ges = "M";
                    System.out.println(ges);
                }

                if(r4.isSelected()){
                    leer = false;
                    System.out.println(leer);
                }else{
                    leer = true;
                    System.out.println(leer);
                }

                PreparedStatement ps;
                String query = "UPDATE `Speler` SET `naam`= ?,`adres`= ?,`woonplaats`= ?,`postcode`= ?,`tel_nrm`= ?,`email`= ?,`geb_datum`= ?,`rating`= ?,`geslacht`= ?,`mc_leraar`= ? WHERE speler_nr = " +  zoekt.getText();

                try {

                    ps =  dbCon.getConnnection().prepareStatement(query);
                    ps.setString(1, naam);
                    ps.setString(2, adres);
                    ps.setString(3, woonplts);
                    ps.setString(4, postc);
                    ps.setString(5, tel);
                    ps.setString(6, email);
                    ps.setDate(7, selectedDate1);
                    ps.setInt(8, rating);
                    ps.setString(9, ges);
                    ps.setBoolean(10, leer);

                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null, "Speler is geupdate");

                        rtfn.setText("");
                        rtfa.setText("");
                        rtfw.setText("");
                        rtfp.setText("");
                        rtft.setText("");
                        rtfe.setText("");
                        rtfr.setText("");

                        datePicker.getModel().setSelected(false);

                    }


                }catch(Exception es){ System.out.println(es); }

                finally { System.out.println("Operation Done"); }


            }
        });

        add(zoekt);
        add(b3);
        add(zoek);
        add(datePicker);
        add(b2);
        add(rlble);
        add(rtfe);
        add(rlblgeb);
        add(rlblr);
        add(rtfr);
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        add(rlblt);
        add(rlbla);
        add(rtfp);
        add(rtfw);
        add(rtfa);
        add(rlblw);
        add(rlblp);
        add(rtft);
        add(rlbln);
        add(rtfn);
        add(b1);
        add(lbl1);


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
