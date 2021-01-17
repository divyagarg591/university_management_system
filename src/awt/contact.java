
package awt;
import java.awt.*;
import java .sql.*;
import java.awt.event.*;
import javax.swing.*;
public class contact extends JFrame implements ActionListener,WindowListener {
    Label mail,topic,cntct;
    Panel p1;
    Choice c;
    TextField textml;
    JTextArea aa;
    Button submit;
    Font f1=new Font("Arial",Font.CENTER_BASELINE,50);
    Font f=new Font("Arial",Font.CENTER_BASELINE,18);
    public contact()
    {
       super("Contact Us");
       p1=new Panel(null);
       add(p1);
       cntct=new Label("Contact Us");
       cntct.setFont(f1);
       cntct.setBounds(500,0,300,85);
       p1.add(cntct);
       p1.setBackground(Color.YELLOW);
       mail=new Label("Work mail");
       mail.setBounds(10, 90, 150, 20);
       mail.setFont(f);
       textml=new TextField(30);
       textml.setBounds(175,90,170,20);
       topic=new Label("What About");
       topic.setBounds(10, 120, 150, 20);
       topic.setFont(f);
       Choice c=new Choice();
       c.setBounds(175, 120, 170, 20);
       aa=new JTextArea(4,5);
       aa.setBounds(175,150,300,80);
       submit=new Button("Submit");
       submit.setBounds(130, 260, 70, 40);
       submit.setBackground(Color.cyan);
       submit.addActionListener(this);
       addWindowListener(this);
       p1.add(mail);
       p1.add(textml);
       p1.add(topic);
       p1.add(c);
       p1.add(aa);
       p1.add(submit);
       setSize(400,400);
         setLocation(210,130);
         setVisible(true);
        
    }
    public static void main(String args[])
    {
       contact ct=new contact(); 
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
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