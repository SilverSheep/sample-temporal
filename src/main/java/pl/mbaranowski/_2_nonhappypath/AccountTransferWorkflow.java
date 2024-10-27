package pl.mbaranowski._2_nonhappypath;

import pl.mbaranowski._0_core.TransferRequestPOJO;

public interface AccountTransferWorkflow {
  String transfer(TransferRequestPOJO transferRequest) throws InterruptedException;
}
