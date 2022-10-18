package club.aimath.study.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {
    public static void main(String[] args) {
//        var repeatedGreeter = new RepeatedGreeter();
//        repeatedGreeter.greet();
        List<String> names = new ArrayList<>(Arrays.asList("ou", "ting", "xiao", "love", "you", "?"));
        Stream<Person> personStream = names.stream().map(Person::new);
        List<Person> people = personStream.collect(Collectors.toList());
        people.forEach(System.out::println);
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Greeter {
    public void greet(ActionEvent event) {
        System.out.println("Hello, the time is " + Instant.ofEpochMilli(event.getWhen()));
    }
}

class RepeatedGreeter extends Greeter {
    public void greet() {
        var time = new Timer(1000, super::greet);
        time.start();
        JOptionPane.showMessageDialog(null, "确认关闭程序?");
        System.exit(0);
    }
}
