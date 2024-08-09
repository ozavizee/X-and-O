import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XandO {
    JFrame tictac = new JFrame("XandO");
    JButton[] buttons = new JButton[9];
    boolean xTurn = true;

    public XandO() {
        tictac.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(e -> {
                if (((JButton) e.getSource()).getText().isEmpty()) {
                    ((JButton) e.getSource()).setText(xTurn ? "X" : "O");
                    xTurn = !xTurn;
                    checkForWin();
                }
            });
            tictac.add(buttons[i]);
        }
        tictac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tictac.setSize(400, 400);
        tictac.setVisible(true);
    }

    void checkForWin() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = buttons[i].getText();
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].isEmpty()) {
                showWinner(board[i][0]);
            }
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].isEmpty()) {
                showWinner(board[0][i]);
            }
        }
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].isEmpty()) {
            showWinner(board[0][0]);
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].isEmpty()) {
            showWinner(board[0][2]);
        }
    }

    void showWinner(String winner) {
        JOptionPane.showMessageDialog(tictac, "Player " + winner + " wins!");
        for (JButton button : buttons) {
            button.setText("");
        }
        xTurn = true;
    }

    public static void main(String[] args) {
        new XandO();
    }
}
