package br.com.renanpollo.digitalwallet.notification.infrastructure.messaging;

import br.com.renanpollo.digitalwallet.notification.domain.ports.INotificationGateway;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;

public class NotificationMessagingAdapter implements INotificationGateway {

    private final NotificationProducer notificationProducer;

    public NotificationMessagingAdapter(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    @Override
    public void notify(Transaction transaction) {
        notificationProducer.sendNotification(transaction);
    }
}
