package nn.kafkaexample.topic.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nn.kafkaexample.dto.DefDto;
import nn.kafkaexample.dto.TmpTableDto;
import nn.kafkaexample.repository.master.MasterTmpTable;
import nn.kafkaexample.repository.master.MasterTmpTableRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class TmpProducer extends AbsProducer<List<TmpTableDto>> {

    private final MasterTmpTableRepository repository;

    @Value("${spring.kafka.topic.tmp}")
    private String topic;



//    @Scheduled(fixedDelay = 10000)
    public void TopicSend(){
        setTopic(topic);
        List<TmpTableDto> result = repository.findAll().stream().map(e-> new TmpTableDto(e)).collect(Collectors.toList());
        setData(result);

        result.forEach(e->{
            log.info("send Data -> {}",e);
        });


        this.send();
    }



}
