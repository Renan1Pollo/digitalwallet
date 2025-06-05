package br.com.renanpollo.digitalwallet.transaction.application.usecases;

import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;

import java.util.List;

public interface GetTransactionsUseCase {
    List<Transaction> findTransactionByPayee(Long payee);
    List<Transaction> findAll();
}
