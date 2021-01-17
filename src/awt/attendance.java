
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class attendance extends Frame implements WindowListener,ActionListener{
 Label lblrn,lblfrst,lblscnd;
 TextField textrn;
 Choice c1,c2;
 JPanel p;
 Button submit,cancel;
  public attendance()
 {
     super("Attendance form");
     p=new JPanel(null);
     p.setBackground(Color.yellow);
     lblrn=new Label("Enter RollNo.");
     lblrn.setBounds(10,50,100,20);
     lblrn.setBackground(Color.black);
     lblrn.setForeground(Color.WHITE);
     textrn=new TextField(20);
     textrn.setBounds(175,50,150,20);
     lblfrst=new Label("First Half");
     lblfrst.setBounds(10,90,100,20);
     lblfrst.setBackground(Color.black);
     lblfrst.setForeground(Color.WHITE);
     c1=new Choice();
     c1.add("Present");
     c1.add("Absent");
     c1.setBounds(175,90,150,20);
     lblscnd=new Label("Second Half");
     lblscnd.setBounds(10,130,100,20);
     lblscnd.setBackground(Color.black);
     lblscnd.setForeground(Color.WHITE);
     c2=new Choice();
     c2.add("Present");
     c2.add("Absent");
     c2.setBounds(175,130,150,20);
     submit=new Button("Submit");
     submit.setBounds(130,220,100,30);
     submit.setBackground(Color.black);
     submit.setForeground(Color.WHITE);
     
     cancel=new Button("Cancel");
     cancel.setBounds(260,220,100,30);
     cancel.setBackground(Color.black);
     cancel.setForeground(Color.WHITE);
     add(p);
     submit.addActionListener(this);
     p.add(lblrn);p.add(textrn);
     p.add(lblfrst);p.add(c1);
     p.add(lblscnd);p.add(c2);
     p.add(submit);p.add(cancel);
          setSize(400,400);
         setLocation(210,130);
         setVisible(true);
    }
public static void main(String[] args) {
      attendance at=new attendance();  
    }


    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      Object o=e.getSource();
      if(o==submit)
      {try{
          String rolls=(textrn.getText());
          int roll=Integer.parseInt(rolls);
          String first=c1.getSelectedItem();
          String scnd=c2.getSelectedItem();
          DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
          LocalDateTime now=LocalDateTime.now();
          String date=(dtf.format(now));
          String query="insert into attendance values(?,?,?,?)";
          Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement(query);
        pdt.setInt(1,roll);
        pdt.setString(2,first);
        pdt.setString(3,scnd);
        pdt.setString(4,date);
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
    }
 }

    
