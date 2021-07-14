
package controls;

import java.awt.Graphics;
import javax.swing.JPasswordField;

public class JPasswordBox extends JPasswordField {

    public JPasswordBox(int size) {
        super(size);
        setOpaque(false);//TRansparant   
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
