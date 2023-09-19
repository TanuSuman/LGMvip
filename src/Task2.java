import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task2 extends JFrame implements ActionListener {
    private static final int BOARD_SIZE = 3;
    private JButton[][] board;
    private boolean playerXTurn = true;

    public Task2() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        board = new JButton[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();

        setVisible(true);
    }

    private void initializeBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.PLAIN, 48));
                button.addActionListener(this);
                board[row][col] = button;
                add(button);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();

        if (buttonClicked.getText().equals("") && playerXTurn) {
            buttonClicked.setText("X");
            playerXTurn = false;
        } else if (buttonClicked.getText().equals("") && !playerXTurn) {
            buttonClicked.setText("O");
            playerXTurn = true;
        }

        if (checkWin("X")) {
            JOptionPane.showMessageDialog(this, "Player X wins!");
            resetBoard();
        } else if (checkWin("O")) {
            JOptionPane.showMessageDialog(this, "Player O wins!");
            resetBoard();
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetBoard();
        }
    }

    private boolean checkWin(String player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0].getText().equals(player)
                    && board[i][1].getText().equals(player)
                    && board[i][2].getText().equals(player)) {
                return true;
            }
            if (board[0][i].getText().equals(player)
                    && board[1][i].getText().equals(player)
                    && board[2][i].getText().equals(player)) {
                return true;
            }
        }
        if (board[0][0].getText().equals(player)
                && board[1][1].getText().equals(player)
                && board[2][2].getText().equals(player)) {
            return true;
        }
        if (board[0][2].getText().equals(player)
                && board[1][1].getText().equals(player)
                && board[2][0].getText().equals(player)) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col].setText("");
            }
        }
        playerXTurn = true;
    }

    public static void main(String[] args) {
        new Task2();
    }
}
