
package Entity;

import company.Tools;
import db.go;
import static db.go.con;
import static db.go.setConnction;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class escale {
    public String vileEsc;
    
    public escale(String ve){
        this.vileEsc=ve; 
    }
    public escale(){
        
    }
    
    public void add(){
        try {
            int key = Integer.parseInt(db.go.getAutoNumber("escale", "numesc"));
            if(db.go.runNonQuery("insert into escale values ("+key+" , '"+this.vileEsc+"')"))

                Tools.msg("Escale a été ajouté");
            else
                Tools.msg("Escale n'a pas été ajouté");
                        
        } catch (SQLException ex) {
            Logger.getLogger(escale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        public static boolean checkAffectingEscale(int numv, int nume) {
        try {
            setConnction();
            Statement stmt = con.createStatement();
            stmt.executeQuery("select * from r_fournit where fouvol = " + numv + " and fouesc = " + nume);
            if (stmt.getResultSet().next()) {
                return true;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
