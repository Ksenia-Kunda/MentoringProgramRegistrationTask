package oop.voucher;

import oop.constants.Food;
import oop.constants.Transfer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class Treatment  extends Voucher {

    private static final int days = 14;
    private static List<Transfer> transferList = new ArrayList<>();
    private static List<Food> foodList = new ArrayList<>();

    static {
        transferList.add(Transfer.TRAIN);
        transferList.add(Transfer.BUS);

        foodList.add(Food.FIFE_TIMES_A_DAY);
        foodList.add(Food.THREE_TIMES_A_DAY);
    }

    @Override
    protected double getPrice() {
        return 0;
    }
}
