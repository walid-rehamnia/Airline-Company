
package Entity;

import company.Tools;
import java.sql.SQLException;


public class AnomalierConstatee {
    public int num;
    public String anomalier ;
    
    public AnomalierConstatee(int nbr,String an){
        this.num=nbr;
        this.anomalier=an;  
    }
    
    public void add(){
        try {
            if(db.go.runNonQuery("insert into anocon values("+this.num+",'"+this.anomalier+"')"))
                Tools.msg("Anomalie ajoutée");
            else
                Tools.msg("Anomalie n'est pas ajoutée");
        } catch (SQLException ex) {
            Tools.msg("erreur en anom.add  "+ex.getMessage());
        }
    }
    

    
}
