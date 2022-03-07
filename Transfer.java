package ATM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Transfer extends ErrorBox{
    JFrame transferframe = new JFrame("TRANSFER");
    JPanel TransferPanel;
    JButton TRANSFERButton2;
    JFormattedTextField ReceiverCardNumber;
    JFormattedTextField TransferSum;
    JButton RETURNButtonTransfer;
    JButton CLEARButton;
    JLabel TransferInfo;

    public Transfer() {
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransferSum.setText("");
                ReceiverCardNumber.setText("");
            }
        });
        ReceiverCardNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                if(ReceiverCardNumber.getText().length() > 15) e.consume();
            }
        });
        TransferSum.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
    }

    public void TransferSum() {
        transferframe.setContentPane(TransferPanel);
        transferframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        transferframe.setResizable(false);
        transferframe.pack();
        transferframe.setLocationRelativeTo(null);
        transferframe.setVisible(true);
    }
}
