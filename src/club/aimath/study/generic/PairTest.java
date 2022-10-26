package club.aimath.study.generic;

import jdk.jfr.Label;

import java.time.LocalDate;

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
//        Pair<LocalDate> pair=dateInterval;
        dateInterval.setSecond(LocalDate.now());
        dateInterval.setSecond("Heele");
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
}

class DateInterval extends Pair{

    @Override
    public void setSecond(Object second) {
        super.setSecond(second);
        System.out.println("origin second = " + second);
    }

    public void setSecond(LocalDate second){
        System.out.println("LocalDate second = " + second);
    }

    public LocalDate getSecond(){
        return (LocalDate) super.getSecond();
    }
}