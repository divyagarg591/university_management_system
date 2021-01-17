
package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class atndnc_dtl extends JFrame implements WindowListener {
  JTable tbl;
    public atndnc_dtl()
    {
        DefaultTableModel dt= new DefaultTableModel();
        tbl=new JTable(dt);
        tbl.setBackground(Color.cyan);
        dt.addColumn("Rollno");
        dt.addColumn("First Half");
        dt.addColumn("Second Half");
        dt.addColumn("Time");
        setTitle("Attedance Details");
            try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement("select * from attendance");
        ResultSet rs=pdt.executeQuery();
        while(rs.next())
        {
            dt.addRow(new Object[]{rs.getInt("rollno"),rs.getString("firsthalf"),rs.getString("secondhalf"),rs.getString("date_time")});
        }
        conn.close();
        }catch(Exception ex){System.out.println(ex);}  
            JScrollPane pane=new JScrollPane(tbl);
        add(pane);
        setSize(500,500);
         setLocation(210,130);
        setVisible(true);
        
    }
    public static void main(String args[])
    {
       atndnc_dtl ad=new atndnc_dtl(); 
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
