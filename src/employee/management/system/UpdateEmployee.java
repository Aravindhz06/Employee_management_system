package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField taddress, tphone, taadhar, tsalary, teducation;
    JLabel tempid, tname, tfname;
    JButton update, back;
    String empId;

    UpdateEmployee(String empId) {
        this.empId = empId;

        getContentPane().setBackground(new Color(173, 216, 230));
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(250, 20, 400, 30);
        add(heading);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 100, 100, 30);
        add(lblname);

        tname = new JLabel();
        tname.setBounds(200, 100, 150, 30);
        add(tname);

        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(400, 100, 150, 30);
        add(lblfname);

        tfname = new JLabel();
        tfname.setBounds(600, 100, 150, 30);
        add(tfname);

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(50, 150, 100, 30);
        add(lbladdress);

        taddress = new JTextField();
        taddress.setBounds(200, 150, 150, 30);
        add(taddress);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(400, 150, 100, 30);
        add(lblphone);

        tphone = new JTextField();
        tphone.setBounds(600, 150, 150, 30);
        add(tphone);

        JLabel lblaadhar = new JLabel("Aadhar:");
        lblaadhar.setBounds(50, 200, 100, 30);
        add(lblaadhar);

        taadhar = new JTextField();
        taadhar.setBounds(200, 200, 150, 30);
        add(taadhar);

        JLabel lblsalary = new JLabel("Salary:");
        lblsalary.setBounds(400, 200, 100, 30);
        add(lblsalary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        add(tsalary);

        JLabel lbleducation = new JLabel("Education:");
        lbleducation.setBounds(50, 250, 100, 30);
        add(lbleducation);

        teducation = new JTextField();
        teducation.setBounds(200, 250, 150, 30);
        add(teducation);

        JLabel lblempid = new JLabel("Employee ID:");
        lblempid.setBounds(400, 250, 100, 30);
        add(lblempid);

        tempid = new JLabel(empId);
        tempid.setBounds(600, 250, 150, 30);
        add(tempid);

        try {
            conn c = new conn();
            String query = "select * from employee where employeeeid = '" + empId + "'";
            ResultSet rs = c.statement.executeQuery(query);
            if (rs.next()) {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                taadhar.setText(rs.getString("aadhar"));
                tsalary.setText(rs.getString("salary"));
                teducation.setText(rs.getString("education"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBounds(250, 320, 120, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(450, 320, 120, 30);
        back.addActionListener(this);
        add(back);

        setSize(800, 450);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String address = taddress.getText();
            String phone = tphone.getText();
            String aadhar = taadhar.getText();
            String salary = tsalary.getText();
            String education = teducation.getText();

            try {
                conn c = new conn();
                String query = "update employee set address = '" + address + "', phone = '" + phone + "', aadhar = '" + aadhar + "', salary = '" + salary + "', education = '" + education + "' where employeeeid = '" + empId + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new ViewEmployee();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}

