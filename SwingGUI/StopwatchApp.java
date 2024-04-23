import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchApp extends JFrame implements ActionListener {
    private JLabel hoursLabel, minutesLabel, secondsLabel, millisecsLabel;
    private JButton startButton, resetButton, stopButton;
    private Timer timer;
    private int hours, minutes, seconds, millisecs;

    public StopwatchApp() {
        setTitle("Stopwatch");
        setLayout(new GridLayout(2, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel displayPanel = new JPanel(new FlowLayout());
        hoursLabel = new JLabel("0");
        minutesLabel = new JLabel("0");
        secondsLabel = new JLabel("0");
        millisecsLabel = new JLabel("0");
        displayPanel.add(hoursLabel);
        displayPanel.add(new JLabel(":"));
        displayPanel.add(minutesLabel);
        displayPanel.add(new JLabel(":"));
        displayPanel.add(secondsLabel);
        displayPanel.add(new JLabel(":"));
        displayPanel.add(millisecsLabel);
        add(displayPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        startButton = new JButton("Start/Resume");
        resetButton = new JButton("Reset");
        stopButton = new JButton("Stop");
        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(stopButton);
        add(buttonPanel);

        startButton.addActionListener(this);
        resetButton.addActionListener(this);
        stopButton.addActionListener(this);

        timer = new Timer(10, e -> {
            millisecs++;
            if (millisecs == 100) {
                millisecs = 0;
                seconds++;
            }
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }
            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
            updateDisplay();
        });
    }

    private void updateDisplay() {
        hoursLabel.setText(String.valueOf(hours));
        minutesLabel.setText(String.valueOf(minutes));
        secondsLabel.setText(String.valueOf(seconds));
        millisecsLabel.setText(String.valueOf(millisecs));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
        } else if (e.getSource() == resetButton) {
            timer.stop();
            hours = minutes = seconds = millisecs = 0;
            updateDisplay();
        } else if (e.getSource() == stopButton) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        StopwatchApp stopwatch = new StopwatchApp();
        stopwatch.pack();
        stopwatch.setVisible(true);
    }
}