package club.aimath.study;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectStudy {
    private String firstName;
    private int age;
    protected final String lastName;

    public ReflectStudy() {
        lastName="Ou";
    }

    public ReflectStudy(String firstName, int age, String lastName) {
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public double test(int a, double b){
        return a+b;
    }

}

class RunTest{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        Class<ReflectStudy> reflectStudyClass = ReflectStudy.class;
        Field[] fields = reflectStudyClass.getDeclaredFields();

        ReflectStudy reflectStudy = new ReflectStudy("Tingxiao", 18, "Ou");

        // 获取所有字段访问修饰符
        for (Field f : fields) {
            System.out.printf("字段名为:%s的修饰符为%s,字段类型为%s;\n", f.getName(), Modifier.toString(f.getModifiers()),f.getType());
        }

        // 获取所有方法
        for (Method m: reflectStudyClass.getDeclaredMethods()){
            System.out.printf("方法名为:%s的方法修饰符为%s,参数类型为%s,返回值类型为%s;\n",m.getName(),Modifier.toString(m.getModifiers()), Arrays.toString(m.getParameterTypes()),m.getGenericReturnType());
        }

        // 获取构造函数
        for (Constructor c:reflectStudyClass.getDeclaredConstructors()){
            System.out.printf("构造名为:%s的修饰符为%s,参数类型为%s;\n", c.getName(),Modifier.toString(c.getModifiers()), Arrays.toString(c.getParameterTypes()));
        }

        Field firstNameField = reflectStudyClass.getDeclaredField("firstName");
        firstNameField.setAccessible(true);

        // lastNameField 具有访问权限
        Field lastNameField = reflectStudyClass.getDeclaredField("lastName");

        Field ageField = reflectStudyClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(reflectStudy,19);
        System.out.printf("reflectStudy's name is %s %s and age is %d\n",lastNameField.get(reflectStudy),firstNameField.get(reflectStudy),ageField.get(reflectStudy));

        Method[] methods = reflectStudyClass.getMethods();

        for (Method m:methods){
            if (m.getParameterCount()==0){
                System.out.println("反射调用方法"+m.getName()+"返回值:"+m.invoke(reflectStudy));
            }
        }
    }
}