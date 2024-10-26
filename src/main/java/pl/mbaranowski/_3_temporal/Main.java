package pl.mbaranowski._3_temporal;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import pl.mbaranowski._0_core.TransferRequestPOJO;

import static pl.mbaranowski._3_temporal.TransferWorker.TASK_QUEUE;

public class Main {
    public static void main(String[] args) {
        // temporal.io setup
        var service = WorkflowServiceStubs.newLocalServiceStubs();
        var workflowClient = WorkflowClient.newInstance(service);
        var options = WorkflowOptions.newBuilder().setTaskQueue(TASK_QUEUE).build();

        var transferWorkflow = workflowClient.newWorkflowStub(AccountTransferWorkflow.class, options);

        // create request
        var transferRequest = new TransferRequestPOJO("fromAccount", "toAccount", 1000);

        System.out.println("Before transfer");

        var result = transferWorkflow.transfer(transferRequest);
        System.out.println(result);

        System.out.println("After transfer");
    }
}