package Entity;

import company.Tools;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class vol {
    public int numVol;
    public String vilDep, vilArr,duree;

    public vol(int num, String vdep, String varr,String duree) {
        this.numVol = num;
        this.vilDep = vdep;
        this.vilArr = varr;
        this.duree=duree;
    }
    public void add(){
        try {                   //insert into vol values(1,'annaba','alger','2011/11/11','09:00','00:45',2);
            if(db.go.runNonQuery("insert into vol values ("+this.numVol+" , '"+this.vilDep+"' , '"+this.vilArr+"', '"+this.duree+"')"))
                Tools.msg("La vol est enregistrer");
            else
                Tools.msg("Erreur lors de l'enregistrement du vol");
        } catch (SQLException ex) {
            Logger.getLogger(vol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
