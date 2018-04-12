package com.temp.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jonas on 2018-04-12.
 */
public class Game {
    private Board board;
    private JPanel wrapper;
    private boolean playerTurn;


    public Game() {


    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setContentPane(new Game().wrapper);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
    public class AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressedButton = (JButton)e.getSource();

        }
    }
}
