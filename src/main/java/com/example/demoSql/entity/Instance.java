package com.example.demoSql.entity;


import lombok.*;
import software.amazon.awssdk.services.ec2.model.InstanceType;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Instance {
    @Id
    private String instanceid;
    private String publicip;
    private String privateip;
    private InstanceType type;

}
