package br.com.renanpollo.digitalwallet.notification.domain.ports;

import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;

public interface INotificationGateway {
    void notify(Transaction transaction);
}