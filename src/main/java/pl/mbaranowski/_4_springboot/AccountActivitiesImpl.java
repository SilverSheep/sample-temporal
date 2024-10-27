package pl.mbaranowski._4_springboot;

import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

@Component
@ActivityImpl(taskQueues = "AccountTransferQueue")
public class AccountActivitiesImpl implements AccountActivities {

  @Override
  public String withdraw(String accountId, String transferId, long amountCents) {
    System.out.printf("Withdraw from %s of %d cents requested. transferId=%s\n", accountId, amountCents, transferId);
//    throw new RuntimeException("simulated withdraw error!");
    return "Successfully withdrawn money from: " + accountId;
  }

  @Override
  public String deposit(String accountId, String transferId, long amountCents) {
    System.out.printf("Deposit to %s of %d cents requested. transferId=%s\n", accountId, amountCents, transferId);
//    throw new RuntimeException("simulated deposit error!");
    return "Successfully deposited money to: " + accountId;
  }
}
