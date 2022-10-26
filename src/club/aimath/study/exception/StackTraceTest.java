package club.aimath.study.exception;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @Description 分析堆栈轨迹元素
 * @Date 2022/10/26 09:28
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class StackTraceTest {

    public static int factorial(int n){
        System.out.println("factorial("+n+"):");
        StackWalker walker = StackWalker.getInstance();//不知道干啥用
        walker.forEach(System.out::println);
        Logger.getGlobal().info("n="+n);
        int r;
        if (n<=1) r=1;
        else r=n*factorial(n-1);
        System.out.println("return "+r);
        return r;
    }

    public static void main(String[] args) {
        try(var in=new Scanner(System.in))
        {
            System.out.print("Enter n: ");
            int n=in.nextInt();
            factorial(n);
        }
    }
}
