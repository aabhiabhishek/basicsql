package demoSql.example.controllers;

import demoSql.example.business.OperationHandler;
import demoSql.example.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DescribeController {

    @Autowired
    OperationHandler operationhandler;

    @PostMapping("/")
    public  String describe(){
        operationhandler.executeOperation(Constants.SAVE);
        return "greeting";
    }

    @GetMapping("/get")
    public ModelAndView get()
    {
        ModelAndView mav = new ModelAndView("AWS");
        Object obj = operationhandler.executeOperation(Constants.READ);
        mav.addObject("instance",obj);
        return mav;
    }


    @GetMapping("/hello")
    public ModelAndView greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        ModelAndView mav = new ModelAndView("greeting");
        mav.addObject("name", name);
        return mav;
    }


    /*
    For React App
     */



}
