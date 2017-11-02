package oop;

import oop.constants.Food;
import oop.constants.Transfer;
import oop.voucher.Voucher;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class Main {

    public static void main(String[] args){
        VoucherManager voucherManager = new VoucherManager();
        voucherManager.setDaysDuration(5, 11);
        voucherManager.setFood(Food.BREAKFAST);
        voucherManager.setFood(Food.ALL_INCLUDED);
        voucherManager.setTransfer(Transfer.AIRPLANE);
        voucherManager.setTransfer(Transfer.SHIP);

        voucherManager.setVoucher();

        for (Voucher voucher: voucherManager.getSuitableVouchers()) {
            System.out.println(voucher.toString());
        }



    }



}
