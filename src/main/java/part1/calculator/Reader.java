package part1.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ksenia on 01.11.2017.
 */
public class Reader {

    private static String operation;
    private static String firstNumber;
    private static String secondNumber;

    public static void readLine() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("Chose and type operation: +, -, *, /");
                operation = bufferedReader.readLine().trim();
            } while (!isOperationCorrect(operation));

            do {
                System.out.println("Type first number");
                firstNumber = bufferedReader.readLine();
            } while (!isNumber(firstNumber));

            do {
                System.out.println("Type second number");
                secondNumber = bufferedReader.readLine();
            } while (!isNumber(secondNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isNumber(String line) {
        if (!line.matches("^\\d+$")) {
            return false;
        }
        return true;
    }

    private static boolean isOperationCorrect(String operation) {
        return operation.equals(Constants.PLUS) || operation.equals(Constants.MINUS) || operation.equals(Constants.DIVISION) || operation.equals(Constants.MULTIPLICATION);
    }

    public static String getOperation() {
        return operation;
    }

    public static int getFirstNumber() {
        return Integer.parseInt(firstNumber);
    }

    public static int getSecondNumber() {
        return Integer.parseInt(secondNumber);
    }


}
