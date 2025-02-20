package Habit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Habit {
    private JPanel panelMain;
    private JTextField inputBox;
    private JButton addButton;
    private JLabel hlable;


    public Habit() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Starts.");

        Habit habit = new Habit();
        JFrame myFrame = new JFrame("Luhar Habit Tracker");

        int w = 1000;
        int h = 700;

        myFrame.setSize(w, h);
        habit.panelMain.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
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
}
