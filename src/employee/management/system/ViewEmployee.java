package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    JButton searchbt, print, update, back, delete;
    JComboBox<String> empCombo;

    ViewEmployee() {
        getContentPane().setBackground(new Color(255, 182, 193));

        JLabel search = new JLabel("Search by emp id");
        search.setFont(new Font("timesnewroman", Font.BOLD, 25));
        search.setBounds(20, 20, 250, 30);
        add(search);

        empCombo = new JComboBox<>();
        empCombo.setBounds(250, 22, 150, 30);
        empCombo.setBackground(Color.WHITE);
        empCombo.setForeground(Color.BLACK);
        add(empCombo);

        // Fill ComboBox with employee IDs
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                empCombo.addItem(resultSet.getString("employeeeid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) {
            E.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        searchbt = new JButton("Search");
        searchbt.setBounds(90, 70, 80, 20);
        searchbt.setBackground(Color.BLACK);
        searchbt.setForeground(Color.WHITE);
        searchbt.addActionListener(this);
        add(searchbt);

        print = new JButton("Print");
        print.setBounds(200, 70, 80, 20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(310, 70, 80, 20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(420, 70, 80, 20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        delete = new JButton("Delete");
        delete.setBounds(530, 70, 80, 20);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbt) {
            conn c = new conn();
            String query = "SELECT * FROM employee WHERE employeeeid = '" + empCombo.getSelectedItem().toString() + "'";
            try {
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(empCombo.getSelectedItem().toString());
        } else if (e.getSource() == delete) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    conn c = new conn();
                    String empid = empCombo.getSelectedItem().toString();
                    String query = "DELETE FROM employee WHERE employeeeid = '" + empid + "'";
                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Employee deleted successfully.");
                    setVisible(false);
                    new ViewEmployee(); // refresh the page
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            setVisible(false);
            new Main();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
