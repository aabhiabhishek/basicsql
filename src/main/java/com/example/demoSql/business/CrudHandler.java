package com.example.demoSql.business;

import com.example.demoSql.entity.Instance;
import com.example.demoSql.repositories.DescribeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

import java.util.List;

@Service
@Slf4j
public class CrudHandler {
    @Autowired
    DescribeRepo describerepo;

    public void Describe(){
        log.info("Save in database");
        Ec2Client ec2 = Ec2Client.builder().build();
        String nextToken = null;

        try {
            do {
                DescribeInstancesRequest request = DescribeInstancesRequest.builder().maxResults(6).nextToken(nextToken).build();
                DescribeInstancesResponse response = ec2.describeInstances(request);

                for (Reservation reservation : response.reservations()) {
                    for (software.amazon.awssdk.services.ec2.model.Instance instanc : reservation.instances()) {

                        Instance ins=new Instance();
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


    public List<Instance> get()
    {
            return describerepo.findAll();
    }
}
