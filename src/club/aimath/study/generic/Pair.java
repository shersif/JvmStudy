package club.aimath.study.generic;

/**
 * @Description 泛型测试
 * @Date 2022/11/2 21:26
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair(){}

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
        this.second = second;
    }
}
