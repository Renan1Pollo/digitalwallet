package br.com.renanpollo.digitalwallet.notification.config;

import br.com.renanpollo.digitalwallet.notification.domain.ports.INotificationGateway;
import br.com.renanpollo.digitalwallet.notification.infrastructure.messaging.NotificationMessagingAdapter;
import br.com.renanpollo.digitalwallet.notification.infrastructure.messaging.NotificationProducer;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class NotificationConfig {

    @Bean
    public NotificationProducer notificationProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        return new NotificationProducer(kafkaTemplate);
    }

    @Bean
    public INotificationGateway notificationGateway(NotificationProducer notificationProducer) {
        return new NotificationMessagingAdapter(notificationProducer);
    }
}

