import java.util.HashMap;
import java.util.Map;

public class CalculatorApp {

    public static int a;
    public static int b;
    public static char sign;
    private static final Map<Character, Integer> romanToIntMap = new HashMap<>();

    static {
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);;
    }


    public static void main(String[] args) {
        System.out.println(Integer.parseInt("I"));
    }

//    public static void checker(String line) throws CalculateException {
//        char[] lineChars = line.replaceAll(" ", "").toCharArray();
//        if (lineChars.length > 3) {
//            throw new CalculateException();
//        } else if (lineChars[0] != '+' && lineChars[0] != '-' && lineChars[0] != '/' && lineChars[0] != '*') {
//            throw new CalculateException();
//        } else if () {
//
//        }
//    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }
}
