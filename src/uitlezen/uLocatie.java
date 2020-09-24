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

public class uLocatie extends JPanel{

    public uLocatie(){
        initializeUI5();
    }

    public void initializeUI5() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));

        JTable table = new JTable(500, 20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[7];

        columnsName[0] = "Locatie_id";
        columnsName[1] = "zaal_naam";
        columnsName[2] = "adres";
        columnsName[3] = "postcode";
        columnsName[4] = "plaats";
        columnsName[5] = "aantal_stoelen";
        columnsName[6] = "aantal_tafels";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[8];

        for (int i = 0; i < getLoc().size(); i++) {

            rowData[0] = getLoc().get(i).getLocatie_id();
            rowData[1] = getLoc().get(i).getZaal_naam();
            rowData[2] = getLoc().get(i).getAdres();
            rowData[3] = getLoc().get(i).getPostcode();
            rowData[4] = getLoc().get(i).getPlaats();
            rowData[5] = getLoc().get(i).getAantal_stoelen();
            rowData[6] = getLoc().get(i).getAantal_tafels();




            model.addRow(rowData);
        }


        table.setModel(model);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    public static void showFrame5() {
        JPanel panel = new uLocatie();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    static ArrayList<Locatie> getLoc(){

        ArrayList<Locatie> loc = new ArrayList<Locatie>();

        PreparedStatement ps;
        String query = "SELECT * FROM `Locatie` LIMIT 10";
        Locatie l;

        try{
            ps =  dbCon.getConnnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                l = new Locatie(rs.getInt("Locatie_id"),
                        rs.getString("zaal_naam"),
                        rs.getString("adres"),
                        rs.getString("postcode"),
                        rs.getString("plaats"),
                        rs.getInt("aantal_stoelen"),
                        rs.getInt("aantal_tafels"));



                loc.add(l);
            }



        }catch(Exception ex){ Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex); }

        finally { System.out.println("Operation Done"); }


        return loc;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                uLocatie.showFrame5();
            }
        });
    }
}
