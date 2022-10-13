package nn.kafkaexample.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nn.kafkaexample.repository.another.AnotherTmpTable;
import nn.kafkaexample.repository.master.MasterTmpTable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TmpTableDto {

    private Long tmpId;

    private String tmpName;


    public TmpTableDto(MasterTmpTable entity){
        this.tmpId = entity.getTmpId();
        this.tmpName = entity.getTmpName();
    }

    public TmpTableDto(AnotherTmpTable entity){
        this.tmpId = entity.getTmpId();
        this.tmpName = entity.getTmpName();
    }

    public MasterTmpTable toMasterEntity(){
        return new MasterTmpTable(this.tmpId,this.tmpName);
    }

    public AnotherTmpTable toAnotherEntity(){
        return new AnotherTmpTable(this.tmpId,this.tmpName);
    }




}
