package demoSql.example.business;

import demoSql.example.constants.Constants;
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
            case Constants.READ:
                return crudhandler.get();

            case Constants.UPDATE:

            break;

            case Constants.DELETE:

            break;

            case Constants.SAVE:
                crudhandler.Describe();
            break;

        }
        return null;
    }

}
