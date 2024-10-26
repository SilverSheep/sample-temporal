package pl.mbaranowski._1_happypath;

import pl.mbaranowski._0_core.Account;
import pl.mbaranowski._0_core.AccountImpl;
import pl.mbaranowski._0_core.TransferRequestPOJO;

public class AccountTransferImpl implements AccountTransfer {

  private final Account account = new AccountImpl();

  @Override
  public String transfer(TransferRequestPOJO transferRequest) {
    account.withdraw(transferRequest.getFrom(), transferRequest.getTransferId(), transferRequest.getAmount());
    account.deposit(transferRequest.getTo(), transferRequest.getTransferId(), transferRequest.getAmount());

    return "Successfully transferred money from: " + transferRequest.getFrom() + " to " + transferRequest.getTo();
  }
}
