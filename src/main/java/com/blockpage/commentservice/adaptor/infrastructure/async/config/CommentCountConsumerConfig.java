package com.blockpage.commentservice.adaptor.infrastructure.async.config;


import com.blockpage.commentservice.adaptor.infrastructure.async.message.CommentCountMessage;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class CommentCountConsumerConfig {

    @Value("${spring.kafka.bootstrapAddress}")
    private String bootStrapServer;

    @Value("${spring.kafka.commentGroup}")
    private String groupName;

    @Bean
    public ConsumerFactory<String, CommentCountMessage> consumerFactory() {
        JsonDeserializer<CommentCountMessage> deserializer = new JsonDeserializer<>(CommentCountMessage.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(consumerFactoryConfig(deserializer), new StringDeserializer(), deserializer);
    }

    private Map<String, Object> consumerFactoryConfig(JsonDeserializer<CommentCountMessage> deserializer) {
        HashMap<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupName);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
        return props;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CommentCountMessage> CommentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CommentCountMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
