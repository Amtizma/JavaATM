package ATM;

import javax.swing.*;
import java.awt.event.*;

public class Deposit extends Withdraw {

    public JFrame getDepositframe() {
        return depositframe;
    }

    JFrame depositframe = new JFrame("DEPOSIT");
    JButton DEPOSITButton2;
    JButton CLEARButton;
    JButton RETURNButtonDeposit;
    JFormattedTextField DepositValue;
    JPanel DepositPanel;
    Integer d = 0;
    public Deposit() {
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositValue.setText("");
            }
        });
        DepositValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
    }

    public void DepositSum() {
        depositframe.setContentPane(DepositPanel);
        depositframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        depositframe.setResizable(false);
        depositframe.pack();
        depositframe.setLocationRelativeTo(null);
        depositframe.setVisible(true);
    }
}
