package nn.kafkaexample.topic.consumer;

import nn.kafkaexample.dto.DefDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DefConsumer extends AbsConsumer<DefDto> {

    @Override
    public Class getClassType() {
        return DefDto.class;
    }


    @KafkaListener(topics = "def", containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord message){
        System.out.println("--------def     receive------------");
        System.out.println(message.value());
        // System.out.println(message.value());
    }


}
