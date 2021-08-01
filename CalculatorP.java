package calculator.p;

import java.awt.event.*;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*; 

public class CalculatorP extends JFrame implements ActionListener {  
 int i,n1,n2,res;
 char op;
 JPanel panel=new JPanel();
 JTextField t;
 JLabel l1,l2;
 JButton b[]=new JButton[16];
 CalculatorP()
 {
    setLayout(new BorderLayout());
    panel.setLayout(new GridLayout(4,4));
 for(i=0;i<10;i++)
 {
     b[i]=new JButton(i+"");
     panel.add(b[i]);
     b[i].addActionListener(this);
 }
 b[10]=new JButton("+"); b[10].addActionListener(this); panel.add(b[10]);
 b[11]=new JButton("-"); b[11].addActionListener(this); panel.add(b[11]);
 b[12]=new JButton("*"); b[12].addActionListener(this); panel.add(b[12]);
 b[13]=new JButton("/"); b[13].addActionListener(this); panel.add(b[13]);
 b[14]=new JButton("="); b[14].addActionListener(this); panel.add(b[14]);
 b[15]=new JButton("C"); b[15].addActionListener(this); panel.add(b[15]);
 t=new JTextField();
      add(panel,BorderLayout.CENTER);
      add(t,BorderLayout.NORTH);
      setVisible(true);
      setSize(300,300);
      setTitle("CALCULATOR");
 }
 public void actionPerformed(ActionEvent e)
 {  JButton jb=(JButton)e.getSource();
     if(jb==b[15])
     {
         n1=n2=res=0;
         t.setText("");
     }
     else
     {
         if(jb==b[14])
         {
             n2=Integer.parseInt(t.getText());
             int r=result();
              t.setText(String.valueOf(n1)+op+String.valueOf(n2)+" = "+r);
         }
         else
         {
             boolean ch=false;
             if(jb==b[10])
             {
                 op='+';
                 ch=true;
             }
             if(jb==b[11])
             {
                 op='-';
                 ch=true;
             }
             if(jb==b[12])
             {
                 op='*';
                 ch=true;
             }
             if(jb==b[13])
             {
                 op='/';
                 ch=true;
             }
             if(ch==false)
             {
                 for(i=0;i<10;i++)
                 {if(jb==b[i])
                 {
                     t.setText(t.getText()+i);
                     break;
                 }
                 }
             }
             else
             {
                 n1=Integer.parseInt(t.getText());
                 t.setText("");
             }
         }
     }
 }

 public int result()
 {
     switch(op)
     {
         case '+':res=n1+n2;
            break;
        case '-':res=n1-n2;
            break;
        case '*':res=n1*n2;
            break;
         case '/':res=n1/n2;
            break;
     }
     return res;
 }
    
    public static void main(String[] args)
    {
        new CalculatorP();
    }
 
}

