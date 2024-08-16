
package contactbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class DeleteContact extends JFrame implements ActionListener {
    String x[]={"ID","FNAME","SNAME","PHONE","EMAIL","LOCATION"};
    String y[][]=new String[30][6];
    int i=0,j=0;
    JTable t;
    Font f;
    JLabel l1;
    JTextField tf;
    JButton bt1,bt2;
    JPanel p1;
    DeleteContact ()
    {
        super("Contact Information");
        setLocation(400,300);
        setSize(800,400);   
        
        f=new Font("Baskerville Old Face",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="Select * from add_contact ";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString( "ID");
                y[i][j++]=rest.getString( "fNAME");
                y[i][j++]=rest.getString( "SNAME");
                y[i][j++]=rest.getString( "PHONE");
                y[i][j++]=rest.getString( "EMAIL");
                y[i][j++]=rest.getString( "LOCATION");
                i++;
                j=0;
                
            }
            t=new JTable(y,x);
            t.setFont(f);
            
           
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        l1=new JLabel("Enter contact ID for Delete");
        tf=new JTextField();
        bt1=new JButton("Delete");
        bt2=new JButton("To Home");
        
        bt1.setBackground(Color.darkGray);
        bt1.setForeground(Color.blue);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        //bt1.setPreferredSize(new Dimension(3, 40));
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf);
        p1.add(bt1);
        p1.add(bt2);
        
        setLayout(new BorderLayout (10,10));
        add(p1,"South");
        add(sp,"Center");
     
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt1)
        {   
           int idno=Integer.parseInt(tf.getText());
           try{
               ConnectionClass obj1=new ConnectionClass();
               String q0="delete from add_contact where Id='"+idno+"'";
               int res=obj1.stm.executeUpdate(q0);
               
               if(res==1)
               {
                   JOptionPane.showMessageDialog(null,"Your Contact Successfully Deleted");
                   this.setVisible(false);
                   new DeleteContact().setVisible(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Your contact did not Deleted");
                   this.setVisible(false);
                   new DeleteContact().setVisible(true);
                   
               }
           }
           catch(Exception ex){
               ex.printStackTrace();
           }
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
    public static void main(String[] args){
        new DeleteContact().setVisible(true);
        
    }
}

        
    
    

