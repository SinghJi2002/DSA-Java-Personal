import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class calculator{
    JFrame frm=new JFrame();
    frm.setSize(400,400);
    frm.setTitle("Calculator");
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setLayout(new FlowLayout());
    frm.setVisible(true);
    JLabel label=new JLabel("Calculator");
    JTextField fld=new JTextField(15); 
    JButton k1=new JButton('0');
    JButton k2=new JButton('1');
    JButton k3=new JButton('2');
    JButton k4=new JButton('3');
    JButton mul=new JButton("*");
    JButton eql=new JButton("=")
    frm.add(label);
    frm.add(fld);
    frm.add(k1);
    frm.add(k2);
    frm.add(k3);
    frm.add(k4);
    frm.add(mul);
    frm.add(eql);
    String value1="";
    String value2="";

    k1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            value1=value1.concat("0");
            fld.setText(value1);
        }
    })
    k2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            value1=value1.concat("1");
            fld.setText(value1);
        }
    })
    k3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            value1=value1.concat("2");
            fld.setText(value1);
        }
    })
    k4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            value1=value1.concat("3");
            fld.setText(value1);
        }
    })
    mul.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            value2=value1;
            value1="";
            fld.setText(value1);
        }
    })
    eql.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            int multi=Integer.parseInt(value1)*Integer.parseInt(value2);
            String sol=new String(multi);
            fld.setText(sol);
        }
    });


}


public class Code1 {
    public static void main(String[] args) {
        new calculator();
    }
}
