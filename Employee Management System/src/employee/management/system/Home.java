
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton view,add,update,remove;
    Home(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(550,20,600,40);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
        image.add(heading);
        
        add=new JButton("ADD EMPLOYEE");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("VIEW EMPLOYEES");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);
        
        update=new JButton("UPDATE EMPLOYEE");
        update.setBounds(650,130,150,40);
        update.addActionListener(this);
        image.add(update);
        
        remove=new JButton("REMOVE EMPLOYEE");
        remove.setBounds(820,130,150,40);
        remove.addActionListener(this);
        image.add(remove);
        
        
        
       
        
        setLayout(null);
        setSize(1120,630);
        setLocation(150,100);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
            
        
    } else if(ae.getSource()==view){
        setVisible(false);
        new ViewEmployee();
    
    } else if(ae.getSource()==update){
        setVisible(false);
        new ViewEmployee();
        
    } else{
        setVisible(false);
        new RemoveEmployee();
    }
        
    }
    
    public static void main(String args[]){
        new Home();
    }
    
}
