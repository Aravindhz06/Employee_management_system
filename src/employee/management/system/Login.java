package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;
    Login(){
        JLabel username=new JLabel("Username:");
        username.setBounds(40,20,100,50);
        add(username);

        tusername=new JTextField();
        tusername.setBounds(140,32,100,30);
        add(tusername);

        JLabel password=new JLabel("Password:");
        password.setBounds(40,70,100,50);
        add(password);

        tpassword=new JPasswordField();
        tpassword.setBounds(140,82,100,30);
        add(tpassword);


        login=new JButton("LOGIN");
        login.setBounds(140,140,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.yellow);
        login.addActionListener(this);
        add(login);

        back=new JButton("BACK");
        back.setBounds(140,180,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.green);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(getClass().getResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(620,0,1000,500);
        add(image);

        ImageIcon i11=new ImageIcon(getClass().getResource("icons/LoginB.jpg"));
        Image i22=i11.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel imagee=new JLabel(i33);
        imagee.setBounds(0,0,1000,500);
        add(imagee);

        setSize(1000,500);
        setLayout(null);
        setLocation(250,200);
        setVisible(true);




}
@Override
 public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            try{
                String username=tusername.getText();
                String password=tpassword.getText();

                conn conn=new conn();
                String query="select * from login where username='"+username+"' and user_password='"+password+"'";
                ResultSet resultSet=conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Inavlid username or password");
                }
            }
            catch(Exception f){
                f.printStackTrace();
            }
        }
        else if(e.getSource()==back){
            System.exit(300);
        }
 }
public static void main(String[] args) {
        new Login();
    }
}
