package nn.kafkaexample.repository.master;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tmp_table")
public class MasterTmpTable {

    @Id
    private Long tmpId;

    private String tmpName;

}
