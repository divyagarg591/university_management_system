package awt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel;
public class menudemo2 extends JFrame implements ActionListener,WindowListener {
  MenuBar menubar;
  
 JLabel back;
 Menu form,details,cntct,abt,attendance,examination,fee_detail;
 MenuItem reg,reg_s,contact,detail_s,detail_t,ext,sep,fee_strctr,atndnc_frm,attendance_detail,f_form,fee_dtll,exam_f,result,aboutt;
 public menudemo2()
    {
        super("Banasthali Vidhyapith");
         ImageIcon i=new ImageIcon("C:\\Users\\pc\\Documents\\NetBeansProjects\\awt\\src\\image\\screenshot.png");
        back=new JLabel("",i,JLabel.CENTER);
        back.setBounds(0,0,4000,4000);
        add(back);
        menubar =new MenuBar();
        setMenuBar(menubar);
      
        form=new Menu("Form");
        menubar.add(form);
        details=new Menu("Details");
        menubar.add(details);
        attendance=new Menu("Attendance");
        menubar.add(attendance);
        atndnc_frm=new MenuItem("Attendance");
        attendance.add(atndnc_frm);
        attendance_detail=new MenuItem("Attendance Details");
        attendance.add(attendance_detail);
        examination=new Menu("Examination");
        menubar.add(examination);
        exam_f=new MenuItem("Insert Record");
        examination.add(exam_f);
        result=new MenuItem("View Record");
        examination.add(result);
        fee_detail=new Menu("Fee Details");
        menubar.add(fee_detail);
        fee_strctr=new MenuItem("Fee Structure");
        fee_detail.add(fee_strctr);
        f_form=new MenuItem("Fee Form");
        fee_detail.add(f_form);
         fee_dtll=new MenuItem("Fee Details");
         fee_detail.add(fee_dtll);
        cntct=new Menu("Contact us");
        contact=new MenuItem("Contact");
        cntct.add(contact);
        menubar.add(cntct);
        abt=new Menu("About us");
        menubar.add(abt);
        aboutt=new MenuItem("About Us");
        abt.add(aboutt);
        
        reg=new MenuItem("Teacher entry Form");
        reg_s=new MenuItem("Student entry Form");
        detail_t=new MenuItem("details of Teacher");
        detail_s=new MenuItem("details of Student");
        sep=new MenuItem("-");
        ext=new MenuItem("Exit");
        form.add(reg);
        form.add(reg_s);
        details.add(detail_t);
        details.add(detail_s);
        form.add(sep);
        form.add(ext);
        addWindowListener(this);
        f_form.addActionListener(this);
        reg.addActionListener(this);
        reg_s.addActionListener(this);
       detail_s.addActionListener(this);
       exam_f.addActionListener(this);
       result.addActionListener(this);
       detail_t.addActionListener(this);
       fee_dtll.addActionListener(this);
       fee_strctr.addActionListener(this);
        ext.addActionListener(this);
        contact.addActionListener(this);
        atndnc_frm.addActionListener(this);
        aboutt.addActionListener(this);
        attendance_detail.addActionListener(this);
            setSize(900,900);
         setLocation(250,100);
            setVisible(true);
    } 
public static void main(String args[])
    {
      menudemo2 m=new menudemo2();
    } 
@Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o==reg)
        {
          new teacher();
        }
        else if(o==reg_s)
        {
            new Swing();
        }
            
        else if(o==detail_t)
        {
            new detail_tchr().setVisible(true);
        }
        else if(o==detail_s)
        {
            new detail_std().setVisible(true);
        }
       
        else if(o==ext)
        {
            System.exit(0);
        }
        else if(o==fee_strctr)
        {
         fee_strutr fs=new fee_strutr();   
        }
        else if(o==atndnc_frm)
        {
         attendance at=new attendance();    
        }
         else if(o==attendance_detail)
        {
         atndnc_dtl ad=new atndnc_dtl(); 
        }
         else if(o==contact)
         {
             contact ct=new contact(); 
         }
        else if(o==f_form)
         {
            fee_form ff = new fee_form();
         }
         else if(o==fee_dtll)
         {
            fee_dtl fd=new fee_dtl();
         }
        else if(o==exam_f)
         {
            exam_form ef=new exam_form();
         }
        else if(o==result)
         {
            chk_rslt cr=new  chk_rslt();
         }
        else if(o==aboutt)
         {
            about ab=new about();
         }
       }

    @Override
    public void windowOpened(WindowEvent e) {
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
