package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class fee_form extends Frame implements WindowListener,ActionListener{
   Label lblrn,lblname,lblcourse,lblbranch,ftrname,sem,amount;
 TextField textrn,textname,textbranch,textftrname,textamount;
 Choice crs,semm;
 JPanel p;
 Button submit,cancel;
  public fee_form()
 {
     super("Fee form");
     p=new JPanel(null);
     p.setBackground(Color.YELLOW);
     lblrn=new Label("RollNo.");
     lblrn.setBounds(10,20,100,20);
     lblrn.setBackground(Color.black);
     lblrn.setForeground(Color.WHITE);
     textrn=new TextField(20);
     textrn.setBounds(175,20,150,20);
     lblname=new Label("Name");
     lblname.setBounds(10,60,100,20);
     lblname.setBackground(Color.black);
     lblname.setForeground(Color.WHITE);
     textname=new TextField(20);
     textname.setBounds(175,60,150,20);
     ftrname=new Label("Father name");
     ftrname.setBounds(10,100,100,20);
     ftrname.setBackground(Color.black);
     ftrname.setForeground(Color.WHITE);
     textftrname=new TextField(20);
     textftrname.setBounds(175,100,150,20);
     lblcourse=new Label("Course");
     lblcourse.setBounds(10,140,100,20);
     lblcourse.setBackground(Color.black);
     lblcourse.setForeground(Color.WHITE);
     crs=new Choice();
     crs.add("B.Tech.");
     crs.add("M.Tech.");
     crs.add("BBA.");
     crs.add("BA.");
     crs.add("B.Com.");
     crs.add("MBA.");
     crs.add("M.Com.");
     crs.add("M.Phill.");
     crs.add("B.Sc.");
     crs.add("M.A.");
     crs.add("LLM.");
     crs.add("M.Des.");
     crs.add("B.Des.");
     crs.add("MSW.");
     crs.add("LLB.");
     crs.setBounds(175,140,100,20);
     lblbranch=new Label("Branch");
     lblbranch.setBounds(10,170,100,20);
     lblbranch.setBackground(Color.black);
     lblbranch.setForeground(Color.WHITE);
      textbranch=new TextField(20);
     textbranch.setBounds(175,170,150,20);
      sem=new Label("Semester");
      sem.setBounds(10,210,100,20);
      sem.setBackground(Color.black);
      sem.setForeground(Color.WHITE);
     semm=new Choice();
     semm.add("Semester_1");
     semm.add("Semester_2");
     semm.add("Semester_3");
     semm.add("Semester_4");
     semm.add("Semester_5");
     semm.add("Semester_6");
     semm.add("Semester_7");
     semm.add("Semester_8");
     semm.setBounds(175,210,150,20);
      amount=new Label("Amount");
      amount.setBounds(10,250,100,20);
      amount.setBackground(Color.black);
      amount.setForeground(Color.WHITE);
      textamount=new TextField(20);
     textamount.setBounds(175,250,150,20);
     submit=new Button("Pay");
     submit.setBounds(130,300,100,30);
     submit.setBackground(Color.green);
     submit.setForeground(Color.WHITE);
     cancel=new Button("Cancel");
     cancel.setBounds(260,300,100,30);
     cancel.setBackground(Color.red);
     cancel.setForeground(Color.WHITE);
     add(p);
     submit.addActionListener(this);
     p.add(lblrn);p.add(textrn);
     p.add(lblname);p.add(textname);
      p.add(ftrname);p.add(textftrname);
       p.add(lblcourse);p.add(crs);
        p.add(lblbranch);p.add(textbranch);
         p.add(sem);p.add(semm);
          p.add(amount);p.add(textamount);
     p.add(submit);p.add(cancel);
          setSize(400,400);
         setLocation(210,130);
         setVisible(true);
    }
public static void main(String[] args) {
      fee_form ff=new fee_form();  
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
        
        if(o==submit)
        {
            try
        {
              Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
         int roll=Integer.parseInt(textrn.getText());
           String sname=textname.getText();
           String ftr=textftrname.getText();
           String crss=crs.getSelectedItem();
           String brnch=textbranch.getText();
           String sem_f=semm.getSelectedItem();
           int amnt=Integer.parseInt(textamount.getText());
          String q="select * from fee where rollno ="+roll+"";
        PreparedStatement pdt=conn.prepareStatement(q);
        ResultSet rs=pdt.executeQuery();
        if(rs.next())
        {
            String qry="";
          if(sem_f.equals("Semester_2"))
          {
                   qry="update fee set sem_2=? where rollno=?";
          }
          else if(sem_f.equals("Semester_3"))
                   qry="update fee set sem_3=? where rollno=?";
          else if(sem_f.equals("Semester_4"))
                   qry="update fee set sem_4=? where rollno=?";
           else if(sem_f.equals("Semester_5"))
                   qry="update fee set sem_5=? where rollno=?";
          else if(sem_f.equals("Semester_6"))
                   qry="update fee set sem_6=? where rollno=?";
          else if(sem_f.equals("Semester_7"))
                   qry="update fee set sem_7=? where rollno=?";
          else if(sem_f.equals("Semester_8"))
                   qry="update fee set sem_8=? where rollno=?";
          
           PreparedStatement pdt1=conn.prepareStatement(qry);
        pdt1.setInt(1,amnt);
        pdt1.setInt(2,roll);
        int i=pdt1.executeUpdate();
        if(i>0)
        {
           
            JOptionPane.showMessageDialog(null, "insert successfully");
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Error...............");
        }
          
        }

        else{
            String query="";
          query="insert into fee (rollno,name,father_name,course,branch,sem_1) values(?,?,?,?,?,?)";    
        PreparedStatement pdt2=conn.prepareStatement(query);
        pdt2.setInt(1,roll);
        pdt2.setString(2,sname);
        pdt2.setString(3,ftr);
        pdt2.setString(4,crss);
        pdt2.setString(5,brnch);
        pdt2.setInt(6,amnt);
        int i=pdt2.executeUpdate();
        if(i>0)
        {
           
            JOptionPane.showMessageDialog(null, "insert successfully");
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Error...............");
        }
       }
        conn.close();
        }catch(Exception ex){ex.printStackTrace();}
       }     
        
   }
}