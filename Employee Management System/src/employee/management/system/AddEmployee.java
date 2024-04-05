package employee.management.system;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

 
public class AddEmployee extends JFrame implements ActionListener {
    
    Random ran=new Random();
    int number=ran.nextInt(999999);
    
    JTextField tfname,tffname,tfdob,tfphone,tfid,tfaddress,tfemail,tfsalary,tfdesignation,tfempid;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempid;
    JButton add,back;
    
    
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //HEADING
        JLabel heading=new JLabel("Add Employees Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        //NAME
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        
       //FATHER NAME
        JLabel labelfathername=new JLabel("Fatther Name");
        labelfathername.setBounds(400,150,150,30);
        labelfathername.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfathername);
        
        tffname=new JTextField();
        tffname.setBounds(600,200,200,30);
        add(tffname);
       
        
        //DATE OF BIRTH
        JLabel labeldob=new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        //SALARY
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(600,150,150,30);
        add(tfsalary);
        
        //ADDRESS
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
         add(labeladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        //PHONE
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        //EMAIL
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        //COURSE
        JLabel labelcourse=new JLabel("Course");
        labelcourse.setBounds(400,300,150,30);
        labelcourse.setFont(new Font("serif",Font.PLAIN,20));
        add(labelcourse);
        
        String Courses[]={"Select The Course","BTECH","BA","BCA","BSC","BBC","BCOM","MCOM","MTECH","MA","MBA","MSC","MCA","PHD"};
        cbeducation=new JComboBox(Courses);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);
        
        //DESIGNATION
        JLabel labeldesignation=new JLabel("Designatin");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        //ID PROOF
        JLabel labelid=new JLabel("Aadhar Number");
        labelid.setBounds(400,350,150,30);
        labelid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelid);
        
        tfid=new JTextField();
        tfid.setBounds(600,350,150,30);
        add(tfid);
        
        //EMPLOYEE ID
        JLabel labelempid=new JLabel("Employee ID");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        
        lblempid=new JLabel(""+number);
        lblempid.setBounds(200,400,150,30);
        lblempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempid);
        
        
        
        
        //ADD BUTTON
        add=new JButton("ADD Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        //BACK BUTTON
        back=new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
       
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone =tfphone.getText();
            String email=tfemail.getText();
            String education= (String)cbeducation.getSelectedItem();
            String designation =tfdesignation.getText();
            String id=tfid.getText();
            String empid = generateEmployeeID();
            
            try{
                Con con=new Con();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+id+"','"+empid+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(true);
                new Home();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
            
        }
    }
    
    // Method to generate employee ID
    private String generateEmployeeID() {
        // Generate a random 6-digit number as employee ID
        return String.format("%06d", ran.nextInt(999999));
    }
    
    
    public static void main(String args[]){
        new AddEmployee();
    }
    
}
