package club.aimath.study;

/**
 * 减少栈内存容量,测试栈溢出
 * VM Args：-Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"+sof.stackLength);
            throw e;
        }
    }
}
