package ATM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionHistory {
    JFrame historyframe = new JFrame("HISTORY");
    JPanel HistoryPanel;
    JTextArea historytext;
    JButton RETURNButtonHistory;


    public void History(){
        historyframe.setContentPane(HistoryPanel);
        historyframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        historyframe.setLocationRelativeTo(null);
        historyframe.setResizable(false);
        historyframe.pack();
        historyframe.setVisible(true);
    }
}
