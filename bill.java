

package chemist_shop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class bill extends JFrame implements ActionListener
{
    JLabel j1, j2, j3, j4, l1, l2, l3, l4;
    Float a;
    Integer i1;
    JPanel p1;
    Font f1 = new Font("Courier New", Font.ITALIC,20);
    JTextField t1, t2, t3, a1, a2, a3, a4;
    Choice ch1;
    JButton b1;
    public bill(int cus_id, float total)
    {
        super("Chemist Shop Bill");
        a = total;
        i1 = cus_id;
        p1 = new JPanel();
        p1.setSize(1000, 1000);
        p1.setLocation(100,100);
        p1.setLayout(new GridLayout(8,2));
        j1 = new JLabel("Customer Name");
        j2 = new JLabel("Date and Time");
        j3 = new JLabel("Amount to be Paid");
        j4 = new JLabel("Mode of Payment");
        l1 = new JLabel("Amount Paid");
        b1 = new JButton("Pay");
        t1 = new JTextField(30);
        t2 = new JTextField(30);
        t3 = new JTextField(30);
        a1 = new JTextField(30);
        t1.setFont(f1);
        a1.setFont(f1);
        l1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        j1.setFont(f1);
        j2.setFont(f1);
        j3.setFont(f1);
        j4.setFont(f1);
        b1.setFont(f1);
        ch1 = new Choice();
        ch1.setFont(f1);
        p1.add(j1);
        p1.add(t1);
        p1.add(j2);
        p1.add(t2);
        p1.add(j3);
        p1.add(t3);
        p1.add(j4);
        p1.add(ch1);
        p1.add(l1);
        p1.add(a1);
        p1.add(b1, "South");
        try
        {
            conn c1 = new conn();
            String q = "SELECT NAME, DATE FROM CUSTOMER, BILL WHERE BILL.CUSTOMER_ID=CUSTOMER.CUSTOMER_ID AND BILL.CUSTOMER_ID="+cus_id;
            ResultSet rs = c1.s.executeQuery(q);
            String a = total+"";
            if(rs.next())
            {
                t1.setText(rs.getString("NAME"));
                t2.setText(rs.getString("DATE"));
                t3.setText(a);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        ch1.add("PayTM");
        ch1.add("Debit Card");
        ch1.add("Credit Card");
        ch1.add("Cash");
        ch1.add("Net Banking");
        add(p1, "North");
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("Pay"))
        {
            new bill_pay(a1.getText(), a, i1).setVisible(true);
        }
        else
        {
            System.out.println("ERROR");
        }
    }
    public static void main(String s[])
    {
        int x = 0;
        new bill(x, x).setVisible(true);
    }
}
