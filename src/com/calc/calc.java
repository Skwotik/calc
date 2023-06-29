package com.calc;
import java.util.List;
import java.util.Scanner;

/**
 * Создай консольное приложение “Калькулятор”.
 * Приложение должно читать из консоли введенные пользователем строки, числа, арифметические операции
 * проводимые между ними и выводить в консоль результат их выполнения.
 * Реализуй класс Main с методом public static String calc(String input).
 * Метод должен принимать строку с арифметическим выражением между двумя числами и возвращать строку
 * с результатом их выполнения. Ты можешь добавлять свои импорты, классы и методы.
 * Добавленные классы не должны иметь модификаторы доступа (public или другие)
 */

public class calc {

    static Scanner scanner = new Scanner(System.in);
    static List<String> valueRomanList = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    static List<String> valueIntList = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    public static void main(String[] args) {

        String firstNumber, secondNumber;
        String operation = "";

        System.out.println("Введите выражение в формате [x+y]:");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                operation = "+";
            } else if (input.charAt(i) == '-') {
                operation = "-";
            } else if (input.charAt(i) == '*') {
                operation = "*";
            } else if (input.charAt(i) == '/') {
                operation = "/";
            }
        }

        String[] inputStr = input.split("[+-/*]");
        if (inputStr.length != 2){
            throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        firstNumber = inputStr[0];
        secondNumber = inputStr[1];

        String strResult;
        int intResult;
        int number1 = romanToNumber(firstNumber);
        int number2 = romanToNumber(secondNumber);

        if (valueRomanList.contains(firstNumber) && valueRomanList.contains(secondNumber)) {
            if ((number1 < 0 || number1 > 10) || (number2 < 0 || number2 > 10)) {
                System.out.println("Неверный формат значений");
            } else {
                String strRomanNumber1 = Integer.toString(romanToNumber(firstNumber));
                String strRomanNumber2 = Integer.toString(romanToNumber(secondNumber));
                strResult = calc(strRomanNumber1, operation, strRomanNumber2);
                intResult = Integer.parseInt(strResult);
                if (intResult <= 0) {
                    System.out.println("В римской системе нет отрицательных чисел");
                } else {
                    System.out.println("Ответ: " + convertNumToRoman(intResult));
                }
            }
        } else if (valueIntList.contains(firstNumber) && valueIntList.contains(secondNumber)) {
            System.out.println("Ответ: " + calc(firstNumber, operation, secondNumber));
        } else {
            System.out.println("Неверный формат значений");
        }

    }

    public static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String s = roman[numArabian];
        return s;
    }

    public static String calc(String value1, String operation, String value2) {
        int resultInt = 0;
        int number1 = Integer.parseInt(value1);
        int number2 = Integer.parseInt(value2);
        switch (operation) {
            case "+":
                resultInt = number1 + number2;
                break;
            case "-":
                resultInt = number1 - number2;
                break;
            case "*":
                resultInt = number1 * number2;
                break;
            case "/":
                resultInt = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("Неверная математическая операция");
        }
        String result = Integer.toString(resultInt);
        return result;
    }

    public static int romanToNumber (String romanValue) {
        if (romanValue.equals("I")) {
             return 1;
        } else if (romanValue.equals("II")) {
             return 2;
        } else if (romanValue.equals("III")) {
             return 3;
        } else if (romanValue.equals("IV")) {
             return 4;
        } else if (romanValue.equals("V")) {
             return 5;
        } else if (romanValue.equals("VI")) {
             return 6;
        } else if (romanValue.equals("VII")) {
             return 7;
        } else if (romanValue.equals("VIII")) {
             return 8;
        } else if (romanValue.equals("IX")) {
             return 9;
        } else if (romanValue.equals("X")) {
            return 10;
        }
        return -1;
    }
}
