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

public class delete_medicine extends JFrame implements ActionListener, ItemListener
{
    Font f1 = new Font("Courier New", Font.ITALIC,26);
    JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, l;
    JTextField t2, t3, t4, t5, t6, t7, t8, t9, t10;
    JButton b1;
    Choice ch1;
    public delete_medicine()
    {
        setSize(1000, 1000);
        setLocation(100,100);
        setLayout(new GridLayout(10,2));
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
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);
        t8.setFont(f1);
        t9.setFont(f1);
        t10.setFont(f1);
        ch1 = new Choice();
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
        add(j1);
        add(ch1);
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
        b1 = new JButton("Delete");
        b1.addActionListener(this);
        add(b1);
    }
    public void actionPerformed(ActionEvent ae)
    {
        int n = JOptionPane.showConfirmDialog(this, null, "Are you sure you want to delete Medicine Record?", JOptionPane.YES_NO_OPTION);
        if(n!=0)
            return;
        String q = "DELETE FROM MEDICINE WHERE MEDICINE_ID="+ch1.getSelectedItem();
        try
        {
            conn c1 = new conn();
            c1.s.executeUpdate(q);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Medicine Record Deleted");
    }
    public void itemStateChanged(ItemEvent ie)
    {
        String q1 = "SELECT * FROM MEDICINE WHERE MEDICINE_ID="+ch1.getSelectedItem();;
        try
        {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery(q1);
            if(rs.next())
            {
                t2.setText(rs.getString("BATCH_NO"));
                t3.setText(rs.getString("DESCRIPTION"));
                t4.setText(rs.getString("MANU_DATE"));
                t5.setText(rs.getString("EXP_DATE"));
                t6.setText(rs.getString("SALT"));
                t7.setText(rs.getString("COMPANY"));
                t8.setText(rs.getString("QUANT"));
                t9.setText(rs.getString("ROL"));
                t10.setText(rs.getString("PRICE"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String s[])
    {
        new delete_medicine().setVisible(true);
    }
}
