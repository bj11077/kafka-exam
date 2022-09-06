package nn.kafkaexample.topic.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.LinkedHashMap;

public abstract class AbsConsumer<T> {


//    // 변환된 데이터
    private T data;

    public T getData() {
        return this.data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public abstract Class getClassType();


    // Dto타입 데이터로 변환해서 data에 저장
    public void messageToDto(ConsumerRecord<String, Object> message){
        LinkedHashMap<String,Object> messageValue = (LinkedHashMap<String, Object>) message.value();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("message val");
        System.out.println(messageValue);
//        System.out.println(data.getClass());
        setData((T) mapper.convertValue(messageValue,getClassType()));
    }

    // 메시지받음  --> 각자에 맞게 재정의
    public abstract void onMessage(ConsumerRecord<String, Object> message);
}
