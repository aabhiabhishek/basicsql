package com.example.demoSql.business;

import static com.example.demoSql.constants.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationHandler {

    @Autowired
    CrudHandler crudhandler;

    public Object executeOperation(String operation)
    {
        switch (operation)
        {
            case READ:
                return crudhandler.get();

            case UPDATE:

            break;

            case DELETE:

            break;

            case SAVE:
                crudhandler.Describe();
            break;

        }
        return null;
    }

}
