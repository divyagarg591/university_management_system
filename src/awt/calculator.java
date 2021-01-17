
package awt;
import java.awt.*;
import java.awt.event.*;
public class calculator extends Frame implements ActionListener,WindowListener {
    Label firstno,secondno,result;
    
    TextField textfrst,textscnd;
    Button add,sub,mul,div;
    Panel p;
    Font f=new Font("Arial",Font.BOLD,20);
    public calculator()
    {
        super("Calculator");
        firstno=new Label("Enter first no.");
        firstno.setBounds(10,50,100,20);
        firstno.setBackground(Color.LIGHT_GRAY);
        firstno.setForeground(Color.black);
        secondno=new Label("Enter second no.");
        secondno.setBounds(10,90,100,20);
        secondno.setBackground(Color.LIGHT_GRAY);
        secondno.setForeground(Color.black);
        textfrst=new TextField(20);
        textfrst.setBounds(175,50,150,20);
        textscnd=new TextField(20);
        textscnd.setBounds(175,90,150,20);
        result=new Label();
        result.setBounds(10,130,60,30);
        result.setForeground(Color.black);
        add=new Button("+");
        add.setFont(f);
       add.setBounds(220,200,70,30);
       add.setForeground(Color.black);
       sub=new Button("-");
       sub.setFont(f);
       sub.setBounds(400,200,70,30);
       sub.setForeground(Color.black);
       mul=new Button("*");
       mul.setFont(f);
       mul.setBounds(220,300,70,30);
       mul.setForeground(Color.black);
       div=new Button("/");
       div.setFont(f);
       div.setBounds(400,300,70,30);
       div.setForeground(Color.black);
       p=new Panel(null);
       add(p); addWindowListener(this);
         add.addActionListener(this);
         sub.addActionListener(this);
         mul.addActionListener(this);
         div.addActionListener(this);
         p.add(firstno); p.add(textfrst); 
         p.add(secondno); p.add(textscnd);
         p.add(add);    p.add(sub);
         p.add(mul);    p.add(div);
         p.add(result);
         setSize(500,500);
         setLocation(350,150);
         p.setBackground(Color.yellow);
         setVisible(true); 
    }
    public static void main(String args[])
    {
        calculator c=new calculator();
    }

    
    public void actionPerformed(ActionEvent e) {
         int a,b,res=0;
         a=Integer.parseInt(textfrst.getText());
         b=Integer.parseInt(textscnd.getText());
         Object o=e.getSource();
         if(o==add)
         {
             res=a+b;
             
         }
         else if(o==sub)
         {
             res=a-b;
             
         }
         else if(o==mul)
         {
             res=a*b;
             
         }
         else if(o==div)
         {
             res=a/b;
             
         }
         result.setText(String.valueOf(res));
         result.setBackground(Color.white);
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
