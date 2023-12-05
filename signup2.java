package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class signup2 extends JFrame implements ActionListener{
    JLabel details,category,income,educational,ocupation,ssn,id,citizen,exacc,qualification,form,fnumb;
    JButton next;
    JRadioButton seniorY,seniorN,accY,accN;
    JTextField tfield1,tfield2;
    JComboBox type,inc,ed,ocup;
    String formno;
    
    signup2(String formno){
        this.formno = formno;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Bank-Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(100, 0, 100, 100);
        add(img);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        details = new JLabel("Page 2: Additonal Details");
        details.setFont(new Font("Times New Roman", Font.BOLD, 22));
        details.setBounds(280,30,600,40);
        add(details);
        
        category = new JLabel("Category:");
        category.setFont(new Font("Times New Roman", Font.BOLD, 20));
        category.setBounds(100,170,100,30);
        add(category);
        
        income = new JLabel("Income:");
        income.setFont(new Font("Times New Roman", Font.BOLD, 20));
        income.setBounds(100,220,100,30);
        add(income);
        
        educational = new JLabel("Educational");
        educational.setFont(new Font("Times New Roman", Font.BOLD, 20));
        educational.setBounds(100,270,150,30);
        add(educational);
                
        
        qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Times New Roman", Font.BOLD, 20));
        qualification.setBounds(100,290,150,30);
        add(qualification);
        
        ocupation = new JLabel("Occupation:");
        ocupation.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ocupation.setBounds(100,340,150,30);
        add(ocupation);
        
        ssn = new JLabel("Social Security Number:");
        ssn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ssn.setBounds(100,390,250,30);
        add(ssn);
        
        id = new JLabel("ID Number:");
        id.setFont(new Font("Times New Roman", Font.BOLD, 20));
        id.setBounds(100,440,180,30);
        add(id);
        
        citizen = new JLabel("Senior Citizen:");
        citizen.setFont(new Font("Times New Roman", Font.BOLD, 20));
        citizen.setBounds(100,490,150,30);
        add(citizen);
        
        seniorY = new JRadioButton("Yes");
        seniorY.setBackground(Color.WHITE);
        seniorY.setBounds(350,490,100,30);
        add(seniorY);
        
        seniorN = new JRadioButton("No");
        seniorN.setBackground(Color.WHITE);
        seniorN.setBounds(460,490,100,30);
        add(seniorN);
        
        ButtonGroup senior = new ButtonGroup();
        senior.add(seniorY);
        senior.add(seniorN);
        
        
        exacc = new JLabel("Existing Account:");
        exacc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        exacc.setBounds(100,540,180,30);
        add(exacc);
        
        accY = new JRadioButton("Yes");
        accY.setBackground(Color.WHITE);     
        accY.setBounds(350,540,100,30);
        add(accY);
        
        accN = new JRadioButton("No");
        accN.setBackground(Color.WHITE);
        accN.setBounds(460,540,100,30);
        add(accN);
        
        ButtonGroup account = new ButtonGroup();
        account.add(accY);
        account.add(accN);
        
        fnumb = new JLabel(formno);
        fnumb.setFont(new Font("Times New Roman", Font.BOLD, 14));
        fnumb.setBounds(760,10,60,30);
        add(fnumb);
        
        
        tfield1 = new JTextField();
        tfield1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tfield1.setBounds(350,390,320,30);
        add(tfield1);
        
        tfield2 = new JTextField();
        tfield2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tfield2.setBounds(350,440,320,30);
        add(tfield2);

        String category[] = {"Checking account","Savings account","Money market account","Retirement Account","Other"};
        type = new JComboBox(category);
        type.setBackground(Color.WHITE);
        type.setFont(new Font("Times New Roman", Font.BOLD, 14));
        type.setBounds(350,170,320,30);
        add(type);
        
        String income[] = {"Null","aprox. $150,000","aprox. $250,000","aprox. $500,000"," Above $1,000,000","Up to $1,000,000"};
        inc = new JComboBox(income);
        inc.setBackground(Color.WHITE);
        inc.setFont(new Font("Times New Roman", Font.BOLD, 14));
        inc.setBounds(350,220,320,30);
        add(inc); 
        
        String education[] = {"Undergraduate","Graduate","Post-Graduate","Doctrate","Others"};
        ed = new JComboBox(education);
        ed.setBackground(Color.WHITE);
        ed.setFont(new Font("Times New Roman", Font.BOLD, 14));
        ed.setBounds(350,270,320,30);
        add(ed);
 
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        ocup = new JComboBox(occupation);
        ocup.setBackground(Color.WHITE);
        ocup.setFont(new Font("Times New Roman", Font.BOLD, 14));
        ocup.setBounds(350,340,320,30);
        add(ocup);
        
        next = new JButton("Next");
        next.setFont(new Font("Times New Roman", Font.BOLD, 14));
        next.setBackground(Color.orange);
        next.setForeground(Color.white);
        next.setBounds(570,600,100,30);
        add(next);
        next.addActionListener(this);
       
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(850,750);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String category = (String)type.getSelectedItem();
        String income = (String)inc.getSelectedItem();
        String education = (String)ed.getSelectedItem();
        String occupation = (String)ocup.getSelectedItem();
        
        String ssn = tfield1.getText();
        String id = tfield2.getText();
        String citizen = null;
         if(seniorY.isSelected()){ 
            citizen = "Yes";
        }else if(seniorN.isSelected()){ 
            citizen = "No";
        }
        String existaccount = "";
        if(accY.isSelected()){ 
            existaccount = "Yes";
        }else if(accN.isSelected()){ 
            existaccount = "No";
        }
    
        try{
            if(tfield2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c = new Conn();
                String q1 = "insert into signupTwo values('"+formno+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+ssn+"','"+id+"','"+citizen+"','"+existaccount+"')";
                c.s.executeUpdate(q1);
                
                new SignupTree(formno).setVisible(true);
                setVisible(false);
            }   
        }catch(Exception ex){
             ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new signup2("").setVisible(true);
    }
}
