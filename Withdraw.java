package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{
    
  JTextField t1;
    JButton draw,back;
    JLabel l1,l2;
    String pinnumber;
    Withdraw(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        l1 = new JLabel("The Maximum Withdrawal allowed is $2,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(170,350,400,20);
        image.add(l1);
        
        l2 = new JLabel("");
        l2.setForeground(Color.black);
        l2.setFont(new Font("System", Font.BOLD, 10));
        l2.setBounds(170,400,300,20);
        image.add(l2);
        
        t1 = new JTextField();
        t1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        t1.setBounds(170,400,330,30);
        image.add(t1);
        
        draw = new JButton("Withdraw");
        back = new JButton("Back");

        draw.setBounds(270,460,150,35);
        image.add(draw);
        
        back.setBounds(270,520,150,35);
        image.add(back);
        
        draw.addActionListener(this);
        back.addActionListener(this);
        
             setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==draw){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "$"+amount+" successful withdrawal");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new Withdraw("").setVisible(true);
    }
}
