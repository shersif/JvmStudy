package club.aimath.study.clone;

/**
 * @Description 克隆练习
 * @Date 2022/10/15 23:09
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee outx = new Employee("outx", 20000d);
        outx.setHireDay(2000,1,1);
        Employee clone = outx.clone();
        clone.raiseSalary(10);
        clone.setHireDay(2022,12,31);
        System.out.println("outx="+outx);
        System.out.println("clone="+clone);
    }
}
