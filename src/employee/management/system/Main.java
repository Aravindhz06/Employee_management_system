package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {
    Main(){

        ImageIcon i1=new ImageIcon(getClass().getResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        //employee management system
        JLabel heading=new JLabel("Employee Managemenet System");
        heading.setBounds(345,130,400,40);
        heading.setFont(new Font("Times New Roman",Font.BOLD,25));
        image.add(heading);

        //add button
        JButton add=new JButton("Add Employee");
        add.setBounds(285,240,130,20);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setSize(140,40);
        image.add(add);
        //actionlisterner
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
            }
        });

        //view button
        JButton view=new JButton("View Employee");
        view.setBounds(615,240,130,20);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.setSize(140,40);
        image.add(view);
        //actionlisterner
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee();
            }
        });

        //remove button
        JButton rem=new JButton("Remove Employee");
        rem.setBounds(450,350,130,20);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLACK);
        rem.setSize(140,40);
        image.add(rem);
        //actionlisterner
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });



        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
        setLayout(null);

    }
    public static void main(String[] args) {
        new Main();
    }
}
