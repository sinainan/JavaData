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

public class uToernooi extends JPanel{

    public uToernooi(){
        initializeUI1();


    }


    public void initializeUI1() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));

        JTable table = new JTable(20, 20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[10];

        columnsName[0] = "toernooi_nr";
        columnsName[1] = "naam";
        columnsName[2] = "toernooi_prijs";
        columnsName[3] = "type";
        columnsName[4] = "max_aantalspeler";
        columnsName[5] = "thema";
        columnsName[6] = "datum";
        columnsName[7] = "begin_tijd";
        columnsName[8] = "eind_tijd";
        columnsName[9] = "zaalNaam";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[11];

        for (int i = 0; i < getToernooi().size(); i++) {

            rowData[0] = getToernooi().get(i).getToernooi_nr();
            rowData[1] = getToernooi().get(i).getNaam();
            rowData[2] = getToernooi().get(i).getToernooi_prijs();
            rowData[3] = getToernooi().get(i).getType();
            rowData[4] = getToernooi().get(i).getMax_aantalspeler();
            rowData[5] = getToernooi().get(i).getThema();
            rowData[6] = getToernooi().get(i).getDatum();
            rowData[7] = getToernooi().get(i).getBegin_tijd();
            rowData[8] = getToernooi().get(i).getEind_tijd();
            rowData[9] = getToernooi().get(i).getZaalNaam();


            model.addRow(rowData);
        }


        table.setModel(model);


        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);

    }

    public static void showFrame1() {
        JPanel panel = new uToernooi();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);



    }



    static ArrayList<Toernooi>getToernooi(){

        ArrayList<Toernooi> toernooi = new ArrayList<Toernooi>();

        PreparedStatement ps;
        String query = "SELECT * FROM Toernooi";
        Toernooi t;

        try{
            ps =  dbCon.getConnnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                t = new Toernooi(rs.getInt("toernooi_nr"),
                        rs.getString("naam"),
                        rs.getDouble("toernooi_prijs"),
                        rs.getInt("type"),
                        rs.getInt("max_aantalspeler"),
                        rs.getString("thema"),
                        rs.getDate("datum"),
                        rs.getString("begin_tijd"),
                        rs.getString("eind_tijd"),
                        rs.getString("zaalNaam"));

                toernooi.add(t);
            }



        }catch(Exception ex){ Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex); }

        finally { System.out.println("Operation Done"); }


        return toernooi;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                uToernooi.showFrame1();
            }
        });
    }

}
