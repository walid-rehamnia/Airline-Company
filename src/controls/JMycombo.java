
package controls;

import java.awt.Graphics;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class JMycombo extends JComboBox {

    public JMycombo() {
        
        setOpaque(false);//TRansparants 
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        //g.fill3DRect(0, 0, getWidth(), getHeight(), true);
        g.fillRoundRect(0, 0,getWidth(),getHeight(),20,20);
        super.paintComponent(g);

    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getBackground());
       // g.fill3DRect(0, 0, getWidth(), getHeight(), true);
       g.drawRoundRect(0, 0,getWidth(),getHeight(),20,20);

    }

}
