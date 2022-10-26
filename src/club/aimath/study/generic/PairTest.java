package club.aimath.study.generic;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * @Description 泛型测试
 * @Date 2022/10/26 15:31
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class PairTest{
    public static void main(String[] args) {
//        String[] names=new String[]{"ou","ting","xiao","is"};
//        Pair<String> minmax = ArrayAlg.minmax(names);
//        System.out.println("minmax.getFirst() = " + minmax.getFirst());
//        System.out.println("minmax.getSecond() = " + minmax.getSecond());
//
//        String min = ArrayAlg.min(names);
//        System.out.println("min = " + min);

        DateInterval dateInterval = new DateInterval();
        Pair<LocalDate> pair=dateInterval;
        pair.setSecond(LocalDate.now());
        System.out.println("pair instanceof Pair = " + (pair instanceof Pair));

        Collection<Pair<String>> collection=new HashSet<>();
        Pair<String> pair1=new Pair<>("ou","ting");
        StringInterval pair2=new StringInterval("ting","xiao");
        Object[] pairs = addAll(collection, pair1, pair2);
        collection.stream().forEach(System.out::println);
        pairs[0]=new Pair<>(12,18);// 成功,符合擦除类型:Pair<?>
//      pairs[0]= "nihao"; 失败,不符合Pair<?> 类型 报:ArrayStoreException错误
        for (int i = 0; i < pairs.length; i++) {
            System.out.println("pairs["+i+"] = " + pairs[i]);
        }
    }

    public static <T> T[] addAll(Collection<T> collection,T... ts){
        for (T t:ts
             ) {
            collection.add(t);
        }
        return ts;
    }
}

class ArrayAlg {
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if (a==null||a.length==0)return null;
        T min=a[0];
        T max=a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i])>0) min=a[i];
            if (max.compareTo(a[i])<0) max=a[i];
        }
        return new Pair<>(min,max);
    }

    public static <T extends Comparable> T min(T[] a){
        if (a==null||a.length==0)return null;
        T samllest=a[0];
        for (int i = 0; i < a.length; i++) {
            if (samllest.compareTo(a[i])>0) samllest=a[i];
        }
        return samllest;
    }
}


class Pair<T>{
    private T first;
    private T second;

    public Pair() {
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        System.out.println("fater received second = " + second);
        this.second = second;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"[" +
                "first=" + first +
                ", second=" + second +
                ']';
    }
}

class DateInterval extends Pair<LocalDate>{

    public void setSecond(LocalDate second){
//        boolean b = this instanceof Pair;
//        System.out.println("this instanceof Pair:"+b);
        System.out.println("LocalDate second = " + second);
        StackWalker walker=StackWalker.getInstance();
        walker.forEach(stackFrame->{
            System.out.println(stackFrame);
        });
    }
}

class StringInterval extends Pair<String>{
    public StringInterval(String first, String second) {
        super(first, second);
    }
}