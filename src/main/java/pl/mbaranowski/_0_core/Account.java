package pl.mbaranowski._0_core;

public interface Account {
  String withdraw(String accountId, String transferId, long amountCents);
  String deposit(String accountId, String transferId, long amountCents);
}
