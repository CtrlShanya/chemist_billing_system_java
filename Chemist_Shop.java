/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chemist_shop;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Chemist_Shop extends JFrame implements ActionListener
{
    Font f1 = new Font("Courier New", Font.ITALIC,36);
    JLabel l1, l2, l;
    JTextField t1;
    JPasswordField t2;
    JButton b1;
    public Chemist_Shop()
    {
        l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("Icon\\login1.png")));
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        b1 = new JButton("Login");
        l1.setFont(f1);
        l2.setFont(f1);
        t1.setFont(f1);
        t2.setFont(f1);
        b1.setFont(f1);
        add(l);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        b1.addActionListener(this);
        setLayout(new FlowLayout());
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            String q = "SELECT * FROM LOGIN WHERE USERNAME='"+u+"' AND PASSWORD='"+v+"'";
            ResultSet rs = c1.s.executeQuery(q);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Valid User");
                new Project().setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid User");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
        Chemist_Shop ch1 = new Chemist_Shop();
        ch1.setVisible(true);
        ch1.setSize(1000,1000);
        ch1.setLocation(200,200);
    }
    
}
