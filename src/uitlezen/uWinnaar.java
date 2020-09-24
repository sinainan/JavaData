package uitlezen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.dbCon;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import data.*;

public class uWinnaar extends JPanel{
    public uWinnaar(){
        initializeUI3();
    }

    public void initializeUI3() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));

        JTable table = new JTable(500, 20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[6];

        columnsName[0] = "winnaar_id";
        columnsName[1] = "gewonnen_prijs";
        columnsName[2] = "tefel_nr";
        columnsName[3] = "ronde_nr";
        columnsName[4] = "speler_nr";
        columnsName[5] = "toernooi_nr";


        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[8];

        for (int i = 0; i < getWinnaar().size(); i++) {

            rowData[0] = getWinnaar().get(i).getWinnaar_id();
            rowData[1] = getWinnaar().get(i).getGewonnen_prijs();
            rowData[2] = getWinnaar().get(i).getTafel_nr();
            rowData[3] = getWinnaar().get(i).getRonde_nr();
            rowData[4] = getWinnaar().get(i).getSpeler_nr();
            rowData[5] = getWinnaar().get(i).getToernooi_nr();


            model.addRow(rowData);
        }


        table.setModel(model);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    public static void showFrame3() {
        JPanel panel = new uWinnaar();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    static ArrayList<Winnaar> getWinnaar(){

        ArrayList<Winnaar> winnaar = new ArrayList<Winnaar>();

        PreparedStatement ps;
        String query = "SELECT * FROM `Winnaar`";
        Winnaar w;

        try{
            ps =  dbCon.getConnnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                w = new Winnaar(rs.getInt("winnaar_id"),
                        rs.getDouble("gewonnen_prijs"),
                        rs.getInt("tefel_nr"),
                        rs.getInt("ronde_nr"),
                        rs.getInt("speler_nr"),
                        rs.getInt("toernooi_nr"));


                winnaar.add(w);
            }



        }catch(Exception ex){ Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex); }

        finally { System.out.println("Operation Done"); }


        return winnaar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                uWinnaar.showFrame3();
            }
        });
    }
}
