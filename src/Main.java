import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws Exception {
        calc("");
    }

    public static String calc(String input) throws Exception {
        System.out.println("Калькулятор принимает числа от 1 до 10, работает с арабскими числами, так и с римскими.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String text = scanner.nextLine();
        String changeText = text.replaceAll(" ", "");

        ////Арабские
        String regexArab = "^(10|[0-9])[\\+|\\-|\\/|\\*](10|[0-9])$";
        Pattern patternArab = Pattern.compile(regexArab);
        Matcher matcherArab = patternArab.matcher(changeText);
        ////Римские
        String regexRom = "^(IX|IV|V?I{0,3}|X)[\\+|\\-|\\/|\\*3](IX|IV|V?I{0,3}|X)$";
        Pattern patternRom = Pattern.compile(regexRom);
        Matcher matcherRom = patternRom.matcher(changeText);

        if (matcherArab.find() || matcherRom.find()) {
            for (int i = 0; i < changeText.length(); i++) {
                if (changeText.charAt(i) == '+' || changeText.charAt(i) == '-' || changeText.charAt(i) == '/' || changeText.charAt(i) == '*') {
                    char a = changeText.charAt(i);

                    String[] words = changeText.split("[\\+|\\-|\\/|\\*]");
                    String num1 = words[0];
                    String num2 = words[1];
                    int numOne = romanToNumber(num1);
                    int numTwo = romanToNumber(num2);

                    switch (a) {
                        case '+':
                            if (numOne < 0 && numTwo < 0) {
                            } else {
                                int addition = numOne + numTwo;
                                String RomanToString = convertNumToRoman(addition);
                                System.out.println(RomanToString);
                                break;
                            }
                            numOne = Integer.parseInt(num1);
                            numTwo = Integer.parseInt(num2);
                            int addition = numOne + numTwo;
                            System.out.println(addition);
                            break;

                        case '-':
                            if (numOne < 0 && numTwo < 0) {
                            } else {
                                int subtraction = numOne - numTwo;
                                String resultRoman = convertNumToRoman(subtraction);
                                System.out.println(resultRoman);
                                break;
                            }
                            numOne = Integer.parseInt(num1);
                            numTwo = Integer.parseInt(num2);
                            int subtraction = numOne - numTwo;
                            System.out.println(subtraction);
                            break;

                        case '/':
                            if (numOne < 0 && numTwo < 0) {
                            } else {
                                int division = numOne / numTwo;
                                String resultRoman = convertNumToRoman(division);
                                System.out.println(resultRoman);
                                break;
                            }
                            numOne = Integer.parseInt(num1);
                            numTwo = Integer.parseInt(num2);
                            int division = numOne / numTwo;
                            System.out.println(division);
                            break;

                        case '*':
                            if (numOne < 0 && numTwo < 0) {
                            } else {
                                int multiplication = numOne * numTwo;
                                String resultRoman = convertNumToRoman(multiplication);
                                System.out.println(resultRoman);
                                break;
                            }
                            numOne = Integer.parseInt(num1);
                            numTwo = Integer.parseInt(num2);
                            int multiplication = numOne * numTwo;
                            System.out.println(multiplication);
                            break;
                    }
                }
            }
            scanner.close();
            return input;
        } else {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }

    private static String convertNumToRoman(int numArabian) {
        try {
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                    "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI",
                    "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI",
                    "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                    "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                    "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                    "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII",
                    "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII",
                    "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            final String s = roman[numArabian];
            return s;
        } catch (Exception e) {
            System.err.println("В римской системе нет отрицательных чисел!");
        }
        return "Повторите операцию заново!";
    }

    private static int romanToNumber(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        return -1;
    }
}
