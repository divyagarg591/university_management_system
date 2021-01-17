
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
public class signup extends Frame implements ActionListener,WindowListener {
    Label userid,cnfrm_ps,password,sin,role;
    Panel p,p1;
    Choice c;
    TextField textid,textpsw,text_ps;
    Button signup,back;
    Font f=new Font("Arial",Font.PLAIN,14);
     Font f1=new Font("Arial",Font.CENTER_BASELINE,50);
    public signup()
    {
       super("signup form");
        p1=new Panel(null);
       sin=new Label("Sign up!!");
       sin.setFont(f1);
       sin.setBounds(65,0,300,85);
       p1.add(sin);
       p1.setBackground(Color.YELLOW);
       p1.setBounds(0, 0, 1277, 85);
       p1.setForeground(Color.red);
        userid=new Label(" Create Userid");
        userid.setFont(f);
        userid.setBounds(10,100,150,20);
        userid.setBackground(Color.black);
        userid.setForeground(Color.white);
        password=new Label("Create Password");
        password.setFont(f);
        password.setBackground(Color.black);
        password.setForeground(Color.white);
        password.setBounds(10,140,150,20);
        cnfrm_ps=new Label("Confirm Password");
        cnfrm_ps.setFont(f);
        cnfrm_ps.setBackground(Color.black);
        cnfrm_ps.setForeground(Color.white);
        cnfrm_ps.setBounds(10,180,150,20);
        role=new Label("Role");
        role.setFont(f);
        role.setBounds(10,220,150,20);
        role.setBackground(Color.black);
        role.setForeground(Color.white);
        textid=new TextField(30);
        textid.setBounds(175,100,150,20);
         textpsw=new TextField(20);
         textpsw.setEchoChar('*');
         textpsw.setBounds(175,140,150,20);
         text_ps=new TextField(20);
         text_ps.setEchoChar('*');
         text_ps.setBounds(175,180,150,20);
         c=new Choice();
         c.add("Student");
         c.add("Admin");
        c.setBounds(175,220,150,20);
         signup=new Button("signup");
         signup.setBackground(Color.cyan);
         signup.setForeground(Color.black);
         signup.setBounds(40,260,100,40);
         back=new Button("Back->");
         back.setBackground(Color.LIGHT_GRAY);
         back.setForeground(Color.black);
         back.setBounds(170,260,100,40);
         p=new Panel(null);
         add(p);p.add(p1);
          addWindowListener(this);
         signup.addActionListener(this);
         back.addActionListener(this);
         p.add(userid); p.add(textid); 
         p.add(password); p.add(textpsw);
         p.add(cnfrm_ps); p.add(text_ps);
         p.add(role);p.add(c);
         p.add(signup);p.add(back);
         p.setBackground(Color.black);
         setSize(400,370);
         setLocation(210,130);
         setVisible(true); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==signup)
        {
        try{
           String s1=textid.getText();
           String s2=textpsw.getText();
           String s3=text_ps.getText();
           String s4=c.getSelectedItem();
           String q="select * from loginnn where id ='"+s1+"'";
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
           PreparedStatement pdt=conn.prepareStatement(q);
           ResultSet rs=pdt.executeQuery();
           if(rs.next())
        {
          JOptionPane.showMessageDialog(null, "*This id is already exist");    
        }
           else if(!s2.equals(s3))
           {
             JOptionPane.showMessageDialog(null, "*Please confirm the passwaord");   
           }
           else
           {
               String query="insert into loginnn values(?,?,?)";
              pdt=conn.prepareStatement(query);     
        pdt.setString(1,s1);
        pdt.setString(2,s2);
        pdt.setString(3,s4);
        int i=pdt.executeUpdate();
        if(i>0)
        {
         JOptionPane.showMessageDialog(null, "*Sign up successfully");       
        }
        else
        {
         JOptionPane.showMessageDialog(null, "*Error in sign up");    
        }
           }
        }catch(Exception ex){ex.printStackTrace();}
        }
        if(o==back)
        {
            new login().setVisible(true);
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
    public static void main(String args[])
    {
     signup s=new signup();   
}
}

