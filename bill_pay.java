/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chemist_shop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author shany
 */
public class bill_pay extends JFrame implements ActionListener
{
    JLabel l4, l2, l3;
    JButton b1;
    Integer i1;
    Float balance;
    JTextField a4, a2, a3;
    Font f1 = new Font("Courier New", Font.ITALIC,20);
    public bill_pay(String total, float a, int cust_id)
    {
        setLayout(new GridLayout(4,2));
        setSize(1000, 400);
        setLocation(100, 100);
            float x = Float.parseFloat(total);
            String am = x+"";
            i1 = cust_id;
        l4 = new JLabel("Amount Paid");
        l2 = new JLabel("Total Bill Amount");
        l3 = new JLabel("Balance");
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        a2 = new JTextField(30);
        a4 = new JTextField(30);
        a3 = new JTextField(30);
        b1 = new JButton("Confirm Payment");
        b1.setFont(f1);
        b1.addActionListener(this);
        a2.setFont(f1);
        a3.setFont(f1);
        a4.setFont(f1);
        add(l4);
        add(a4);
        add(l2);
        add(a2);
        add(l3);
        add(a3);
        add(b1);
        String f = a+"";
        a2.setText(f);
        a4.setText(am);
        float b = x-a;
        balance = b;
        String bal = b+"";
        a3.setText(bal);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("Confirm Payment"))
        {
            int n = JOptionPane.showConfirmDialog(this, null, "Confirm Payment?", JOptionPane.YES_NO_OPTION);
            if(n!=0)
                return;
            else
            {
                //String q1 = "UPDATE BILL SET STATUS='P' WHERE CUSTOMER_ID="+i1;
                String r1 = "SELECT * FROM BILL WHERE CUSTOMER_ID="+i1+" AND STATUS='NP'";
                System.out.println(r1);
                String r2 = "";
                int x=0, med_id=0;
                try
                {
                    conn c2 = new conn();
                    ResultSet rs1 = c2.s.executeQuery(r1);
                    while(rs1.next())
                    {
                        x = Integer.parseInt(rs1.getString("QUANTITY"));
                        System.out.println(x);
                        med_id = Integer.parseInt(rs1.getString("MEDICINE_ID"));
                        System.out.println(med_id);
                        r2 = "UPDATE MEDICINE SET QUANT=QUANT-"+x+" WHERE MEDICINE_ID="+med_id;
                        conn c3 = new conn();
                        c3.s.executeUpdate(r2);
                    }
                    //c2.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Transaction Complete!");
                    new view_cart3(i1, balance).setVisible(true);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String s[])
    {
        float a = 20;
        new bill_pay("1200", a,1).setVisible(true);
    }
    
}
