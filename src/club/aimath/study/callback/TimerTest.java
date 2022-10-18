package club.aimath.study.callback;


import javax.swing.*;

public class TimerTest {
    public static void main(String[] args) {
        TimePrinter listener = new TimePrinter();
        Timer timer = new Timer(1000, listener);
        timer.start();

        // 弹出用户确认框
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
