
package Entity;

import company.Tools;
import db.go;
import static db.go.con;
import static db.go.setConnction;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class r_prog {
    public int provol;
    public String date,hdep,typeAvion;
    
    public r_prog(int n_vol,String date,String hdep,String type_avion){
        this.provol=n_vol;
        this.date = date ;
        this.typeAvion=type_avion;
        this.hdep=hdep;
    } 
    public r_prog(){
        
    }
    public void add(){
        try {
            if(db.go.runNonQuery("insert into r_prog values("+this.provol+" , '"+this.date+"', '"+this.hdep+"' , '"+this.typeAvion+"', -1)"))
                    
                Tools.msg(" oui programmée ");
            else
                Tools.msg("N'est pas programmée");
                    
        } catch (SQLException ex) {
            Logger.getLogger(r_prog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
        public static Boolean is_used_day(int numVol, String day) {
        boolean b = false;
        try {

            setConnction();
            Statement st = con.createStatement();
            st.executeQuery("select * from r_prog where progvol=" + numVol + " and progjour = '" + day + "'");
            if (st.getResultSet().next()) {
                b = true;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
}
