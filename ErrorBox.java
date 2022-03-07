package ATM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ErrorBox extends TransactionHistory{
    ArrayList<String> history = new ArrayList<String>();
    JFrame Error = new JFrame();
    JPanel ErrorBox;
    JButton RETURNButtonError;
    JLabel ErrorMesage;

    public ErrorBox() {
        RETURNButtonError.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Error.dispose();
            }
        });
    }
    public void Error() {
        Error.setContentPane(ErrorBox);
        Error.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Error.setResizable(false);
        Error.pack();
        Error.setLocationRelativeTo(null);
        Error.setVisible(true);
    }
}
