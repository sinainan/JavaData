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

public class uMarsterClass extends JPanel{

    public uMarsterClass(){
        initializeUI2();
    }

    public void initializeUI2() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));

        JTable table = new JTable(500, 20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[8];

        columnsName[0] = "class_nr";
        columnsName[1] = "ratingpunten";
        columnsName[2] = "naam";
        columnsName[3] = "prijs";
        columnsName[4] = "datum";
        columnsName[5] = "begin_tijd";
        columnsName[6] = "eind_tijd";
        columnsName[7] = "Locatie_id";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[8];

        for (int i = 0; i < getMaster().size(); i++) {

            rowData[0] = getMaster().get(i).getClass_nr();
            rowData[1] = getMaster().get(i).getRating();
            rowData[2] = getMaster().get(i).getNaam();
            rowData[3] = getMaster().get(i).getPrijs();
            rowData[4] = getMaster().get(i).getDatum();
            rowData[5] = getMaster().get(i).getBegin_tijd();
            rowData[6] = getMaster().get(i).getEind_tijd();
            rowData[7] = getMaster().get(i).getLocatie_id();



            model.addRow(rowData);
        }


        table.setModel(model);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    public static void showFrame2() {
        JPanel panel = new uMarsterClass();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    static ArrayList<masterclassRegisteren> getMaster(){

        ArrayList<masterclassRegisteren> master = new ArrayList<masterclassRegisteren>();

        PreparedStatement ps;
        String query = "SELECT * FROM `MarsterClass`";
        masterclassRegisteren m;

        try{
            ps =  dbCon.getConnnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                m = new masterclassRegisteren(rs.getInt("class_nr"),
                        rs.getInt("ratingpunten"),
                        rs.getString("naam"),
                        rs.getDouble("prijs"),
                        rs.getDate("datum"),
                        rs.getString("begin_tijd"),
                        rs.getString("eind_tijd"),
                        rs.getInt("Locatie_id"));


                master.add(m);
            }



        }catch(Exception ex){ Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex); }

        finally { System.out.println("Operation Done"); }


        return master;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                uMarsterClass.showFrame2();
            }
        });
    }


}
