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

public class user_account extends JFrame implements ActionListener
{
    JTextField t1;
    JPasswordField p1, p2;
    JLabel l1, l2, l3;
    JButton b1;
    Font f1 = new Font("Courier New", Font.ITALIC,26);
    public user_account()
    {
        setBackground(Color.pink);
        setSize(1000,1000);
        setLocation(200,200);
        setLayout(new FlowLayout());
        setFont(f1);
        l1 = new JLabel("Username");
        l2 = new JLabel("PAssword");
        l3 = new JLabel("Confirm Password");
        t1 = new JTextField(20);
        p1 = new JPasswordField(20);
        p2 = new JPasswordField(20);
        l1.setFont(f1);
        t1.setFont(f1);
        l2.setFont(f1);
        p1.setFont(f1);
        l3.setFont(f1);
        p2.setFont(f1);
        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(l3);
        add(p2);
        b1 = new JButton("Submit");
        add(b1);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String q = "INSERT INTO LOGIN VALUES('"+t1.getText()+"', '"+p1.getText()+"')";
        String one = p1.getText();
        String two  = p2.getText();
        if(one.equals(two)==true)
        {
            try
            {
                conn c1 = new conn();
                c1.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "New USer Account Created");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(one.equals(two)==false)
        {
            JOptionPane.showMessageDialog(null, "Passwords aren't equal");
        }
    }
    public static void main(String s[])
    {
        new user_account().setVisible(true);
    }
}
