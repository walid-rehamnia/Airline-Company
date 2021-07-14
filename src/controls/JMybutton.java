
package controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JTextField;

public class JMybutton extends JButton {

    public JMybutton() {
       
        setOpaque(false);//TRansparant   
        setContentAreaFilled(false);//
        setForeground(Color.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));//To design a hand when you select
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(70,130,180));
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
