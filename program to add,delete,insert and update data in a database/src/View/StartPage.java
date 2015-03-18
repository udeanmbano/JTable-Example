/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Mbano
 */

import Model.User;
import View.login;
import View.Hostels;
import static View.UserUIReloaded.panel2;
import static com.sun.glass.events.DndEvent.EXIT;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPage extends JFrame {

    private JButton jbt = new JButton("Student");
    private JButton jbt2 = new JButton("Degree");
    private JButton jbt3 = new JButton("Lecturer");
    private JButton jbt5 = new JButton("User Management");
    private JButton jbt4 = new JButton("Exit");
   
    public StartPage() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2, 10, 5));
      
        p.setSize(500, 800);
        jbt.setSize(50, 50);
        jbt.setBackground(Color.BLACK);
        jbt.setForeground(Color.WHITE);
        jbt2.setSize(50, 50);
        jbt2.setBackground(Color.BLACK);
        jbt2.setForeground(Color.WHITE);
        jbt3.setSize(50, 50);
        jbt3.setBackground(Color.BLACK);
        jbt3.setForeground(Color.WHITE);
        jbt4.setSize(50, 50);
        jbt4.setBackground(Color.BLACK);
        jbt4.setForeground(Color.WHITE);
        jbt5.setSize(50, 50);
        jbt5.setBackground(Color.BLACK);
        jbt5.setForeground(Color.WHITE);
        p.add(jbt);
        p.add(jbt2);
        p.add(jbt3);
        p.add(jbt4);
        p.add(jbt5);
        p.setBackground(Color.MAGENTA);
        add(p);
        jbt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                     Hostels n;
                    try {
                        n = new Hostels();
                         n.setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(splash.class.getName()).log(Level.SEVERE, null, ex);
                    }  
              
            }
        });
        jbt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        jbt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        jbt4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            System.exit(-1);
            }
        });
           jbt5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserUIReloaded navigate = new UserUIReloaded();
                navigate.setSize(1000, 200);
                navigate.setResizable(false);
                navigate.setVisible(true);
                 navigate.setLocationRelativeTo(null);
                navigate.add(panel2);
                setVisible(false);
                
            }
        });
    }

    public static void main(String args[]) {
        StartPage f = new StartPage();
  
        f.setSize(400, 300);
        f.setResizable(false);

        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setBackground(Color.MAGENTA);

    }
}
