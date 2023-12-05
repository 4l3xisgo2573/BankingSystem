package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JLabel text;
    JButton deposit, withdraw, fastcash, statement, pinchange, balance,transfer,exit, n1;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel("SELECT YOUR TRANSACTION");
        text.setBounds(235, 400, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 445, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(360, 445, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 485, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        pinchange = new JButton("Change your PIN");
        pinchange.setBounds(360, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Account balance");
        balance.setBounds(170, 525, 150, 30);
        balance.addActionListener(this);
        image.add(balance);
        
        statement = new JButton("Statements");
        statement.setBounds(360, 525, 150, 30);
        statement.addActionListener(this);
        image.add(statement);
        
        /*transfer = new JButton("Transfer");
        transfer.setBounds(170, 565, 150, 30);
        transfer.addActionListener(this);
        image.add(transfer);*/
        
        exit = new JButton("Exit");
        exit.setBounds(360, 565, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        /*
        n1 = new JButton("1");
        n1.setBounds(200, 700, 40, 40);
        n1.addActionListener(this);
        image.add(n1);*/
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
           System.exit(0);
        } else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource()== withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if (ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource()==statement){
            setVisible(false);
            //new Statements(pinnumber).setVisible(true);
        }else if (ae.getSource()==pinchange){
            setVisible(false);
            new Pin(pinnumber).setVisible(true);
        }else if (ae.getSource()==balance){
            setVisible(false);
            new BalanceCheck(pinnumber).setVisible(true);
        }else if (ae.getSource()==transfer){
            setVisible(false);
            //new Transfer(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("").setVisible(true);
    }

}
