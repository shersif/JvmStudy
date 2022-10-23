package club.aimath.study.innerclass;

import java.util.Random;

/**
 * @Description 静态内部类测试
 * @Date 2022/10/23 16:03
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        var values=new double[20];
        for (int i = 0; i < values.length; i++) {
            values[i]= 100*Math.random();
        }
        ArrayAlg.Pair minmax = ArrayAlg.minmax(values);
        System.out.println("min = " + minmax.getFirst());
        System.out.println("max = " + minmax.getSecond());
    }
}

class ArrayAlg{
    public static class Pair{
        private double first;
        private double second;
        public Pair(double f,double s){
            first=f;
            second=s;
        }

        public double getFirst(){
            return first;
        }

        public double getSecond(){
            return second;
        }

    }

    public static Pair minmax(double[] values){
        double min=Double.POSITIVE_INFINITY;
        double max=Double.NEGATIVE_INFINITY;

        for (double v:values
             ) {
            min= Math.min(v, min);
            max= Math.max(v, max);
        }

        return new Pair(min,max);
    }

}
