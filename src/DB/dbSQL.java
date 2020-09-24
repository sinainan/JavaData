package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class dbSQL {

    public String naam, achternaam;

    public static void createTable() throws Exception{
        try {
            Connection conn = dbCon.getConnnection();

            PreparedStatement create =  conn.prepareStatement("CREATE TABLE IF NOT EXISTS tbltest(ID int NOT NULL AUTO_INCREMENT, naam VARCHAR(255), achternaam VARCHAR(255), PRIMARY KEY(ID))");
            create.executeUpdate();

            System.out.println("Table has been created Succesfull");

        }catch(Exception e){ System.out.println(e); }

        finally { System.out.println("Operation Done"); }

    }

    public static void dropTable() throws Exception{
        try {
            Connection conn = dbCon.getConnnection();

            PreparedStatement drop =  conn.prepareStatement("DROP TABLE tbltest");
            drop.executeUpdate();

            System.out.println("Table has been deleted Succesfull");

        }catch(Exception e){ System.out.println(e); }

        finally { System.out.println("Operation Done"); }
    }

    public static void insertTable() throws Exception{
        try {
            Connection conn = dbCon.getConnnection();

            PreparedStatement insert =  conn.prepareStatement("INSERT INTO tbltest(naam, achternaam) VALUES('Sina', 'Inan')");
            insert.executeUpdate();

            System.out.println("Data has been entered succesfull");

        }catch(Exception e){ System.out.println(e); }

        finally { System.out.println("Operation Done"); }
    }


}
