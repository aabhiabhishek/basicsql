package demoSql.example.apis;

import demoSql.example.business.OperationHandler;
import demoSql.example.constants.Constants;
import demoSql.example.entity.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to accept requests from React Appp
 */

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class FrontendApi {

    @Autowired
    OperationHandler operationhandler;

    @GetMapping("/details")
    public List<Instance> details()
    {
        List<Instance> list = (List<Instance>) operationhandler.executeOperation(Constants.READ);
        return list;
    }

}
