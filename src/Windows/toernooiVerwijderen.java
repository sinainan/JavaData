package Windows;

import DB.dbCon;
import Main.Main;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class toernooiVerwijderen extends JFrame {

    private JButton b2;
    private JButton b1, b3;
    private JLabel lbl1;
    private JComboBox type;
    private UtilDateModel model;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;


    public static int width = 700;
    public static int hight = 700;

    private JLabel rlbln, rlbla, rlblw, rlblp, rlblt, rlblgeb, rlbt, rlblbt, rlblet ;
    private JTextField rtfn, rtfa, rtfw, rtfp, rtft, rtfe, rtfr, rtfbt, rtfet;

    private JLabel adres, post, plaats, stoelen, tafels, zoek;
    private JTextField adress, postt, plaatss, stoelenn, tafelss, zoekt;



    public toernooiVerwijderen(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Terug");
        b1.setBounds(605,630,80,35);
        lbl1 = new JLabel("Toernooi verwijderen");
        lbl1.setFont(lbl1.getFont().deriveFont(16.0f));
        lbl1.setBounds(300, 20,190,35);

        //------------------------------------------------//

        rlbln = new JLabel("Naam :");
        rlbln.setBounds(170, 70, 120, 35);
        rtfn = new JTextField();
        rtfn.setBounds(220, 75, 120, 25);

        rlbla = new JLabel("Zaal naam :");
        rlbla.setBounds(145, 110, 120, 35);
        rtfa = new JTextField();
        rtfa.setBounds(220, 115, 120, 25);

        rlblw = new JLabel("Prijs :");
        rlblw.setBounds(170, 150, 120, 35);
        rtfw = new JTextField();
        rtfw.setBounds(220, 155, 120, 25);

        rlblp = new JLabel("Aantal Speler :");
        rlblp.setBounds(125, 190, 120, 35);
        rtfp = new JTextField();
        rtfp.setBounds(220, 195, 120, 25);

        rlblt = new JLabel(" Thema :");
        rlblt.setBounds(160, 230, 120, 35);
        rtft = new JTextField();
        rtft.setBounds(220, 235, 120, 25);


        rlblgeb = new JLabel("datum :");
        rlblgeb.setBounds(160, 310, 120, 35);
        model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(220, 315, 120, 35);

        rlbt = new JLabel("Type :");
        rlbt.setBounds(170, 265, 120, 35);
        String[] msgArr = {"Normaal", "Kersttoernooi", "Nieuwjaarstoernooi", "Carnavalstoernooi", "Paastoernooi", "Pink Ribbon"};
        type = new JComboBox(msgArr);
        type.setSelectedIndex(0);
        type.setBounds(220, 270, 120, 25);

        rlblbt = new JLabel(" Begin tijd :");
        rlblbt.setBounds(150, 355, 120, 35);
        rtfbt = new JTextField();
        rtfbt.setBounds(220, 360, 120, 25);

        rlblet = new JLabel(" Eind tijd :");
        rlblet.setBounds(160, 395, 120, 35);
        rtfet = new JTextField();
        rtfet.setBounds(220, 400, 120, 25);



        b2 = new JButton("Verwijderen");
        b2.setBounds(225,475,140,35);

        //---------------------------------------------------------//


        //-------------------------------------------------------//
        //               zaal                                  //

        adres = new JLabel("Adres :");
        adres.setBounds(400, 110, 120, 35);
        adress = new JTextField();
        adress.setBounds(450, 115, 120, 25);

        post = new JLabel("Postcode :");
        post.setBounds(370, 150, 120, 35);
        postt = new JTextField();
        postt.setBounds(450, 155, 120, 25);

        plaats = new JLabel("plaats :");
        plaats.setBounds(400, 190, 120, 35);
        plaatss = new JTextField();
        plaatss.setBounds(450, 195, 120, 25);

        tafels = new JLabel(" Aantal tafels :");
        tafels.setBounds(360, 230, 120, 35);
        tafelss = new JTextField();
        tafelss.setBounds(450, 235, 120, 25);

        //--------------------------------------------------//
        //                 zoek                            //

        zoek = new JLabel("Zoek Toernooi:");
        zoek.setBounds(50, 600, 100, 35);
        zoekt = new JTextField();
        zoekt.setBounds(50, 630, 120, 25);
        b3 = new JButton("Zoek");
        b3.setBounds(50, 660, 100, 35);


        //-------------------------------------------------//



        //button Listener
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                toernooiVerwijderen.super.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement ps, ps1;
                String query = "DELETE FROM `Toernooi` WHERE `toernooi_nr` =" +  zoekt.getText();
                String query1 = "DELETE FROM `Locatie` WHERE `Locatie_id` =" + zoekt.getText();

                try {

                    ps =  dbCon.getConnnection().prepareStatement(query);
                    ps1 =  dbCon.getConnnection().prepareStatement(query1);

                    if(ps.executeUpdate() > 0 && ps1.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null, "Toernooi is verwijderdt");


                    }


                }catch(Exception es){ System.out.println(es); }

                finally { System.out.println("Operation Done"); }


            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement ps, ps2;
                String query = "SELECT * FROM `Toernooi` WHERE `toernooi_nr` = " + zoekt.getText();
                String query1 = "SELECT * FROM `Locatie` WHERE `Locatie_id` = " + zoekt.getText();

                try {

                    ps =  dbCon.getConnnection().prepareStatement(query);
                    ps2 = dbCon.getConnnection().prepareStatement(query1);
                    ResultSet rs = ps.executeQuery();
                    ResultSet rs2 = ps2.executeQuery();
                    while (rs.next() && rs2.next()) {
                        String naam = rs.getString("naam");
                        double prijs = rs.getDouble("toernooi_prijs");
                        int type1 = rs.getInt("type");
                        int speler = rs.getInt("max_aantalspeler");
                        String thema = rs.getString("thema");
                        java.sql.Date date = rs.getDate("datum");
                        String btijd = rs.getString("begin_tijd");
                        String etijd = rs.getString("eind_tijd");
                        String zaalNaam = rs.getString("zaalNaam");


                        String zaaln = rs2.getString("zaal_naam");
                        String adres1 = rs2.getString("adres");
                        String postcode1 = rs2.getString("postcode");
                        String plaats1 = rs2.getString("plaats");
                        int stoel1 = rs2.getInt("aantal_stoelen");
                        int tafel1 = rs2.getInt("aantal_tafels");

                        rtfn.setText(naam);
                        rtfw.setText(Double.toString(prijs));
                        type.setSelectedIndex(type1);
                        rtfp.setText(Integer.toString(speler));
                        rtft.setText(thema);
                        rtfbt.setText(btijd);
                        rtfet.setText(etijd);
                        rtfa.setText(zaalNaam);

                        adress.setText(adres1);
                        postt.setText(postcode1);
                        plaatss.setText(plaats1);
                        tafelss.setText(Integer.toString(tafel1));

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





                    }


                }catch(Exception es){ System.out.println(es); }

                finally { System.out.println("Operation Done"); }


            }
        });

        add(zoekt);
        add(b3);
        add(zoek);
        add(tafels);
        add(tafelss);
        add(plaats);
        add(plaatss);
        add(post);
        add(postt);
        add(adres);
        add(adress);
        add(rtfbt);
        add(rtfet);
        add(rlblbt);
        add(rlblet);
        add(b1);
        add(lbl1);
        add(datePicker);
        add(b2);
        add(type);
        add(rlblgeb);
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
        add(lbl1);
        add(rlbt);

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



