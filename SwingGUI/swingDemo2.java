import java.util.logging.Level;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class swingDemo2 {
    JLabel jlb;
    swingDemo2(){
        JFrame frm=new JFrame("First Event Application");
        frm.setLayout(new FlowLayout());
        frm.setSize(300,150);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jalpha=new JButton("Alpha");
        JButton jbeta=new JButton("Beta");
        frm.add(jalpha);
        frm.add(jbeta);
        jalpha.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                jlb.setText("Alpha is Pressed");
            }
        });
        jbeta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                jlb.setText("Beta is Pressed");
            }
        });
        jlb=new JLabel("Press the button");
        frm.add(jlb);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new swingDemo2();
    }
}
