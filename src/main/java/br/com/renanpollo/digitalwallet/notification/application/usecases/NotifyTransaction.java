package br.com.renanpollo.digitalwallet.notification.application.usecases;

import br.com.renanpollo.digitalwallet.notification.domain.ports.INotificationGateway;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import br.com.renanpollo.digitalwallet.shared.annotations.UseCase;

@UseCase
public class NotifyTransaction implements NotifyTransactionUseCase {
    private final INotificationGateway notificationGateway;

    public NotifyTransaction(INotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @Override
    public void notify(Transaction transaction) {
        notificationGateway.notify(transaction);
    }
}
