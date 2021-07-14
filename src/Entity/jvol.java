
package Entity;

import company.Tools;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class jvol {
    public String date ;
    public jvol(String day){
        this.date=day;    
    }
    public void add(){
        try {//insert into jvol values('"+this.date+"') where '"+this.date+"' >= current_date()
                db.go.runNonQuery("insert into jvol values('"+this.date+"')");
        } catch (SQLException ex) {
            Tools.msg("Erreur lors de la creation du jour du vol \nex :"+ex.getMessage());
        }
    }
}
