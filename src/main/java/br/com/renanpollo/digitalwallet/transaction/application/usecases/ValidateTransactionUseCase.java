package br.com.renanpollo.digitalwallet.transaction.application.usecases;

import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;

public interface ValidateTransactionUseCase {
    void validate(Transaction transaction);
}
