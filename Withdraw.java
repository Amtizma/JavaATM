package ATM;

import javax.swing.*;
import java.awt.event.*;

public class Withdraw extends Transfer{
    JFrame withdrawframe = new JFrame("WITHDRAW");
    JFormattedTextField WithdrawValue;
    JButton WITHDRAWButton2;
    JButton CLEARButton;
    JPanel WithdrawPanel;
    JButton RETURNButtonWithdraw;

    public Withdraw() {
        WithdrawValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawValue.setText("");
            }
        });
    }

    public void WithdrawSum() {
        withdrawframe.setContentPane(WithdrawPanel);
        withdrawframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        withdrawframe.setResizable(false);
        withdrawframe.pack();
        withdrawframe.setLocationRelativeTo(null);
        withdrawframe.setVisible(true);
    }
}
