/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.Tools;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mentionnerRep {
        public int numText;
    public int numrep;
    
    public mentionnerRep(int numtext,int numrep){
        this.numrep=numrep;
        this.numText=numtext;
    }
    
   public void add(){
        try {
            if(db.go.runNonQuery("insert into r_menrep values ( "+this.numText+","+this.numrep+")"))
                Tools.msg("La relation r_menrep est creer");
            else
                Tools.msg("La relation r_menrep n'est pas creer");
        } catch (SQLException ex) {
            Logger.getLogger(mentionnerAno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
