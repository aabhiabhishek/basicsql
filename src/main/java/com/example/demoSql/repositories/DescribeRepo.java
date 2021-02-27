package com.example.demoSql.repositories;

import com.example.demoSql.entity.Instance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescribeRepo extends JpaRepository<Instance,String> {

}
