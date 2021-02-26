package com.example.demoSql.apis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "testing endpoints")
@RequestMapping("/1.0")
public interface Describe {

    @GetMapping("/hello")
    @ApiOperation(value = "this is hello world",response = Object.class, notes = "This is test Api")
    Object hello(@RequestParam(required = true) String value);


}
