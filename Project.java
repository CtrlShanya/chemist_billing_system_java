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
import javax.swing.UIManager.*;

public class Project extends JFrame implements ActionListener
{
    Font f1 = new Font("Courier New", Font.ITALIC,26);
    JLabel l1;
    public Project()
    {
        l1 = new JLabel("");
        l1.setOpaque(true);
        l1.setBackground(Color.pink);
        add(l1);
        setFont(f1);
        setSize(1000,1000);
        JMenuBar mb = new JMenuBar();
        //mb.acceleratorFont(f1);
        setJMenuBar(mb);
        mb.setFont(f1);
        JMenu first = new JMenu("Master");
        first.setForeground(Color.red);
        first.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\master.png")));
        mb.add(first);
        JMenuItem t1 = new JMenuItem("New Account");
        t1.setForeground(Color.red);
        t1.setMnemonic('U');
        t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\new_user.png")));
        t1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        t1.setFont(f1);
        first.add(t1);
        JMenuItem t2 = new JMenuItem("New Medicine");
        t2.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\new_med.png")));
        t2.setForeground(Color.red);
        t2.setMnemonic('N');
        t2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        //t2.acceleratorFont(f1);
        t2.setFont(f1);
        first.add(t2);
        t1.addActionListener(this);
        JMenuItem t9 = new JMenuItem("New Customer");
        t9.setMnemonic('C');
        t9.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\new_cus.png")));
        t9.setForeground(Color.red);
        t9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        t9.setFont(f1);
        first.add(t9);
        t9.addActionListener(this);
        t2.addActionListener(this);
        JMenuItem t3 = new JMenuItem("Update Medicine");
        t3.setMnemonic('M');
        t3.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\update_med.png")));
        t3.setForeground(Color.red);
        t3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        t3.setFont(f1);
        first.add(t3);
        t3.addActionListener(this);
        JMenuItem t4 = new JMenuItem("Delete Medicine");
        t4.setMnemonic('Z');
        t4.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\delete_med.png")));
        t4.setForeground(Color.red);
        t4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
        t4.setFont(f1);
        first.add(t4);
        t4.addActionListener(this);
        JMenu second = new JMenu("Reports");
        second.setForeground(Color.red);
        second.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\report.png")));
        mb.add(second);
        JMenuItem t5 = new JMenuItem("List Users");
        t5.setMnemonic('L');
        t5.setForeground(Color.red);
        t5.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\list_users.png")));
        t5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        t5.setFont(f1);
        second.add(t5);
        t5.addActionListener(this);
        JMenuItem t6 = new JMenuItem("List Medicines");
        t6.setMnemonic('P');
        t6.setForeground(Color.red);
        t6.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\list_med.png")));
        t6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        t6.setFont(f1);
        second.add(t6);
        t6.addActionListener(this);
        JMenuItem t7 = new JMenuItem("Cart");
        t7.setMnemonic('X');
        t7.setForeground(Color.red);
        t7.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\cart.png")));
        t7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        t7.setFont(f1);
        second.add(t7);
        t7.addActionListener(this);
        JMenuItem t8 = new JMenuItem("List Customers");
        t8.setMnemonic('F');
        t8.setForeground(Color.red);
        t8.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icon\\list_users.png")));
        t8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
        t8.setFont(f1);
        second.add(t8);
        t8.addActionListener(this);
        first.setFont(f1);
        second.setFont(f1);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("New Account"))
            new user_account().setVisible(true);
        if(msg.equals("New Medicine"))
            new new_medicine().setVisible(true);
        if(msg.equals("New Customer"))
            new new_customer().setVisible(true);
        if(msg.equals("Delete Medicine"))
            new delete_medicine().setVisible(true);
        if(msg.equals("Update Medicine"))
            new update_medicine().setVisible(true);
        if(msg.equals("Cart"))
            new cart().setVisible(true);
        if(msg.equals("List Medicines"))
            new list_medicine().setVisible(true);
        if(msg.equals("List Users"))
            new list_users().setVisible(true);
        if(msg.equals("List Customers"))
            new list_customers().setVisible(true);
    }
    public static void main(String s[])
    {
        Font f = new Font("Courier New", Font.ITALIC,22);
        UIManager.getLookAndFeelDefaults().put("MenuItem.acceleratorFont", f);
        UIManager.getLookAndFeelDefaults().put("MenuItem.acceleratorForeground", Color.black);
        new Project().setVisible(true);
    }
}
