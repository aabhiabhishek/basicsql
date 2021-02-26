package com.example.demoSql.Controllers;


import com.example.demoSql.Entity.instance;
import com.example.demoSql.Repositories.DescribeRepo;
import com.example.demoSql.apis.Describe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

import java.util.List;

@RestController
public class DescribeController implements Describe {

    @Autowired
    DescribeRepo describerepo;

    @PostMapping("/describe")
    public  void describe(){

        Ec2Client ec2 = Ec2Client.builder().build();
        boolean done = false;
        String nextToken = null;

        try {
            do {
                DescribeInstancesRequest request = DescribeInstancesRequest.builder().maxResults(6).nextToken(nextToken).build();
                DescribeInstancesResponse response = ec2.describeInstances(request);

                for (Reservation reservation : response.reservations()) {
                    for (Instance instanc : reservation.instances()) {

                        instance ins=new instance();
                        ins.setInstanceid(instanc.instanceId());
                        ins.setPrivateip(instanc.privateIpAddress());
                        ins.setPublicip(instanc.publicIpAddress());
                        ins.setType(instanc.instanceType());


                        describerepo.save(ins);

                    }
                }
                nextToken = response.nextToken();
            } while (nextToken != null);

        } catch (Ec2Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    @GetMapping("/get")
    public List<instance> get()
    {
        return describerepo.findAll();
    }


    @Override
    public Object hello(String value) {
        return null;
    }
}
