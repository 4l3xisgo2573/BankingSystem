package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField field1,field2;
    JButton change,back;                               
    JLabel pintext,newpin,confirmpin;
    String pinnumber;
    Pin(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        
        pintext = new JLabel("CHANGE YOUR PIN");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(280,330,800,35);
        image.add(pintext);
        
        newpin = new JLabel("New PIN:");
        newpin.setFont(new Font("System", Font.BOLD, 14));
        newpin.setForeground(Color.WHITE);
        newpin.setBounds(180,390,120,35);
        image.add(newpin);
        
        confirmpin = new JLabel("Re-Enter the PIN:");
        confirmpin.setFont(new Font("System", Font.BOLD, 14));
        confirmpin.setForeground(Color.WHITE);
        confirmpin.setBounds(180,440,120,35);
        image.add(confirmpin);
        
        field1 = new JPasswordField();
        field1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        field1.setBounds(320,390,180,25);
        image.add(field1);
        
        field2 = new JPasswordField();
        field2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        field2.setBounds(320,440,180,25);
        image.add(field2);
        
        change = new JButton("Change");
        change.setBounds(320,500,150,35);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(320,550,150,35);
        image.add(back);
        
        change.addActionListener(this);
        back.addActionListener(this);
        
        setLayout(null);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = field1.getText();
            String rpin = field2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "PIN does not match");
                return;
            }
            
            if(ae.getSource()==change){
                if (field1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter a new PIN");
                }
                if (field2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter the new PIN");
                }
                
                Conn c = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q3 = "update signupThree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN successfully changed");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==back){
                new Transactions(pinnumber).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}
