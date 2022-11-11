package club.aimath.study.base.extend;

import java.util.Objects;

/**
 * @Description 自动包装测试
 * 基本类型对应的包装类中，Byte、Short、Integer、Long和Character的缓存池都是[-128, 127]，Boolean的缓存池比较特殊，只有true和false两个Boolean对象.
 * 自动封装调用的为 {Object}.valueOf函数
 * 基本类型 与 包装类型比较时包装类会自动拆包 包装类与包装类比较的为引用地址
 * @Date 2022/11/11 17:13
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class AutoWrappingTest {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test1() {
        //if -129<i<128 true else false Integer缓存池
        Integer a= Integer.valueOf(-129);
        Integer b=Integer.valueOf(-129);

        //false
//        Integer a= new Integer(100);
//        Integer b=new Integer(100);
        System.out.println(a==b);
    }

    public static void test2(){
        Boolean b1=new Boolean(false);
        Boolean b2=new Boolean(false);
        boolean b3=false;

        System.out.println("b1==b2 = " + (b1 == b2));
        System.out.println("b1==b3 = " + (b1==b3));
    }

    public static void test3(){
        System.out.println(Integer.toString(3,3));
        System.out.println( ("15l"));
    }
}
