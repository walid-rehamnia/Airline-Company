
package Entity;

import company.Tools;
import java.sql.SQLException;

public class r_equi {
    public int numEmp,numVol;
    public String date;
    
    public r_equi(int emp,int vol,String date){
        this.numEmp=emp;
        this.numVol=vol;
        this.date=date;
    }
    public void add(){
        try {
           if(db.go.runNonQuery("insert into r_equi values("+this.numEmp+" , "+this.numVol+" , '"+this.date+"')"))
           Tools.msg("l'employée à été affecter au vol");
        } catch (SQLException ex) {
            Tools.msg("r_equi.add() ! :"+ex.getMessage());
        }
    }
}
