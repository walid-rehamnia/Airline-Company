
import java.awt.AWTException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tools {

    public static void msg(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    public static void createFolder(String folder_name, String path) {
        File f = new File(path + "/" + folder_name);
        f.mkdir();
    }

    public static void open_form(JFrame form) {
        form.setLocationRelativeTo(null);
        try {
            Image img = ImageIO.read(Tools.class.getResource("Tulips.jpg"));
            form.setIconImage(img);
            form.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void clearText(Container form) {
        JTextField txt = new JTextField();
        for (Component c : form.getComponents()) {
            if (c instanceof JTextField) {
                txt = (JTextField) c;
                txt.setText("");
            } else if (c instanceof Container) {
                clearText((Container) c);
            }
        }
    }

    public static void createEmptyFile(String file_name) {
        try {
            File f = new File(file_name);
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createFile(String file_name, Object data[]) {

        PrintWriter f = null;
        try {
            f = new PrintWriter(file_name);
            for (Object o : data) {
                f.println(o);
            }
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            f.close();
        }

    }

    public static Object InputBox(String title) {
        Object obj = JOptionPane.showInputDialog(title);
        return obj;
    }

    public static String getNumber(String text) {
        int n=text.length();
        String str="";
        for(char i:text.toCharArray())
            if(i=='1'||i=='2'||i=='3'||i=='4'||i=='5'||i=='6'||i=='7'||i=='8'||i=='9'||i=='0')
               str=str+i;
        return str;
    }
    
    
    public static String deleteNumber(String text){
        String str="";
        for(char i :text.toCharArray())
            if(i!='1'&&i!='2'&&i!='3'&&i!='4'&&i!='5'&&i!='6'&&i!='7'&&i!='8'&&i!='9'&&i!='0')
                str=str+i;
       
        return str;
    }
    
    
    public static void printScreen(String imageName){
        try {
            Robot r = new Robot();
            Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage img = r.createScreenCapture(rec);
            ImageIO.write(img,"jpg",new File(imageName+".jpg"));
           // rec.setSize(720,720);
        } catch (Exception ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

}
