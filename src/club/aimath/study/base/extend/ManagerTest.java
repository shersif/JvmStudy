package club.aimath.study.base.extend;

public class ManagerTest {

    public static void test1( ){
        Manager boss=new Manager("Carl Cracker",80000,1987,12,15);
        boss.setBonus(5000);

        Employee[] staff=new Employee[3];

        staff[0]=boss;
        staff[1]=new Employee("Harry Hacker",50000,1989,10,1);
        staff[2]=new Employee("Tommy Tester",40000,1990,3,15);

        for (int i = 0; i < staff.length; i++) {
            System.out.println("staff["+i+"].getSalary() = " + staff[i].getSalary());
        }
    }

    /**
     * ArrayStoreException
     */
    public static void test2(){
        Manager[] managers=new Manager[3];
        Employee[] employees=managers;
        employees[0]=new Employee("Harry Hacker",50000,1989,10,1);
    }
    public static void main(String[] args) {
        test2();
    }
}