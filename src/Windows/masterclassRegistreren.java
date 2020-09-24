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

public class masterclassRegistreren extends JFrame {

    private JButton b1;
    private JButton b2;
    private JLabel lbl1;

    public static int width = 500;
    public static int hight = 700;
    private JLabel rlbln, rlbla, rlblw, rlblp, rlblt, rlblgeb, rlblbegin , rlbleind;
    private JTextField rtfn, rtfa, rtfw, rtfp, rtft, rtfbegin , rtfeind;
    private UtilDateModel model;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;



    public masterclassRegistreren(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Terug");
        b1.setBounds(405,630,80,35);
        lbl1 = new JLabel("Masterclass registreren");
        lbl1.setFont(lbl1.getFont().deriveFont(16.0f));
        lbl1.setBounds(120, 20,250,35);

        //-----------------------------------//
        //            masterclass               //

        rlbln = new JLabel("Naam :");
        rlbln.setBounds(170, 70, 120, 35);
        rtfn = new JTextField();
        rtfn.setBounds(220, 75, 120, 25);

        rlbla = new JLabel("Rating punten :");
        rlbla.setBounds(130, 110, 120, 35);
        rtfa = new JTextField();
        rtfa.setBounds(220, 115, 120, 25);

        rlblw = new JLabel("Prijs :");
        rlblw.setBounds(170, 150, 120, 35);
        rtfw = new JTextField();
        rtfw.setBounds(220, 155, 120, 25);

        rlblt = new JLabel(" Locatie :");
        rlblt.setBounds(160, 190, 120, 35);
        rtft = new JTextField();
        rtft.setBounds(220, 195, 120, 25);

        rlblbegin = new JLabel("Begin tijd :");
        rlblbegin.setBounds(150, 230, 120, 35);
        rtfbegin = new JTextField();
        rtfbegin.setBounds(220, 235, 120, 25);

        rlbleind = new JLabel("Eind tijd :");
        rlbleind.setBounds(150, 270, 120, 35);
        rtfeind = new JTextField();
        rtfeind.setBounds(220, 275, 120, 25);

        rlblgeb = new JLabel("Datum :");
        rlblgeb.setBounds(150, 310, 120, 35);
        model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(220, 315, 120, 25);


        b2 = new JButton("Opslaan");
        b2.setBounds(225,360,100,35);


        //button Listener
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                Windows.masterclassRegistreren.super.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naam = rtfn.getText();
                int niveau = Integer.parseInt(rtfa.getText());
                int locatie = Integer.parseInt(rtft.getText());
                double prijs = Double.parseDouble(rtfw.getText());
                String beginT = rtfbegin.getText();
                String eindT = rtfeind.getText();

                Date selectedDate = (Date) datePicker.getModel().getValue();
                java.sql.Date selectedDate1 = new java.sql.Date(selectedDate.getTime());

                PreparedStatement ps;
                String query = "INSERT INTO `MarsterClass`(`ratingpunten`, `naam`, `prijs`,`datum`, `begin_tijd`,`eind_tijd`,`Locatie_id`) VALUES (?,?,?,?,?,?,?)";

                try {

                    ps =  dbCon.getConnnection().prepareStatement(query);
                    ps.setInt(1, niveau);
                    ps.setString(2, naam);
                    ps.setDouble(3, prijs);
                    ps.setDate(4, selectedDate1);
                    ps.setString(5, beginT);
                    ps.setString(6, eindT);
                    ps.setInt(7, locatie);

                    if(ps.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null, "masterclass is geplaats");

                        rtfn.setText("");
                        rtfa.setText("");
                        rtfw.setText("");
                        rtfp.setText("");
                        rtft.setText("");
                        rtfbegin.setText("");
                        rtfeind.setText("");
                        datePicker.getModel().setSelected(false);

                    }


                }catch(Exception es){ System.out.println(es); }

                finally { System.out.println("Operation Done"); }


            }
        });




        add(b1);
        add(lbl1);
        add(datePicker);
        add(b2);
        add(rlblgeb);
        add(rlblt);
        add(rtfeind);
        add(rlbleind);
        add(rlbla);
        add(rtfa);
        add(rlblbegin);
        add(rtfbegin);
        add(rtfw);
        add(rlblw);

        add(rtft);

        add(rlbln);
        add(rtfn);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

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






