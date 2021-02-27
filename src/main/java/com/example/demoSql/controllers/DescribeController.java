package com.example.demoSql.controllers;

import static com.example.demoSql.constants.Constants.*;

import com.example.demoSql.entity.Instance;
import com.example.demoSql.apis.Describe;
import com.example.demoSql.business.OperationHandler;
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
        operationhandler.executeOperation(SAVE);
    }

    @GetMapping("/get")
    public List<Instance> get()
    {
         return (List<Instance>) operationhandler.executeOperation(READ);
    }


    @Override
    public Object hello(String value) {
        return null;
    }
}
