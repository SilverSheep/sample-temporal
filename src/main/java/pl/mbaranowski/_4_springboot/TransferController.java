package pl.mbaranowski._4_springboot;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mbaranowski._0_core.TransferRequestPOJO;

@Controller
public class TransferController {

  @Autowired WorkflowClient client;

  @GetMapping("/transfer")
  public String hello(Model model) {
    var transferWorkflow = client.newWorkflowStub(AccountTransferWorkflow.class, WorkflowOptions.newBuilder()
            .setTaskQueue("AccountTransferQueue")
            .build());
    var transferRequest = new TransferRequestPOJO("fromAccount", "toAccount", 1000);

    System.out.println("Before transfer");

    var result = transferWorkflow.transfer(transferRequest);
    System.out.println(result);
    System.out.println("After transfer");
    return result;
  }
}
