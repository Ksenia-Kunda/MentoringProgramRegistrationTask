package oop.exception;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class NoParametersException extends RuntimeException{

    public NoParametersException() {
        System.out.println("There are no parameters for voucher search");
    }
}
