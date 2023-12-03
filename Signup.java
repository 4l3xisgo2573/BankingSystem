package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.random;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Signup extends JFrame implements ActionListener {
    
    JLabel formno,personDetails,name,pname,dob,gender,email,status,address,city,state,pincode;
    JTextField namefield,fnamefield,emailfield,addressfield,cityfield,statefield,pincodefield;
    JRadioButton male,female,single,married,other;
    JButton next;
    JDateChooser dateChooser;
    
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);
    
    Signup(){
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Bank-Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(100, 0, 100, 100);
        add(img);
        
        formno = new JLabel("APPLICATION FORM NO. " + first);
        formno.setFont(new Font("Times New Roman", Font.BOLD, 36));
        formno.setBounds(250, 40, 600, 40);
        add(formno);
        
        personDetails = new JLabel("Page 1: Personal Details ");
        personDetails.setFont(new Font("Times New Roman", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);
        
        name = new JLabel("Name: ");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        namefield = new JTextField();
        namefield.setFont(new Font("calibri", Font.PLAIN, 14));
        namefield.setBounds(300, 140, 400, 30);
        add(namefield);
        
        pname = new JLabel("Parent's Name: ");
        pname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pname.setBounds(100, 190, 200, 30);
        add(pname);

        fnamefield = new JTextField();
        fnamefield.setFont(new Font("calibri", Font.PLAIN, 14));
        fnamefield.setBounds(300, 190, 400, 30);
        add(fnamefield);
        
        dob = new JLabel("Day of Birth: ");
        dob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setFont(new Font("calibri", Font.BOLD, 14));
        add(dateChooser);
        
        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Times New Roman", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60,  30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 90,  30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        email = new JLabel("Email Address: ");
        email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email); 
        
        emailfield = new JTextField();
        emailfield.setFont(new Font("calibri", Font.PLAIN, 14));
        emailfield.setBounds(300, 340, 400, 30);
        add(emailfield);
        
        status = new JLabel("Marital Status: ");
        status.setFont(new Font("Times New Roman", Font.BOLD, 20));
        status.setBounds(100, 390, 200, 30);
        add(status); 
        
        single = new JRadioButton("Single");
        single.setBounds(300, 390, 100,  30);
        single.setBackground(Color.white);
        add(single);
        
        married = new JRadioButton("Married");
        married.setBounds(450, 390, 100,  30);
        married.setBackground(Color.white);
        add(married);
        
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100,  30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup statusgroup = new ButtonGroup();
        statusgroup.add(single);
        statusgroup.add(married);
        statusgroup.add(other);
        
        
        address = new JLabel("Address: ");
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressfield = new JTextField();
        addressfield.setFont(new Font("calibri", Font.PLAIN, 14));
        addressfield.setBounds(300, 440, 400, 30);
        add(addressfield);       
        
        city = new JLabel("City: ");
        city.setFont(new Font("Times New Roman", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city); 
        
        cityfield = new JTextField();
        cityfield.setFont(new Font("calibri", Font.PLAIN, 14));
        cityfield.setBounds(300, 490, 400, 30);
        add(cityfield); 
        
        state = new JLabel("State: ");
        state.setFont(new Font("Times New Roman", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state); 
        
        statefield = new JTextField();
        statefield.setFont(new Font("calibri", Font.PLAIN, 14));
        statefield.setBounds(300, 540, 400, 30);
        add(statefield);
        
        pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pincodefield = new JTextField();
        pincodefield.setFont(new Font("calibri", Font.PLAIN, 14));
        pincodefield.setBounds(300, 590, 400, 30);
        add(pincodefield);
        
        next = new JButton("Next");
        next.setBackground(Color.orange);
        next.setForeground(Color.white);
        next.setFont(new Font("calibri", Font.BOLD, 14));
        next.setBounds(660, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        //TEST
        JLabel test = new JLabel("");
        test.setFont(new Font("Times New Roman", Font.BOLD, 36));
        test.setBounds(300, 400, 100, 40);
        add(test);
        
        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setVisible(true);
        setLocation(350, 10);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = first;
        String name  = namefield.getText();
        String pname  = fnamefield.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
         if(male.isSelected()){ 
            gender = "Male";
        }else if(female.isSelected()){ 
            gender = "Female";
        }
            
        String email = emailfield.getText();
        String status = null;
        if(married.isSelected()){ 
            status = "Married";
        }else if(single.isSelected()){ 
            status = "Single";
        }else if(other.isSelected()){ 
            status = "Other";
        }
        String address = addressfield.getText();
        String city = cityfield.getText();
        String pincode = pincodefield.getText();
        String state = statefield.getText();
        
        try{   
            if(namefield.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c = new Conn();
                String q1 = "insert into signup values('"+formno+"','"+name+"','"+pname+"','"+dob+"','"+gender+"','"+email+"','"+status+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(q1);
                
                setVisible(false);
                //new Signup2(formno).setVisible(true);
            }
            
        }catch(Exception e){
             e.printStackTrace();
        }

    }
    
    public static void main(String args[]){
        new Signup().setVisible(true);
    }

    
}
