package awt;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JLabel;
 public class fee_strutr extends JFrame{
     JLabel back;
    fee_strutr()
     {
 super("Fee_Structure");
         ImageIcon i=new ImageIcon("C:\\Users\\pc\\Documents\\NetBeansProjects\\awt\\src\\image\\index.jpg");
        back=new JLabel("",i,JLabel.CENTER);
        back.setBounds(0,0,600,600);
        add(back);
        setSize(600,600);
         setLocation(250,100);
            setVisible(true);
}
     public static void main(String args[])
    {
      fee_strutr fs=new fee_strutr();
    }
 }
