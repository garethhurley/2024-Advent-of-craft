package games;

import io.vavr.collection.LinkedHashMap;
import io.vavr.collection.Map;
import io.vavr.control.Option;

import static io.vavr.control.Option.none;
import static io.vavr.control.Option.some;

public class FizzBuzz {
    public static final int MIN = 1;
    public static final int MAX = 100;

    static {
        LinkedHashMap.of(
                15, "FizzBuzz",
                77, "WhizzBang",
                55, "BuzzBang",
                35, "BuzzWhizz",
                21, "FizzWhizz",
                3, "Fizz",
                5, "Buzz",
                7, "Whizz",
                11, "Bang"
        );
    }

    public static Option<String> convert(int input, Map<Integer, String> gameValuesMap) {
        return isOutOfRange(input) || isValidGameConfiguration(gameValuesMap)
                ? none()
                : some(convertSafely(input, gameValuesMap));
    }

    private static boolean isValidGameConfiguration(Map<Integer, String> gameValuesMap) {
        return gameValuesMap == null || gameValuesMap.isEmpty();
    }

    private static boolean is(Integer divisor, Integer input) {
        return input % divisor == 0;
    }

    private static boolean isOutOfRange(Integer input) {
        return input < MIN || input > MAX;
    }

    private static String convertSafely(Integer input, Map<Integer, String> gameValuesMap) {
        return gameValuesMap
                .find(p -> is(p._1, input))
                .map(p -> p._2)
                .getOrElse(input.toString());
    }
}