package awt;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JLabel;
 public class about extends JFrame implements WindowListener {
     JLabel back;
     Label lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
     Panel p;
     Font f=new Font("serif",Font.BOLD,40);
     Font f1=new Font("serif",Font.BOLD,44);
     Font f2=new Font("serif",Font.BOLD,26);
     Font f3=new Font("serif",Font.BOLD,20);
     public about()
     {
         p=new Panel(null);
     back=new JLabel();
     back.setBounds(360,30,260,150);
     lbl1=new Label("University");
     lbl1.setForeground(Color.CYAN);
     
     lbl1.setFont(f1);
     lbl1.setBounds(90,30,210,50);
     lbl2=new Label("Management System");
     lbl2.setBounds(0,53,400,80);
     lbl2.setForeground(Color.green);
     
     lbl2.setFont(f);
     lbl3=new Label("Developed By: Divya Garg");
     
     lbl3.setForeground(Color.BLACK);
     lbl3.setFont(f2);
     lbl3.setBounds(90,185,410,40);
     lbl4=new Label("Roll Number - 1812737---");
     lbl4.setForeground(Color.BLACK);
     lbl4.setBackground(Color.ORANGE);
     lbl4.setFont(f3);
     lbl4.setBounds(90,225,410,30);
     lbl5=new Label("Contact : divyagarg591@gmail.com   ");
     lbl5.setForeground(Color.BLACK);
     lbl5.setBackground(Color.ORANGE);
     lbl5.setFont(f3);
     lbl5.setBounds(90,255,410,30);
     lbl6=new Label("Education - B.Tech.3rdYear(Computer Science)");
     lbl6.setForeground(Color.BLACK);
     lbl6.setBackground(Color.ORANGE);
     lbl6.setFont(f3);
     lbl6.setBounds(90,285,410,30);
     lbl7=new Label("Phone NO - 7740843838");
     lbl7.setForeground(Color.BLACK);
     lbl7.setBackground(Color.ORANGE);
     lbl7.setFont(f3);
     lbl7.setBounds(90,315,410,30);
     ImageIcon i=new ImageIcon("C:\\Users\\pc\\Documents\\NetBeansProjects\\awt\\src\\image\\images.jpg");
       Image img=i.getImage();
       Image newimg=img.getScaledInstance(260,150,Image.SCALE_SMOOTH);
       ImageIcon ii=new ImageIcon(newimg);
        back.setIcon(ii);
        addWindowListener(this);
        add(p);
        p.add(back);
        p.add(lbl1);
        p.add(lbl2);
        p.add(lbl3);
         p.add(lbl4);
         p.add(lbl5);
          p.add(lbl6);
          p.add(lbl7);
         
        p.setBackground(Color.white);
        setSize(650,500);
         setLocation(210,130);
         setVisible(true);

                }
     public static void main(String args[])
    {
        about ab=new about();
    }
        
     @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
         e.getWindow().dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        e.getWindow().dispose();
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
