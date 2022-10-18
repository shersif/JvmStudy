package club.aimath.study;

/**
 * @Description 员工类
 * @Date 2022/10/4 22:32
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class Employee {
    private static int nextId=1;
    protected int id;

    public static int getNextId(){
        int id=nextId;
        nextId++;
        return id;
    }

    public Employee() {
        id=getNextId();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}
