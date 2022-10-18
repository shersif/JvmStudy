package club.aimath.study.lamda;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

/**
 * @Description
 * @Date 2022/10/17 16:27
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class LambdaTest {

    public static  void test1(int j){

        IntBinaryOperator comparator = Integer::compare;
        comparator.applyAsInt(10,j);
    }

    public static void main(String[] args) {

        test1(10);
//        var planets=new String[]{"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
//        System.out.println(Arrays.toString(planets));
//        System.out.println("Sorted in dictionary order:");
//        Arrays.sort(planets);
//        System.out.println(Arrays.toString(planets));
//        System.out.println("Sorted in length:");
//        Arrays.sort(planets, Comparator.comparingInt(String::length));
//        System.out.println(Arrays.toString(planets));
//
//        Timer timer = new Timer(1000, System.out::println);
//
//        timer.start();
//        JOptionPane.showMessageDialog(null,"停止程序?");
//        System.exit(0);
    }
}
