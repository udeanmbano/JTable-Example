package View;

import View.Hostels;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class splash extends JWindow {

    static boolean isRegistered;
    private static JProgressBar progressBar = new JProgressBar();
    private static splash execute;
    private static int count;
    private static Timer timer1;

    public splash() {

        Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 10, 348, 150);
        panel.setLayout(null);
        container.add(panel);

        JLabel label = new JLabel("Hostel Management System");
          
        panel.add(label);
        

        progressBar.setMaximum(100);
        progressBar.setBounds(55, 180, 250, 15);
        container.add(progressBar);
        loadProgressBar();
        setSize(370, 217);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);
                

                if (count == 100) {

                   login n;
                    try {
                        n = new login();
                         n.setResizable(false);
                n.setVisible(true);
                 n.setLocationRelativeTo(null);
                      
                    } catch (Exception ex) {
                        Logger.getLogger(splash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  

                    execute.setVisible(false);//swapped this around with timer1.stop()

                    timer1.stop();
                }

            }

            
        };
        timer1 = new Timer(50, al);
        timer1.start();
    }

    public static void main(String[] args) {
        
        execute = new splash();
    }
};