
package contactbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class EntryData extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1,tf2,tf3,tf4,tf5;
    
    EntryData()
    {
        super("ADD CONTACT");
        setLocation(400,100);
        setSize(430,550);
        
        
        f=new Font("Baskerville Old Face",Font.BOLD,30);
        f1=new Font("Baskerville Old Face",Font.BOLD,15);
        
        l1=new JLabel("ADD CONTACT");
        l2=new JLabel("FIRST NAME");
        l3=new JLabel("SECOND NAME");
        l4=new JLabel("PHONE NO");
        l5=new JLabel("EMAIL ADDRESS");
        l6=new JLabel("LOCATION");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        
        bt1=new JButton("Add Contact");
        bt2=new JButton("Back");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,20,20));
        p1.add(l1);
        
        
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(6,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,20));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {
        String fname=tf1.getText();
        String sname=tf2.getText();
        String pno=tf3.getText();
        String email=tf4.getText();
        String location=tf5.getText();
        
        if(e.getSource()==bt1)
        {
           try{
               ConnectionClass obj =new ConnectionClass();
               String q = "insert into add_contact (fname,sname,phone,email,location) value('"+fname+"','"+sname+"','"+pno+"','"+email+"','"+location+"')";
               int aa=obj.stm.executeUpdate(q);
               if(aa==1){
                   JOptionPane.showMessageDialog(null,"Your data successfully inserted.");
                   this.setVisible(false);
                   new Home().setVisible(true);
                   
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"please fill the details carefully.");
               }
               
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
        }
         if(e.getSource()==bt2)
        {
            
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
    public static void main(String[] args )
    {
        new EntryData().setVisible(true);
    }
    
}
