package club.aimath.study.base.extend;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2022/11/11 16:31
 * @Created by outx
 * @Email outingxiao@126.com
 */
// 泛型数组测试
public class ArrayListTest {
    public static void test1(){

        List<Employee> staff = new ArrayList<Employee>();

        staff.add(new Employee("Harry Hacker",50000,1989,10,1));
        staff.add(new Manager("Carl Cracker",80000,1987,12,15));

        for (Employee e:staff)
            System.out.println(e);
    }

    public static void main(String[] args) {
        test1();
    }
}
