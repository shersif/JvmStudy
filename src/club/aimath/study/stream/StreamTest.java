package club.aimath.study.stream;

import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        testConsumer();
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
