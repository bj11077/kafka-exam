package nn.kafkaexample.topic.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import nn.kafkaexample.dto.AbcDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class AbcConsumer extends AbsConsumer<AbcDto> {




    //    @KafkaListener(topics = "abc", containerFactory = "kafkaListenerContainerFactory")
//    public void onMessage(ConsumerRecord<String,Object> message){
//        System.out.println("message convert before");
//        System.out.println(message.value());
//        LinkedHashMap<String,Object> data = (LinkedHashMap<String, Object>) message.value();
//        ObjectMapper mapper = new ObjectMapper();
//        AbcDto dto = (AbcDto) mapper.convertValue(data,AbcDto.class);
//        System.out.println(dto.toString());
////        MessageToDto(message);
////        System.out.println(getData().toString());
//
//    }

    @Override
    public Class getClassType() {
        return AbcDto.class;
    }


@KafkaListener(topics = "abc", containerFactory = "kafkaListenerContainerFactory")
public void onMessage(ConsumerRecord<String,Object> message){
    System.out.println("message convert before");
    System.out.println(message.value());
    MessageToDto(message);
    AbcDto dto = getData();
    System.out.println(dto.toString());
//        MessageToDto(message);
//        System.out.println(getData().toString());

}






}
