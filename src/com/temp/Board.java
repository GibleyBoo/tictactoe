package com.temp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jonas on 2018-04-11.
 */
public class Board {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel playerOneScoreLabel;
    private JPanel playerInfoPanel;
    private JLabel playerTwoScoreLabel;
    private JPanel playerScorePanel;
    private JPanel World;
    private JPanel BoardPanel;
    private JLabel playerOneScore;
    private JLabel playerTwoScore;
    private JLabel playerTurnLabel;
    private JLabel playerTurn;

    public Board() {

        button1.addActionListener(new AL());
        button2.addActionListener(new AL());
        button3.addActionListener(new AL());
        button4.addActionListener(new AL());
        button5.addActionListener(new AL());
        button6.addActionListener(new AL());
        button7.addActionListener(new AL());
        button8.addActionListener(new AL());
        button9.addActionListener(new AL());
        playerTurnLabel.setText("1");

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BoardPanel");
        frame.setContentPane(new Board().World);
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
            JButton pressedButton = ((JButton)e.getSource());
            if (playerTurnLabel.getText().equals("1")) {
                pressedButton.setText("X");
                playerTurnLabel.setText("2");
            } else {
                pressedButton.setText("O");
                playerTurnLabel.setText("1");
            }
            pressedButton.setEnabled(false);
        }
    }
}
