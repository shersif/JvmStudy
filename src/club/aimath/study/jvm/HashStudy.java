package club.aimath.study.jvm;

public class HashStudy {
    public static void main(String[] args) throws Exception {

        var cl=Class.forName("java.lang.StringBuilder");
        StringBuilder stringBuilder = (StringBuilder) cl.getConstructor().newInstance();
        StringBuilder hello = stringBuilder.append("Hello").append(" ").append("Word").append("!");
        System.out.println(hello);
//        var hello="Hello";
//        StringBuilder builder=new StringBuilder(hello);
//        String hello1 = builder.toString();
//        System.out.println("hello1.getClass().getName() = " + hello1.getClass().getName());

//        System.out.println(hello==hello1);
//        System.out.println(hello.hashCode()==hello1.hashCode());
    }
}
