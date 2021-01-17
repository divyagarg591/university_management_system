
package awt;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JLabel;
 public class first extends JFrame implements Runnable {
     JLabel back;
     Thread t;
     first()
     {
 super("Banasthali Vidhyapith");
         ImageIcon i=new ImageIcon("C:\\Users\\pc\\Documents\\NetBeansProjects\\awt\\src\\image\\WhatsApp Image 2021-01-11 at 8.57.02 AM.jpeg");
        Image img=i.getImage();
        Image newimg=img.getScaledInstance(940,620,Image.SCALE_SMOOTH);
       ImageIcon ii=new ImageIcon(newimg);
       back=new JLabel("",ii,JLabel.CENTER);
        add(back);
        t=new Thread(this);
        t.start();
        setSize(940,650);
         setLocation(180,40);
            setVisible(true);
}
     public static void main(String args[])
    {
      first f=new first();
    } 
    public void run() {
         try {
             Thread.sleep(7000);
         } catch (InterruptedException ex) {
             Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
         }
     this.setVisible(false);
     login l=new login(); 
    }
 }
