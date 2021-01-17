
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
public class detail_std extends JFrame implements WindowListener {
    JTable tbl;
    public detail_std()
    {
        DefaultTableModel dt= new DefaultTableModel();
        tbl=new JTable(dt);
        tbl.setBackground(Color.cyan);
        dt.addColumn("Roll no");
        dt.addColumn("Name");
        dt.addColumn("Address");
        dt.addColumn("Qualification");
        dt.addColumn("Language");
        dt.addColumn("Gender");
        setTitle("Details of Students");
            try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement("select * from student");
        ResultSet rs=pdt.executeQuery();
        while(rs.next())
        {
            dt.addRow(new Object[]{rs.getInt("rollno"),rs.getString("name"),rs.getString("address"),rs.getString("qualification"),rs.getString("language"),rs.getString("gender")});
        }
        conn.close();
        }catch(Exception ex){System.out.println(ex);}  
            JScrollPane pane=new JScrollPane(tbl);
        add(pane);
        setSize(900,900);
         setLocation(210,130);
        setVisible(true);
        
    }
    public static void main(String args[])
    {
       detail_std d=new detail_std(); 
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
