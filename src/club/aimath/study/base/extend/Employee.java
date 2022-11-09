package club.aimath.study.base.extend;

import java.time.LocalDate;

/**
 * @Description 员工类
 * @Date 2022/11/6 14:52
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class Employee extends Person{
    public static int nextId=1;
    private String name;
    private double salary;
    private LocalDate hireDay;
    private int id;

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
        this.id=nextId;
        nextId++;
    }

    @Override
    public String getDescription() {
        return toString();
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary+=raise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                ", id=" + id +
                '}';
    }
}
