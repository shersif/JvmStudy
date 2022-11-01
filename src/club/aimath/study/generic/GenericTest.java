package club.aimath.study.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description 泛型测试类
 * @Date 2022/11/1 22:15
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class GenericTest {
    public static void main(String[] args)throws Exception {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(6);
        // 反射机制实现
        Class<? extends ArrayList> aClass = list.getClass();
        Method add = aClass.getDeclaredMethod("add", Object.class);
        add.invoke(list, "👏北京欢迎您!");
        System.out.println("list = " + list);
    }

    /**
     * 因为List传入的可以为 Animal 的任何子类,所有可以用 Animal 来接收结果,但是不可以传入null外的所有的对象,因为只能传入?所代表类的
     * 对象或?子类的对象,因编译时不可知?所代表具体类,所以仅可以传入null.
     * @param list
     */
    public static void method(List<? extends Animal> list){
        //正确 因为传入的一定是Animal的子类
        Animal animal = list.get(0);
        //正确 当然也可以用Object类接收，因为Object是顶层父类
        Object object = list.get(1);
        //错误 不能用？接收
//        ? t = lists.get(2);
        // 错误
//        list.add(new Dog("lito","green"));
        // 错误
//        list.add(new Pig("piqi","green"));
        // 错误
//        list.add(new Object());
        // 错误
//        list.add(new Animal("a","dfw"));
        // 正确 除null外 不允许加入任何元素
        list.add(null);
    }

    public static void method1(List<? super Pig> pigs) {
        // 正确 它是所有类的父类 ?一定小于等于Object
        Object object = pigs.get(0);
        // 错误 虽然Animal是Pig的父类,但是?不一定=Animal也可以是Animal的父类或者父类的父类
//        Animal animal = pigs.get(1);
        // 错误 不能用？接收
//        ? pig=pigs.get(3);
        // 错误
//        pigs.add(object);
        // 错误
//        pigs.add(new Animal());
        // 正确
        pigs.add(new Pig("dog","yellow"));
        // 正确 可以存放null元素
        pigs.add(null);
    }
}
