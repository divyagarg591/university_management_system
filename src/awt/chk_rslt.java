
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
public class chk_rslt extends JFrame implements WindowListener,ActionListener {
   Label lblid;
    JLabel back;
    TextField textno;
    Button rslt;
    Font f=new Font("Arial",Font.BOLD,20); 
    public chk_rslt()
    {  
     super("RESULT CHECK");
        ImageIcon i=new ImageIcon("C:\\Users\\pc\\Documents\\NetBeansProjects\\awt\\src\\image\\image5.jpg");
        back=new JLabel("",i,JLabel.CENTER);
        back.setBounds(0,0,2000,2000);
        add(back);
        lblid=new Label("Enter Roll.NO.");
        lblid.setBounds(10,70,100,20);
        lblid.setBackground(Color.LIGHT_GRAY);
        lblid.setForeground(Color.black);  
        textno=new TextField(20);
        textno.setBounds(150,70,150,20);
        rslt=new Button("Check Result");
        rslt.setBounds(100,130, 120,30);
        rslt.setBackground(Color.black);
        rslt.setForeground(Color.white);
        rslt.addActionListener(this);
        addWindowListener(this);
        add(back);
        
        back.add(lblid);
        back.add(textno);
        back.add(rslt);
        setSize(400,500);
         setLocation(210,130);
         setVisible(true);
         
}
    public static void main(String[] args) {
       chk_rslt cr= new chk_rslt();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==rslt)
        {
            marks m=new marks(textno.getText());
        }
    }
}

