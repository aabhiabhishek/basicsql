package demoSql.example.controllers;

import demoSql.example.apis.Describe;
import demoSql.example.business.OperationHandler;
import demoSql.example.constants.Constants;
import demoSql.example.entity.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DescribeController implements Describe {

    @Autowired
    OperationHandler operationhandler;

    @PostMapping("/describe")
    public  void describe(){
        operationhandler.executeOperation(Constants.SAVE);
    }

    @GetMapping("/get")
    public List<Instance> get()
    {
         return (List<Instance>) operationhandler.executeOperation(Constants.READ);
    }


    @Override
    public Object hello(String value) {
        return null;
    }
}
