package club.aimath.study.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Description 员工类
 * @Date 2022/10/15 23:13
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class Employee implements Cloneable{
    private String name;
    private Double salary;
    private Date hireDay;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay=new Date();
    }


    protected Employee clone() throws CloneNotSupportedException {
        Employee clone = (Employee) super.clone();
        clone.hireDay=(Date) this.hireDay.clone();
        return clone;
    }

    public void setHireDay(int year,int month,int day){
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        this.hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent){
        this.salary=this.salary*(1+byPercent/100);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
