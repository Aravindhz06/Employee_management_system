package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEmp;
    JButton delete, back;

    RemoveEmployee() {
        getContentPane().setBackground(new Color(255, 204, 204));
        setLayout(null);

        JLabel heading = new JLabel("Remove Employee");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(250, 20, 300, 30);
        add(heading);

        JLabel lblEmpId = new JLabel("Select Employee ID:");
        lblEmpId.setBounds(100, 100, 150, 30);
        lblEmpId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblEmpId);

        choiceEmp = new Choice();
        choiceEmp.setBounds(270, 100, 200, 30);
        add(choiceEmp);

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT employeeeid FROM employee");
            while (rs.next()) {
                choiceEmp.add(rs.getString("employeeeid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        delete = new JButton("Delete");
        delete.setBounds(200, 180, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(350, 180, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(600, 300);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    conn c = new conn();
                    String empId = choiceEmp.getSelectedItem();
                    c.statement.executeUpdate("DELETE FROM employee WHERE employeeeid = '" + empId + "'");
                    JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");

                    // refresh choice box
                    choiceEmp.remove(empId);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Main();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
