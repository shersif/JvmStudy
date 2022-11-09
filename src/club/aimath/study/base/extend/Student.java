package club.aimath.study.base.extend;

/**
 * @Description
 * @Date 2022/11/9 23:05
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class Student extends Person {

    private final String major;

    public Student(String name,String major) {
        super(name);
        this.major=major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in "+major;
    }
}
