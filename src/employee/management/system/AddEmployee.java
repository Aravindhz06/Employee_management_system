package employee.management.system;

import com.toedter.calendar.JDateChooser;
import employee.management.system.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tname,taddress,tfname,tphone,taadhar,tsalary;
    JDateChooser tdob;
    JComboBox<String> BoxEducation;//Dropdown Menu
    JLabel tempid;
    JButton add,back;

    //random numbers for creating employee id
    Random rand=new Random();
    int number=rand.nextInt(999999);

    AddEmployee(){
        getContentPane().setBackground(new Color(163,255,188));
        JLabel heading=new JLabel("Add employee detail");
        heading.setFont(new Font("serif",Font.BOLD,25));
        heading.setBounds(320,30,500,50);
        add(heading);

        //Name
        JLabel name=new JLabel("Name:");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        //Address
        JLabel address=new JLabel("Address:");
        address.setBounds(50,190,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress=new JTextField();
        taddress.setBounds(200,190,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        //Father's name
        JLabel fname=new JLabel("Father's Name: ");
        fname.setBounds(50,230,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname=new JTextField();
        tfname.setBounds(200,230,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        //DOB
        JLabel dob=new JLabel("DOB: ");
        dob.setBounds(50,270,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        tdob=new JDateChooser();
        tdob.setBounds(200,270,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        //Phone number
        JLabel phone=new JLabel("PhoneNumber: ");
        phone.setBounds(50,310,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(200,310,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        //aadhar
        JLabel aadhar=new JLabel("Aadhar: ");
        aadhar.setBounds(50,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        taadhar=new JTextField();
        taadhar.setBounds(200,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        //Salary
        JLabel salary=new JLabel("Salary: ");
        salary.setBounds(50,390,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(200,390,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        //empoyee id
        JLabel empid=new JLabel("Employee id: ");
        empid.setBounds(50,430,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid =new JLabel(""+number);
        tempid.setBounds(200,430,150,30);
        tempid.setBackground(new Color(177,252,197));
        tempid.setForeground(Color.MAGENTA);
        tempid.setFont(new Font("timesnewroman",Font.BOLD,20));
        add(tempid);

        //Highest Education
        JLabel education=new JLabel("Highest Education: ");
        education.setBounds(50,470,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        String[] items={"B.E","B.TECH","MBA","BCA","M.PHIL","M.E"};
        BoxEducation =new JComboBox(items);
        BoxEducation.setBackground(new Color(177,252,197));
        BoxEducation.setBounds(200,470,150,30);
        add(BoxEducation);

        //add button
        add=new JButton("Add");
        add.setBounds(400,520,150,30);
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);

        //back button
        back =new JButton("Back");
        back.setBounds(600,520,150,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setSize(900,600);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=tname.getText();
            String fname=tfname.getText();
            String address=taddress.getText();
            String dob=((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String phone=tphone.getText();
            String aadhar=taadhar.getText();
            String education=(String) BoxEducation.getSelectedItem();
            String salary=tsalary.getText();
            String employeeeid=tempid.getText();

            try{
                conn c=new conn();
                String query="insert into employee values('"+name+"','"+fname+"','"+address+"','"+dob+"','"+phone+"','"+aadhar+"','"+education+"','"+salary+"','"+employeeeid+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new Main();

            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Main();
        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
