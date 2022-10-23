package club.aimath.study.jvm;

/**
 * @Description 非主动使用类字段演示
 * @Date 2022/10/3 15:16
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
        ClassLoader classLoader = SubClass.class.getClassLoader();
    }
}

class SuperClass{
    static {
        System.out.println("SuperClass init!");
    }

    public static int value=123;
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}

