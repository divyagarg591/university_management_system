
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class exam_form extends JFrame implements WindowListener,ActionListener {
   Label lblid,lblcls, lbl,lblsub,lblmark;
    JLabel back;
    TextField textno,textcls,textmrk1,textmrk2,textmrk3,textmrk4,textmrk5,textsb1,textsb2,textsb3,textsb4,textsb5;
    Button submit;
    Font f=new Font("Arial",Font.BOLD,20);
    public exam_form()
    {  
     super("MARKS ENTRY FORM");
        ImageIcon i=new ImageIcon("C:\\Users\\pc\\Documents\\NetBeansProjects\\awt\\src\\image\\image5.jpg");
        back=new JLabel("",i,JLabel.CENTER);
        back.setBounds(0,0,2000,2000);
        add(back);
        lbl=new Label("       Enter Marks Of Student");
        lbl.setFont(f);
        lbl.setBounds(0,20,320,30);
        lbl.setBackground(Color.white); 
        lbl.setForeground(Color.black);  
        lblid=new Label("Enter Roll.NO.");
        lblid.setBounds(10,70,150,20);
        lblid.setBackground(Color.LIGHT_GRAY);
        lblid.setForeground(Color.black);  
        textno=new TextField(20);
        textno.setBounds(175,70,150,20);
        lblcls=new Label("Enter Class");
        lblcls.setBounds(10,95,150,20);
        lblcls.setBackground(Color.LIGHT_GRAY);
        lblcls.setForeground(Color.black);  
        textcls=new TextField(20);
        textcls.setBounds(175,95,150,20);
        lblsub=new Label("Enter Subjects");
        lblsub.setBounds(10,150,150,20);
        lblsub.setBackground(Color.LIGHT_GRAY);
        lblsub.setForeground(Color.black);
        lblmark=new Label("Enter Marks");
        lblmark.setBounds(180,150,150,20);
        lblmark.setBackground(Color.LIGHT_GRAY);
        lblmark.setForeground(Color.black);
        textsb1=new TextField(20);
        textsb1.setBounds(10,190,150,20);
        textsb2=new TextField(20);
        textsb2.setBounds(10,230,150,20);
        textsb3=new TextField(20);
        textsb3.setBounds(10,270,150,20);
        textsb4=new TextField(20);
        textsb4.setBounds(10,310,150,20);
        textsb5=new TextField(20);
        textsb5.setBounds(10,350,150,20);
        textmrk1=new TextField(20);
        textmrk1.setBounds(180,190,150,20);
        textmrk2=new TextField(20);
        textmrk2.setBounds(180,230,150,20);
        textmrk3=new TextField(20);
        textmrk3.setBounds(180,270,150,20);
        textmrk4=new TextField(20);
        textmrk4.setBounds(180,310,150,20);
        textmrk5=new TextField(20);
        textmrk5.setBounds(180,350,150,20);
        submit=new Button("Submit");
        submit.setBounds(100,400,100,30);
        submit.addActionListener(this);
        addWindowListener(this);
        add(back);
        back.add(lbl);
        back.add(lblid);
        back.add(textno);
        back.add(lblcls);
        back.add(textcls);
        back.add(lblsub);
        back.add(lblmark);
        back.add(textsb1);
        back.add(textsb2);
        back.add(textsb3);
        back.add(textsb4);
        back.add(textsb5);
        back.add(textmrk1);
        back.add(textmrk2);
        back.add(textmrk3);
        back.add(textmrk4);
        back.add(textmrk5);
        back.add(submit);
        
        
        setSize(400,500);
         setLocation(210,130);
         setVisible(true);
}
    public static void main(String[] args) {
       exam_form ef= new exam_form();
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
         int roll=Integer.parseInt(textno.getText());
           String cls=textcls.getText();
           String sub_1=textsb1.getText();
           String sub_2=textsb2.getText();
           String sub_3=textsb3.getText();
           String sub_4=textsb4.getText();
           String sub_5=textsb5.getText();
           int mrk_1=Integer.parseInt(textmrk1.getText());
           int mrk_2=Integer.parseInt(textmrk2.getText());
           int mrk_3=Integer.parseInt(textmrk3.getText());
           int mrk_4=Integer.parseInt(textmrk4.getText());
           int mrk_5=Integer.parseInt(textmrk5.getText());
           int obtained=(mrk_1+mrk_2+mrk_3+mrk_4+mrk_5);
          String q="select * from exam  where rollno ="+roll+"";
        PreparedStatement pdt=conn.prepareStatement(q);
        ResultSet rs=pdt.executeQuery();
        if(rs.next())
        {
        
           
            JOptionPane.showMessageDialog(null, "Record From This RollNo Is Already Inserted");
        }

        else{
            String query="";
          query="insert into exam values(?,?,?,?,?,?,?,?,?,?,?,?,?)";    
        PreparedStatement pdt2=conn.prepareStatement(query);
        pdt2.setInt(1,roll);
        pdt2.setString(2,cls);
        pdt2.setString(3,sub_1);
        pdt2.setString(4,sub_2);
        pdt2.setString(5,sub_3);
        pdt2.setString(6,sub_4);
        pdt2.setString(7,sub_5);
        pdt2.setInt(8,mrk_1);
        pdt2.setInt(9,mrk_2);
        pdt2.setInt(10,mrk_3);
        pdt2.setInt(11,mrk_4);
        pdt2.setInt(12,mrk_5);
        pdt2.setInt(13,obtained);
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
