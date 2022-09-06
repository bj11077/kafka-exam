package nn.kafkaexample.topic.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import nn.kafkaexample.dto.AbcDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class AbcConsumer extends AbsConsumer<AbcDto> {

    @Override
    public Class getClassType() {
        return AbcDto.class;
    }


    @KafkaListener(topics = "abc", containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord<String,Object> message){
        System.out.println("--------abc     receive------------");
//        System.out.println("message convert before");
        System.out.println(message.value());
        messageToDto(message);
        AbcDto dto = getData();
        System.out.println(dto.toString());

}






}
