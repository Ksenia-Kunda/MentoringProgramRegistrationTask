package oop.voucher;

import oop.constants.Food;
import oop.constants.Transfer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class Excursion extends Voucher {

    private static final int minDays = 2;
    private static final int maxDays = 5;
    private static List<Transfer> transferList = new ArrayList<>();

    static {
        transferList.add(Transfer.BUS);
    }
    @Override
    protected double getPrice() {
        return 0;
    }
}
