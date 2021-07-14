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

public class mentionnerOrg {
        public int numText;
    public int numorg;
    
    public mentionnerOrg(int numtext,int numorg){
        this.numorg=numorg;
        this.numText=numtext;
    }
    
    public void add(){
        try {
            if(db.go.runNonQuery("insert into r_menorg values ( "+this.numText+","+this.numorg+")"))
                Tools.msg("La relation r_menano est creer");
            else
                Tools.msg("La relation r_menano n'est pas creer");
        } catch (SQLException ex) {
            Logger.getLogger(mentionnerAno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
