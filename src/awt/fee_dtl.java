package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
public class fee_dtl extends JFrame implements WindowListener {
    JTable tbl;
    public fee_dtl()
    {
        DefaultTableModel dt= new DefaultTableModel();
        tbl=new JTable(dt);
        tbl.setBackground(Color.cyan);
        dt.addColumn("Roll no");
        dt.addColumn("Name");
        dt.addColumn("Father Name");
        dt.addColumn("Course");
        dt.addColumn("Branch");
        dt.addColumn("1_semester");
        dt.addColumn("2_semester");
        dt.addColumn("3_semester");
        dt.addColumn("4_semester");
        dt.addColumn("5_semester");
        dt.addColumn("6_semester");
        dt.addColumn("7_semester");
        dt.addColumn("8_semester");
              
        setTitle("Details of fee");
            try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","divya","divyagarg");
        PreparedStatement pdt=conn.prepareStatement("select * from fee");
        ResultSet rs=pdt.executeQuery();
        while(rs.next())
        {
            dt.addRow(new Object[]{rs.getInt("rollno"),rs.getString("name"),rs.getString("father_name"),rs.getString("course"),rs.getString("branch"),rs.getInt("sem_1"),rs.getInt("sem_2"),rs.getInt("sem_3"),rs.getInt("sem_4"),rs.getInt("sem_5"),rs.getInt("sem_6"),rs.getInt("sem_7"),rs.getInt("sem_8")});
        }
        conn.close();
        }catch(Exception ex){System.out.println(ex);}  
            JScrollPane pane=new JScrollPane(tbl);
        add(pane);
        setSize(900,500);
         setLocation(210,130);
        setVisible(true);
        
    }
    public static void main(String args[])
    {
       fee_dtl fd=new fee_dtl();
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