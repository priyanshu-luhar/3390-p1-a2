package Habit;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Habit {
    private JPanel panelMain;
    private JTextField inputBox;
    private JButton addButton;
    private JLabel hlable;
    public Object[][] data = {{"a", "b"}};
    private String Filename = "previous.txt";
    private JTable myTable;
    private JScrollPane myPane;
    private DefaultTableModel myModel;

    public Habit() {
        myModel = new DefaultTableModel();
        myModel.addColumn("Habit");
        myModel.addColumn("DATE");
        myTable.setModel(myModel);
        JTableHeader header = myTable.getTableHeader();
        header.setFont(header.getFont().deriveFont(30f));
        myTable.setRowHeight(24);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentTime = getTime();
                String input = inputBox.getText();
                String logInput = input + "," + currentTime + "\n";
                inputBox.setText("");
                Object[] nR = {input, currentTime};

                data = addRow(data, nR);
                myTable.setModel(myModel);
                myModel.addRow(nR);
                try {
                    File file = new File(Filename);
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(logInput);
                    bufferedWriter.close();
                } catch (IOException a) {
                    System.err.println("An error occurred: " + a.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        Habit habit = new Habit();
        JFrame myFrame = new JFrame("Loren Ipsum Habit Tracker");
        Font myFont = new Font("Courier New", Font.PLAIN, 36);

        habit.data = habit.getData();

        int w = 1000;
        int h = 700;

        myFrame.setSize(w, h);

        habit.panelMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.yellow, 4),
                "My Habit Tracker Pro", TitledBorder.DEFAULT_JUSTIFICATION, 0, myFont));
        habit.panelMain.setBackground(Color.GRAY);
        habit.panelMain.setForeground(Color.lightGray);
        habit.panelMain.setPreferredSize(new Dimension(w, h));

        habit.addButton.setBorderPainted(false);
        habit.addButton.setOpaque(true);
        habit.addButton.setBackground(Color.GREEN);
        habit.addButton.setFocusPainted(true);
        habit.addButton.setPreferredSize(new Dimension(70, 50));
        habit.inputBox.setPreferredSize((new Dimension(410, 50)));

        myFrame.setContentPane(habit.panelMain);


        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();

        myFrame.setVisible(true);
    }

    // Method to add a row to the array
    public static Object[][] addRow(Object[][] originalArray, Object[] newRow) {
        Object[][] newArray = Arrays.copyOf(originalArray, originalArray.length + 1);
        newArray[newArray.length - 1] = newRow;
        return newArray;
    }

    Object[][] getData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Filename));
            ArrayList<String> list = new ArrayList();
            String str = "";

            while((str = bufferedReader.readLine()) != null) {
                list.add(str);
            }
            int n = list.get(0).split(",").length;

            Object[][] zata = new Object[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                zata[i] = list.get(i).split(",");
                myModel.addRow(zata[i]);
            }
            bufferedReader.close();

            return zata;
        } catch (Exception x) {
            x.printStackTrace();
            return null;
        }
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
