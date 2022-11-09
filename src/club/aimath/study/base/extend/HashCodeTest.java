package club.aimath.study.base.extend;

/**
 * @Description 哈希码测试类
 * @Date 2022/11/10 00:06
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class HashCodeTest {
    public static void main(String[] args) {
        var s="OK";
        var sb=new StringBuilder(s);
        System.out.println("s.hashCode() = " + s.hashCode());
        System.out.println("sb.hashCode() = " + sb.hashCode());

        var t = new String(s);
        var tb=new StringBuilder(t);
        System.out.println("t.hashCode() = " + t.hashCode());
        System.out.println("tb.hashCode() = " + tb.hashCode());
    }
}
