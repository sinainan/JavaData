package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import DB.dbSet.*;

public class dbCon {

    public static Connection getConnnection() throws Exception{

        try{
            //Class.forName(dbSet.driver);

            Connection conn = DriverManager.getConnection(dbSet.url, dbSet.name, dbSet.pass);
            System.out.println("Connected");
            return conn;

        }catch(Exception e) {System.out.println(e);}

        return null;
    }
}
