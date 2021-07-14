
package Entity;

import company.Tools;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class reparation {
    public int numReparation;
    public String nomReapration;
    
    public reparation(int num,String nom){
        this.numReparation=num;
        this.nomReapration=nom; 
    }
    
    public void add(){
        
        try {
            if(db.go.runNonQuery("insert into repeff values ( "+this.numReparation+",'"+this.nomReapration+"')"))
                Tools.msg("réparation ajoutée");
            else
                Tools.msg("la réparation n'est pas ajoutée");   
        } catch (SQLException ex) {
            Logger.getLogger(reparation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
