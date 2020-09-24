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
import java.util.Date;
import java.util.Properties;


public class toernooiPlaatsen extends JFrame {

    private JButton b2;
    private JButton b1;
    private JLabel lbl1;
    private JComboBox type;
    private UtilDateModel model;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;


    public static int width = 700;
    public static int hight = 700;

    private JLabel rlbln, rlbla, rlblw, rlblp, rlblt, rlblgeb, rlbt, rlblbt, rlblet ;
    private JTextField rtfn, rtfa, rtfw, rtfp, rtft, rtfe, rtfr, rtfbt, rtfet;

    private JLabel adres, post, plaats, stoelen, tafels;
    private JTextField adress, postt, plaatss, stoelenn, tafelss;



    public toernooiPlaatsen(){

        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Terug");
        b1.setBounds(605,630,80,35);
        lbl1 = new JLabel("Toernooi plaatsen");
        lbl1.setFont(lbl1.getFont().deriveFont(16.0f));
        lbl1.setBounds(300, 20,160,35);

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



        b2 = new JButton("Opslaan");
        b2.setBounds(225,475,100,35);

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



        //button Listener
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                toernooiPlaatsen.super.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String naam = rtfn.getText();
                String zaal = rtfa.getText();
                String prijs = rtfw.getText();
                String aantal = rtfp.getText();
                String thema = rtft.getText();
                String btijd = rtfbt.getText();
                String etijd = rtfet.getText();

                Object obj = type.getSelectedIndex();
                int i = (int) obj;

                Date selectedDate = (Date) datePicker.getModel().getValue();
                java.sql.Date selectedDate1 = new java.sql.Date(selectedDate.getTime());


                String adres = adress.getText();
                String post = postt.getText();
                String plaats = plaatss.getText();
                int stoelen = Integer.parseInt(rtfp.getText());
                int tafels = Integer.parseInt(tafelss.getText());

                PreparedStatement ps, ps1;
                String query = "INSERT INTO `Toernooi`(`naam`, `toernooi_prijs`, `type`, `max_aantalspeler`, `thema`, `datum`, `begin_tijd`, `eind_tijd`, `zaalNaam`) VALUES (?,?,?,?,?,?,?,?,?)";
                String query1= "INSERT INTO `Locatie`(`zaal_naam`, `adres`, `postcode`, `plaats`, `aantal_stoelen`, `aantal_tafels`) VALUES (?,?,?,?,?,?)";




                try {

                    ps =  dbCon.getConnnection().prepareStatement(query);
                    ps1 = dbCon.getConnnection().prepareStatement(query1);

                    ps.setString(1, naam);
                    ps.setString(2, prijs);
                    ps.setInt(3, i);
                    ps.setString(4, aantal);
                    ps.setString(5, thema);
                    ps.setDate(6, selectedDate1);
                    ps.setString(7, btijd);
                    ps.setString(8, etijd);
                    ps.setString(9, zaal);


                    ps1.setString(1, zaal);
                    ps1.setString(2, adres);
                    ps1.setString(3,post);
                    ps1.setString(4, plaats);
                    ps1.setInt(5,stoelen);
                    ps1.setInt(6, tafels);


                    if(ps.executeUpdate() > 0 && ps1.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null, "toernooi is geplaats");

                        rtfn.setText("");
                        rtfa.setText("");
                        rtfw.setText("");
                        rtfp.setText("");
                        rtft.setText("");
                        rtfet.setText("");
                        rtfbt.setText("");

                        datePicker.getModel().setSelected(false);

                        adress.setText("");
                        postt.setText("");
                        plaatss.setText("");
                        tafelss.setText("");

                    }


                }catch(Exception es){ System.out.println(es); }

                finally { System.out.println("Operation Done"); }


            }
        });

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