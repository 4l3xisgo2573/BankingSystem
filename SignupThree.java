package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignupTree extends JFrame implements ActionListener{
    
    JLabel accDetails,accType,cardNo,number,digits,atm,pin,hidePin,pass,services,form,formDetail;
    JRadioButton r1,r2,r3,r4;
    JButton submit,cancel;
    JCheckBox service1,service2,service3,service4,service5,service6,service7;
    String formno;
    SignupTree(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Bank-Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(100, 0, 100, 100);
        add(img);
        
        accDetails = new JLabel("Page 3: Account Details");
        accDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
        accDetails.setBounds(280,40,400,40);
        add(accDetails); 
        
        accType = new JLabel("Account Type:");
        accType.setFont(new Font("Times New Roman", Font.BOLD, 20));
        accType.setBounds(100,140,200,30);
        add(accType);
        
        cardNo = new JLabel("Card Number:");
        cardNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cardNo.setBounds(100,300,200,30);
        add(cardNo);
        
        number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Times New Roman", Font.BOLD, 20));
        number.setBounds(330,300,250,30);
        add(number);
        
        digits = new JLabel("(Your 16-digit Card number)");
        digits.setFont(new Font("Times New Roman", Font.BOLD, 12));
        digits.setBounds(100,330,200,20);
        add(digits);
        
        atm = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        atm.setFont(new Font("Times New Roman", Font.BOLD, 12));
        atm.setBounds(330,330,500,20);
        add(atm);
        
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Times New Roman", Font.BOLD, 18));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        hidePin = new JLabel("XXXX");
        hidePin.setFont(new Font("Times New Roman", Font.BOLD, 18));
        hidePin.setBounds(330,370,200,30);
        add(hidePin);
    
        pass = new JLabel("(4-digit password)");
        pass.setFont(new Font("Times New Roman", Font.BOLD, 12));
        pass.setBounds(100,400,200,20);
        add(pass);
    
        services = new JLabel("Services Required:");
        services.setFont(new Font("Times New Roman", Font.BOLD, 18));
        services.setBounds(100,450,200,30);
        add(services);
        
        
        formDetail = new JLabel(formno);
        formDetail.setFont(new Font("Times New Roman", Font.BOLD, 14));  
        formDetail.setBounds(770,10,40,30);
        add(formDetail);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Times New Roman", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(480,600,100,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(620,600,100,30);
        add(cancel);
        cancel.addActionListener(this);
       
        service1 = new JCheckBox("ATM CARD");
        service1.setBackground(Color.WHITE);
        service1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        service1.setBounds(100,500,200,30);
        add(service1);
        
        service2 = new JCheckBox("Internet Banking");
        service2.setBackground(Color.WHITE);
        service2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        service2.setBounds(350,500,200,30);
        add(service2);
        
        service3 = new JCheckBox("Mobile Banking");
        service3.setBackground(Color.WHITE);
        service3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        service3.setBounds(100,550,200,30);
        add(service3);

        service4 = new JCheckBox("EMAIL Alerts");
        service4.setBackground(Color.WHITE);
        service4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        service4.setBounds(350,550,200,30);
        add(service4);
        
        service5 = new JCheckBox("Cheque Book");
        service5.setBackground(Color.WHITE);
        service5.setFont(new Font("Times New Roman", Font.BOLD, 16));
        service5.setBounds(100,600,200,30);
        add(service5);
        
        service6 = new JCheckBox("E-Statement");
        service6.setBackground(Color.WHITE);
        service6.setFont(new Font("Times New Roman", Font.BOLD, 16));
        service6.setBounds(350,600,200,30);
        add(service6);
        
        service7 = new JCheckBox("Yes, I have read and accept the general terms and conditions.",true);
        service7.setBackground(Color.WHITE);
        service7.setFont(new Font("Times New Roman", Font.BOLD, 14));
        service7.setBounds(100,680,600,20);
        add(service7);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,30);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,300,30);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,30);
        add(r3);
       
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,30);
        add(r4);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);
        
        setLayout(null);    

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(500,120);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        String atype = null;
        if(r1.isSelected()){ 
            atype = "Saving Account";
        }
        else if(r2.isSelected()){ 
            atype = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){ 
            atype = "Current Account";
        }else if(r4.isSelected()){ 
            atype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long card = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(card);
        
        long pinn = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(pinn);
        
        String facility = "";
        if(service1.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(service2.isSelected()){ 
            facility = facility + " Online Banking";
        }
        if(service3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(service4.isSelected()){ 
            facility = facility + " email Alerts";
        }
        if(service5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(service6.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try{
            if(ae.getSource()==submit){
                
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn c3 = new Conn();
                    String qs1 = "insert into signupThree values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    String qs2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c3.s.executeUpdate(qs1);
                    c3.s.executeUpdate(qs2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    setVisible(false);
                    new Deposit(pin).setVisible(false);
                    
                }
            
            }else if(ae.getSource()==cancel){
                setVisible(false);
                new Login().setVisible(true);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new SignupTree("").setVisible(true);
    }
    
}
