package uitlezen;

import DB.dbCon;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import data.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class uInschrijving extends JPanel {

    public uInschrijving(){
        initializeUI4();
    }

    public void initializeUI4() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));

        JTable table = new JTable(500, 20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[4];

        columnsName[0] = "inschrijving_nr";
        columnsName[1] = "speler_nr";
        columnsName[2] = "toernooi_nr";
        columnsName[3] = "betaald";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[4];

        for (int i = 0; i < getInsch().size(); i++) {

            rowData[0] = getInsch().get(i).getInschrijving_nr();
            rowData[1] = getInsch().get(i).getSpeler_nr();
            rowData[2] = getInsch().get(i).getToernooi_nr();
            rowData[3] = getInsch().get(i).isBetaald();



            model.addRow(rowData);
        }


        table.setModel(model);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    public static void showFrame4() {
        JPanel panel = new uInschrijving();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    static ArrayList<Inschrijvingen> getInsch(){

        ArrayList<Inschrijvingen> insch = new ArrayList<Inschrijvingen>();

        PreparedStatement ps;
        String query = "SELECT * FROM `Inschrijving`";
        Inschrijvingen i;

        try{
            ps =  dbCon.getConnnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                i = new Inschrijvingen(rs.getInt("inschrijving_nr"),
                        rs.getInt("speler_nr"),
                        rs.getInt("toernooi_nr"),
                        rs.getBoolean("betaald"));



                insch.add(i);
            }



        }catch(Exception ex){ Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex); }

        finally { System.out.println("Operation Done"); }


        return insch;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                uInschrijving.showFrame4();
            }
        });
    }
}
