package pl.mbaranowski._1_happypath;

import pl.mbaranowski._0_core.TransferRequestPOJO;

public interface AccountTransferWorkflow {
  String transfer(TransferRequestPOJO transferRequest);
}
