
package awt;
import java.awt.*;
import java .sql.*;
import java.awt.event.*;
import javax.swing.*;
public class login extends Frame implements ActionListener,WindowListener {
    Label userid,password,result,sign,wlcm,role;
    Panel p,p1;
    Choice c;
    TextField textusr,textpsw;
    Button login,reset,signup;
    Font f=new Font("Arial",Font.BOLD,14);
    Font f1=new Font("Arial",Font.CENTER_BASELINE,50);
    public login()
    {
       super("login form");
       p1=new Panel(null);
       wlcm=new Label("Welcome!!");
       wlcm.setFont(f1);
       wlcm.setBounds(65,0,300,85);
       p1.add(wlcm);
       p1.setBackground(Color.YELLOW);
       p1.setBounds(0, 0, 1277, 85);
       p1.setForeground(Color.red);
        userid=new Label("Userid");
        userid.setFont(f);
        userid.setBounds(10,100,100,20);
        userid.setBackground(Color.black);
        userid.setForeground(Color.white);
        password=new Label("Password");
        password.setFont(f);
        password.setBackground(Color.black);
        password.setForeground(Color.white);
        password.setBounds(10,140,100,20);
        role=new Label("Role");
        role.setFont(f);
        role.setBackground(Color.black);
        role.setForeground(Color.white);
        role.setBounds(10,180,100,20);
        textusr=new TextField(20);
        textusr.setBounds(175,100,150,20);
         textpsw=new TextField(20);
         textpsw.setEchoChar('*');
         textpsw.setBounds(175,140,150,20);
          c=new Choice();
          c.add("Admin");
          c.add("Student");
          c.setBounds(175,180,150,40);
         result=new Label();
         login=new Button("Login");
         login.setBackground(Color.green);
         login.setForeground(Color.black);
         login.setBounds(20,230,100,30);
         reset=new Button("Reset");
         reset.setBackground(Color.red);
         reset.setForeground(Color.white);
         reset.setBounds(150,230,100,30);
         sign=new Label("Don't have any account?");
         sign.setFont(f);
         sign.setBackground(Color.black);
         sign.setForeground(Color.white);
         sign.setBounds(10,270,230,30);
         signup=new Button("Sign up");
         signup.setBackground(Color.cyan);
         signup.setForeground(Color.black);
         signup.setBounds(260,270,100,30);
         p=new Panel(null);
         add(p);
          addWindowListener(this);
         login.addActionListener(this);
         signup.addActionListener(this);
         reset.addActionListener(this);
         p.add(p1);
         p.add(userid); p.add(textusr); 
         p.add(password); p.add(textpsw);
         p.add(role);p.add(c);
         p.add(login);    p.add(reset);
         p.add(result);p.add(sign);
         p.add(signup);
         p.setBackground(Color.black);
         setSize(400,370);
         setLocation(210,130);
         setVisible(true); 
    }
    public static void main(String args[])
    {
       login l=new login(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==login)
        {
        try{
            String s1=textusr.getText();
            String s2=textpsw.getText();
            String s3=c.getSelectedItem();
      String q="select * from loginnn where (id ='"+s1+"'and pswrd='"+s2+"')and role='"+s3+"'";
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
           PreparedStatement pdt=conn.prepareStatement(q);
           ResultSet rs=pdt.executeQuery();
           if(rs.next())
        {
          if(s3.equals("Student"))
          {
              new menudemo();
          }
          else if(s3.equals("Admin"))
          {
              new menudemo2();
          }
        }
           else
           {
             JOptionPane.showMessageDialog(null, "*invalid\nplease enter correct details");   
           }
        }catch(Exception ex){ex.printStackTrace();}
        }
       if(o==reset)
       {
          textusr.setText("");
          textpsw.setText("");
          result.setText("");
          result.setVisible(false);
          result.setBackground(Color.black);
       }
       if(o==signup)
       {
           new signup().setVisible(true);
       }
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
