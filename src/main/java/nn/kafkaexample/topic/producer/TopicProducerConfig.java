package nn.kafkaexample.topic.producer;

import nn.kafkaexample.topic.custom.CustomObjectSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class TopicProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    String bootStrapServer;

    @Bean
    public KafkaProducer<String,Object> kafkaProducer(){
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServer);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,CustomObjectSerializer.class);
        return new KafkaProducer<String, Object>(config);
    }





}
