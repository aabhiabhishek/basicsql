package com.example.demoSql.Entity;


import software.amazon.awssdk.services.ec2.model.InstanceType;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class instance {
    @Id
    private String instanceid;
    private String publicip;
    private String privateip;

    private InstanceType type;


    public InstanceType getType() {
        return type;
    }

    public void setType(InstanceType type) {
        this.type = type;
    }

    public String getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }



    public void setPublicip(String publicip) {
        this.publicip = publicip;
    }

    public void setPrivateip(String privateip) {
        this.privateip = privateip;
    }

    public String getPublicip() {
        return publicip;
    }

    public String getPrivateip() {
        return privateip;
    }

    public instance(){

    }

}
