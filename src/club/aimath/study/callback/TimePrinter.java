package club.aimath.study.callback;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is "+ Instant.ofEpochMilli(e.getWhen()));
        // 发出声响
        Toolkit.getDefaultToolkit().beep();
    }
}
