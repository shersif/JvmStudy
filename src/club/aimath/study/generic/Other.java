package club.aimath.study.generic;

/**
 * @Description 其它类
 * @Date 2022/10/31 09:54
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class Other {
    public static void main(String[] args) {
        B b = new B();
        String bName = b.setName("outingxiao");
        System.out.println("bName = " + bName);
        A a=b;
        String aName = a.setName("nihao");
        System.out.println("aName = " + aName);
    }
}

class A{
    private Object name;
    public String setName(Object o){
        System.out.println("调用了A:"+this.getClass().getSimpleName());
        return o.toString();
    }
}

class B extends A{
    public String setName(String name){
        System.out.println("调用了B:"+this.getClass().getSimpleName());
        return name;
    }
}
