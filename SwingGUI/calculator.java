import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class calculator {
    String storedValue="";
    String value="";
    String lastAction="";
    int sol;
    calculator(){
        JFrame frm=new JFrame();
        frm.setLayout(new FlowLayout());
        frm.setSize(200,200);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel clc=new JLabel("Calculator");
        JTextField fld=new JTextField(12);
        frm.add(clc);
        frm.add(fld);
        JButton k1=new JButton("1");
        JButton k2=new JButton("2");
        JButton k3=new JButton("3");
        JButton add=new JButton("+");
        JButton k4=new JButton("4");
        JButton k5=new JButton("5");
        JButton k6=new JButton("6");
        JButton sub=new JButton("-");
        JButton k7=new JButton("7");
        JButton k8=new JButton("8");
        JButton k9=new JButton("9");
        JButton mul=new JButton("*");
        JButton div=new JButton("/");
        JButton k0=new JButton("0");
        JButton mod=new JButton("%");
        JButton equal=new JButton("=");
        frm.add(k1);
        frm.add(k2);
        frm.add(k3);
        frm.add(add);
        frm.add(k4);
        frm.add(k5);
        frm.add(k6);
        frm.add(sub);
        frm.add(k7);
        frm.add(k8);
        frm.add(k9);
        frm.add(mul);
        frm.add(div);
        frm.add(k0);
        frm.add(mod);
        frm.add(equal);
        frm.setVisible(true);   


        k1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("1");
                fld.setText(value);
            }
        });
        k2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("2");
                fld.setText(value);
            }
        });  
        k3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("3");
                fld.setText(value);
            }
        });
        k4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("4");
                fld.setText(value);
            }
        });
        k5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("5");
                fld.setText(value);
            }
        });
        k6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("6");
                fld.setText(value);
            }
        });
        k7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("7");
                fld.setText(value);
            }
        });
        k8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("8");
                fld.setText(value);
            }
        });
        k9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("9");
                fld.setText(value);
            }
        });
        k0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                value=value.concat("0");
                fld.setText(value);
            }
        });      
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                storedValue=value;
                value="";
                lastAction=lastAction.concat("+");
                fld.setText(null);
            }
        });
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                storedValue=value;
                value="";
                lastAction=lastAction.concat("-");
                fld.setText(null);
            }
        });
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                storedValue=value;
                value="";
                lastAction=lastAction.concat("/");
                fld.setText(null);
            }
        });
        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                storedValue=value;
                value="";
                lastAction=lastAction.concat("*");
                fld.setText(null);
            }
        });

        equal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if(lastAction=="+"){
                    sol=0;
                    sol=sol+Integer.parseInt(value)+Integer.parseInt(storedValue);
                    fld.setText(Integer.toString(sol));
                }
                else if(lastAction=="-"){
                    sol=0;
                    sol=sol+Integer.parseInt(value)-Integer. parseInt(storedValue);
                    fld.setText(Integer.toString(sol));
                }
                else if(lastAction=="+"){
                    sol=1;
                    sol=sol*Integer.parseInt(value)*Integer.parseInt(storedValue);
                    fld.setText(Integer.toString(sol));
                }
                else if(lastAction=="+"){
                    sol=1;
                    sol=(sol*Integer.parseInt(value))/Integer.parseInt(storedValue);
                    fld.setText(Integer.toString(sol));
                }
                lastAction="";
                value="";
                storedValue="";     
            }
        });
    }

    public static void main(String[] args) {
        new calculator();
    }
}

