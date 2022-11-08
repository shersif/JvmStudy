package club.aimath.study.base.classAndObject;

import java.time.LocalDate;

/**
 * @Description localDate测试类
 * @Date 2022/11/6 14:21
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate firstDay=today.plusDays(-today.getDayOfMonth()+1);
        int firstDayOfWeek = firstDay.getDayOfWeek().getValue();
        LocalDate tempDate=firstDay;
        int i=1;
        System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun\t");
        while (tempDate.getMonthValue()==today.getMonthValue()){
            if (i<firstDayOfWeek){
                System.out.print(" \t");
            }else {
                System.out.print(tempDate.getDayOfMonth()+(tempDate.getDayOfMonth()==today.getDayOfMonth()?"*":"\t"));
            }
            if (i%7==0)
                System.out.print("\n");
            if (i>=firstDayOfWeek)
                tempDate=tempDate.plusDays(1);
            i++;
        }
    }
}
