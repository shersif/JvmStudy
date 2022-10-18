package club.aimath.study;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @Description 第一个java程序
 * @Date 2022/10/3 22:01
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class FirstSample {

    // 生成当月日历
    public static void showCalendar(){
        LocalDate now = LocalDate.now();
        int month = now.getMonthValue();
        int today = now.getDayOfMonth();
        LocalDate date=now.minusDays(today-1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("周一\t周二\t周三\t周四\t周五\t周六\t周日");

        for (int i = 1; i < value; i++) {
            System.out.print("\t");
        }
        while (date.getMonthValue()==month){
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth()==today)
                System.out.print("*");
            else
                System.out.print("\t");
            date=date.plusDays(1);
            if (date.getDayOfWeek().getValue()==1) System.out.println();
        }
    }

    public static void main(String[] args) {
        showCalendar();
//        Employee employee1 = new Employee();
//        Employee employee2 = new Employee();
//        System.out.println("employee1 = " + employee1);
//        System.out.println("employee2 = " + employee2);
    }
}
