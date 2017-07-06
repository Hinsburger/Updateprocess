import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ListToDb {

    public static void newVerbalizations(LevelList list) {

        Connection con = null;
        Statement st = null;

        String url = "jdbc:postgresql://134.96.217.36:5432/benutzerverwaltung";
        String user = "benutzerverwaltung";
        String password = "D2r@!FG45%";

        try {

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            con.setAutoCommit(false);

            for(Level level : list.getList()) {
                if(level.isReady()) {
                    st.executeUpdate("UPDATE game_level SET verbalization = '" + level.getVerbalization()
                                        + "' WHERE game_level.glevel_levelID = " + level.getId());
                    System.out.println("Hallo");
                }
            }

            con.commit();

        } catch (SQLException ex) {
            System.err.println("FUCK UPLOAD " + ex);

            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex1) {

                }
            }

        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FUCK UPLOAD " + ex);
            }
        }
    }
}