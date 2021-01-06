

package chemist_shop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class view_cart2 extends JFrame implements ActionListener
{
    Integer u1;
    Float u2;
    Font f1 = new Font("Courier New", Font.ITALIC,20);
    JTable j1;
    JButton b1;
    String h[]={"Medicine ID", "Company", "Salt", "Price", "Quantity", "Expiry Date", "Amount"};
    String d[][], a;
    int i=0, j=0, m;
    float l=0, k=0;
    public view_cart2(int cus_id)
    {
        super("CART");
        setSize(800, 500);
        setLocation(150, 150);
        b1 = new JButton("Proceed to Payment");
        b1.setFont(f1);
        b1.addActionListener(this);
        u1 = cus_id;
        System.out.println(u1);
        try
        {
            String r = "SELECT MEDICINE.MEDICINE_ID, COMPANY, EXP_DATE, SALT, PRICE, QUANTITY, AMOUNT FROM BILL, MEDICINE WHERE CUSTOMER_ID="+u1+" AND BILL.MEDICINE_ID=MEDICINE.MEDICINE_ID AND STATUS='NP'";
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
                u2 = l;
                d[i+1][j++]="Total";
                d[i+1][j]=l+"";
                j=0;
                j1 = new JTable(d, h);
                j1.setFont(f1);
                JScrollPane s1 = new JScrollPane(j1);
                s1.setFont(f1);
                add(s1);
                add(b1, "South");
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
        if(msg.equals("Proceed to Payment"))
            new bill(u1, u2).setVisible(true);
    }
    public static void main(String s[])
    {
        int x = 0;
        new view_cart2(x).setVisible(true);
    }
}
