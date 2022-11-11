package club.aimath.study.base.extend;

/**
 * @Description 经理类
 * @Date 2022/11/8 23:32
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);// super调用构造器必须是子类构造器的第一条语句
        bonus=0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary()+bonus;
    }

    @Override
    public String toString() {
        return super.toString()+"{bonus=" + bonus+"}" ;
    }
}
