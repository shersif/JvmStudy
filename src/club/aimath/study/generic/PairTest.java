package club.aimath.study.generic;

/**
 * @Description 泛型测试
 * @Date 2022/11/2 21:27
 * @Created by outx
 * @Email outingxiao@126.com
 */
public class PairTest {
    public static void main(String[] args) {
        Dog dh = new Dog("Big Yellow", "yellow");
        Dog wc = new Dog("Wang Cai", "brown");
        var buddies = new Pair<>(dh, wc);
        printBuddies(buddies);

        Dog[] dogs=new Dog[]{dh,wc};
        var result=new Pair<Animal>();
        minmaxNames(dogs,result);
        System.out.println("first:"+result.getFirst().getName()+", second:"+result.getSecond().getName());

        maxminNames(dogs,result);
        System.out.println("first:"+result.getFirst().getName()+", second:"+result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Animal> p) {
        Animal first = p.getFirst();
        Animal second = p.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+" are buddies.");
    }

    public static void minmaxNames(Dog[] dogs,Pair<? super Dog> result){
        int minIndex=0,maxIndex=0;
        for (int i = 0; i < dogs.length; i++)
            if (dogs[minIndex].getName().compareTo(dogs[i].getName())>0)
                minIndex=i;
            else if (dogs[maxIndex].getName().compareTo(dogs[i].getName())<0)
                maxIndex=i;

        result.setFirst(dogs[minIndex]);
        result.setSecond(dogs[maxIndex]);
    }

    public static void maxminNames(Dog[] dogs,Pair<? super Dog> result){
        minmaxNames(dogs,result);
        PairAlg.swap(result);
    }
}

class PairAlg{
    public static boolean hasNulls(Pair<?> p){
        return p.getFirst()==null||p.getSecond()==null;
    }
    public static void swap(Pair<?> p){
        // 会进行通配符捕获
        swapHelper(p);}

    public static <T> void swapHelper(Pair<T> p){
        T t= p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
