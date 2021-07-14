package company;


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
             form.setResizable(false); // maximize button disable
            Image img = ImageIO.read(Tools.class.getResource("images.png"));
            form.setIconImage(img);
            form.setVisible(true);
            form.setTitle("La compagnie aérienne ");
            
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

    public static Boolean ContainEmptyField(Container form) {
        controls.JTextBox txt = new controls.JTextBox(15);
        String g;
        for (Component c : form.getComponents()) {
            if (c instanceof controls.JTextBox) {
                txt = (controls.JTextBox) c;
                g=txt.getText();
                if (g.equals("")) {
                    return true;
                }
            } /*else if (c instanceof Container) {
                return ContainEmptyField((Container) c);
              */
            }
        return false;
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

    public static String getNumber(String text) {
        int n = text.length();
        String str = "";
        for (char i : text.toCharArray()) {
            if (i == '1' || i == '2' || i == '3' || i == '4' || i == '5' || i == '6' || i == '7' || i == '8' || i == '9' || i == '0') {
                str = str + i;
            }
        }
        return str;
    }

    public static String deleteNumber(String text) {
        String str = "";
        for (char i : text.toCharArray()) {
            if (i != '1' && i != '2' && i != '3' && i != '4' && i != '5' && i != '6' && i != '7' && i != '8' && i != '9' && i != '0') {
                str = str + i;
            }
        }

        return str;
    }

    public static void printScreen(String imageName) {
        try {
            Robot r = new Robot();
            Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage img = r.createScreenCapture(rec);
            ImageIO.write(img, "jpg", new File(imageName + ".jpg"));
            // rec.setSize(720,720);
        } catch (Exception ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void msg(Exception ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class Table {

        public int columns;
        public Object table[][];

        public Table(int columns) {
            this.columns = columns;
            this.table = new Object[0][columns];
        }

        public void addRow(Object row[]) {

            if (row.length > columns) {
                JOptionPane.showMessageDialog(null, "your row is over length");
                System.exit(0);
            }
            Object temp[][] = table;
            table = new Object[table.length + 1][columns];

            int i;
            int n = temp.length;
            for (i = 0; i < n; i++) {
                table[i] = temp[i];
            }

            table[n] = row;
        }

        void display() {
            for (Object i[] : table) {
                for (Object j : i) {
                    System.out.print(j + " ; ");
                }
                System.out.println();
            }
        }

        public void edit(int i, int j, Object newdata) {
            table[i][j] = newdata;
        }

        public void deleteRow(int row_index) {
            Object[][] temp = table;
            table = new Object[table.length - 1][columns];
            int n = temp.length;
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (i != row_index) {
                    table[j] = temp[i];
                    j++;
                }
            }
        }

        public Object getValue(int i, int j) {
            return table[i][j];
        }

        public Object[] getRow(int row_index) {
            return table[row_index];
        }

    }

}
