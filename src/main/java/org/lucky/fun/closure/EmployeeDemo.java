package org.lucky.fun.closure;


import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

record Employees(String name, int exp, double hike_percent){}

@FunctionalInterface
interface EmployeesData{
    Function<Double, Employees> apply(Employees e);
}
public class EmployeeDemo {

    public static void main(String[] args) {
        EmployeesData emp_fun = (Employees e) -> hike_per -> {
            hike_per = e.exp() > 2 ? hike_per : 2;
            return new Employees(e.name(),e.exp(),hike_per);
        };

//        Function<Double, Employees> lucky = emp.apply(new Employees("lucky", 32, 0.0));

        List<Function<Double, Employees>> list_emp = IntStream.range(1, 5)
                .mapToObj(i -> new Employees("emp"+i, i, 0.0))
                .map(emp_fun::apply)
                .toList();

        IntStream.range(1, 5)
                .mapToObj(i -> new Employees("emp"+i, i, 0.0))
                .forEach(System.out::println);
        list_emp
                .stream()
                .map(map_fun -> map_fun.apply(20.0))
                .forEach(System.out::println);
    }
}
