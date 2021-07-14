/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author R-Walid Pro_Book
 */
public class rapport {

    public int numtxt, avionrev, numemp;
    public String datrev, nbhrev;

    public rapport(int nr, int na, int ne) {
        this.numtxt = nr;
        this.avionrev = na;
        this.numemp = ne;
        this.nbhrev = db.go.getHeureAvion(this.avionrev);
    }
     public rapport(){
         
     }

    public Boolean add() {
        try {//String nv="insert into raptxt VALUES("+this.numtxt+",current_date(),"+this.nbhrev+","+this.avionrev+" , "+this.numemp+")";
            String query = "insert into raptxt values(" + this.numtxt + ",curdate(),'" + this.nbhrev + "'," + this.avionrev + " , " + this.numemp + ")";
            if (db.go.runNonQuery(query)) {
                Tools.msg("votre rapport est enregistrer");
                return true;
            } else {
                Tools.msg("Le rapport n'a pas été enregistré");
            }
        } catch (SQLException ex) {
            Logger.getLogger(rapport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static String getDatRev(int numTxt) {
        String inf = "";
        try {
            setConnction();
            Statement stmt = con.createStatement();
            stmt.executeQuery("select datrev from raptxt where numtxt = " + numTxt);
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                inf = rs.getString("datrev");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inf;

    }

    public static String getNbhrev(int numTxt) {
        String inf = "";
        try {
            setConnction();
            Statement stmt = con.createStatement();
            stmt.executeQuery("select nbhrev from raptxt where numtxt = " + numTxt);
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                inf = rs.getString("nbhrev");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inf;
    }

}
