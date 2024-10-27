package pl.mbaranowski._1_happypath;

import pl.mbaranowski._0_core.AccountActivities;
import pl.mbaranowski._0_core.AccountActivitiesImpl;
import pl.mbaranowski._0_core.TransferRequestPOJO;

public class AccountTransferWorkflowImpl implements AccountTransferWorkflow {

  private final AccountActivities accountActivities = new AccountActivitiesImpl();

  @Override
  public String transfer(TransferRequestPOJO transferRequest) {
    accountActivities.withdraw(transferRequest.getFrom(), transferRequest.getTransferId(), transferRequest.getAmount());
    accountActivities.deposit(transferRequest.getTo(), transferRequest.getTransferId(), transferRequest.getAmount());

    return "Successfully transferred money from: " + transferRequest.getFrom() + " to " + transferRequest.getTo();
  }
}
