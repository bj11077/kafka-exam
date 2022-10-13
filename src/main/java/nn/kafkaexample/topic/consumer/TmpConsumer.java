package nn.kafkaexample.topic.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nn.kafkaexample.dto.AbcDto;
import nn.kafkaexample.dto.DefDto;
import nn.kafkaexample.dto.TmpTableDto;
import nn.kafkaexample.repository.another.AnotherTmpTableRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class TmpConsumer extends AbsConsumer<List<TmpTableDto>> {

    @Override
    public Class getClassType() {
        return TmpTableDto.class;
    }

    private final AnotherTmpTableRepository repository;


    @KafkaListener(topics = "tmp", containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord message){
        System.out.println("--------tmp     receive------------");
        System.out.println(message.value());
        messageToDto(message);

        List<TmpTableDto> result = getData();

        repository.saveAll(result.stream().map(e-> e.toAnotherEntity()).collect(Collectors.toList()));

        result.forEach(e->{
            log.info("receive data -> {}",e);
        });

    }


}
