package Habit;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Habit {
    private JPanel panelMain;
    private JTextField inputBox;
    private JButton addButton;
    private JLabel hlable;
    private JTable myTable;
    public String[] columnNames = {"Habit", "Date"};
    public Object[][] data = {{"my Habit one", }};

    public Habit() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentTime = getTime();
                String logInput = inputBox.getText() + " && " + currentTime;
                inputBox.setText("");

            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Starts.");


        Habit habit = new Habit();
        JFrame myFrame = new JFrame("Luhar Habit Tracker");
        Font myFont = new Font("Courier New", Font.PLAIN, 36);

        int w = 1000;
        int h = 700;

        myFrame.setSize(w, h);

        habit.panelMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.yellow, 4),
                "My Habit Tracker Pro", TitledBorder.DEFAULT_JUSTIFICATION, 0, myFont));
        //habit.panelMain.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
        habit.panelMain.setBackground(Color.GRAY);
        habit.panelMain.setForeground(Color.lightGray);


        habit.addButton.setBorderPainted(false);
        habit.addButton.setOpaque(true);
        habit.addButton.setBackground(Color.GREEN);
        habit.addButton.setFocusPainted(true);
        habit.panelMain.setPreferredSize(new Dimension(w, h));
        habit.addButton.setPreferredSize(new Dimension(70, 50));
        habit.inputBox.setPreferredSize((new Dimension(410, 50)));

        myFrame.setContentPane(habit.panelMain);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();

        myFrame.setVisible(true);
    }

    public String getTime() {
        // Get the current date and time
        ZonedDateTime now = ZonedDateTime.now();
        // Define the format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
        // Format the current date and time
        return now.format(formatter);
    }

}
