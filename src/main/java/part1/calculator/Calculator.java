package part1.calculator;

/**
 * Created by Ksenia on 01.11.2017.
 */
public class Calculator {

    private int result;

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVISION = "/";
    private static final String MULTIPLICATION = "*";

    public void calculate() {
        Reader.readLine();
        switch (Reader.getOperation()) {
            case Constants.PLUS:
                result = Reader.getFirstNumber() + Reader.getSecondNumber();
                break;
            case Constants.MINUS:
                result = Reader.getFirstNumber() - Reader.getSecondNumber();
                break;
            case Constants.MULTIPLICATION:
                result = Reader.getFirstNumber() * Reader.getSecondNumber();
                break;
            case Constants.DIVISION:
                result = Reader.getFirstNumber() / Reader.getSecondNumber();
                break;
        }
    }

    public void printResult() {
        System.out.println(result);
    }


}
