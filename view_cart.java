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

public class view_cart extends JFrame implements ActionListener
{
    JLabel l1;
    Integer u1;
    JTextArea a1;
    Panel p1;
    JTable j1;
    Choice ch;
    JButton b1, b2;
    String h[]={"Medicine ID", "Company", "Salt", "Price", "Quantity", "Expiry Date", "Amount"};
    String d[][], a;
    int i=0, j=0, m;
    float l=0, k=0;
    public  view_cart()
    {
        super("BILL");
        setSize(800, 500);
        setLocation(150, 150);
        l1 = new JLabel("Choose Customer ID");
        ch = new Choice();
        p1 = new Panel();
        b1 = new JButton("Show");
        b2 = new JButton("Print");
        p1.add(l1);
        a1 = new JTextArea(20, 50);
        p1.add(ch);
        p1.add(b1);
        try
        {
            String q = "SELECT * FROM CUSTOMER";
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery(q);
            while(rs.next())
            {
                ch.add(rs.getString("CUSTOMER_ID"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        add(p1, "North");
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("Show"))
        {
            setVisible(false);
            u1 = Integer.parseInt(ch.getSelectedItem());
            System.out.println(u1);
            try
            {
                String r = "SELECT MEDICINE.MEDICINE_ID, COMPANY, EXP_DATE, SALT, PRICE, QUANTITY, AMOUNT FROM BILL, MEDICINE WHERE CUSTOMER_ID="+u1+" AND BILL.MEDICINE_ID=MEDICINE.MEDICINE_ID";
                System.out.println(r);
                conn c1 = new conn();
                d = new String[25][7];
                ResultSet rs = c1.s.executeQuery(r);
                while(rs.next())
                {
                    d[i][j++]=rs.getString("MEDICINE_ID");
                    d[i][j++]=rs.getString("COMPANY");
                    d[i][j++]=rs.getString("SALT");
                    d[i][j++]=rs.getString("PRICE");
                    d[i][j++]=rs.getString("QUANTITY");
                    d[i][j++]=rs.getString("EXP_DATE");
                    d[i][j++]=rs.getString("AMOUNT");
                    i++;
                    j=0;
                }
                for(m=0;m<i;m++)
                {
                    l+=Float.parseFloat(d[m][6]);
                }
                d[i+1][j++]="Total";
                d[i+1][j]=l+"";
                j=0;
                j1 = new JTable(d, h);
                JScrollPane s1 = new JScrollPane(j1);
                add(s1);
                add(b2, "South");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            setVisible(true);
            i=0;
        }
        else
        {
            try
            {
                j1.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String s[])
    {
        new view_cart().setVisible(true);
    }
}
