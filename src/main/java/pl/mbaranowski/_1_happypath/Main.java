package pl.mbaranowski._1_happypath;

import pl.mbaranowski._0_core.TransferRequestPOJO;

public class Main {
    public static void main(String[] args) {
        var transfer = new AccountTransferImpl();
        var transferRequest = new TransferRequestPOJO("fromAccount", "toAccount", 1000);

        System.out.println("Before transfer");

        var result = transfer.transfer(transferRequest);
        System.out.println(result);

        System.out.println("After transfer");
    }
}