package testing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelTestAgain {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        label.setText("Work for fucks sake");
        JPanel panel = new JPanel();
        panel.add(label);
        frame.add(panel);
        frame.setSize(300, 300);
        // frame.setLayout(null);
        frame.setVisible(true);
    }
}
