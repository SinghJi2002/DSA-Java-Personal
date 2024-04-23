import javax.swing.*;
import java.awt.FlowLayout;

class swingDemo {
    swingDemo(){//There are many appreaches to this but we are using constructor.
        //The first step is to create a container/frame.
        JFrame frm=new JFrame("First Application");//Content here appears on title bar.
        //Next we set frame attributes.
        frm.setLayout(new FlowLayout());//Under this layout every component will be placed one after the other horizontally.
        frm.setSize(300,150);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//There are few more options
        JLabel jlb=new JLabel("I belong to CSE 43");//Here we have created  a component. 
        //Next step add component to container
        frm.add(jlb);//The frm frame is invivisible from start. We need to make it visible.
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new swingDemo();
    }
}