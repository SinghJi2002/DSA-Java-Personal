import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class colorPicker {
    colorPicker(){
        JFrame frm=new JFrame("Color Picker");
        frm.setLayout(new FlowLayout());
        frm.setSize(400,300);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel red=new JLabel("Red");
        JLabel green=new JLabel("Green");
        JLabel blue=new JLabel("Blue");
        red.setForeground(Color.RED);
        blue.setForeground(Color.BLUE);
        green.setForeground(Color.GREEN);
        JComboBox redComboBox=new JComboBox<>();
        JComboBox greenComboBox=new JComboBox<>();
        JComboBox blueComboBox=new JComboBox<>();
        for(int i=0;i<=255;i++){
            redComboBox.addItem(i);
            blueComboBox.addItem(i);
            greenComboBox.addItem(i);
        }
        JButton show=new JButton("Show");
        JPanel colorPanel=new JPanel();
        colorPanel.setPreferredSize(new Dimension(400,300));
        colorPanel.setBackground(Color.GREEN);
        colorPanel.add(red);
        colorPanel.add(redComboBox);
        colorPanel.add(green);
        colorPanel.add(greenComboBox);
        colorPanel.add(blue);
        colorPanel.add(blueComboBox);
        colorPanel.add(show);
        frm.add(colorPanel);

        frm.setVisible(true);


        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                int red=(int)redComboBox.getSelectedItem();
                int green=(int)greenComboBox.getSelectedItem();
                int blue=(int)blueComboBox.getSelectedItem();
                colorPanel.setBackground(new Color(red,green,blue));
            }
        });
    }

    public static void main(String[] args) {
        new colorPicker();
    }
}
