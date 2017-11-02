package oop.voucher;

import oop.constants.Food;
import oop.constants.Transfer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class Cruise extends Voucher{

    private static final int minDays = 3;
    private static final int maxDays = 10;
    private static List<Transfer> transferList = new ArrayList<>();
    private static List<Food> foodList = new ArrayList<>();

    static {
        transferList.add(Transfer.SHIP);

        foodList.add(Food.ALL_INCLUDED);
        foodList.add(Food.TWO_TIMES_A_DAY);
        foodList.add(Food.THREE_TIMES_A_DAY);
    }

    @Override
    protected double getPrice() {
        return 0;
    }

}
