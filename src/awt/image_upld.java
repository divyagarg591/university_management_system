
package awt;
import java.awt.*;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
public class image_upld extends JFrame implements ActionListener {
    JButton upload;
    JPanel p;
   JLabel label;
   Label imgi;
   TextField text;
   
    public image_upld()
    {
       p=new JPanel(null);
       label=new JLabel();
        label.setBounds(400,0,500,300);
        imgi=new Label("");
        imgi.setBounds(400,330,50,20);
        text=new  TextField(40);
        upload =new JButton("BROWSE");
        upload.setBounds(600,400,100,30);
        upload.setForeground(Color.black);
        upload.setBackground(Color.PINK);
        String data[][]={{"aa","aa"}};
        String column[]={"picture","about"};
         JTable tbl=new JTable(data,column);
        tbl.setBounds(700,40,10,40);
         JScrollPane pane=new JScrollPane(tbl);
           add(pane);
           add(p);
        upload.addActionListener(this);
       p.add(label);
         p.add(imgi);
         p.add(text);
         p.add(upload);
         p.setBackground(Color.cyan);
        setSize(500,500);
         setLocation(350,150);
         setVisible(true);  
    }
    public static void main(String args[])
    {
       image_upld ip=new image_upld(); 
    }


    @Override
    public void actionPerformed(ActionEvent e) {
     Object o=e.getSource();
     if(o==upload)
     {
        JFileChooser jf=new JFileChooser();
        jf.showOpenDialog(null);
        File f=jf.getSelectedFile();
        String path=f.getAbsolutePath();
        ImageIcon i=new ImageIcon(path);
        Image img=i.getImage();
        Image newimg=img.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
       ImageIcon ii=new ImageIcon(newimg);
        label.setIcon(ii);
        imgi.setText(" Image");
        imgi.setBackground(Color.pink);
        text.setBounds(450,330,200,20);
        text.setText(path); 
     }
    }

    private JLabel setIcon(ImageIcon imageIcon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
