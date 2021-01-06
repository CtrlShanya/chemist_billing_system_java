/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chemist_shop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class sframe extends JFrame implements Runnable
{
    Thread t1;
    sframe(String s)
    {
        super(s);
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Icon\\One.jpg"));
        
        JLabel m1 = new JLabel(c1);
        add(m1);
        add(new JLabel("This is Free License"));
        add(new JLabel("Support Security"));
        t1 = new Thread(this);
        t1.start();
    }
    public void run()
    {
        try
        {
            Thread.sleep(7000);
            this.setVisible(false);
            Chemist_Shop f1 = new Chemist_Shop();
            f1.setSize(550, 200);
            f1.setLocation(300, 300);
            f1.setVisible(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
class splash 
{
    public static void main(String s[])
    {
        String t = "Banking System Free License Version 2.0";
        sframe f1 = new sframe(t);
        f1.setVisible(true);
        int i;
        int x=1;
        for(i=2;i<=300;i+=4,x+=6)
        {
            f1.setLocation((600-(i+x)/2), 300-(i/2));
            f1.setSize(800+i+x, 800+i);
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }  
}
