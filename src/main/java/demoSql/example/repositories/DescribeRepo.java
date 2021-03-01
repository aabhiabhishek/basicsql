package demoSql.example.repositories;

import demoSql.example.entity.Instance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescribeRepo extends JpaRepository<Instance,String> {

}
