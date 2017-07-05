import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Retrieve {

    public static void fillList(ArrayList<Level> list) {
        System.out.println("Tabelle game_level:");

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:postgresql://134.96.217.36:5432/benutzerverwaltung";
        String user = "benutzerverwaltung";
        String password = "D2r@!FG45%";

        try {

            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("SELECT * FROM game_level");
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(" : ");
                System.out.print(rs.getInt(2));
                System.out.print(" : ");
                System.out.print(rs.getString(3));
                System.out.print(" : ");
                System.out.println(rs.getString(4));

            }

        } catch (SQLException ex) {
            System.err.println("FEHLER RETRIVE");

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
                System.out.println("-------------------------------------------");

            } catch (SQLException ex) {
                System.err.println("FEHLER CON-SCHLIEßEN RETRIVE");
            }
        }
    }
}