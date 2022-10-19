package club.aimath.study.stream;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class StreamTest {

    private static final DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
//        testConsumer();
//        testSupplier();
//        testFunction();
//        test4();
//        testStreamMap();
        testHasStatus();
    }

    public static void  test1(){
        Stream<Integer> integerStream = Stream.of(2, 2, 10, 50);
        Integer max = integerStream.max(Integer::compareTo).get();
//        Integer max = integerStream.max((Integer a, Integer b) -> a - b).get();
        System.out.println("max = " + max);
    }

    public static void test2(){
        Stream<String> names = Stream.of("zs", "ls", "ww", "zl");
        names.forEach(System.out::println);
    }

    // 测试延时调用
    public static void test3(){
        //未遇到终结操作不会执行
        Stream<Integer> peek = List.of(1, 2, 3, 45, 5, 6).stream().filter(i -> i % 5 == 0).peek(System.out::println).filter(i->i>5);
        System.out.println("在此之前不会进行调用!");
        //调用count终结操作,执行函数
        System.out.println("list count is "+peek.count());
    }

    // 测试创建Stream
    public static void test4(){

        Stream<Integer> integerStream = Stream.of(1, 2, 3);

        Stream<Double> doubleStream = Stream.of(1.1d, 2.2d, 3.3d);

        Stream<String> stringStream = Stream.of("1", "2", "3");

        Stream<Object> empty = Stream.empty();

        // 无限添加值
//        Stream<Object> stream = Stream.generate(StreamTest::methodForSupplier).peek((s) -> {
//            try {
//                sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        stream.forEach(System.out::println);

        Stream<Integer> integerStreamList = List.of(1, 2, 3).stream();

        Stream<String> stringStreamList = List.of("1", "2", "3").stream();

        Stream<Integer> listStream = List.of(1, 2, 3).stream();

        Stream<Integer> setStream = Set.of(1, 2, 3).stream();

        // 创建并行流,元素过万对性能才有明显提升
        Stream<Integer> integerParallelStream = Stream.of(1, 2, 3).parallel();

        Stream<String> stringParallelStream = Stream.of("1", "2", "3").parallel();

        Stream<Integer> integerParallelStreamList = List.of(1, 2, 3).parallelStream();

        Stream<String> stringParallelStreamList = List.of("1", "2", "3").parallelStream();

        // 并行转串行流
        Stream.of(1, 2, 3).parallel().sequential();

        // 连接Stream,自动推断会自动的推断出两种类型相同的父类
        Stream<? extends Serializable> concat = Stream
                .concat(Stream.of(1, 2, 3), Stream.of('4', '5', '6'));
        concat.forEach(o-> System.out.println(o.getClass().getTypeName()));


    }

    public static void testStreamMap(){
        IntStream integerStream = IntStream.of(1, 2, 31);
        integerStream.map(i -> i % 3 * 2%3).forEach(System.out::println);

    }

    public static void testHasStatus(){
        IntStream intStream = IntStream.of(1, 2, 3, 3, 4, 4, 5, 6, 10);
        IntStream distinct = intStream.distinct();
        distinct.forEach(System.out::println);
    }

    public static void testPredicate(){
        Stream<Book> bookStream = Stream.of(new Book("三国演义", 12d), new Book("西游记", 20d));
        Stream<Book> bookStream1 = bookStream.filter(book -> book.name.length() > 3);
//        Stream<Book> bookStream2 = bookStream.filter(book -> book.price > 15d);
        System.out.println("name length > 3 books:");
        // 在此应用了 Consumer
        bookStream1.forEach(System.out::print);
//        System.out.println("price > 15 books:");
//        bookStream2.forEach(System.out::print);
    }

    public static void testConsumer(){
        Stream<Book> bookStream = Stream.of(new Book("三国演义", 12d), new Book("西游记", 20d));
        bookStream.forEach(System.out::println);
    }

    public static void testSupplier(){
        Stream<String> names = Stream.of("zs", "ls", "ww", "zl");
        List<String> listDetail=names.collect(
                ()->{
            List<String> arrayList = new ArrayList<>(Collections.singleton("hello"));
            System.out.println("第一个list诞生,size:"+arrayList.size());
            return arrayList;
        },
                (theList,item)->{
            System.out.println("第二个list的size:"+theList.size());
            theList.add(item);
        },
                (list1,list2)->{
            System.out.println("第三个list1的size:"+list1.size());
            System.out.println("第三个list2的size:"+list2.size());
            list1.addAll(list2);
        });

        System.out.println(listDetail);
    }

    public static Object methodForSupplier(){
        return dateFormat.format(new Date());
    }

    public static String methodForTestFunction(String s){
        return s+="hello";
    }

    public static void testFunction(){
        Stream<String> names = Stream.of("zs", "ls", "ww", "zl");
        Stream<String> stringStream = names.map(StreamTest::methodForTestFunction);
        stringStream.forEach(System.out::println);
    }

    static class Book{
        private String name;
        private Double price;

        public Book(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", price='" + price + '\'' +
                    '}';
        }
    }
}
