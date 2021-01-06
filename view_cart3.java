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
import javax.swing.UIManager.*;

public class view_cart3 extends JFrame implements ActionListener
{
    JLabel name, byline, address, thanks, total, bal;
    JTextField t1, t2, t3;
    Integer u1;
    Float u2;
    Font f1 = new Font("Courier New", Font.ITALIC,26);
    Font f2 = new Font("Courier New", Font.ITALIC,18);
    String h[]={"Company", "Price", "Quantity", "Amount"};
    String d[][], a;
    int i=0, j=0, m;
    float l=0, k=0;
    JTable j1;
    JButton b1;
    public view_cart3(int cus_id, float balance)
    {
        setLocation(100, 100);
        setSize(800, 1200);
        name = new JLabel("Shanya's Chemist Shop     ");
        address = new JLabel("SCO-65, Sector 16B, Chandigarh, 160016");
        thanks = new JLabel("    Thanks for shopping!        ");
        total = new JLabel("        Total Amount: ");
        bal =  new JLabel("         Balance: ");
        total.setFont(f1);
        bal.setFont(f1);
        name.setFont(f1);
        address.setFont(f1);
        thanks.setFont(f1);
        b1 = new JButton("Print Receipt");
        b1.setFont(f1);
        b1.addActionListener(this);
        setLayout(new FlowLayout());
        add(name);
        add(address);
        u1 = cus_id;
        System.out.println(u1);
        try
        {
            String r = "SELECT COMPANY, PRICE, QUANTITY, AMOUNT FROM BILL, MEDICINE WHERE CUSTOMER_ID="+u1+" AND BILL.MEDICINE_ID=MEDICINE.MEDICINE_ID AND STATUS='NP'";
            System.out.println(r);
            String r2 = "SELECT COUNT(*) FROM BILL WHERE STATUS='NP' AND CUSTOMER_ID='"+u1+"'";
            String q1 = "UPDATE BILL SET STATUS='P' WHERE CUSTOMER_ID="+u1;
            System.out.println(r2);
                conn c1 = new conn();
                ResultSet rs1 = c1.s.executeQuery(r2);
                int num=0;
                if(rs1.next())
                    num=Integer.parseInt(rs1.getString("count(*)"));
                System.out.println(num);
                d = new String[num][4];
                ResultSet rs = c1.s.executeQuery(r);
                while(rs.next())
                {
                    d[i][j++]=rs.getString("COMPANY");
                    d[i][j++]=rs.getString("PRICE");
                    d[i][j++]=rs.getString("QUANTITY");
                    d[i][j++]=rs.getString("AMOUNT");
                    i++;
                    j=0;
                }
                for(m=0;m<i;m++)
                {
                    l+=Float.parseFloat(d[m][3]);
                }
                u2 = l;
                String tot = l+"";
                String balan = balance+"";
                j=0;
                j1 = new JTable(d, h);
                j1.setBounds(30, 40, 100, 200);
                j1.setFont(f2);
                j1.setShowGrid(false);
                JScrollPane s1 = new JScrollPane(j1);
                s1.setFont(f2);
                s1.setBorder(BorderFactory.createEmptyBorder());
                s1.setPreferredSize(new Dimension(600, 150));
                add(s1);
                conn c2 = new conn();
                c2.s.executeUpdate(q1);
                t1 = new JTextField(10);
                t1.setFont(f1);
                t2 = new JTextField(10);
                t2.setFont(f1);
                add(total);
                t1.setText(tot);
                t1.setEditable(false);
                t1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                add(t1);
                add(bal);
                t2.setText(balan);
                t2.setEditable(false);
                t2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                add(t2);
                t3 = new JTextField(10);
                t3.setEditable(false);
                t3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                add(thanks);
                add(t3);
                add(b1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        i=0;
    }
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("Print")==true)
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
        
        new view_cart3(2, 0).setVisible(true);
    }
}
