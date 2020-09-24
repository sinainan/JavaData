
package Windows;

import DB.dbCon;
import Main.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class inschrijvenMasterclass extends JFrame {

    private JButton b1, b2;
    private JLabel lbl1;

    private JLabel splr, toer;
    private JTextField splrt, toert;
    private JRadioButton r1, r2;


    public static int width = 400;
    public static int hight = 425;


    public inschrijvenMasterclass() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        b1 = new JButton("Terug");
        b1.setBounds(305, 380, 80, 35);
        lbl1 = new JLabel("Inschrijven masterklassen");
        lbl1.setFont(lbl1.getFont().deriveFont(16.0f));
        lbl1.setBounds(100, 20, 220, 35);

        splr = new JLabel("Speler nummer :");
        splr.setBounds(90, 70, 120, 35);
        splrt = new JTextField();
        splrt.setBounds(220, 75, 120, 25);

        toer = new JLabel("Klas nummer :");
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


        b2 = new JButton("Opslaan");
        b2.setBounds(150, 190, 100, 35);


        //button Listener
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                inschrijvenMasterclass.super.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean betaald = true;

                int spl = Integer.parseInt(splrt.getText());
                int toe = Integer.parseInt(toert.getText());

                if (r2.isSelected()) {
                    betaald = false;
                    System.out.println(betaald);
                } else {
                    betaald = true;
                    System.out.println(betaald);
                }


                PreparedStatement ps;
                String query = "INSERT INTO `MC_inschrijving`(`betaald`, `speler_nr`, `class_nr`) VALUES (?, ?, ?)";

                try {

                    ps = dbCon.getConnnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // TODO deze moet ook derbij
                    ps.setInt(1, spl);
                    ps.setInt(2, toe);
                    ps.setBoolean(3, betaald);
                    //-----------------//
                    // TODO dit moet aangepast worden op alle paginas waar insert wordt gebruikt
                    ps.executeUpdate();
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Je bent ingeschreven. \n Je inschrijf nummer is: " + rs.getInt(1));
                        splrt.setText("");
                        toert.setText("");
                    }


                } catch (ClassNotFoundException ess) {
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

            }
        });

        add(b1);
        add(b2);
        add(lbl1);
        add(r1);
        add(r2);
        add(splr);
        add(splrt);
        add(toer);
        add(toert);

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
