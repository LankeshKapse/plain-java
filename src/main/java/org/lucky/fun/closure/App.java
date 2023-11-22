package org.lucky.fun.closure;


import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.IntStream;

record Employee(String name,int exp,double hike_percent){}

@FunctionalInterface
interface BiFunction<T, U, R> {
    R apply(T t, U u);

    default <V> BiFunction<T, U, V> andThen(BiFunction<? super T,? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        System.out.println("calling add then");
        return (T t, U u) -> {
            R apply = apply(t, u);
            System.out.println("applyied apply(t, u)>> "+apply);
            System.out.println("x >> "+t);
            System.out.println("y >> "+apply);
            return after.apply(t,apply);
        };
    }
}
@FunctionalInterface
interface UnaryFun<T> {
    T apply(T t);
}


@FunctionalInterface
interface HigherFun<T,R>{
    Function<T,R> apply(T t);
}

@FunctionalInterface
interface HigherFun2<T,R,U>{
    BiFunction<T,R,U> apply(Function<T,R> fun);
}





public class App {

    public static void main(String[] args){
        BiFunction<Integer,Integer,Integer> fun = (x, y) -> {
            System.out.println("applying addition");
            return x + y;
        };
        UnaryFun<Integer> unary_fun = (x) -> -x;

//        System.out.println(fun.apply(10,20));

//        System.out.println(unary_fun.apply(20));

        Integer apply = fun.andThen((x,y) -> x-y).apply(10, 20);
        System.out.println("apply "+apply);

        HigherFun<Integer,Integer> fun1 = (Integer x) -> y-> x*y;
        System.out.println("fun1>> "+
                fun1.apply(3)
                .apply(4));

        HigherFun2<Integer,Integer,Integer> higherFun2 = (in_fun) -> (integer, integer2) -> integer+in_fun.apply(integer2);
        System.out.println(
                higherFun2
                .apply((x) -> x*x)
                .apply(2,3)
        );

        EmployeeData emp = (Employees e) -> hike_per -> new Employees(e.name(),e.exp(),hike_per);

        Function<Double, Employees> lucky = emp.apply(new Employees("lucky", 32, 0.0));

        List<Function<Double, Employees>> list_emp = IntStream.range(1, 5)
                .mapToObj(i -> emp.apply(new Employees("emp"+i, i, 0.0)))
                .toList();
        list_emp
                .stream()
                .map(map_fun -> map_fun.apply(5.0))
                .forEach(System.out::println);

    }
}
@FunctionalInterface
interface EmployeeData{
    Function<Double, Employees> apply(Employees e);
}

