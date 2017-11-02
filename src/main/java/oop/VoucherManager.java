package oop;

import oop.constants.Food;
import oop.constants.Transfer;
import oop.voucher.Treatment;
import oop.voucher.Voucher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class VoucherManager {

    private int[] days;
    private List<Transfer> transferList = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();

    public void setDays(int ... days) {
        this.days = days;
    }

    public void setTransfer(Transfer transfer) {
        this.transferList.add(transfer);
    }

    public void setFood(Food food) {
        this.foodList.add(food);
    }

    public Voucher getVoucher() {
        return null;
    }

    private static void handleRequest() {

    }
}
