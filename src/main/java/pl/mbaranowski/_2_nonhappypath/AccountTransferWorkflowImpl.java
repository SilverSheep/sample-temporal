package pl.mbaranowski._2_nonhappypath;

import pl.mbaranowski._0_core.AccountActivities;
import pl.mbaranowski._0_core.AccountActivitiesImpl;
import pl.mbaranowski._0_core.TransferRequestPOJO;

public class AccountTransferWorkflowImpl implements AccountTransferWorkflow {

  private final AccountActivities accountActivities = new AccountActivitiesImpl();
  private final int maxTries = 4;

  // debounce to avoid DoS on transaction system
  private final int debounceFactor = 2;
  private final int initialDebounce = 1; // seconds

  @Override
  public String transfer(TransferRequestPOJO transferRequest) throws InterruptedException {
    int tryNo = 1;
    boolean success = false;
    int debounce = initialDebounce * 1000;  // milliseconds

    while (!success && tryNo <= maxTries) {
      try {
        accountActivities.withdraw(transferRequest.getFrom(), transferRequest.getTransferId(), transferRequest.getAmount());
        success = true;
      } catch (Exception e) {
        System.out.println("Exception occured while withdrawing from " + transferRequest.getFrom());
        Thread.sleep(debounce);
        debounce *= debounceFactor;
        ++tryNo;
      }
    }

    if (!success) {
      throw new RuntimeException("Aborting due to unsuccessful withdraw");
    }

    tryNo = 1;
    success = false;
    debounce = initialDebounce * 1000;  // milliseconds

    while (!success && tryNo <= maxTries) {
      try {
        accountActivities.deposit(transferRequest.getTo(), transferRequest.getTransferId(), transferRequest.getAmount());
        success = true;
      } catch (Exception e) {
        System.out.println("Exception occured while depositing to " + transferRequest.getTo());
        Thread.sleep(debounce);
        debounce *= debounceFactor;
        ++tryNo;
      }
    }

    if (success) {
      return "Successfully transferred money from: " + transferRequest.getFrom() + " to " + transferRequest.getTo();
    }

    // return money to sender
    System.out.println("Unsuccessful deposit. Returning money");
    accountActivities.deposit(transferRequest.getFrom(), transferRequest.getTransferId(), transferRequest.getAmount());

    return "Unsuccessful transfer. Returned money back";
  }
}
