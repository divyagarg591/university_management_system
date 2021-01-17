
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel;
public class menudemo extends JFrame implements ActionListener,WindowListener {
 MenuBar menubar;
 JLabel back;
 Menu form,details,cntct,abt,rprt;
 MenuItem reg,detail_s,ext,sep;
    public menudemo()
    {
        super("Banasthali Vidhyapith");
         ImageIcon i=new ImageIcon("C:\\Users\\pc\\Documents\\NetBeansProjects\\awt\\src\\image\\screenshot.png");
        back=new JLabel("",i,JLabel.CENTER);
        back.setBounds(0,0,4000,4000);
        add(back);
        menubar =new MenuBar();
        setMenuBar(menubar);
      
        form=new Menu("Form");
        menubar.add(form);
        details=new Menu("Details");
        menubar.add(details);
        
        cntct=new Menu("Contact us");
        menubar.add(cntct);
        abt=new Menu("About us");
        menubar.add(abt);
        rprt=new Menu("Report");
        menubar.add(rprt);
        reg=new MenuItem("Student Form");
        detail_s=new MenuItem("Student Details");
        sep=new MenuItem("-");
        ext=new MenuItem("Exit");
        form.add(reg);
        details.add(detail_s);
        form.add(sep);
        form.add(ext);
        addWindowListener(this);
        reg.addActionListener(this);
       detail_s.addActionListener(this);
        ext.addActionListener(this);
            setSize(900,900);
         setLocation(210,130);
            setVisible(true);
            
            
    }  
    public static void main(String args[])
    {
      menudemo m=new menudemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==reg)
        {
          new Swing();
        }
        else if(o==detail_s)
        {
            new detail_std();
        }
        else if(o==ext)
        {
            System.exit(0);
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
