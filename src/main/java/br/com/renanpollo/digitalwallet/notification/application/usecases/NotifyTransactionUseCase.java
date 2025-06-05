package br.com.renanpollo.digitalwallet.notification.application.usecases;

import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;

public interface NotifyTransactionUseCase {
    void notify(Transaction transaction);
}
