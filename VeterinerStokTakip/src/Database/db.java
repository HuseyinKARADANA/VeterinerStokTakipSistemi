
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class db {
    Connection conn = null;
    
    public static Connection java_db() {
        String path="C:\\Users\\huseyinkaradana\\Documents\\NetBeansProjects\\VeterinerStokTakip\\src\\Database\\VeterinerStokTakip.accdb"; 
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String url = "jdbc:ucanaccess://"+path;
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (Exception e) {
   
            return null;
        }

    }
}