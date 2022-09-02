package nn.kafkaexample.topic.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbsProducer<T> {

    @Autowired
    KafkaProducer<String,Object> producer;

    private String topic;

    private T data;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void send(){
        ProducerRecord<String,Object> sendData = new ProducerRecord<>(getTopic(),getData());
        producer.send(sendData);
    }





}
