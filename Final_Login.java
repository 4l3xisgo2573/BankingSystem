package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField  cardTextField, nameTextField;
    JPasswordField pinTextField;
    
    Login(){
        
        setTitle("Bank Management System");
        //70 10 100 100
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icons/Bank-Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,  10, 100, 100);
        add(label);
        
        //WELCOME TITLE
        JLabel card_no = new JLabel("Welcome to ATM");
        card_no.setFont(new Font("Times New Roman", Font.BOLD, 36));
        card_no.setBounds(200, 40, 400, 40);
        add(card_no);
        
        //CARD 120 150 150 30
        JLabel text = new JLabel("Card number:");
        text.setFont(new Font("Times New Roman", Font.BOLD, 20));
        text.setBounds(120, 150, 150, 30);
        add(text);
        
        //CARD FIELD  300 150 230 30
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("calibri", Font.PLAIN,14));
        add(cardTextField);
        
        //PIN 120 220 250 30
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        //PIN FIELD 300 220 230 30
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("calibri", Font.PLAIN,14));
        add(pinTextField);
       
        // SIGN IN  BUTTON 300 300 100 30
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.orange);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        // CLEAR BUTTON 430 300 100 30
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.orange);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        //SIGN UP  300 350 230 30
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.orange);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);       
  
          //TEST
        JLabel test = new JLabel("");
        test.setFont(new Font("Times New Roman", Font.BOLD, 36));
        test.setBounds(300, 400, 100, 40);
        add(test);
        
        getContentPane().setBackground(Color.white);
        
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource()==login){
        
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup().setVisible(true);
            
        }
    
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}
