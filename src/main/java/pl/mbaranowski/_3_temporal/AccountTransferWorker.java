package pl.mbaranowski._3_temporal;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.WorkerFactory;

import static pl.mbaranowski._3_temporal.TransferWorker.TASK_QUEUE;


public class AccountTransferWorker {

  @SuppressWarnings("CatchAndPrintStackTrace")
  public static void main(String[] args) {
    // Get worker to poll the common task queue.
    // gRPC stubs wrapper that talks to the local docker instance of temporal service.
    var service = WorkflowServiceStubs.newLocalServiceStubs();
    // client that can be used to start and signal workflows
    var client = WorkflowClient.newInstance(service);

    // worker factory that can be used to create workers for specific task queues
    var factory = WorkerFactory.newInstance(client);
    var worker = factory.newWorker(TASK_QUEUE);
    worker.registerWorkflowImplementationTypes(AccountTransferWorkflowImpl.class);
    // Start all workers created by this factory.
    factory.start();
    System.out.println("Worker started for task queue: " + TASK_QUEUE);
  }
}
