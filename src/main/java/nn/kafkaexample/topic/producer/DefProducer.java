package nn.kafkaexample.topic.producer;

import nn.kafkaexample.dto.AbcDto;
import nn.kafkaexample.dto.DefDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DefProducer extends AbsProducer<DefDto> {


    @Value("${spring.kafka.topic.def}")
    private String topic;



    @Scheduled(fixedDelay = 1000)
    public void TopicSend(){
        setTopic(topic);
        DefDto dto = new DefDto();
        dto.setValue("valval");
        dto.setKeySet("keykey");
        setData(dto);
        this.send();
    }



}
