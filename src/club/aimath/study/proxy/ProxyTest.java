package club.aimath.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @Description 代理测试类
 * @Date 2022/10/23 22:04
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class ProxyTest {
    public static void main(String[] args) {
        var elements=new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            elements[i]=Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Comparable.class},new TraceHandler(i+1));
        }

        int key = new Random().nextInt(elements.length) + 1;
        int result = Arrays.binarySearch(elements, key);
        if (result>=0) System.out.println("key:"+key+",result:"+elements[result]);
    }
}

class TraceHandler implements InvocationHandler{

    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("%s.%s(%s)\n",target,method.getName(), args==null?"":Arrays.toString(args));
        return method.invoke(target,args);
    }
}
