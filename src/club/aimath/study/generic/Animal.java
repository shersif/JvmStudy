package club.aimath.study.generic;

/**
 * @Description 动物类
 * @Date 2022/11/1 22:21
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class Animal {
    /**
     * 动物名称
     */
    private String name;
    /**
     * 动物毛色
     */
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
