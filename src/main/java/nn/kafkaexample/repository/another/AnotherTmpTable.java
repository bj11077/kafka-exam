package nn.kafkaexample.repository.another;

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
public class AnotherTmpTable {

    @Id
    private Long tmpId;

    private String tmpName;

}
