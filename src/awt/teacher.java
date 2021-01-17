
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
public class teacher extends JFrame implements WindowListener,ActionListener{
   Label lblid,lblname,lbladrs,gender,quali,age,dprtmnt,phno;
    JLabel back;
    TextField textno,textname,textag,textphn;
    JRadioButton c3,c4;
    Choice c,d;
    JTextArea textadrs;
    Button insert,delete,update,back1;
    public teacher()
    {
        super("Teacher entry form");
        ImageIcon i=new ImageIcon("C:\\Users\\pc\\Documents\\NetBeansProjects\\awt\\src\\image\\image5.jpg");
        back=new JLabel("",i,JLabel.CENTER);
        back.setBounds(0,0,2000,2000);
        add(back);
        lblid=new Label("Id");
        lblid.setBounds(10,50,150,20);
        lblid.setBackground(Color.LIGHT_GRAY);
        lblid.setForeground(Color.black);
        lblname=new Label("Enter the name");
        lblname.setBackground(Color.LIGHT_GRAY);
        lblname.setForeground(Color.black);
        lblname.setBounds(10,75,150,20);
        textno=new TextField(20);
        textno.setBounds(175,50,150,20);
         textname=new TextField(20);
         textname.setBounds(175,75,150,20);
         lbladrs=new Label("Enter the address");
         lbladrs.setBounds(10,100,150,20);
         lbladrs.setBackground(Color.LIGHT_GRAY);
        lbladrs.setForeground(Color.black);
         textadrs=new JTextArea(5,4);
         textadrs.setBounds(175,100,400,100); 
         quali=new Label("Qualification");
         quali.setBounds(10,205,150,20);
         quali.setBackground(Color.LIGHT_GRAY);
         quali.setForeground(Color.black);
         c=new Choice();
         c.add("B.Tech.");
         c.add("M.Tech.");
         c.add("Msc");
         c.add("Bsc.");
         c.add("mca");
         c.setBounds(175,205,150,20);
         age=new Label("Age");
        age.setBounds(10,230,150,20);
        age.setBackground(Color.LIGHT_GRAY);
        age.setForeground(Color.black);
        textag=new TextField(20);
        textag.setBounds(175,230,150,20);
         dprtmnt=new Label("Department");
         dprtmnt.setBounds(10,255,150,20);
         dprtmnt.setBackground(Color.LIGHT_GRAY);
         dprtmnt.setForeground(Color.black);
         d=new Choice();
         d.add("Computer Science");
         d.add("Physics");
         d.add("Mathematics");
         d.add("Chemistry and Bichemistry");
         d.add("Sociology");
         d.setBounds(175,255,150,20);
         gender=new Label("Gender");
         gender.setBackground(Color.LIGHT_GRAY);
         gender.setForeground(Color.black);
         gender.setBounds(10,280,150,20);
         c3=new JRadioButton("Male",false);
         c3.setBounds(175,280,150,20);
         c4=new JRadioButton("Female",false);
         c4.setBounds(350,280,150,20);
         phno=new Label("Phone no.");
        phno.setBounds(10,305,150,20);
        phno.setBackground(Color.LIGHT_GRAY);
        phno.setForeground(Color.black);
        textphn=new TextField(20);
        textphn.setBounds(175,305,150,20);
         insert=new Button("Insert");
         insert.setBackground(Color.LIGHT_GRAY);
        insert.setForeground(Color.black);
         insert.setBounds(175,350,100,30);
         delete=new Button("Delete");
         delete.setBackground(Color.LIGHT_GRAY);
          delete.setForeground(Color.black);
         delete.setBounds(350,350,100,30);
         update=new Button("Update");
         update.setBackground(Color.LIGHT_GRAY);
        update.setForeground(Color.black);
         update.setBounds(525,350,110,30);
         back1=new Button("Back->");
         back1.setBackground(Color.LIGHT_GRAY);
        back1.setForeground(Color.black);
         back1.setBounds(700,350,110,30);
         addWindowListener(this);
         insert.addActionListener(this);
         delete.addActionListener(this);
         update.addActionListener(this);
         back1.addActionListener(this);
         back.add(lblid); back.add(textno); 
         back.add(lblname); back.add(textname);
         back.add(lbladrs);back.add(textadrs);
         back.add(quali); back.add(c);
         back.add(age); back.add(textag);
         back.add(dprtmnt);back.add(d);
         back.add(gender);
         back.add(c3);
         back.add(c4);back.add(phno);
         back.add(textphn);
         back.add(insert);
         back.add(delete);back.add(update);
         back.add(back1);
         setSize(900,900);
         setLocation(210,130);
         setVisible(true);
    }
    public static void main(String[] args) {
       teacher t= new teacher();
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
        
        if(o==insert)
        {
            try{
           String sname=textname.getText();
           String addrs= textadrs.getText();
           String quli=c.getSelectedItem();
           int ag=Integer.parseInt((String)textag.getText());
           String dp=d.getSelectedItem();
           String gndr="";
           if(c3.isSelected())
               gndr=c3.getText();
           else if(c4.isSelected())
               gndr=c4.getText();
           int phn=Integer.parseInt((String)textphn.getText());
           String query="insert into teacher(name,address,qulification,age,department,gender,phone) values(?,?,?,?,?,?,?)";
           Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement(query);
        pdt.setString(1,sname);
        pdt.setString(2,addrs);
        pdt.setString(3,quli);
        pdt.setInt(4,ag);
        pdt.setString(5,dp);
        pdt.setString(6,gndr);
        pdt.setInt(7,phn);
        int i=pdt.executeUpdate();
        if(i>0)
        {
           
            JOptionPane.showMessageDialog(null, "insert successfully");
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Error...............");
        }
        conn.close();
        }catch(Exception ex){ex.printStackTrace();}
       }
        else if(o==delete)
        {
            try{
        int idd=Integer.parseInt(textno.getText());
        String query="delete from teacher where id=?";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement(query); 
        pdt.setInt(1,idd);
        int i=pdt.executeUpdate();
        if(i>0)
        {
           JOptionPane.showMessageDialog(null, "delete successfully");
           
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error...............");
        }
        conn.close();
    }catch(Exception ex){ex.printStackTrace();} 
        } 
        else if(o==update)
        {
            try
        {
           int no=Integer.parseInt(textno.getText());
           String sname=textname.getText();
           String query="update teacher set name=? where id=?";
           Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement(query);
        pdt.setString(1,sname);
        pdt.setInt(2,no);
        int i=pdt.executeUpdate();
        if(i>0)
        {JOptionPane.showMessageDialog(null, "update successfully");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error...............");
        }
        conn.close();
    }catch(Exception ex){ex.printStackTrace();}
        }
        else if(o==back1)
        {
            new menudemo2().setVisible(true);
        }
     } 
}
