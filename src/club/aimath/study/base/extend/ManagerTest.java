package club.aimath.study.base.extend;

import club.aimath.study.base.classAndObject.Employee;

public class ManagerTest {
    public static void main(String[] args) {
        Manager boss=new Manager("Carl Cracker",80000,1987,12,15);
        boss.setBonus(5000);

        var staff=new Employee[3];

        staff[0]=boss;
        staff[1]=new Employee("Harry Hacker",50000,1989,10,1);
        staff[2]=new Employee("Tommy Tester",40000,1990,3,15);

        for (int i = 0; i < staff.length; i++) {
            System.out.println("staff["+i+"].getSalary() = " + staff[i].getSalary());
        }
    }
}