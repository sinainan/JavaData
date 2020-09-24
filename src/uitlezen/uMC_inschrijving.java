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

public class uMC_inschrijving extends JPanel{
    public uMC_inschrijving(){
        initializeUI6();
    }

    public void initializeUI6() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));

        JTable table = new JTable(500, 20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[4];

        columnsName[0] = "inschrijving_nr";
        columnsName[1] = "betaald";
        columnsName[2] = "speler_nr";
        columnsName[3] = "class_nr";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[4];

        for (int i = 0; i < getMC().size(); i++) {

            rowData[0] = getMC().get(i).getInschrijving_nr();
            rowData[1] = getMC().get(i).isBetaald();
            rowData[2] = getMC().get(i).getSpeler_nr();
            rowData[3] = getMC().get(i).getClass_nr();



            model.addRow(rowData);
        }


        table.setModel(model);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    public static void showFrame6() {
        JPanel panel = new uMC_inschrijving();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    static ArrayList<McInschrijving> getMC(){

        ArrayList<McInschrijving> mc = new ArrayList<McInschrijving>();

        PreparedStatement ps;
        String query = "SELECT * FROM `MC_inschrijving`";
        McInschrijving m;

        try{
            ps =  dbCon.getConnnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                m = new McInschrijving(rs.getInt("inschrijving_nr"),
                        rs.getBoolean("betaald"),
                        rs.getInt("speler_nr"),
                        rs.getInt("class_nr"));



                mc.add(m);
            }



        }catch(Exception ex){ Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex); }

        finally { System.out.println("Operation Done"); }


        return mc;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                uMC_inschrijving.showFrame6();
            }
        });
    }
}
