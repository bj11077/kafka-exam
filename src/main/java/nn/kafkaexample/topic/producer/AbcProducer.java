package nn.kafkaexample.topic.producer;

import nn.kafkaexample.dto.AbcDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AbcProducer extends AbsProducer<AbcDto> {


    @Value("${spring.kafka.topic.abc}")
    private String topic;



    @Scheduled(fixedDelay = 1000)
    public void TopicSend(){
        setTopic(topic);
        AbcDto dto = new AbcDto();
        dto.setName("abc");
        dto.setVal("val");
        setData(dto);
        this.send();
    }



}
