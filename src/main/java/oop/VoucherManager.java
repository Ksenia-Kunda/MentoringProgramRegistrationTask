package oop;

import oop.constants.Food;
import oop.constants.Transfer;
import oop.exception.NoParametersException;
import oop.voucher.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class VoucherManager {

    private static final int DAYS = 2;
    private static final int TRANSFER = 3;
    private static final int FOOD = 4;

    private List<List<String>> voucherCharacteristic;

    private List<Integer> daysDuration = new ArrayList<>();
    private List<Transfer> transferList = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();

    private List<Voucher> suitableVouchers = new ArrayList<>();

    public void setDaysDuration(int... daysDuration) {
        for (int i = 0; i < daysDuration.length; i++) {
            this.daysDuration.add(daysDuration[i]);
        }
    }

    public void setTransfer(Transfer transfer) {
        this.transferList.add(transfer);
    }

    public void setFood(Food food) {
        this.foodList.add(food);
    }

    public void setVoucher() {
        handleRequest();
        if (isVoucherSuitable("Cruise")) {
            Voucher cruise = new Cruise();
            suitableVouchers.add(addParameters(cruise, "Cruise"));
        }
        if (isVoucherSuitable("Excursion")) {
            Voucher excursion = new Excursion();
            suitableVouchers.add(addParameters(excursion, "Excursion"));
        }
        if (isVoucherSuitable("Shopping")) {
            Voucher shopping = new Shopping();
            suitableVouchers.add(addParameters(shopping, "Shopping"));
        }
        if (isVoucherSuitable("Treatment")) {
            Voucher treatment = new Treatment();
            suitableVouchers.add(addParameters(treatment, "Treatment"));
        }
        if (isVoucherSuitable("Vacation")) {
            Voucher vacation = new Vacation();
            suitableVouchers.add(addParameters(vacation, "Vacation"));
        }
    }

    private void handleRequest() {
        if (daysDuration.isEmpty() && transferList.isEmpty() && foodList.isEmpty()) {
            throw new NoParametersException();
        }
    }

    public boolean isVoucherSuitable(String voucherType) {
        boolean isDaysSuitable = false;
        boolean isTransferSuitable = false;
        boolean isFoodSuitable = false;
        voucherCharacteristic = MySqlHandler.readMySQLdb(voucherType);
        for (int dayDuration : daysDuration) {
            isDaysSuitable = voucherCharacteristic.get(DAYS).contains(String.valueOf(dayDuration));
            if (isDaysSuitable) {
                break;
            }
        }
        for (Enum transfer : transferList) {
            isTransferSuitable = voucherCharacteristic.get(TRANSFER).contains(String.valueOf(transfer));
            if (isTransferSuitable) {
                break;
            }
        }
        for (Enum food : foodList) {
            isFoodSuitable = voucherCharacteristic.get(FOOD).contains(String.valueOf(food));
            if (isFoodSuitable) {
                break;
            }
        }
        return isDaysSuitable && isTransferSuitable && isFoodSuitable;
    }

    private List<Integer> getDays(String voucherType) {
        List<Integer> days = new ArrayList<>();
        for (int dayDuration : daysDuration) {
            if (voucherCharacteristic.get(DAYS).contains(String.valueOf(dayDuration)));
                days.add(dayDuration);
        }
        return days;
    }

    private List<Transfer> getTransferList(String voucherType) {
        List<Transfer> transfers = new ArrayList<>();
        for (Transfer transfer : transferList) {
            if (voucherCharacteristic.get(TRANSFER).contains(String.valueOf(transfer)));
            transfers.add(transfer);
        }
        return transfers;
    }

    private List<Food> getFoodList(String voucherType) {
        List<Food> foods = new ArrayList<>();
        for (Food food : foodList) {
            if (voucherCharacteristic.get(FOOD).contains(String.valueOf(food)));
            foods.add(food);
        }
        return foods;
    }

    private Voucher addParameters(Voucher voucher, String type) {
        voucher.setDaysNumber(getDays(type));
        voucher.setFood(getFoodList(type));
        voucher.setTransfer(getTransferList(type));
        return voucher;
    }

    public List<Voucher> getSuitableVouchers() {
        return suitableVouchers;
    }
}
