import java.util.Scanner;
import java.util.TreeMap;

public class CalculatorApp {

    public static int a;
    public static int b;
    public static String sign;
    public static boolean romanFlag;

    private static final TreeMap<String, Integer> roman = new TreeMap<>();
    private static final TreeMap<Integer, String> arabic = new TreeMap<>();

    static {
        roman.put("I", 1);
        roman.put("II", 2);
        roman.put("III", 3);
        roman.put("IV", 4);
        roman.put("V", 5);
        roman.put("VI", 6);
        roman.put("VII", 7);
        roman.put("VIII", 8);
        roman.put("IX", 9);
        roman.put("X", 10);

        arabic.put(1, "I");
        arabic.put(2, "II");
        arabic.put(3, "III");
        arabic.put(4, "IV");
        arabic.put(5, "V");
        arabic.put(6, "VI");
        arabic.put(7, "VII");
        arabic.put(8, "VIII");
        arabic.put(9, "IX");
        arabic.put(10, "X");
        arabic.put(20, "XX");
        arabic.put(30, "XXX");
        arabic.put(40, "XL");
        arabic.put(50, "L");
        arabic.put(60, "LX");
        arabic.put(70, "LXX");
        arabic.put(80, "LXXX");
        arabic.put(90, "XC");
        arabic.put(100, "C");
    }


    public static void main(String[] args) throws CalculateException {
        Scanner scanner = new Scanner(System.in);
        checker(scanner.nextLine());
        System.out.println(calculate());
    }

    public static void checker(String line) throws CalculateException {
        String[] lines = line.split(" ");
        if (lines.length != 3) {
            throw new CalculateException("Неверный формат ввода");
        } else if (!lines[1].equals("+") && !lines[1].equals("-") && !lines[1].equals("/") && !lines[1].equals("*")) {
            throw new CalculateException("Неправильный знак");
        } else if (lines[0].matches("\\d+") && !lines[2].matches("\\d+") || !lines[0].matches("\\d+") && lines[2].matches("\\d+")) {
            throw new CalculateException("Операнды в неправильном формате");
        } else if (lines[0].matches("\\d+") && lines[2].matches("\\d+")) {
            a = Integer.parseInt(lines[0]);
            b = Integer.parseInt(lines[2]);
            sign = lines[1];
            if (a > 10 || b > 10) {
                throw new CalculateException("Операнды должны быть в пределах от 1 до 10");
            }
        } else {
            a = converterToInt(lines[0]);
            b = converterToInt(lines[2]);
            romanFlag = true;
            sign = lines[1];
        }
    }

    public static String calculate() throws CalculateException {
        int result;
        switch (sign) {
            case "+":
               result = addition();
               break;
            case "-":
                result = subtraction();
                break;
            case "*":
                result = multiplication();
                break;
            case "/":
                if (b == 0) {
                    throw new CalculateException("Деление на ноль");
                }
                result = division();
                break;
            default:
                result = 0;
        }
        if (romanFlag) {
            if (result < 1) {
                throw new CalculateException("Результат меньше единицы");
            }
            return converterToRoman(String.valueOf(result));
        }
        return String.valueOf(result);
    }

    public static int converterToInt(String num) throws CalculateException {
        int result;
        try {
            result = roman.get(num);
        } catch (NullPointerException e) {
            throw new CalculateException("Операнды должны быть в пределах от I до X");
        }
        return result;
    }

    public static String converterToRoman(String num) {
        int number = Integer.parseInt(num);
        int floorKey = arabic.floorKey(number);
        if (number == floorKey) {
            return arabic.get(number);
        }
        return arabic.get(floorKey) + converterToRoman(String.valueOf(number - floorKey));
    }

    public static int addition() {
        return a + b;
    }

    public static int subtraction() {
        return a - b;
    }

    public static int division() {
        return a / b;
    }

    public static int multiplication() {
        return a * b;
    }
}
