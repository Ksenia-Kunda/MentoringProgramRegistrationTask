package oop.voucher;

import oop.constants.Food;
import oop.constants.Transfer;

import java.util.List;

/**
 * Created by Ksenia on 02.11.2017.
 */
public abstract class Voucher {

    protected List<Transfer> transfer;
    protected List<Integer> daysNumber;
    protected List<Food> food;


    public List<Transfer> getTransfer() {
        return transfer;
    }

    public List<Integer> getDaysNumber() {
        return daysNumber;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setTransfer(List<Transfer> transfer) {
        this.transfer = transfer;
    }

    public void setDaysNumber(List<Integer> daysNumber) {
        this.daysNumber = daysNumber;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    protected abstract double getPrice();

    @Override
    public String toString() {
        String result = "Voucher{" +
                "transfer=";
        for (Transfer transfer: transfer) {
            result += String.valueOf(transfer);
        }
        result += ", daysNumber=";

        for (int day: daysNumber) {
            result += String.valueOf(day);
        }
        result += ", food=";
        for (Food food: food) {
            result += String.valueOf(food);
        }
        result +=  '}';
        return result;
    }
}
