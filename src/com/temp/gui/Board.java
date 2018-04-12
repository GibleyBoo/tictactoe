package com.temp.gui;

import javax.swing.*;

/**
 * Created by jonas on 2018-04-12.
 */
public class Board {
    private JPanel wrapper;
    private JButton[] button;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Board");
        frame.setContentPane(new Board().wrapper);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
