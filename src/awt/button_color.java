package awt;
import java.awt.*;
import java.awt.event.*;
public class button_color extends Frame implements ActionListener,WindowListener  {
     Button green,yellow,pink;
    Panel p;
    public button_color()
    {
       green=new Button("Green");
       green.setBounds(40,50,70,30);
       green.setForeground(Color.black);
       yellow=new Button("Yellow");
       yellow.setBounds(150,50,70,30);
       yellow.setForeground(Color.black);
       pink=new Button("Pink");
       pink.setBounds(260,50,70,30);
       pink.setForeground(Color.black);
       p=new Panel();
       add(p); addWindowListener(this);
       green.addActionListener(this);
       yellow.addActionListener(this);
       pink.addActionListener(this);
       p.add(green);
       p.add(yellow);p.add(pink);
       setSize(500,500);
       setLocation(350,150);
       setVisible(true);
    }
 public static void main(String args[])
    {
        button_color b=new button_color();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==green)
        {
            
         p.setBackground(Color.green); 
        }
        else if(o==yellow)
        {
         p.setBackground(Color.yellow);   
        }
        else if(o==pink)
        {
         p.setBackground(Color.pink);   
        }
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
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
