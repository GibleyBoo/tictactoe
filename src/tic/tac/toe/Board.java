package tic.tac.toe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

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
    private JLabel turnsLeft;


    public Board() {
        buttons = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};
        for (JButton button : buttons) {
            button.addActionListener(new AL());
            button.setText("-");
        }
    }


    public static void main(String[] args) {
            Board board = new Board();
            JFrame frame = new JFrame("Board");
            frame.setContentPane(board.wrapper);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            board.currentPlayer.setText("X");
            board.turnsLeft.setText("5");
            do {} while (!board.check() || Integer.parseInt(board.turnsLeft.getText()) > 0);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

    }

    private boolean check() {
        ArrayList<ArrayList<String>> rows = this.getRows();
        for (ArrayList<String> row : rows) {
            String box0 = row.get(0);
            if (box0.equals("-")) {
                continue;
            }
            byte k = 0;
            for (String box : row) {
                if (box0.equals(box)) {
                    k++;
                }
            }
            if (k==3) {
                return true;
            }
        }
        return false;
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

                if (currentPlayer.getText().equals("X")) {
                    currentPlayer.setText("O");
                } else {
                    currentPlayer.setText("X");
                }

                turnsLeft.setText(Integer.toString(Integer.parseInt(turnsLeft.getText()) - 1));

            } catch (ClassCastException g) {
                g.printStackTrace();
            }
        }

    }


}
