package awt;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Awt extends Frame implements WindowListener,ActionListener {
    Label lblrno,lblname,lbladrs,gender,quali,lang,label;
    TextField textno,textname;
    Checkbox c1,c2,c3,c4;
    CheckboxGroup cg;
    Choice c;
    TextArea textadrs;
    Button insert,delete,update;
    Panel p;
    public Awt()
    {
        super("student entry form");
        lblrno=new Label("Enter the roll no");
        lblrno.setBounds(10,50,150,20);
        lblrno.setBackground(Color.white);
        lblrno.setForeground(Color.black);
        lblname=new Label("Enter the name");
        lblname.setBackground(Color.white);
        lblname.setForeground(Color.black);
        lblname.setBounds(10,70,150,20);
        textno=new TextField(20);
        textno.setBounds(175,50,150,20);
         textname=new TextField(20);
         textname.setBounds(175,70,150,20);
         lbladrs=new Label("enter the address");
         lbladrs.setBounds(10,90,150,20);
         lbladrs.setBackground(Color.white);
        lbladrs.setForeground(Color.black);
         textadrs=new TextArea(5,4);
         textadrs.setBounds(175,90,400,100); 
         quali=new Label("qualification");
         quali.setBounds(10,190,150,20);
         quali.setBackground(Color.white);
         quali.setForeground(Color.black);
         c=new Choice();
         c.add("B.Tech.");
         c.add("M.Tech.");
         c.add("Msc");
         c.add("Bsc.");
         c.add("mca");
         c.setBounds(175,190,150,20);
         lang=new Label("Language");
         lang.setBounds(10,210,150,20);
         lang.setBackground(Color.white);
         lang.setForeground(Color.black);
         c1=new Checkbox("Java");
         c1.setBounds(175,210,150,20);
         c2=new Checkbox("C++");
         c2.setBounds(175,230,150,20);
         gender=new Label("gender");
         gender.setBackground(Color.white);
         gender.setForeground(Color.black);
         gender.setBounds(10,250,150,20);
         cg=new CheckboxGroup();
         c3=new Checkbox("Male",cg,false);
         c3.setBounds(175,250,150,20);
         c4=new Checkbox("Female",cg,true);
         c4.setBounds(350,250,150,20);
         insert=new Button("Insert");
         insert.setBackground(Color.white);
        insert.setForeground(Color.black);
         insert.setBounds(175,300,100,30);
         delete=new Button("Delete");
         delete.setBackground(Color.white);
          delete.setForeground(Color.black);
         delete.setBounds(350,300,100,30);
         update=new Button("Update");
         update.setBackground(Color.white);
        update.setForeground(Color.black);
         update.setBounds(525,300,110,30);
         label=new Label();
         label.setBounds(10,300,110,30);
         label.setForeground(Color.black);
         p=new Panel(null);
         add(p); addWindowListener(this);
         insert.addActionListener(this);
         delete.addActionListener(this);
         update.addActionListener(this);
         p.add(lblrno); p.add(textno); 
         p.add(lblname); p.add(textname);
         p.add(lbladrs);p.add(textadrs);
         p.add(quali); p.add(c);
         p.add(lang); p.add(c1); 
         p.add(c2);p.add(gender);
         p.add(c3);
         p.add(c4); p.add(insert);
         p.add(delete);p.add(update);
         p.add(label);
         p.setBackground(Color.pink);
         setSize(500,500);
         setLocation(350,150);
         setVisible(true);
    }
public static void main(String[] args) {
       Awt a= new Awt();
       
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
           String lang="";
           if(c1.getState()==true)
           {
            lang=c1.getLabel();
           }
           else if(c2.getState()==true)
           {
            lang=c2.getLabel();
           }   
           Checkbox ch=cg.getSelectedCheckbox();
           String gndr=ch.getLabel();
           String query="insert into student values(?,?,?,?,?,?)";
           Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement(query);
        pdt.setInt(1,roll);
        pdt.setString(2,sname);
        pdt.setString(3,add);
        pdt.setString(4,quli);
        pdt.setString(5,lang);
        pdt.setString(6,gndr);
        int i=pdt.executeUpdate();
        if(i>0)
        {
            label.setText("Insert successfully");
            label.setBackground(Color.LIGHT_GRAY);
        }
        else
        {
           label.setText("Error in insert");
            label.setBackground(Color.LIGHT_GRAY); 
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
           label.setText("delete successfully");
           label.setBackground(Color.LIGHT_GRAY); 
           
        }
        else
        {
            label.setText("error in delete");
            label.setBackground(Color.LIGHT_GRAY); 
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
        {
            label.setText("update successfully");
            label.setBackground(Color.LIGHT_GRAY);
            
        }
        else
        {
            label.setText("Error in update");
            label.setBackground(Color.LIGHT_GRAY);
        }
        conn.close();
    }catch(Exception ex){ex.printStackTrace();}
        }
     }
    
}

    

