package nn.kafkaexample.repository.another;

import nn.kafkaexample.repository.master.MasterTmpTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotherTmpTableRepository extends JpaRepository<AnotherTmpTable,Long> {

}
