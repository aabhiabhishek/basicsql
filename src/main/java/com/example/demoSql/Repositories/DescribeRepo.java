package com.example.demoSql.Repositories;

import com.example.demoSql.Entity.instance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescribeRepo extends JpaRepository<instance,String> {

}
