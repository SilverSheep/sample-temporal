package pl.mbaranowski._2_nonhappypath;

import pl.mbaranowski._0_core.TransferRequestPOJO;

public interface AccountTransfer {
  String transfer(TransferRequestPOJO transferRequest) throws InterruptedException;
}
