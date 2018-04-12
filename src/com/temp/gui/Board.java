package com.temp.gui;

import com.sun.org.omg.CORBA.ExceptionDescription;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jonas on 2018-04-12.
 */
public class Board {
    private JPanel wrapper;
    private JButton[] buttons;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel currentPlayer;


    public Board() {
        buttons = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};
        for (JButton button : buttons) {
            button.addActionListener(new AL());
            button.setText("-");
        }

        currentPlayer.setText("X");
        while (!this.check()) {
                try {
                    this.wait(55555);
                } catch (InterruptedException e) {
                    if (currentPlayer.getText().equals("X")) {
                        currentPlayer.setText("O");
                    } else {
                        currentPlayer.setText("X");
                    }
                }
            }
        }

    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("Board");
            frame.setContentPane(new Board().wrapper);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean check() {
        ArrayList<ArrayList<String>> rows = this.getRows();
        return true;
    }
    private ArrayList<ArrayList<String>> getRows() {
        ArrayList<ArrayList<String>> rows = new ArrayList<>(8);
        // Add horizontal rows
        for (int i = 0; i <= 2; i++) {
            ArrayList<String> row = new ArrayList<>(3);
            for (int j = i * 3; j <= i * 3 + 2; j++) {
                row.add(this.buttons[j].getText());
            }
            rows.add(row);
        }
        // Add vertical rows
        for (int i = 0; i <= 2; i++) {
            ArrayList<String> row = new ArrayList<>(3);
            for (int j = i; j <= i + 6; j+=3) {
                row.add(this.buttons[j].getText());
            }
            rows.add(row);
        }
        // Add diagonal rows
        for (int i = 0; i <= 1; i++) {
            ArrayList<String> row = new ArrayList<>(3);
            for (int j = i*2; j <= 8 - 2*i; j+=4-2*i) {
                row.add(this.buttons[j].getText());
            }
            rows.add(row);
        }
        return rows;
    }

    public class AL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressedButton;
            try {
                pressedButton = (JButton) e.getSource();

                //TODO: find a way to receive current player
                pressedButton.setText(currentPlayer.getText());
                pressedButton.setEnabled(false);


            } catch (ClassCastException g) {
                g.printStackTrace();
            }
            /*try {
                System.out.println(e.getActionCommand());
            } catch (Exception g) {
                g.printStackTrace();
            }*/
        }
    }


}
