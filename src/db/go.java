package db;

import Entity.AnomalierConstatee;
import Entity.avion;
import Entity.organeChangee;
import Entity.reparation;
import company.Tools;
import company.Tools.Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class go {

    private static String url = "";
    public static Connection con;

    private static void setURL() {
        url = "jdbc:mysql://localhost:3306/company";
    }

    public static void setConnction() {

        try {
            setURL();
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            Tools.msg("1" + ex.getMessage());
        }
    }

    public static Boolean runNonQuery(String sqlStatement) throws SQLException {

        try {
            setConnction();

            Statement stmt = con.createStatement();
            stmt.execute(sqlStatement);
            con.close();
            return true;
        } catch (SQLException ex) {
            Tools.msg(ex.getMessage());
            con.close();
            return false;
        }
    }

    public static String getAutoNumber(String tableName, String columnName) {

        try {
            setConnction();
            Statement st = con.createStatement();
            String query = "select max(" + columnName + ")+1 as 'nbr' from " + tableName;
            st.execute(query);
            String n = "";
            while (st.getResultSet().next()) {
                n = st.getResultSet().getString("nbr");
            }
            con.close();
            if (n == null || "".equals(n)) {
                return "1";
            } else {
                return n;
            }
        } catch (SQLException ex) {
            Tools.msg("erreur en getAutoNumber" + ex.getMessage());
            return "0";
        }
    }

    public static Table getTable(String query) {
        Tools t = new Tools();
        try {
            setConnction();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();
            Table table = t.new Table(c);
            while (rs.next()) {
                Object[] row = new Object[c];
                for (int i = 0; i < c; i++) {
                    row[i] = rs.getString(i + 1);
                }
                table.addRow(row);
            }
            con.close();
            return table;
        } catch (SQLException ex) {
            Tools.msg(ex.getMessage());
            return t.new Table(0);
        }
    }

    public static void fillToJTable(String query, JTable table, Boolean clearFirst) {

        try {

            setConnction();
            Statement st = con.createStatement();
            ResultSet rs;
            /*Tools.msg("dedededemdldlml");
             text=text.toLowerCase();
             if ("select ".equals(text.substring(0,7))) {
             select = text;
             } else {
             select = "select * from " + text;
             }
             Tools.msg(select);*/
            rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int c = rsmd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setColumnCount(c);
            if (clearFirst) {
                model.setRowCount(0);
            }

            Vector row = new Vector();
            while (rs.next()) {
                row = new Vector(c);
                for (int i = 1; i <= c; i++) //  row.add(i)=rs.getString(i+1);
                {

                    row.add(rs.getString(i));

                }
                model.addRow(row);
            }
            if (table.getColumnCount() != c) {
                Tools.msg("\n\tmodel.getColumnCount()!=c");
            }
            con.close();
        } catch (SQLException ex) {
            Tools.msg(ex.getMessage());
        }
    }

    public static Boolean checkExistenceOf(String tableName, String keyName, int n) {
        try {
            setConnction();
            Statement stmt;
            stmt = con.createStatement();
            String query = "select *from " + tableName + " where " + keyName + " = " + n;
            stmt.executeQuery(query);
            while (stmt.getResultSet().next()) {
                con.close();
                return true;
            }
            con.close();
        } catch (SQLException ex) {
            Tools.msg("check exestence of dit : \n" + ex.getMessage());
        }
        return false;

    }

    public static Boolean checkExistenceOf(String tableName, String keyName, String n) {
        boolean b = false;
        try {
            setConnction();
            Statement stmt;
            stmt = con.createStatement();
            String query = "select * from " + tableName + " where " + keyName + " = '" + n + "'";
            stmt.executeQuery(query);
            while (stmt.getResultSet().next()) {
                b = true;
            }
            con.close();
        } catch (SQLException ex) {
            Tools.msg("check exestence of c_a_d: \n" + ex.getMessage());
        }
        return b;

    }

    public static int saveData(String tableName, String keyColumn, String dataColumn, String text) {
        int key = 0;
        try {
            setConnction();
            Statement st = con.createStatement();

            st.executeQuery("select " + keyColumn + " from " + tableName + " where " + dataColumn + " = '" + text + "'");

            ResultSet rs = st.getResultSet();
            if (rs.next()) { //c_a_d l'information est déjàs stocker donc il suffit de prendre leur key ;
                key = Integer.parseInt(rs.getString(1));
            } else//Je vais creer entierement
            {
                key = Integer.parseInt(db.go.getAutoNumber(tableName, keyColumn));
                if (tableName.equals("anocon")) {
                    AnomalierConstatee ac = new AnomalierConstatee(key, text);
                    ac.add();
                } else if (tableName.equals("repeff")) {
                    reparation r = new reparation(key, text);
                    r.add();
                } else {
                    organeChangee orgcha = new organeChangee(key, text);
                    orgcha.add();
                }
            }

        } catch (SQLException ex) {
            Tools.msg("erreur sur saveData()\n" + ex.getMessage());
        }

        return key;
    }

    public static String setAvionRev(int numTxt) {
        String inf = "";
        try {
            setConnction();
            Statement stmt = con.createStatement();
            stmt.executeQuery("select avionrev from raptxt where numtxt = " + numTxt);
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                inf = rs.getString("avionrev");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inf;

    }

    public static void updateSystem() {
        try {
            //Update avions
            char[] item = avion.getArryAvion().toCharArray();
            ///Set pret after enVol
            /*
             db.go.runNonQuery("update avion set situation = 'pret' where numav in (select est_affecter from r_prog where("
             + "((addtime(hdep,(select durvol from vol where numvol = progvol))<='23:59:59') and ((addtime(hdep,(select durvol from vol where numvol = progvol)))<=current_time()))"
             + "or"
             + "((addtime(hdep,(select durvol from vol where numvol = progvol))>'23:59:59') and (datediff(CURRENT_DATE(),progjour)>=1) and current_time()>(timediff(addtime(hdep,(select durvol from vol where numvol = progvol)),'24:00:00')) )"
             + ") )");
             */
            db.go.runNonQuery("update avion set situation = 'pret' where numav not in (select est_affecter from r_prog where("
                    // + "((addtime(hdep,(select durvol from vol where numvol = progvol))<='23:59:59') and (current_time() between hdep and (addtime(hdep,(select durvol from vol where numvol = progvol)))))"//Bset choice
                    + "((addtime(hdep,(select durvol from vol where numvol = progvol))<='23:59:59') and (current_time() <= (addtime(hdep,(select durvol from vol where numvol = progvol)))))"//temporary choice   
                    + "or"
                    + "((addtime(hdep,(select durvol from vol where numvol = progvol))>'23:59:59') and (datediff(CURRENT_DATE(),progjour)=1) and ((current_time() between hdep and '23:59:59')or(current_time() between '00:00:00' and (subtime(addtime(hdep,(select durvol from vol where numvol = progvol)), '24:00:00'))))) ))");
            ///Revision:
            db.go.runNonQuery("update avion set situation = 'necessiteRevision' where numav in (select numav from avion where length(avion.nbhddrev)>=7)");
            for (char i : item) {
                db.go.runNonQuery("update avion set situation = 'necessiteRevision' where numav in (select AVIONREV from raptxt where datediff(CURRENT_DATE(),(select max(datrev) from raptxt where avionrev = " + i + "))>=182)");
            }

            db.go.runNonQuery("update avion set situation = 'necessiteRevision' where datediff(CURRENT_DATE(),datms)>=182 and numav not in(select avionrev from raptxt)");
            /// mettre a jour les donnes d'avion en cas d'une vol a affecter:
            String type, jour, durée = "";
            int numAvion = 0, numVol;
            setConnction();
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            ResultSet rs1, rs2;
            st.executeQuery("select progvol,progjour,progtype from r_prog where est_affecter= -1 and datediff(current_date(),progjour)>=0 order by progjour");
            rs1 = st.getResultSet();
            while (rs1.next()) {
                type = rs1.getString("progtype");
                jour = rs1.getString("progjour");
                numVol = rs1.getInt("progvol");

                //Query to get the 'duree' variable
                st2.executeQuery("select durvol from vol where numvol= " + numVol);
                rs2 = st2.getResultSet();
                if (rs2.next()) {
                    durée = rs2.getString("durvol");
                }
                ///To get the key of avion respect caractiristic and update it(I start with type to optimise the table lenght)

                st2.executeQuery("select numav from avion where typav='" + type + "' and situation ='pret' limit 1");
                rs2 = st2.getResultSet();
                //numAvion=rs2.getInt("numav");
                if (rs2.next()) {
                    numAvion = Integer.parseInt(rs2.getString("numav"));
                }
                avion av = new avion(numAvion);
                if (db.go.checkExistenceOf("avion", "numav", numAvion)) {

                    av.update("situation", "enVol");

                    av.update("nbhddrev", durée);
                    //la mise a jour maintenant de est affecterù update r_prog set est_affecter = 3 where ( progvol=1 and progjour= "2020/03/06")

                    runNonQuery("update r_prog set est_affecter = " + numAvion + " where ( progvol=" + numVol + " and progjour= '" + jour + "')");
                }

            }
            con.close();
        } catch (Exception ex) {
            Tools.msg("updateSystem()! :" + ex.getMessage());
        }

    }

    public static String NBTHV(int numEmp) {
        String time = "00:00", durée = "";
        int numVol = 0;
        try {
            ResultSet rs1, rs2;
            setConnction();
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            stmt1.executeQuery("select equvol from r_equi where equempv = " + numEmp);
            rs1 = stmt1.getResultSet();
            while (rs1.next()) {
                numVol = rs1.getInt("equvol");
                stmt2.executeQuery("select durvol from vol where numvol = " + numVol);
                rs2 = stmt2.getResultSet();
                if (rs2.next()) {
                    durée = rs2.getString("durvol");
                }
                time = avion.getSum2Hour(durée, time);//put the Sum of two hour in time ;

            }
            con.close();

        } catch (SQLException ex) {
            Tools.msg("Erreur en NBTHV()  ! :" + ex.getMessage());
        }
        return time;
    }

    public static String NBMHV(int numEmp) {
        String time = "00:00", durée = "";
        int numVol = 0;
        try {
            ResultSet rs1, rs2;
            setConnction();
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            stmt1.executeQuery("select equvol from r_equi where equempv = " + numEmp + " and (year(equdate)=year(current_date())) and ( month(equdate)=month(current_date()) )");
            rs1 = stmt1.getResultSet();
            while (rs1.next()) {
                numVol = rs1.getInt("equvol");
                stmt2.executeQuery("select durvol from vol where numvol = " + numVol);
                rs2 = stmt2.getResultSet();
                if (rs2.next()) {
                    durée = rs2.getString("durvol");
                }
                time = avion.getSum2Hour(durée, time);//put the Sum of two hour in time ;

            }
            con.close();

        } catch (SQLException ex) {
            Tools.msg("Erreur en NBTHV()  ! :" + ex.getMessage());
        }
        return time;
    }

    public static String getCurrentHour(int key) {
        String h = "";
        try {
            setConnction();
            Statement stmt = con.createStatement();
            stmt.executeQuery("select nbhddrev from avion where numav=" + key);
            if (stmt.getResultSet().next()) {
                h = stmt.getResultSet().getString("nbhddrev");
            }
            con.close();
        } catch (SQLException ex) {
            Tools.msg("getCurrentHour(int key) : " + ex.getMessage());
        }
        return h;
    }

    //Je suis sur dans cette methode que l'avioon est existe
    public static String getHeureAvion(int numav) {
        String heure = "";
        try {
            setConnction();
            Statement st = con.createStatement();
            st.executeQuery("select nbhddrev from avion where numav=" + numav);
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                heure = rs.getString("nbhddrev");
            }
            con.close();
        } catch (SQLException ex) {
            Tools.msg("getHeureAvion : \n" + ex.getMessage());
        }
        return heure;
    }

    public static long getupdateTime() {
        long x = 1800000;
        try {
            setConnction();
            Statement st = con.createStatement();
            st.executeQuery("select updateTime from info");
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                x = rs.getLong("updateTime");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public static int getSelected() {
        int x = 3;
        try {
            setConnction();
            Statement st = con.createStatement();
            st.executeQuery("select selected from up");
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                x = rs.getInt("selected");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Tools.msg(x);
        return x;
    }
    
public static int getRowNumber(String tableName){
    int count=0;
        try {
            setConnction();
            Statement st = con.createStatement();
            st.executeQuery("SELECT COUNT(*) FROM "+tableName);
            ResultSet rs = st.getResultSet();
            if(rs.next())
                count=rs.getInt("count(*)");
            con.close();
                
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
}
}
