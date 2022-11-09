package club.aimath.study.base.extend;


/**
 * @Description 抽象类测试
 * @Date 2022/11/9 23:08
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0]=new Employee("Harry Hacker",50000,1989,10,1);
        people[1]=new Manager("Carl Cracker",80000,1987,12,15);
        people[2]=new Student("outx","Math");
        
        for (Person p:people)
            System.out.println("p.getDescription() = " + p.getDescription());
    }
}
