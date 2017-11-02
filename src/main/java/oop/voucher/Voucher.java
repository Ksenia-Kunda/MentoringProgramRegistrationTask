package oop.voucher;

/**
 * Created by Ksenia on 02.11.2017.
 */
public abstract class Voucher {

    protected String transfer;
    protected int daysNumber;
    protected String food;

    protected abstract double getPrice();
}
