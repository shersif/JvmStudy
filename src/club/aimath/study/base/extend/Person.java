package club.aimath.study.base.extend;

/**
 * @Description 抽象类
 * @Date 2022/11/9 23:01
 * @Created by outx
 * @Email outingxiao@126.com
 */
public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }
}
