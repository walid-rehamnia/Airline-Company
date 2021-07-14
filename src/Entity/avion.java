package Entity;

import company.Tools;
import db.go;
import static db.go.con;
import static db.go.setConnction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class avion {

    public int numav;
    public String typav;

    public avion(int n, String type) {
        this.numav = n;
        this.typav = type;
    }

    public avion(int n) {
        this.numav = n;
    }

    public avion() {

    }

    public void add() {
        try {
            String insert;
            insert = "insert into avion values (" + numav + ",'" + typav + "',CURDATE(),'pret','00:00')";
            Boolean b = db.go.runNonQuery(insert);
            if (b) {
                Tools.msg("L'avion a été ajouté avec succès");
            }
        } catch (SQLException ex) {

            Tools.msg("Erreur lors de l'ajout de l'avion :'" + ex.getMessage() + "'");
        }
    }

    public void delete() {
        try {
            String delete = "delete from avion where NUMAV=" + numav;
            if (db.go.runNonQuery(delete)) {
                Tools.msg("L'avion a été supprimer");
            }
        } catch (SQLException ex) {
            Tools.msg("Erreur lors de la suppressin d'avion :");
            Logger.getLogger(avion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String column, String nv) {
        try {
            if (column.equals("situation")) {
                if (go.runNonQuery("update avion set situation='" + nv + "'where numav=" + this.numav)) {
                }
            } else {
                if (db.go.runNonQuery("update avion set nbhddrev= '" + getSum2Hour(nv, db.go.getCurrentHour(this.numav)) + "' where numav=" + this.numav)) {
                    //Tools.msg("Le nombre d'heure d'avion a été maitre a jour");
                } else {
                    Tools.msg("error in : updateAvionHour : ");
                }
            }
        } catch (SQLException ex) {
            Tools.msg("avion.update() : " + ex.getMessage());
        }
    }

    public static String getSum2Hour(String nv,String cureent) {
        boolean b = false;
        String currentH =cureent;
        String hOld = "", mOld = "", hNew = "", mNew = "";
        char[] temp = currentH.toCharArray();
        int i = 0;

        while (temp[i] != ':') {
            hOld += temp[i];
            i++;
        }
        mOld += temp[++i];
        mOld += temp[++i];
        char[] temp1=nv.toCharArray();
        i = 0;
        while (temp1[i] != ':') {
            hNew += temp1[i];
            i++;
        }

        mNew += temp1[++i];
        mNew += temp1[++i];

        //now a will calculate the sum of 2 hours (hOld+hNew) and I will add 
        //also (mOld+mNew)%60 when the sum of 2 min is greater than 60
        int mn = Integer.parseInt(mNew);
        int mo = Integer.parseInt(mOld);
        
        //I was use hNew mNew for not redeclaring other not nececery variables
        
        hNew = String.valueOf(Integer.parseInt(hNew) + Integer.parseInt(hOld) + ((mo + mn) / 60));
        mNew = String.valueOf((mo + mn) % 60);
        
        //I will now reassemble in 'hNew' minutes with hours by putting between there ':'
        if (mNew.length() == 1) {
            mNew = "0" + mNew;
        }
        hNew = hNew + ":" + mNew;
        return hNew;
    }
        public static Boolean IsOnFlight(int num) {
        boolean b = false;
        try {
            db.go.setConnction();
            Statement st = db.go.con.createStatement();
            ResultSet rs = st.executeQuery("select * from avion where (situation ='enVol' and numav =" + num + ")");
            if (rs.next()) {
                b = true;
            }
            db.go.con.close();
        } catch (SQLException ex) {
            Tools.msg("Erreur dans 'IsOnFlight' : " + ex.getMessage());
        }
        return b;
    }
        
        
            public static String getArryAvion() {
        String keys = "";
        try {
            setConnction();
            Statement st = con.createStatement();
            st.executeQuery("select numav from avion");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                keys = keys + rs.getString("numav");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return keys;
    }
            
            
                public static boolean isReadyAvion(int key) {
        try {
            setConnction();
            Statement st = con.createStatement();
            st.executeQuery("select situation from avion where numav = " + key + "");
            if (st.getResultSet().next()) {
                if (st.getResultSet().getString("situation").equals("pret")) {
                    con.close();
                    return true;
                }
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
}
