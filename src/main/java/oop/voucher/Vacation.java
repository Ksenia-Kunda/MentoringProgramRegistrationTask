package oop.voucher;

import oop.constants.Food;
import oop.constants.Transfer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class Vacation extends Voucher {

    private double price;

    private static final int minDays = 7;
    private static final int maxDays = 21;
    private static List<Transfer> transferList = new ArrayList<>();
    private static List<Food> foodList = new ArrayList<>();

    static {
        transferList.add(Transfer.AIRPLANE);
        transferList.add(Transfer.TRAIN);
        transferList.add(Transfer.BUS);

        foodList.add(Food.ALL_INCLUDED);
        foodList.add(Food.TWO_TIMES_A_DAY);
        foodList.add(Food.BREAKFAST);
    }

    @Override
    protected double getPrice() {
        return 0;
    }
}
