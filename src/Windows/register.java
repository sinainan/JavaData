package Windows;

import DB.dbCon;
import Main.Main;
import javafx.scene.control.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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


public class register extends JFrame {

    private JButton b1, b2;
    private JLabel lbl1, rlbln, rlbla, rlblw, rlblp, rlblt, rlble, rlblgeb, rlblr;
    private JTextField rtfn, rtfa, rtfw, rtfp, rtft, rtfe, rtfr;
    private JRadioButton r1, r2, r3, r4;
    private UtilDateModel model;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;



    public static int width = 500;
    public static int hight = 700;


    public register(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Terug");
        b1.setBounds(405,630,80,35);
        lbl1 = new JLabel("Registreren");
        lbl1.setFont(lbl1.getFont().deriveFont(16.0f));
        lbl1.setBounds(200, 20,120,35);

        //-----------------------------------//
        //            register               //

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

        //button Listener
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                register.super.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date curdate = new Date();
                String tekst = dateFormat.format(curdate);
                String[] parts = tekst.split("/");
                String part1 = parts[0];
                String part2 = parts[1];
                String part3 = parts[2];

                int year = Integer.parseInt(part1);
                int month = Integer.parseInt(part2);
                int day = Integer.parseInt(part3);

                int year18 = year - 18;

                int chyear = datePicker.getModel().getYear();
                int chmonth = datePicker.getModel().getMonth();
                int chday = datePicker.getModel().getDay();

                System.out.println("DP: " + chyear + "/" + chmonth + "/" + chday + " -- curdate: " + year + " || " + year18 + "/" + month + "/" + day);

                if (chyear <= year18) {
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

                    if (r2.isSelected()) {
                        ges = "V";
                        System.out.println(ges);
                    } else {
                        ges = "M";
                        System.out.println(ges);
                    }

                    if (r4.isSelected()) {
                        leer = false;
                        System.out.println(leer);
                    } else {
                        leer = true;
                        System.out.println(leer);
                    }

                    PreparedStatement ps;
                    String query = "INSERT INTO `Speler`(`naam`, `adres`, `woonplaats`, `postcode`, `tel_nrm`, `email`, `geb_datum`, `rating`, `geslacht`, `mc_leraar`) VALUES (?,?,?,?,?,?,?,?,?,?)";

                    try {

                        ps = dbCon.getConnnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
                        ps.executeUpdate();
                        ResultSet rs = ps.getGeneratedKeys();
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null, "Speler is geregistreerd \n Je spelers nummer is: " + rs.getInt(1));

                            datePicker.getModel().setSelected(false);

                            rtfn.setText("");
                            rtfa.setText("");
                            rtfw.setText("");
                            rtfp.setText("");
                            rtft.setText("");
                            rtfe.setText("");
                            rtfr.setText("");

                        }


                    }catch (ClassNotFoundException ess) {
                        // TODO Auto-generated catch block
                        ess.printStackTrace();
                    } catch (SQLException esss) {
                        // TODO Auto-generated catch block
                        esss.printStackTrace();
                    } catch (Exception es) {
                        System.out.println(es);
                    } finally {
                        System.out.println("Operation Done");
                    }


                }else{
                    JOptionPane.showMessageDialog(null, "Speler is jonger dan 18");
                }
            }
        });

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
