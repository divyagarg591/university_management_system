
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
public class marks extends JFrame implements WindowListener{ 
    Label lblcls,lblrol,lbl,lblsub,lblmark,lblmrk1,lblmrk2,lblmrk3,lblmrk4,lblmrk5,lblsb1,lblsb2,lblsb3,lblsb4,lblsb5,obtnd,totl;
    //Button submit;
    Panel p;
    Font f=new Font("Arial",Font.BOLD,20);
    
    public marks(String str)
    {  
        
        p=new Panel(null);
        lbl=new Label("   Result Of Examination");
        lbl.setFont(f);
        lbl.setBounds(60,10,250,30);
        lbl.setBackground(Color.white); 
        lbl.setForeground(Color.black);
        lblrol=new Label();
        lblrol.setBounds(0,60,150,30);
        lblrol.setBackground(Color.yellow); 
        lblrol.setForeground(Color.black);
        lblcls=new Label();
        lblcls.setBounds(200,60,150,30);
        lblcls.setBackground(Color.yellow); 
        lblcls.setForeground(Color.black);
        lblsub=new Label("Subjects:");
        lblsub.setBounds(0,120,150,30);
        lblsub.setBackground(Color.yellow); 
        lblsub.setForeground(Color.black);
        lblmark=new Label("Marks:");
        lblmark.setBounds(200,120,150,30);
        lblmark.setBackground(Color.yellow); 
        lblmark.setForeground(Color.black);
        lblsb1=new Label();
        lblsb1.setBounds(0,150,150,30);
        lblsb1.setBackground(Color.yellow); 
        lblsb1.setForeground(Color.black);
        lblsb2=new Label();
        lblsb2.setBounds(0,180,150,30);
        lblsb2.setBackground(Color.yellow); 
        lblsb2.setForeground(Color.black);
        lblsb3=new Label();
        lblsb3.setBounds(0,210,150,30);
        lblsb3.setBackground(Color.yellow); 
        lblsb3.setForeground(Color.black);
        lblsb4=new Label();
        lblsb4.setBounds(0,240,150,30);
        lblsb4.setBackground(Color.yellow); 
        lblsb4.setForeground(Color.black);
        lblsb5=new Label();
        lblsb5.setBounds(0,270,150,30);
        lblsb5.setBackground(Color.yellow); 
        lblsb5.setForeground(Color.black);
        lblmrk1=new Label();
        lblmrk1.setBounds(200,150,150,30);
        lblmrk1.setBackground(Color.yellow); 
        lblmrk1.setForeground(Color.black);
        lblmrk2=new Label();
        lblmrk2.setBounds(200,180,150,30);
        lblmrk2.setBackground(Color.yellow); 
        lblmrk2.setForeground(Color.black);
       lblmrk3=new Label();
        lblmrk3.setBounds(200,210,150,30);
        lblmrk3.setBackground(Color.yellow); 
        lblmrk3.setForeground(Color.black);
        lblmrk4=new Label();
        lblmrk4.setBounds(200,240,150,30);
        lblmrk4.setBackground(Color.yellow); 
        lblmrk4.setForeground(Color.black);
        lblmrk5=new Label();
        lblmrk5.setBounds(200,270,150,30);
        lblmrk5.setBackground(Color.yellow); 
        lblmrk5.setForeground(Color.black);
        totl=new Label("TOTAL->500");
        totl.setBounds(0,310,100,20);
        totl.setBackground(Color.yellow); 
        totl.setForeground(Color.black);
        obtnd=new Label();
        obtnd.setBounds(0,330,100,20);
        obtnd.setBackground(Color.yellow); 
        obtnd.setForeground(Color.black);
        
       
         try
        {
            
              Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        int st=Integer.parseInt(str);
          String q="select * from exam  where rollno=?";
        PreparedStatement pdt=conn.prepareStatement(q);
        pdt.setInt(1,st);
        ResultSet rs=pdt.executeQuery();
        if(rs.next())
        {
        String s1="RollNo.->"+String.valueOf(rs.getInt("rollno"));
           lblrol.setText(s1);
        String s2=rs.getString("class");
        lblcls.setText(s2);
        String s3=rs.getString("sub1");
        lblsb1.setText(s3);
        String s4=rs.getString("sub2");
        lblsb2.setText(s4);
        String s5=rs.getString("sub3");
        lblsb3.setText(s5);
        String s6=rs.getString("sub4");
        lblsb4.setText(s6);
        String s7=rs.getString("sub5");
        lblsb5.setText(s7);
         String s8=String.valueOf(rs.getInt("mrk1"));
           lblmrk1.setText(s8);
           String s9=String.valueOf(rs.getInt("mrk2"));
           lblmrk2.setText(s9);
           String s10=String.valueOf(rs.getInt("mrk3"));
           lblmrk3.setText(s10);
           String s11=String.valueOf(rs.getInt("mrk4"));
           lblmrk4.setText(s11);
           String s12=String.valueOf(rs.getInt("mrk5"));
           lblmrk5.setText(s12);
           String s13="OBTAINED->"+String.valueOf(rs.getInt("obtnd"));
      
           obtnd.setText(s13);
           add(p);
        p.add(lbl);
        p.add(lblrol);
        p.add(lblcls);
        p.add(lblsub);
        p.add(lblmark);
        p.add(lblsb1);p.add(lblsb2);p.add(lblsb3);p.add(lblsb4);p.add(lblsb5);
        p.add(lblmrk1);p.add(lblmrk2);p.add(lblmrk3);p.add(lblmrk4);p.add(lblmrk5);
        p.add(totl);p.add(obtnd);
         setSize(400,400);
         setLocation(210,130);
         setVisible(true);
           
        }
        else
        {
             JOptionPane.showMessageDialog(null, "Record Is Not Exist...............");
             setVisible(false);
        }
        conn.close();
        }catch(Exception ex){ex.printStackTrace();}
        
        
        
          
    }
    public static void main(String args[])
    {
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
