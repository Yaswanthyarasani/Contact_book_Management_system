
package contactbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class SearchDatatableForEdit extends JFrame implements ActionListener
{
    String x[]={"ID","FNAME","SNAME","PHONE","EMAIL","LOCATION"};
    String y[][]=new String[30][6];
    int i=0,j=0;
    JTable t;
    Font f;
    JLabel l1;
    JTextField tf1;
    JButton bt1,bt2;
    JPanel p1;
    
    SearchDatatableForEdit()
    {
        
    }
    SearchDatatableForEdit(String name1 )
    {
        
          super("Contact Information");
          setLocation(400,300);
          setSize(800,400);   
        
        f=new Font("Baskerville Old Face",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="Select * from add_contact where FNAME='"+name1+"'";
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
        l1=new JLabel("Enter Contact ID");
        tf1=new JTextField();
        bt1=new JButton("Edit");
        bt2=new JButton("Back");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,4,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt1);
        p1.add(bt2);
        
        setLayout(new BorderLayout (10,10));
        add(p1,"South");
        add(sp,"Center");
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
            new SearchNameForEdit().setVisible(true);
            
        }
        else
        {
            int idno=Integer.parseInt(tf1.getText());
            if(e.getSource()==bt1)
        {
            new EditData(idno).setVisible(true);
            this.setVisible(false);
        }
        }
        
        
        
    
    }
    public static void main(String[] args)
    {
        new SearchDatatableForEdit().setVisible(true);
    }
    
}
