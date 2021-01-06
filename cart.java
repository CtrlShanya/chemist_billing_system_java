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

public class cart extends JFrame implements ActionListener, ItemListener
{
    Font f1 = new Font("Courier New", Font.ITALIC,26);
    JLabel l1, l2, l3, l4, l5, l6, l7;
    Choice ch1, ch2;
    JTextField t1, t2, t3, t4;
    JButton b1, b2;
    public cart()
    {
        setSize(1000, 1000);
        setLocation(100,100);
        setLayout(new GridLayout(8,2));
        l1 = new JLabel("Medicine ID");
        l1.setFont(f1);
        l2 = new JLabel("Company");
        l2.setFont(f1);
        l3 = new JLabel("Salt");
        l3.setFont(f1);
        l4 = new JLabel("Price");
        l4.setFont(f1);
        l5 = new JLabel("Quantity");
        l5.setFont(f1);
        l7 = new JLabel("Customer ID");
        l7.setFont(f1);
        t1 = new JTextField(30);
        t1.setFont(f1);
        t2 = new JTextField(30);
        t2.setFont(f1);
        t3 = new JTextField(30);
        t3.setFont(f1);
        t4 = new JTextField(30);
        t4.setFont(f1);
        b1 = new JButton("Add to Cart");
        b1.setFont(f1);
        b2 = new JButton("View Cart");
        b2.setFont(f1);
        ch1 = new Choice();
        ch1.setFont(f1);
        try
        {
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM MEDICINE");
            while(rs.next())
            {
                ch1.add(rs.getString("MEDICINE_ID"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        ch1.addItemListener(this);
        ch2 = new Choice();
        ch2.setFont(f1);
        try
        {
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM CUSTOMER");
            while(rs.next())
            {
                ch2.add(rs.getString("CUSTOMER_ID"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        ch2.addItemListener(this);
        add(l7);
        add(ch2);
        add(l1);
        add(ch1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(l4);
        add(t3);
        add(l5);
        add(t4);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        float x = Float.parseFloat(t4.getText());
        float y = Float.parseFloat(t3.getText());
        float product = x*y;
        int cus_id = Integer.parseInt(ch2.getSelectedItem());
        int med_id = Integer.parseInt(ch1.getSelectedItem());
        String msg = ae.getActionCommand();
        if(msg.equals("Add to Cart"))
        {
            String t = new java.util.Date().toString();
            String q1 = "INSERT INTO BILL VALUES(NULL,"+cus_id+", "+med_id+", "+x+", "+product+", 'NP', '"+t+"')";
            //String r1 = "UPDATE MEDICINE SET QUANT=QUANT-"+x+" WHERE MEDICINE_ID="+med_id;
            try
            {
                conn c1 = new conn();
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Item Added to Cart");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(msg.equals("View Cart"))
        {
            new view_cart2(cus_id).setVisible(true);
        }
    }
    public void itemStateChanged(ItemEvent ie)
    {
        String q1 = "SELECT * FROM MEDICINE WHERE MEDICINE_ID="+ch1.getSelectedItem();
        try
        {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery(q1);
            if(rs.next())
            {
                t1.setText(rs.getString("COMPANY"));
                t2.setText(rs.getString("SALT"));
                t3.setText(rs.getString("PRICE"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String s[])
    {
        new cart().setVisible(true);
    }
}
