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

public class new_medicine extends JFrame implements ActionListener
{
    Font f1 = new Font("Courier New", Font.ITALIC,26);
    JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, l;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    JButton b1;
    public new_medicine()
    {
        setSize(1000, 1000);
        setLocation(100,100);
        //setFont(f1);
        setLayout(new GridLayout(12,2));
        j1 = new JLabel("Medicine ID");
        j2 = new JLabel("Batch No.");
        j3 = new JLabel("Description");
        j4 = new JLabel("Manufacturing Date");
        j5 = new JLabel("Expiry Date");
        j6 = new JLabel("Salt");
        j7 = new JLabel("Company");
        j8 = new JLabel("Quantity");
        j9 = new JLabel("ROL");
        j10 = new JLabel("Price");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(100);
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        t6 = new JTextField(20);
        t7 = new JTextField(20);
        t8 = new JTextField(20);
        t9 = new JTextField(20);
        t10 = new JTextField(20);
        j1.setFont(f1);
        j2.setFont(f1);
        j3.setFont(f1);
        j4.setFont(f1);
        j5.setFont(f1);
        j6.setFont(f1);
        j7.setFont(f1);
        j8.setFont(f1);
        j9.setFont(f1);
        j10.setFont(f1);
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);
        t8.setFont(f1);
        t9.setFont(f1);
        t10.setFont(f1);
        add(j1);
        add(t1);
        add(j2);
        add(t2);
        add(j3);
        add(t3);
        add(j4);
        add(t4);
        add(j5);
        add(t5);
        add(j6);
        add(t6);
        add(j7);
        add(t7);
        add(j8);
        add(t8);
        add(j9);
        add(t9);
        add(j10);
        add(t10);
        b1 = new JButton("Submit");
        b1.addActionListener(this);
        add(b1);
    }
    public void actionPerformed(ActionEvent ae)
    {
        int x = Integer.parseInt(t1.getText());
        int y = Integer.parseInt(t2.getText());
        int z = Integer.parseInt(t8.getText());
        int w = Integer.parseInt(t9.getText());
        float p = Float.parseFloat(t10.getText());
        String q = "INSERT INTO MEDICINE VALUES("+x+", "+y+", '"+t3.getText()+"', '"+t4.getText()+"', '"+t5.getText()+"', '"+t6.getText()+"', '"+t7.getText()+"', "+z+", "+w+", "+p+")";
        System.out.println(q);
        try
        {
            conn c1 = new conn();
            c1.s.executeUpdate(q);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "New Medicine Added");
    }
    public static void main(String s[])
    {
        new new_medicine().setVisible(true);
    }
}
