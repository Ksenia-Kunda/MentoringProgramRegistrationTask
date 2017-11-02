package oop.voucher;

import oop.constants.Food;
import oop.constants.Transfer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class Shopping  extends Voucher {

    private static final int minDays = 1;
    private static final int maxDays = 3;
    private static List<Transfer> transferList = new ArrayList<>();

    static {
        transferList.add(Transfer.TRAIN);
        transferList.add(Transfer.BUS);
    }

    @Override
    protected double getPrice() {
        return 0;
    }
}
