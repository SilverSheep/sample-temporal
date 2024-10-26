package pl.mbaranowski._4_springboot;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import pl.mbaranowski._0_core.TransferRequestPOJO;

@WorkflowInterface
public interface AccountTransferWorkflow {
  @WorkflowMethod
  String transfer(TransferRequestPOJO transferRequest);
}
