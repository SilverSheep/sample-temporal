package pl.mbaranowski._4_springboot;

import io.temporal.activity.ActivityOptions;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;
import pl.mbaranowski._0_core.TransferRequestPOJO;

import java.time.Duration;

@WorkflowImpl(taskQueues = "AccountTransferQueue")
public class AccountTransferWorkflowImpl implements AccountTransferWorkflow {

  private final ActivityOptions options =
      ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(5)).build();
  private final AccountActivities accountActivities = Workflow.newActivityStub(AccountActivities.class, options);

  @Override
  public String transfer(TransferRequestPOJO transferRequest) {
    accountActivities.withdraw(transferRequest.getFrom(), transferRequest.getTransferId(), transferRequest.getAmount());
    accountActivities.deposit(transferRequest.getTo(), transferRequest.getTransferId(), transferRequest.getAmount());

    return "Successfully transferred money from: " + transferRequest.getFrom() + " to " + transferRequest.getTo();
  }
}
