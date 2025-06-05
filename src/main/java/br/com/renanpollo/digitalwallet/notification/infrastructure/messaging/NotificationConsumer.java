package br.com.renanpollo.digitalwallet.notification.infrastructure.messaging;

import br.com.renanpollo.digitalwallet.notification.domain.exceptions.NotificationException;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NotificationConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);
    private RestClient restClient;

    public NotificationConsumer(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://util.devi.tools/api/v1/notify")
                .build();
    }

    @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio-backend")
    public void receiveNotification(Transaction transaction) {
        var response = restClient.get().retrieve().toEntity(NotificationResponse.class);

        if (response.getStatusCode().isError() || !response.getBody().message()) {
            throw new NotificationException("Error notifying transaction " + transaction);
        }
    }

    public record NotificationResponse(boolean message) {
    }
}