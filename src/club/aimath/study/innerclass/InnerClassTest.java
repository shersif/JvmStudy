package club.aimath.study.innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @Description 内部类测试
 * @Date 2022/10/23 11:09
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1000, true);
        talkingClock.start();


        // 保持程序开启,直至点击关闭按钮
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }


}

/**
 * @Description 具有内部类的类
 * @Date 2022/10/23 11:10
 * @Created by outx
 * @Email outingxiao@126.com
 */
class TalkingClock {
    // 响铃间隔时间
    private int interval;
    // 是否响铃
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        TimePrinter timePrinter = new TimePrinter();
        //        new Timer(interval,timePrinter).start();
        new Timer(interval, timePrinter).start();
    }

    public class TimePrinter implements ActionListener {

        public void actionPerformed(ActionEvent event){
            System.out.println("At the tone, the time is "+ Instant.ofEpochMilli(event.getWhen()) + " class:" + getClass());
            if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
