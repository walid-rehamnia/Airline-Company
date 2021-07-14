package company;

import Entity.UpdateSystem;
import Forms.fmain;
import static db.go.updateSystem;

public class Company {

    public static void main(String[] args) {
        try {
            fmain form = new fmain();
            Tools.open_form(form);
            UpdateSystem us = new UpdateSystem();
            while (true) {
                updateSystem();
                updateSystem();
                Thread.sleep(db.go.getupdateTime());
            }

        } catch (Exception ex) {
            Tools.msg(ex);
        }

    }
}