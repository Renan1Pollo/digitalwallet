package br.com.renanpollo.digitalwallet.authorization.application.usecases;

import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;

public interface AuthorizeTransactionUseCase {
    void authorize(Transaction transaction);
}
