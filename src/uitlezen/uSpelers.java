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

public class uSpelers extends JPanel{

    public uSpelers(){
        initializeUI();
    }

    public void initializeUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));

        JTable table = new JTable(500, 20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[11];

        columnsName[0] = "speler_nr";
        columnsName[1] = "naam";
        columnsName[2] = "adres";
        columnsName[3] = "woonplaats";
        columnsName[4] = "postcode";
        columnsName[5] = "tel_nrm";
        columnsName[6] = "email";
        columnsName[7] = "geb_datum";
        columnsName[8] = "rating";
        columnsName[9] = "geslacht";
        columnsName[10] = "mc_leraar";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[11];

        for (int i = 0; i < getSpeler().size(); i++) {

            rowData[0] = getSpeler().get(i).getSpeler_nr();
            rowData[1] = getSpeler().get(i).getNaam();
            rowData[2] = getSpeler().get(i).getAdres();
            rowData[3] = getSpeler().get(i).getWoonplaats();
            rowData[4] = getSpeler().get(i).getPostcode();
            rowData[5] = getSpeler().get(i).getTel_nrm();
            rowData[6] = getSpeler().get(i).getEmail();
            rowData[7] = getSpeler().get(i).getGeb_datum();
            rowData[8] = getSpeler().get(i).getRating();
            rowData[9] = getSpeler().get(i).getGeslacht();
            rowData[10] = getSpeler().get(i).isMc_leraar();


            model.addRow(rowData);
        }


        table.setModel(model);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    public static void showFrame() {
        JPanel panel = new uSpelers();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    static ArrayList<Speler> getSpeler(){

        ArrayList<Speler> speler = new ArrayList<Speler>();

        PreparedStatement ps;
        String query = "SELECT * FROM Speler LIMIT 10";
        Speler s;

        try{
            ps =  dbCon.getConnnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                s = new Speler(rs.getInt("speler_nr"),
                        rs.getString("naam"),
                        rs.getString("adres"),
                        rs.getString("woonplaats"),
                        rs.getString("postcode"),
                        rs.getString("tel_nrm"),
                        rs.getString("email"),
                        rs.getString("geb_datum"),
                        rs.getInt("rating"),
                        rs.getString("geslacht"),
                        rs.getBoolean("mc_leraar"));

                speler.add(s);
            }



        }catch(Exception ex){ Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex); }

        finally { System.out.println("Operation Done"); }


        return speler;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                uSpelers.showFrame();
            }
        });
    }

}
