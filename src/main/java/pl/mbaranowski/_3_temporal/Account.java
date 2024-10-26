package pl.mbaranowski._3_temporal;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface Account {

  @ActivityMethod
  String withdraw(String accountId, String transferId, long amountCents);

  @ActivityMethod
  String deposit(String accountId, String transferId, long amountCents);
}
