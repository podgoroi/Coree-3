package task.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream {

  public static int addNumbers(int num1, int num2) {
    BinaryOperator<Integer> bo = (x, y) -> num1 + num2;
    return bo.apply(num1, num2);
  }

  public static List<String> filterWordsByLetter(List<String> words, char letter) {
    List<String> list = new ArrayList<>();
    for (String str : words) {
      Predicate<String> pr = str1 -> {
        if (str.charAt(0) == letter) {
          return true;
        } else {
          return false;
        }
      };
      if (pr.test(str)) {
        list.add(str);
      } else {
        continue;
      }
    }
    return list;
  }

  public static List<Integer> squareNumbers(List<Integer> numbers) {
    Function<Integer, Integer> f = x -> x * x;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < numbers.size(); i++) {
      int a = f.apply(numbers.get(i));
      list.add(a);
    }
    return list;
  }

  public static void printUpperCase(List<String> words) {
    Consumer<String> c = (String str) -> System.out.println(str.toUpperCase());
    words.forEach(e -> c.accept(e));
  }

  public static int sumOfNumbers(List<Integer> numbers) {
    int sum = numbers.stream().reduce((accumulator, element) -> accumulator + element).get();
    return sum;
  }

  public static OptionalDouble averageOfNumbers(List<Integer> numbers) {
    OptionalDouble o = numbers.stream().mapToDouble(e -> e).average();
    return o;
  }

  public static Optional<Integer> findMaxNumber(List<Integer> numbers) {
    return numbers.stream().max(Integer::compare);
  }

  public static Optional<Integer> findMinNumber(List<Integer> numbers) {
    return numbers.stream().min(Integer::compare);
  }

  public static boolean containsValue(List<Integer> numbers, int value) {
    return numbers.stream().anyMatch(x -> {
      if (numbers.contains(value)) {
        return true;
      } else {
        return false;
      }
    });
  }

  public static List<Integer> removeDuplicates(List<Integer> numbers) {
    List <Integer> numbers2 = numbers.stream().distinct().collect(Collectors.toList());
    return numbers2;
  }

  public static List<Integer> stringLengths(List<String> words) {
    List <Integer> numbers = words.stream().map(x -> x.length()).collect(Collectors.toList());
    return numbers;
  }

  public static String concatenateStrings(List<String> words) {
    StringBuilder str = new StringBuilder("");
    words.stream().forEach(element -> str.append(element).append(" "));
    return str.deleteCharAt(str.length() - 1).toString();
  }

  public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
    List <Integer> numbers2 = numbers.stream().filter(el -> el % 2 == 0).collect(Collectors.toList());
    return numbers2;
  }

  public static Optional<Integer> findFirstEvenNumber(List<Integer> numbers) {
    return numbers.stream().filter(el -> el % 2 == 0).findFirst();
  }

}