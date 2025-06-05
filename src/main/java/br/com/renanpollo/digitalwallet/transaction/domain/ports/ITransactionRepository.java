package br.com.renanpollo.digitalwallet.transaction.domain.ports;

import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;

import java.util.List;

public interface ITransactionRepository {
    Transaction save(Transaction transaction);
    List<Transaction> findAll();
    List<Transaction> findByPayee(Long payee);
}
