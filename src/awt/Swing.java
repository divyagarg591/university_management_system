
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
public class Swing extends JFrame implements WindowListener,ActionListener,ItemListener {
    Label lblrno,lblname,lbladrs,gender,quali,lang;
    JLabel back;
    String s1="",s2="";
    TextField textno,textname;
    JCheckBox c1,c2;
    JRadioButton c3,c4;
    Choice c;
    TextArea textadrs;
    Button insert,delete,update,back1;
    
    public Swing()
    {
        super("student entry form");
        ImageIcon i=new ImageIcon("C:\\Users\\pc\\Documents\\NetBeansProjects\\awt\\src\\image\\image5.jpg");
        back=new JLabel("",i,JLabel.CENTER);
        back.setBounds(0,0,2000,2000);
        add(back);
        lblrno=new Label("Enter the roll no");
        lblrno.setBounds(10,50,150,20);
        lblrno.setBackground(Color.LIGHT_GRAY);
        lblrno.setForeground(Color.black);
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
         textadrs=new TextArea(5,4);
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
         lang=new Label("Language");
         lang.setBounds(10,230,150,20);
         lang.setBackground(Color.LIGHT_GRAY);
         lang.setForeground(Color.black);
         c1=new JCheckBox("Java");
         c1.setBounds(175,230,150,20);
         c2=new JCheckBox("C++");
         c2.setBounds(175,250,150,20);
         gender=new Label("Gender");
         gender.setBackground(Color.LIGHT_GRAY);
         gender.setForeground(Color.black);
         gender.setBounds(10,275,150,20);
         
         c3=new JRadioButton("Male",false);
         c3.setBounds(175,275,150,20);
         c4=new JRadioButton("Female",true);
         c4.setBounds(350,275,150,20);
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
         c1.addItemListener(this);
         c2.addItemListener(this);
         back.add(lblrno); back.add(textno); 
         back.add(lblname); back.add(textname);
         back.add(lbladrs);back.add(textadrs);
         back.add(quali); back.add(c);
         back.add(lang); back.add(c1); 
         back.add(c2);back.add(gender);
         back.add(c3);
         back.add(c4); back.add(insert);
         back.add(delete);back.add(update);
         back.add(back1);
         setSize(900,900);
         setLocation(210,130);
         setVisible(true);
    }
public static void main(String[] args) {
       Swing s= new Swing();
       
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
            try
        {
           int roll=Integer.parseInt(textno.getText());
           String sname=textname.getText();
           String add=textadrs.getText();
           String quli=c.getSelectedItem();
           String langgg=s1;
           String gndr="";
           if(c3.isSelected())
               gndr=c3.getText();
           else if(c4.isSelected())
               gndr=c4.getText();
           String query="insert into student values(?,?,?,?,?,?)";
           Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement(query);
        pdt.setInt(1,roll);
        pdt.setString(2,sname);
        pdt.setString(3,add);
        pdt.setString(4,quli);
        pdt.setString(5,langgg);
        pdt.setString(6,gndr);
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
        int rlno=Integer.parseInt(textno.getText());
        String query="delete from student where rollno=?";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement(query); 
        pdt.setInt(1,rlno);
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
           int rno=Integer.parseInt(textno.getText());
           String sname=textname.getText();
           String query="update student set name=? where rollno=?";
           Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement(query);
        pdt.setString(1,sname);
        pdt.setInt(2,rno);
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
            new menudemo().setVisible(true);
        }
     }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object o=e.getSource();
        if(o==c1)
        {
          if(e.getStateChange()==1)
          {
              s1=(String)c1.getText();
          }
        }
          else if(o==c2)
          {
            if(e.getStateChange()==1)
            {
              s1=(String)c2.getText();
            }
        }
        
    }
    
}
   
