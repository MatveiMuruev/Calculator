import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    // BinaryOperator<Integer> devide = (x, y) -> x / y; // при у=0 выдает ошибку, так как на ноль делить нельзя
    //решение: ввести проверку переменной у на равенство нулю, например (y != 0 ?):

    //ВАРИАНТ №1 (дается ответ ноль БЕЗ КОММЕНТАРИЕВ):
    // BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : 0;

    //ВАРИАНТ №2 (дается ответ ноль С КОММЕНТАРИЯМИ):
    BinaryOperator<Integer> devide = (x, y) -> {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println("ошибка! деление на ноль! проверьте данные!");
        }
        return 0;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

}
