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

public class list_medicine extends JFrame implements ActionListener
{
    JTable j1;
    JButton b1;
    String h[]={"Medicine ID", "Batch No.", "Description", "Manufacturing", "Expiry", "Salt", "Company", "Quantity", "ROL", "Price"};
    String d[][]=new String[15][10];
    int i=0, j=0;
    public list_medicine()
    {
        super("Medicines in Stock");
        setSize(1000, 1000);
        setLocation(150, 150);
        try
        {
            String q = "SELECT * FROM MEDICINE";
            conn c2 = new conn();
            ResultSet rs = c2.s.executeQuery(q);
            while(rs.next())
            {
                d[i][j++]=rs.getString("MEDICINE_ID");
                d[i][j++]=rs.getString("BATCH_NO");
                d[i][j++]=rs.getString("DESCRIPTION");
                d[i][j++]=rs.getString("MANU_DATE");
                d[i][j++]=rs.getString("EXP_DATE");
                d[i][j++]=rs.getString("SALT");
                d[i][j++]=rs.getString("COMPANY");
                d[i][j++]=rs.getString("QUANT");
                d[i][j++]=rs.getString("ROL");
                d[i][j]=rs.getString("PRICE");
                i++;
                j=0;
            }
            j1 = new JTable(d, h);
        }
        catch(Exception e){}
        b1 = new JButton("Print");
        add(b1, "South");
        JScrollPane s1 = new JScrollPane(j1);
        add(s1);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            j1.print();
        }
        catch(Exception e){}
    }
    public static void main(String s[])
    {
        new list_medicine().setVisible(true);
    }
}
