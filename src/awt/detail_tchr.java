
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class detail_tchr extends JFrame implements WindowListener {
    JTable tbl;
    public detail_tchr()
    {
        DefaultTableModel dt= new DefaultTableModel();
        tbl=new JTable(dt);
        tbl.setBackground(Color.cyan);
        dt.addColumn("id");
        dt.addColumn("Name");
        dt.addColumn("Address");
        dt.addColumn("Qualification");
        dt.addColumn("Age");
        dt.addColumn("Department");
        dt.addColumn("Gender");
        dt.addColumn("Phone no");
        setTitle("Details of Teacher");
            try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement("select * from teacher");
        ResultSet rs=pdt.executeQuery();
        while(rs.next())
        {
            dt.addRow(new Object[]{rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getString("qulification"),rs.getInt("age"),rs.getString("department"),rs.getString("gender"),rs.getInt("phone")});
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
       detail_tchr d=new detail_tchr(); 
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
