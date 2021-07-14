
package Entity;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class organeChangee {
    public int numOrg;
    public String organe;
    
    public organeChangee(int num,String org){  
        this.numOrg=num;
        this.organe=org;
    }
    public void add(){
        try {
            db.go.runNonQuery("insert into orgcha values( "+this.numOrg+" , '"+this.organe+"')");
        } catch (SQLException ex) {
            Logger.getLogger(organeChangee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
