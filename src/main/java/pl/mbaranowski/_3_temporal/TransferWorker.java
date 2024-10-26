package pl.mbaranowski._3_temporal;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.WorkerFactory;

public class TransferWorker {

  public static final String TASK_QUEUE = "AccountTransfer";

  @SuppressWarnings("CatchAndPrintStackTrace")
  public static void main(String[] args) {
    // gRPC stubs wrapper that talks to the local instance of temporal service.
    var service = WorkflowServiceStubs.newLocalServiceStubs();
    // client that can be used to start and signal workflows
    var client = WorkflowClient.newInstance(service);

    // worker factory that can be used to create workers for specific task queues
    var factory = WorkerFactory.newInstance(client);
    var worker = factory.newWorker(TASK_QUEUE);

    var account = new AccountImpl();

    worker.registerWorkflowImplementationTypes(AccountTransferWorkflowImpl.class);
    worker.registerActivitiesImplementations(account);

    // Start all workers created by this factory.
    factory.start();
    System.out.println("Activity Worker started for task queue: " + TASK_QUEUE);
  }
}
