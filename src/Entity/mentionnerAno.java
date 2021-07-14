
package Entity;

import company.Tools;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mentionnerAno {
    public int numText;
    public int numAno;
    
    public mentionnerAno(int numtext,int numano){
        this.numAno=numano;
        this.numText=numtext;
    }
    
    public void add(){
        try {
            if(db.go.runNonQuery("insert into r_menano values ( "+this.numText+","+this.numAno+")"))
                Tools.msg("La relation r_menano est creer");
            else
                Tools.msg("La relation r_menano n'est pas creer");
        } catch (SQLException ex) {
            Logger.getLogger(mentionnerAno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
