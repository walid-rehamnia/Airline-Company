
package Entity;

import company.Tools;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class r_fournit {
    public int numEsc,numVol;
    public String harresc,duresc;
    
    public r_fournit(int numV,int numE,String heure,String durée){
        this.numVol=numV;
        this.numEsc=numE;
        this.harresc=heure;
        this.duresc=durée;
    }
    
    public void add(){
        try {
            if(db.go.runNonQuery("insert into r_fournit values ("+this.numVol+" , "+this.numEsc+" , '"+this.harresc+"' , '"+this.duresc+"')"))
                Tools.msg("L'escale a été ajouté au vol");
            else
                Tools.msg("L'arrêt n'a pas été ajouté au vol");
        } catch (SQLException ex) {
            Logger.getLogger(r_fournit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
