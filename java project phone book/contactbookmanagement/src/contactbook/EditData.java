package contactbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class EditData extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    EditData()
    {
        
    }
    
    EditData(int idno)
    {
        super("Edit CONTACT");
        setLocation(400,100);
        setSize(430,550);
        
        
        f=new Font("Baskerville Old Face",Font.BOLD,30);
        f1=new Font("Baskerville Old Face",Font.BOLD,15);
        
        l1=new JLabel("EDIT CONTACT");
        l2=new JLabel("FIRST NAME");
        l3=new JLabel("SECOND NAME");
        l4=new JLabel("PHONE NO");
        l5=new JLabel("EMAIL ADDRESS");
        l6=new JLabel("LOCATION");
        l7=new JLabel("ID");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();
        
        bt1=new JButton("Edit Contact");
        bt2=new JButton("Back");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        bt1.setBackground(Color.darkGray);
        bt1.setForeground(Color.blue);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(7,2,10,10));
        p2.add(l7);
        p2.add(tf6);
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
        
        try
        {
            ConnectionClass obj1=new ConnectionClass();
            String q1="Select * from add_contact where Id='"+idno+"'";
            ResultSet rest1=obj1.stm.executeQuery(q1);
            while(rest1.next())
            {
                tf6.setText(rest1.getString("Id"));
                tf1.setText(rest1.getString("fname"));
                tf2.setText(rest1.getString("sname"));
                tf3.setText(rest1.getString("phone"));
                tf4.setText(rest1.getString("email"));
                tf5.setText(rest1.getString("location"));
                
            }
                
            
        }
        catch(Exception exx )
        {
            exx.printStackTrace();
        }
        
        tf6.setEditable(false);
        
        setLayout(new BorderLayout(10,20));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int cid=Integer.parseInt(tf6.getText());
            String fname=tf1.getText();
            String sname=tf2.getText();
            String phno=tf3.getText();
            String email=tf4.getText();
            String location=tf5.getText();
            
            try
            {
                ConnectionClass obj3=new ConnectionClass();
                String q1 = "update add_contact set fname='"+fname+"',sname='"+sname+"',phone='"+phno+"',email='"+email+"',location='"+location+"' where Id='"+cid+"'";
                int aa=obj3.stm.executeUpdate(q1);
                if(aa==1)
                {
                   JOptionPane.showMessageDialog(null,"Your data successfully Updated.");
                   this.setVisible(false);
                   new SearchDatatableForEdit(fname).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please,Fill all the details carefully");
                }
            
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
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
        new EditData().setVisible(true);
    }
    
    
    
}
