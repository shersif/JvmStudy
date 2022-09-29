package club.aimath.study;

import java.util.HashSet;


public class RuntimeConstantPoolOOM {

    /**
     * 运行时常量池测试,在jdk8中原本放在永久代的字符串被迁移至Java堆之中
     * 通过 -Xmx6M限制堆大小
     */
    public static void main1(String[] args) {
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        HashSet<String> set = new HashSet<>();
        // 在short范围内足以让6MB的堆产生OOM了
        short i=0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }

    public static void main(String[] args) {
        String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);

        String str2=new StringBuilder("j").append("ava").toString();
        System.out.println(str2.intern()==str2);

        System.out.println(str2.intern()=="java");
    }
}
