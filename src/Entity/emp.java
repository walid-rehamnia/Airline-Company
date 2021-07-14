package Entity;

import company.Tools;
import java.sql.SQLException;

public class emp {

    public int num_emp;
    public String nom_emp, prenom_emp, tel_emp, adresse, date_emp, fonc_emp;
    public Double sal_emp;
    boolean navignat;

    public emp(int num, String name, String surname, String tel, String adr, String date, Double salaire, String f, boolean nav) {
        this.num_emp = num;
        this.nom_emp = name;
        this.prenom_emp = surname;
        this.tel_emp = tel;
        this.adresse = adr;
        this.date_emp = date;
        this.sal_emp = salaire;
        this.fonc_emp = f;
        this.navignat = nav;
    }
    public emp(int n){
        this.num_emp=n;   
    }

    public void add() {
        try {
            String query = "insert into emp values(" + this.num_emp + ",'" + this.nom_emp + "','" + this.prenom_emp + "','" + this.tel_emp
                    + "','" + this.adresse + "', '"+this.date_emp+"'," + this.sal_emp + ",'" + this.fonc_emp + "' , "+this.navignat+")";

            if (db.go.runNonQuery(query)) {
                Tools.msg("L'employé a été ajouté");
            }
        } catch (SQLException ex) {
            Tools.msg("error add emp");
        }
    }

    public void delete() {
        try {
            if (db.go.runNonQuery("delete from emp where numemp = " + this.num_emp)) {
                Tools.msg("L'employée a été supprimé");
            } else {
                Tools.msg("Problème lors de la suppression");
            }
        } catch (SQLException ex) {
            Tools.msg("error delete emp");
        }
    }

}
