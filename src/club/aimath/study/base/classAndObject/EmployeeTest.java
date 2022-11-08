package club.aimath.study.base.classAndObject;

/**
 * @Description 员工测试类
 * @Date 2022/11/6 14:54
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff=new Employee[3];



        staff[0]=new Employee("Carl Cracker",75000,1987,12,15);
        staff[1]=new Employee("harry Hacker",5000,1989,10,1);
        staff[2]=new Employee("Tony Tester",40000,1990,3,15);

        for (Employee e:staff)
            e.raiseSalary(5);

        for(Employee e:staff)
            System.out.println(e.toString());

        System.out.println("Employee.nextId = " + Employee.nextId);
    }
}
