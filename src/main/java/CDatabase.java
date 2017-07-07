import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
/**
 *
 */
public class CDatabase {

    /**
     *
     */
    public static void checkVersion() {
        System.out.println("Version:");

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String [] props = getProperties();

        try {
            con = DriverManager.getConnection(props[0], props[1], props[2]);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
            System.err.println("FEHLER VERSION");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.err.println("FEHLER CON-SCHLIEßEN VERSION");
            }
        }
    }

    /**
     *
     * @param list
     */
    public static void importLevel(CLevelList list) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String [] props = getProperties();

        try {

            con = DriverManager.getConnection(props[0], props[1], props[2]);
            pst = con.prepareStatement("SELECT * FROM game_level");
            rs = pst.executeQuery();

            int id;
            String solution;
            System.out.println("Tabelle game_level:");
            while (rs.next()) {

                //PRINTOUT DEBUG
                System.out.print(rs.getInt(1));
                System.out.print(" : ");
                System.out.print(rs.getInt(2));
                System.out.print(" : ");
                System.out.print(rs.getString(3));
                System.out.print(" : ");
                System.out.print(rs.getString(4));
                System.out.print(" : ");
                System.out.println(rs.getBoolean(5));

                //END DEBUG

                id = rs.getInt(1);
                solution = rs.getString(4);
                list.add(id , solution);
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

            } catch (SQLException ex) {
                System.err.println("FEHLER CON-SCHLIEßEN RETRIVE");
            }
        }
    }

    /**
     *
     * @param list
     */
    public static void exportLevel(CLevelList list) {

        Connection con = null;
        Statement st = null;

        String [] props = getProperties();

        try {

            con = DriverManager.getConnection(props[0], props[1], props[2]);
            st = con.createStatement();

            con.setAutoCommit(false);

            for(CLevel level : list.getList()) {
                if(level.isReady()) {
                    st.executeUpdate("UPDATE game_level SET verbalization = '" + level.getVerbalization()
                            + "', ready = TRUE WHERE game_level.levelid = " + level.getId());
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

    /**
     *
     * @return
     */
    private static String[] getProperties(){
        String [] strings = new String[3];

        Properties props = new Properties();
        FileInputStream in = null;

        try {
            in = new FileInputStream("src/main/resources/database.properties");
            props.load(in);

        } catch (IOException ex) {

            System.out.println("Properties konnten nicht ermittelt werden: " + ex);

        } finally {

            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                System.err.println("Darf nie passieren");
            }
        }

        strings[0] = props.getProperty("url");
        strings[1] = props.getProperty("user");
        strings[2] = props.getProperty("password");

        //Debug
        //System.out.println(strings[0] + " " + strings[1] + " " + strings[2]);

        return strings;
    }
}